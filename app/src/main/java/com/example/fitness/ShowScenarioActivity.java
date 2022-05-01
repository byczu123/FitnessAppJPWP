package com.example.fitness;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ShowScenarioActivity extends AppCompatActivity {

    TextView passedName, passedDescription, listOfExercises, calories, timeOfTraining;
    static MyDatabaseHelper myDB;
    Button add, saveBtn, cancelBtn;
    AlertDialog dialog;
    AlertDialog.Builder builder;

    ArrayList<String> exercises;
    ArrayList<Integer> lvl,reps, series;
    ArrayList<Workout> workouts;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_scenario);
        Intent i = getIntent();
        String passedN = i.getStringExtra("passNameScen");
        Intent intent = getIntent();
        String passedD = intent.getStringExtra("passDescriptionScen");
        exercises = new ArrayList<>();
        lvl = new ArrayList<>();
        reps = new ArrayList<>();
        series = new ArrayList<>();
        myDB = new MyDatabaseHelper(ShowScenarioActivity.this);
        String exercises = "";
        int number = 0;
        int time = 0;


        passedName = findViewById(R.id.xmlName);
        passedDescription = findViewById(R.id.xmlDesc);
        passedName.setText(passedN);
        passedDescription.setText(passedD);
        listOfExercises = findViewById(R.id.xmlExercises);
        calories = findViewById(R.id.xmlCalories);
        timeOfTraining = findViewById(R.id.xmlTime);
        workouts = myDB.getData(passedN);
        for (int j = 0; j < workouts.size(); j++) {
            exercises += workouts.get(j).workOutName + ": [" + workouts.get(j).reps + " reps] [" +
                    workouts.get(j).series + " series] \n ";
            number += workouts.get(j).level / 50 * workouts.get(j).reps * workouts.get(j).series;
            time += workouts.get(j).reps * workouts.get(j).series / 7;
        }

        listOfExercises.setText(exercises);
        calories.setText(String.valueOf(number));
        timeOfTraining.setText(String.valueOf(time));


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
    public void calendar(View view) {
        builder = new AlertDialog.Builder(this);
        final View popupView = getLayoutInflater().inflate(R.layout.popup_calendar, null);
        saveBtn = (Button) popupView.findViewById(R.id.saveBtn);
        cancelBtn = (Button) popupView.findViewById(R.id.dismissBtn);

        builder.setView(popupView);
        dialog = builder.create();
        dialog.show();

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }








    /*
    public void displayList() {
        Cursor cursor = myDB.injectDataScenarios();
        String text = "";
        int number = 0;
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "Brak wyników", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                exercises.add(cursor.getString(0));
            }

        }
    }
    public void displayCalories(){
        Cursor cursor = myDB.injectToList();
        String text="";
        int number=0;
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "Brak wyników", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                lvl.add(cursor.getInt(1));
                reps.add(cursor.getInt(2));
                series.add(cursor.getInt(3));
            }

        }
    }
 */
}

