package com.example.fitness;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BicepsActivity extends AppCompatActivity {
    static RecyclerView recyclerView;
    MyDatabaseHelper myDB;
    ArrayList<String> name, description, category;
    ArrayList<Integer> percent;
    static AdapterForRecycler adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biceps);
        Intent i = getIntent();
        String cat = i.getStringExtra("category");
        recyclerView = findViewById(R.id.BicepsrecycleView);
        myDB = new MyDatabaseHelper(BicepsActivity.this);
        name = new ArrayList<>();
        description = new ArrayList<>();
        category = new ArrayList<>();
        percent = new ArrayList<>();

        storeInArrays(cat);
        adapter = new AdapterForRecycler(BicepsActivity.this, name, description, category, percent, getIntent());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(BicepsActivity.this));
    }
    void storeInArrays(String injected) {
        Cursor cursor = myDB.injectData(injected);
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "Brak wyników", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                name.add(cursor.getString(1));
                description.add(cursor.getString(2));
                category.add(cursor.getString(3));
                percent.add(cursor.getInt(4));
            }
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
}
