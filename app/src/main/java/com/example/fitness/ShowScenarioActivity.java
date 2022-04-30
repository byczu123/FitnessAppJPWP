package com.example.fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowScenarioActivity extends AppCompatActivity {

    TextView passedName, passedDescription;
    MyDatabaseHelper myDB;
    Button add;
    int[] viss;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_scenario);
        viss = new int[]{0};
        Intent i = getIntent();
        String passedN = i.getStringExtra("passNameScen");
        Intent intent = getIntent();
        String passedD = intent.getStringExtra("passDescriptionScen");




        passedName = findViewById(R.id.xmlName);
        passedDescription = findViewById(R.id.xmlDesc);
        passedName.setText(passedN);
        passedDescription.setText(passedD);
        add = findViewById(R.id.addEx);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowScenarioActivity.this, BaseActivity.class);
                intent.putExtra("vis", "yes");
                intent.putExtra("scenName", passedName.getText());
                intent.putExtra("scenDescr", passedDescription.getText());
                startActivity(intent);

            }
        });


    }

}