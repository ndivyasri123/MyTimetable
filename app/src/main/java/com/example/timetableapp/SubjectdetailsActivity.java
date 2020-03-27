package com.example.timetableapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class SubjectdetailsActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjectdetails);
        setupUIView();
        initToolbar();
        setupListView();
    }
    public void setupUIView(){
        toolbar=(Toolbar)findViewById(R.id.ToolbarSubjectdetails);
        listView=(ListView)findViewById(R.id.lvSubjectdetails);
    }
    private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Syllabus");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void setupListView() {
        String subject_selected = Main4Activity.subjectPreferances.getString(Main4Activity.SUB_PREF, null);
        String[] syllabus = new String[]{};
        String[] titles = getResources().getStringArray(R.array.titles);
        if (subject_selected.equalsIgnoreCase("Subject1")) {
            syllabus = getResources().getStringArray(R.array.PrinciplesofCommunication);
        } else if (subject_selected.equalsIgnoreCase("Subject2")) {
            syllabus = getResources().getStringArray(R.array.DigitalELectronics);
        } else if (subject_selected.equalsIgnoreCase("Subject3")) {
            syllabus = getResources().getStringArray(R.array.ElectromagneticTheory);
        } else if (subject_selected.equalsIgnoreCase("Subject4")) {
            syllabus = getResources().getStringArray(R.array.Management);
        } else if (subject_selected.equalsIgnoreCase("Subject5")) {
            syllabus = getResources().getStringArray(R.array.Networks);
        } else {
            syllabus = getResources().getStringArray(R.array.SolidStateDevices);
        }
        SubjectsAdapter subjectsAdapter=new SubjectsAdapter(this,titles,syllabus);
        listView.setAdapter(subjectsAdapter);
    }
    public   class SubjectsAdapter extends BaseAdapter {
            private Context mContext;
            private LayoutInflater layoutInflater;
            private TextView title,syllabus;
            private String[] titleArray,syllabusArray ;
            public SubjectsAdapter(Context context,String[] title,String[] syllabus)
            {  mContext=context;
                titleArray=title;
                syllabusArray=syllabus;
                layoutInflater=LayoutInflater.from(context);
            }
            @Override
            public int getCount() {
                return titleArray.length;
            }

            @Override
            public Object getItem(int position) {
                return titleArray[position];
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if(convertView==null){
                    convertView=layoutInflater.inflate(R.layout.activity_subjectdetails_1,null);
                }
                title=(TextView)convertView.findViewById(R.id.tvSubjectTitle);
                syllabus=(TextView)convertView.findViewById(R.id.tvSyllabus);
                title.setText(titleArray[position]);
                syllabus.setText(syllabusArray[position]);



                return convertView;

            }
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home :{
                onBackPressed();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
