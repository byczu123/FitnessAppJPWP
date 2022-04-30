package com.example.fitness;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class WorkoutRoutineActivity extends AppCompatActivity {

    private AlertDialog.Builder builder;
    private AlertDialog dialog;
    private EditText workoutName, description;
    private Button saveButton, cancelButton;

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


    public void createNewWorkout(View view){
        builder = new AlertDialog.Builder(this);
        final View popupView = getLayoutInflater().inflate(R.layout.popup, null);
        workoutName = (EditText) popupView.findViewById(R.id.nameWorkout);
        description = (EditText) popupView.findViewById(R.id.description);
         saveButton = (Button) popupView.findViewById(R.id.btnSave);
         cancelButton = (Button) popupView.findViewById(R.id.btnCancel);

         builder.setView(popupView);
         dialog = builder.create();
         dialog.getWindow().setBackgroundDrawableResource(R.drawable.popup);
         dialog.show();
         saveButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

             }
         });
         cancelButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 dialog.dismiss();
             }
         });
    }
}
