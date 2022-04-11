package com.example.fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class dodajCwiczeniaActivity extends AppCompatActivity {

    EditText name_input, description_input, level_input;
    Spinner category;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodaj_cwiczenia);

        name_input = findViewById(R.id.editTextTextPersonName);
        description_input = findViewById(R.id.editTextTextPersonName2);
        level_input = findViewById(R.id.editTextNumber);
        category = findViewById(R.id.spinner);
        add = findViewById(R.id.button);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(dodajCwiczeniaActivity.this);
                myDB.addEx(name_input.getText().toString().trim(),
                        description_input.getText().toString().trim(),
                        category.getSelectedItem().toString().trim(),
                        Integer.valueOf(level_input.getText().toString().trim()));
                bazaActivity.recyclerView.setAdapter(bazaActivity.adapter);
            }
        });

    }

}