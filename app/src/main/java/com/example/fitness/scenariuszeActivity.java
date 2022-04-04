package com.example.fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class scenariuszeActivity extends AppCompatActivity {
    private ListView PlanBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenariusze);
        PlanBase = findViewById(R.id.ExBase);
        ArrayList<String> Plany = new ArrayList<>();
        Plany.add("Push-Pull");
        Plany.add("FBW");
        Plany.add("Split");
        Plany.add("Upper Lower");
        Plany.add("Upper Body Priority");
        Plany.add("Lower Body Priority");
        Plany.add("Fat burning");
        ArrayAdapter<String> ExercisesAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                Plany
        );
        PlanBase.setAdapter(ExercisesAdapter);
        PlanBase.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(scenariuszeActivity.this, Plany.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

}