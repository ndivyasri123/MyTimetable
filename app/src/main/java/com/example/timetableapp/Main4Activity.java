package com.example.timetableapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.timetableapp.Utils.LetterImageView;

public class Main4Activity extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView listView;
    private String[] subjects;
    public static SharedPreferences subjectPreferances;
    public static String SUB_PREF;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        setupUIView();
        initToolbar();
        setupListView();
    }
    public void setupUIView(){
        toolbar=(Toolbar)findViewById(R.id.ToolbarSubjects);
        listView=(ListView)findViewById(R.id.lvSubjects);
        subjectPreferances=getSharedPreferences("Subjects",MODE_PRIVATE);
    }
    private void initToolbar(){
       setSupportActionBar(toolbar);
       getSupportActionBar().setTitle("Subjects");
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void setupListView(){
        subjects=getResources().getStringArray(R.array.Subjects);
        SubjectAdapter subjectAdapter=new SubjectAdapter(this,R.layout.activity_main4_1,subjects);
        listView.setAdapter(subjectAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:{
                        subjectPreferances.edit().putString(SUB_PREF,"PrinciplesofCommunication").apply();
                        Intent intent=new Intent(Main4Activity.this,SubjectdetailsActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case 1:{
                        subjectPreferances.edit().putString(SUB_PREF,"DigitalElectronics").apply();
                        Intent intent=new Intent(Main4Activity.this,SubjectdetailsActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case 2:{
                        subjectPreferances.edit().putString(SUB_PREF,"ElectromagneticTheory").apply();
                        Intent intent=new Intent(Main4Activity.this,SubjectdetailsActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case 3:{
                        subjectPreferances.edit().putString(SUB_PREF,"Management").apply();
                        Intent intent=new Intent(Main4Activity.this,SubjectdetailsActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case 4:{
                        subjectPreferances.edit().putString(SUB_PREF,"Networks").apply();
                        Intent intent=new Intent(Main4Activity.this,SubjectdetailsActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case 5:{
                        subjectPreferances.edit().putString(SUB_PREF,"SolidStateDevices").apply();
                        Intent intent=new Intent(Main4Activity.this,SubjectdetailsActivity.class);
                        startActivity(intent);
                        break;
                    }
                }

            }
        });
    }
    public class SubjectAdapter extends ArrayAdapter {
        int resource;
        private LayoutInflater layoutInflater;
        private String[] subjects= new String[]{};

        public SubjectAdapter(Context context, int resource, String[] objects) {
            super(context, resource,objects);
            this.resource=resource;
            this.subjects=objects;
            layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent){
            ViewHolder holder;
            if(convertView==null){
                holder=new ViewHolder();
                convertView= getLayoutInflater().inflate(resource,null);
                holder.ivLogo=(LetterImageView)convertView.findViewById(R.id.ivLettersubject);

                holder.tvSubject=(TextView)convertView.findViewById(R.id.tvSubject);
                convertView.setTag(holder);
            }else {
                holder=(ViewHolder)convertView.getTag();
            }
            holder.ivLogo.setOval(true);
            CharSequence[] subjects=getResources().getStringArray(R.array.Subjects);
            holder.ivLogo.setLetter(subjects[position].charAt(0));
            holder.tvSubject.setText(subjects[position]);



         return convertView;

    }

    }
    class ViewHolder{
        public LetterImageView ivLogo;
        public TextView tvSubject;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home :{
                onBackPressed();
            }
        }


        return super.onOptionsItemSelected(item);
    }



}
