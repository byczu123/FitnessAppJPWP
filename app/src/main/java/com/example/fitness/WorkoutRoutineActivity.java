package com.example.fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class WorkoutRoutineActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_routine);
    }

    public void launchBaza(View v) {
        Intent i = new Intent(this, BaseActivity.class);
        startActivity(i);
    }
    public void launchDays(View v) {
        Intent i = new Intent(this, DaysActivity.class);
        startActivity(i);
    }
    public void launcher(View v){
        //to do, if brak planu to days else to Baza
    }


}
