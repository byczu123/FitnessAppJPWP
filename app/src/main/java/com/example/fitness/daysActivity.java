package com.example.fitness;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class daysActivity extends AppCompatActivity {
     RadioButton radioButton;
     RadioGroup radioGroup;
     Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days);
        radioGroup=(RadioGroup) findViewById(R.id.radioGroup);
    }
    public void onClickButton(View v){
        int selectedId = radioGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(selectedId);
        if(selectedId==-1){
            Toast.makeText(daysActivity.this,"Nothing selected", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(daysActivity.this,radioButton.getText(), Toast.LENGTH_SHORT).show();
        }
    }
}

