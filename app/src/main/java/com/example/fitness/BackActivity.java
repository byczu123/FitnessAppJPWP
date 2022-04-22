package com.example.fitness;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BackActivity extends AppCompatActivity {

    static RecyclerView recyclerView;
    MyDatabaseHelper myDB;
    ArrayList<String> name, description, category;
    ArrayList<Integer> percent;
    static AdapterForRecycler adapter;
    Button delete;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back);

        Intent i = getIntent();
        String cat = i.getStringExtra("category");
        recyclerView = findViewById(R.id.BackrecycleView);
        myDB = new MyDatabaseHelper(BackActivity.this);
        name = new ArrayList<>();
        description = new ArrayList<>();
        category = new ArrayList<>();
        percent = new ArrayList<>();

        storeInArrays(cat);
        adapter = new AdapterForRecycler(BackActivity.this, name, description, category, percent);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(BackActivity.this));
        delete = findViewById(R.id.delete_new);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_abs);
            }
        });
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
    public void confirmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete this exercise?");
        builder.setMessage("Are you sure you want to delete this exercise?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(BackActivity.this);
                myDB.deleteRecord(id);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();

    }
}

