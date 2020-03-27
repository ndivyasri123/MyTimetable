package com.example.timetableapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.timetableapp.Utils.LetterImageView;

public class Main3Activity extends AppCompatActivity {
     private ListView listView;
     private androidx.appcompat.widget.Toolbar toolbar;
     public static String[] Monday;
    public static String[] Tuesday;
    public static String[] Wednesday;
    public static String[] Thursday;
    public static String[] Friday;
    public static String[] Saturday;
    public static String[] time1;
    public static String[] time2;
    public static String[] time3;
    public static String[] time4;
    public static String[] time5;
    public static String[] time6;
    private String[] PreferredDay;
    private String[] PreferredTime;


     protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setupUIView();
        initToolbar();
        setupListView();
    }
    private void setupUIView(){
        listView=(ListView)findViewById(R.id.lvDay);
        toolbar=(androidx.appcompat.widget.Toolbar) findViewById(R.id.ToolbarDay);


    }
    public void initToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(Main2Activity.sharedPreferences.getString(Main2Activity.SELECTED_DAY,null));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupListView(){
      Monday=getResources().getStringArray(R.array.Monday);
      Tuesday=getResources().getStringArray(R.array.Tuesday);
        Wednesday=getResources().getStringArray(R.array.Wednesday);
        Thursday=getResources().getStringArray(R.array.Thursday);
        Friday=getResources().getStringArray(R.array.Friday);


        time1=getResources().getStringArray(R.array.time1);
        time2=getResources().getStringArray(R.array.time2);
        time3=getResources().getStringArray(R.array.time3);
        time4=getResources().getStringArray(R.array.time4);
        time5=getResources().getStringArray(R.array.time5);


        String selected_day=Main2Activity.sharedPreferences.getString(Main2Activity.SELECTED_DAY,null);
        if(selected_day.equalsIgnoreCase("Monday")){
          PreferredDay=Monday;
          PreferredTime=time1;
        }else if(selected_day.equalsIgnoreCase("Tuesday")){
            PreferredDay=Tuesday;
            PreferredTime=time2;
        }else if(selected_day.equalsIgnoreCase("Wednesday")) {
            PreferredDay = Wednesday;
            PreferredTime = time3;
        }else if(selected_day.equalsIgnoreCase("Thursday")) {
            PreferredDay = Thursday;
            PreferredTime = time4;
        }else if(selected_day.equalsIgnoreCase("Friday")) {
            PreferredDay = Friday;
            PreferredTime = time5;
        }
     SimpleAdapter simpleAdapter=new SimpleAdapter(this,PreferredDay,PreferredTime);
     listView.setAdapter(simpleAdapter);


    }
    public class SimpleAdapter extends BaseAdapter{
        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView subjects,time;
        private String[] subjectArray,timeArray ;
        private LetterImageView letterImageView;
        public SimpleAdapter(Context context,String[] subject,String[] time)
        {  mContext=context;
            subjectArray=subject;
            timeArray=time;
            layoutInflater=LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return subjectArray.length;
        }

        @Override
        public Object getItem(int position) {
            return subjectArray[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView==null){
                convertView=layoutInflater.inflate(R.layout.activity_main_1,null);
            }
            subjects=(TextView)convertView.findViewById(R.id.tvDay);
            time=(TextView)convertView.findViewById(R.id.tvTime);
            letterImageView=(LetterImageView)convertView.findViewById(R.id.ivDay);
            subjects.setText(subjectArray[position]);
            time.setText(timeArray[position]);
            letterImageView.setOval(true);
            letterImageView.setLetter(subjectArray[position].charAt(0));
            return convertView;

        }
    }
}

