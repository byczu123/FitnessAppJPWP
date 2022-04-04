package com.example.fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void launchPlan(View v){
        Intent i = new Intent(this, planActivity.class);
        startActivity(i);
    }

    public void launchBaza(View v){
        Intent i = new Intent(this, bazaActivity.class);
        startActivity(i);
    }

    public void launchScenariusze(View v){
        Intent i = new Intent(this, scenariuszeActivity.class);
        startActivity(i);
    }
}