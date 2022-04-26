package com.example.fitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class BaseActivity extends AppCompatActivity{

    MyDatabaseHelper myDB;
    ArrayList<String> name, description, category;
    ArrayList<Integer> percent;
    static AdapterForRecycler adapter;
    ListView listView;

    String[] maintitle ={
            "Chest","Back","Shoulders",
            "Triceps","Biceps",
            "Legs","ABS"
    };
    Integer[] imgid={
            R.drawable.chest,R.drawable.back,
            R.drawable.shoulder,R.drawable.triceps,
            R.drawable.back, R.drawable.leg,R.drawable.chest
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        MyListAdapter adapter= new MyListAdapter(this, maintitle, imgid);

        listView = (ListView)findViewById(R.id.listView1);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent();
                if(position == 0) {
                    intent.setClass(BaseActivity.this, ChestActivity.class);
                    intent.putExtra("category", "Chest");
                    startActivity(intent);
                }
                if(position == 1) {
                    intent.setClass(BaseActivity.this, BackActivity.class);
                    intent.putExtra("category", "Back");
                    startActivity(intent);

                }
                if(position == 2) {
                    intent.setClass(BaseActivity.this, ShouldersActivity.class);
                    intent.putExtra("category", "Shoulders");
                    startActivity(intent);

                }
                if(position == 3) {
                    intent.setClass(BaseActivity.this, BicepsActivity.class);
                    intent.putExtra("category", "Biceps");
                    startActivity(intent);

                }
                if(position == 4) {
                    intent.setClass(BaseActivity.this, TricepsActivity.class);
                    intent.putExtra("category", "Triceps");
                    startActivity(intent);

                }
                if(position == 5) {
                    intent.setClass(BaseActivity.this, LegsActivity.class);
                    intent.putExtra("category", "Legs");
                    startActivity(intent);

                }
                if(position == 6) {
                    intent.setClass(BaseActivity.this, ABSActivity.class);
                    intent.putExtra("category", "ABS");
                    startActivity(intent);

                }
            }
        });

    }


    public void launchDodaj (View v){
        Intent i = new Intent(this, AddExerciseActivity.class);
        startActivity(i);
    }



}