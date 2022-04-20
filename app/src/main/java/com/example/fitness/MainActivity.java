package com.example.fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

