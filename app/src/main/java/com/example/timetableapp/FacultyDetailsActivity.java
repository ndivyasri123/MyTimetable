    package com.example.timetableapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class FacultyDetailsActivity extends AppCompatActivity {
      private CircleImageView circleImageView;
      private Toolbar toolbar;
      private TextView facultyName,phonenumber,emailid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_details);
        setupUIViews();
        initToolbar();
        setupDetails();
    }
    private void setupUIViews() {
        toolbar = (Toolbar) findViewById(R.id.ToolBarFacultyDetails);
        circleImageView = (CircleImageView) findViewById(R.id.civFaculty);
        facultyName=(TextView)findViewById(R.id.tvfacultyname);
        phonenumber=(TextView)findViewById(R.id.tvMobile);
        emailid=(TextView)findViewById(R.id.tvEmail);


    }

    public void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("FacultyDetails");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void setupDetails(){
        int faculty_pos=FacultyActivity.sharedPreferences.getInt(FacultyActivity.SEL_FACULTY,0);
        String[] facultyname = getResources().getStringArray(R.array.Faculty);
        int[] facultyimages=new int[]{R.mipmap.default_user,R.mipmap.default_user,R.mipmap.default_user,R.mipmap.default_user,R.mipmap.default_user,R.mipmap.default_user};
        int[] facultyarray=new int[]{R.array.SwethaMaam,R.array.CommunicationSir,R.array.DigitalSir,R.array.SumanSir,R.array.RajeevSir,R.array.ManagementMaam};
        String[] facultyDetails=getResources().getStringArray(facultyarray[faculty_pos]);
        phonenumber.setText(facultyDetails[0]);
        emailid.setText(facultyDetails[1]);
        circleImageView.setImageResource(facultyimages[faculty_pos]);
        facultyName.setText(facultyname[faculty_pos]);
    }
    public boolean onOptionsItemSelected(@Nullable MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                onBackPressed();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
