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

public class BaseActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    //static RecyclerView recyclerView;
    FloatingActionButton floatingActionButton;
    MyDatabaseHelper myDB;
    ArrayList<String> name, description, category;
    ArrayList<Integer> percent;
    static AdapterForRecycler adapter;
    static int option;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        ListView listview = findViewById(R.id.listView1);
        listview.setOnItemClickListener(this);

    }

    public void onItemClick(AdapterView<?> l, View v, int position, long id) {
        Intent intent = new Intent();
        option = (int) id;
        switch (option) {
            case 0:
                intent.setClass(this, ChestActivity.class);
                intent.putExtra("category", "Chest");
                startActivity(intent);
                break;
            case 1:
                intent.setClass(this, BackActivity.class);
                intent.putExtra("category", "Back");
                startActivity(intent);
                break;
            case 2:
                intent.setClass(this, ShouldersActivity.class);
                intent.putExtra("category", "Shoulders");
                startActivity(intent);
                break;
            case 3:
                intent.setClass(this, LegsActivity.class);
                intent.putExtra("category", "Legs");
                startActivity(intent);
                break;
            case 4:
                intent.setClass(this, BicepsActivity.class);
                intent.putExtra("category", "Biceps");
                startActivity(intent);
                break;
            case 5:
                intent.setClass(this, TricepsActivity.class);
                intent.putExtra("category", "Triceps");
                startActivity(intent);
                break;
            case 6:
                intent.setClass(this, ABSActivity.class);
                intent.putExtra("category", "ABS");
                startActivity(intent);
                break;
            // Or / And

        }
    }

       /* recyclerView = findViewById(R.id.recycleView);
       // floatingButton = findViewById(R.id.fbAddEx);*/

        /*myDB = new MyDatabaseHelper (BaseActivity.this);
        name = new ArrayList<>();
        description = new ArrayList<>();
        category = new ArrayList<>();
        percent = new ArrayList<>();

        storeInArrays();

        adapter = new AdapterForRecycler(BaseActivity.this, name, description, category, percent);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(BaseActivity.this));*/



   /* void storeInArrays(){
        Cursor cursor = myDB.injectData();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "Brak wyników", Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
                name.add(cursor.getString(1));
                description.add(cursor.getString(2));
                category.add(cursor.getString(3));
                percent.add(cursor.getInt(4));
            }
        }
    }*/
    public void launchDodaj (View v){
        Intent i = new Intent(this, AddExerciseActivity.class);
        startActivity(i);
    }



}