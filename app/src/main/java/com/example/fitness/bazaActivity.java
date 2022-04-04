package com.example.fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class bazaActivity extends AppCompatActivity {
    private ListView ExBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baza);
        ExBase = findViewById(R.id.ExBase);
        ArrayList<String> Exercises = new ArrayList<>();
        Exercises.add("Klata");
        Exercises.add("Plecy");
        Exercises.add("Barki");
        Exercises.add("Nogi");
        Exercises.add("Biceps");
        Exercises.add("Triceps");
        Exercises.add("Brzuch");
        ArrayAdapter<String> ExercisesAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                Exercises
        );
        ExBase.setAdapter(ExercisesAdapter);
        ExBase.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(bazaActivity.this, Exercises.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}