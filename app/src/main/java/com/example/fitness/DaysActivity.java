package com.example.fitness;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class DaysActivity extends AppCompatActivity {
    RadioButton one,two,three,four,five,six,seven;
    Button button;
    String number;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days);
        one = findViewById(R.id.oneDayRadioB);
        two = findViewById(R.id.twoDayRadioB);
        three = findViewById(R.id.threeDayRadioB);
        four = findViewById(R.id.fourDayRadioB);
        five = findViewById(R.id.fiveDayRadioB);
        six = findViewById(R.id.sixDayRadioB);
        seven = findViewById(R.id.sevenDayRadioB);
        button = findViewById(R.id.fbAddDays);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (one.isChecked()) {
                    number = one.getText().toString();
                } else if (two.isChecked()) {
                    number = two.getText().toString();
                } else if (three.isChecked()) {
                    number = three.getText().toString();
                } else if (four.isChecked()) {
                    number = four.getText().toString();
                } else if (five.isChecked()) {
                    number = five.getText().toString();
                }
                Toast.makeText(getApplicationContext(), number, Toast.LENGTH_LONG).show(); // print the value of selected super star
            }
        });

    }
}

