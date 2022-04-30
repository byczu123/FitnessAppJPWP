package com.example.fitness;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ShowExActivity extends AppCompatActivity {

    TextView passedName, passedDescription;
    Button deleteButton1;
    String id;
    MyDatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_ex);
        Intent i = getIntent();
        String name11 = i.getStringExtra("passName");
        Intent intent = getIntent();
        String name112 = intent.getStringExtra("passDescription");

        passedName = findViewById(R.id.name1);
        passedDescription = findViewById(R.id.description1);

        passedName.setText(name11);
        passedDescription.setText(name112);

        id = getIntent().getStringExtra("passName");

        deleteButton1 = findViewById(R.id.delete_new);
        myDB = new MyDatabaseHelper(this);


        deleteButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });

    }
    public void confirmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        Intent intent = new Intent(this, BaseActivity.class);

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        builder.setTitle("Delete this exercise?");
        builder.setMessage("Are you sure you want to delete this exercise?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                myDB.deleteRecord(id);
                startActivity(intent);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
}