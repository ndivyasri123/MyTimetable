package com.example.timetableapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
     private Toolbar toolbar;
     private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUIView();
        initToolbar();
    }
    public void setupUIView(){
     toolbar=(Toolbar)findViewById(R.id.ToolbarMain);
     listView=(ListView)findViewById(R.id.lvMain);
    }
    public void initToolbar(){
     setSupportActionBar(toolbar);
     getSupportActionBar().setTitle("TimeTable App");
    }
     private void setupListView(){
        String[] title=getResources().getStringArray(R.array.Main);
        String[] description=getResources().getStringArray(R.array.Description);
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,title,description);
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               switch (position) {
                   case 0: {
                       Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                       startActivity(intent);
                       break;
                   }
                   case 1: {
                       Intent intent = new Intent(MainActivity.this, Main4Activity.class);
                       startActivity(intent);
                       break;
                   }

                   case 2:
                   {
                       Intent intent = new Intent(MainActivity.this, FacultyActivity.class);
                       startActivity(intent);
                       break;
                   }
                   case 3:
                       break;
               }
            }
        });
     }



    public class SimpleAdapter extends BaseAdapter{
        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView title,description;
        private String[] titleArray,descriptionArray ;
        private ImageView imageView;
        public SimpleAdapter(Context context,String[] title,String[] description)
        {  mContext=context;
           titleArray=title;
           descriptionArray=description;
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
                convertView=layoutInflater.inflate(R.layout.activity_main_1,null);
            }
            title=(TextView)convertView.findViewById(R.id.tvMain);
            description=(TextView)convertView.findViewById(R.id.tvDescription);
            imageView=(ImageView)convertView.findViewById(R.id.ivMain);
            title.setText(titleArray[position]);
            description.setText(descriptionArray[position]);

            if(titleArray[position].equalsIgnoreCase("TimeTable")){
                imageView.setImageResource(R.drawable.timetable);
            }else if(titleArray[position].equalsIgnoreCase("Subjects")){
                imageView.setImageResource(R.drawable.books);
            }else if (titleArray[position].equalsIgnoreCase("Faculty")){
                imageView.setImageResource(R.drawable.contacts);
            }
            return convertView;

        }
    }

}
