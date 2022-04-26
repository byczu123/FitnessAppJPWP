package com.example.fitness;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.bazaCwiczenId);
        b2 = findViewById(R.id.scenariuszeId);
        b3 = findViewById(R.id.planId);

    }

    public void launchBaza(View v) {
        Intent i = new Intent(this, BaseActivity.class);
        startActivity(i);
    }
    public void launchPlan(View v) {
        Intent i = new Intent(this, WorkoutRoutineActivity.class);
        startActivity(i);
    }
    public void launchScenariusze(View v) {
        Intent i = new Intent(this, ReadyWorkoutsActivity.class);
        startActivity(i);
    }

}

