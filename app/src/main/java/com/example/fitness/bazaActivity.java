package com.example.fitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class bazaActivity extends AppCompatActivity {

    static RecyclerView recyclerView;
    FloatingActionButton floatingButton;
    MyDatabaseHelper myDB;
    ArrayList <String> name, description, category;
    ArrayList <Integer> percent;
    static AdapterForRecycler adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baza);

        recyclerView = findViewById(R.id.recycleView);
       // floatingButton = findViewById(R.id.fbAddEx);

        myDB = new MyDatabaseHelper (bazaActivity.this);
        name = new ArrayList<>();
        description = new ArrayList<>();
        category = new ArrayList<>();
        percent = new ArrayList<>();

        storeInArrays();

        adapter = new AdapterForRecycler(bazaActivity.this, name, description, category, percent);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(bazaActivity.this));
    }
    public void launchDodaj(View v){
        Intent i = new Intent(this, dodajCwiczeniaActivity.class);
        startActivity(i);
    }

    void storeInArrays(){
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
    }



}