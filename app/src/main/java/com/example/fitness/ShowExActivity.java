package com.example.fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ShowExActivity extends AppCompatActivity {

    TextView passedName, passedDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_ex);
        Intent i = getIntent();
        String name11 = i.getStringExtra("passName");
        Intent intent = getIntent();
        String name112 = intent.getStringExtra("passDescription");

        passedName = findViewById(R.id.name1);
        passedDescription = findViewById(R.id.description1);

        passedName.setText(name11);
        passedDescription.setText(name112);


    }
}