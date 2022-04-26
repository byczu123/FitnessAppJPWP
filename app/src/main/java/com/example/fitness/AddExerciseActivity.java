package com.example.fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Objects;

public class AddExerciseActivity extends AppCompatActivity {

    EditText name_input, description_input, level_input;
    Spinner category;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exercises);

        name_input = findViewById(R.id.editTextTextPersonName);
        description_input = findViewById(R.id.editTextTextPersonName2);
        level_input = findViewById(R.id.editTextNumber);
        category = findViewById(R.id.spinner);
        add = findViewById(R.id.button);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddExerciseActivity.this);
                myDB.addEx(name_input.getText().toString().trim(),
                        description_input.getText().toString().trim(),
                        category.getSelectedItem().toString().trim(),
                        Integer.valueOf(level_input.getText().toString().trim()));
                    if (Objects.equals(category.getSelectedItem().toString().trim(), "Chest")) {
                        ChestActivity.recyclerView.setAdapter(ChestActivity.adapter);
                    } else if (Objects.equals(category.getSelectedItem().toString().trim(), "Back")) {
                        BackActivity.recyclerView.setAdapter(BackActivity.adapter);
                    } else if (Objects.equals(category.getSelectedItem().toString().trim(), "Shoulders")) {
                        ShouldersActivity.recyclerView.setAdapter(ShouldersActivity.adapter);
                    } else if (Objects.equals(category.getSelectedItem().toString().trim(), "Legs")) {
                        LegsActivity.recyclerView.setAdapter(LegsActivity.adapter);
                    } else if (Objects.equals(category.getSelectedItem().toString().trim(), "Triceps")) {
                        TricepsActivity.recyclerView.setAdapter(TricepsActivity.adapter);
                    } else if (Objects.equals(category.getSelectedItem().toString().trim(), "Biceps")) {
                        BicepsActivity.recyclerView.setAdapter(BicepsActivity.adapter);
                    } else if (Objects.equals(category.getSelectedItem().toString().trim(), "ABS")) {
                        ABSActivity.recyclerView.setAdapter(ABSActivity.adapter);
                    }
                }
        });

    }

}