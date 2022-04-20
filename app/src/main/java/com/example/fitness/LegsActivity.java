package com.example.fitness;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class LegsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legs);
    }
        /* recyclerView = findViewById(R.id.recycleView);
       // floatingButton = findViewById(R.id.fbAddEx);*/

        /*myDB = new MyDatabaseHelper (BaseActivity.this);
        name = new ArrayList<>();
        description = new ArrayList<>();
        category = new ArrayList<>();
        percent = new ArrayList<>();

        storeInArrays();

        adapter = new AdapterForRecycler(BaseActivity.this, name, description, category, percent);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(BaseActivity.this));*/



   /* void storeInArrays(){
        Cursor cursor = myDB.injectData();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "Brak wyników", Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
                name.add(cursor.getString(1));
                description.add(cursor.getString(2));
                category.add(cursor.getString(3));
                percent.add(cursor.getInt(4));
            }
        }
    }*/
}
