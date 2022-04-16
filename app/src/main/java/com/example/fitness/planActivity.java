package com.example.fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class planActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
    }

    public void launchBaza(View v) {
        Intent i = new Intent(this, bazaActivity.class);
        startActivity(i);
    }
    public void launchDays(View v) {
        Intent i = new Intent(this, daysActivity.class);
        startActivity(i);
    }
    public void launcher(View v){
        //to do, if brak planu to days else to Baza
    }


}
