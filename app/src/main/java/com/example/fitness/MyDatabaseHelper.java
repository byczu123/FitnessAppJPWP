package com.example.fitness;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String dbName = "Exercises.db";
    private static final int versionOfDB = 4;
    private static final String tableName = "Exercises";
    private static final String table1Name = "Scenarios";


    private static final String ExIdColumn = "_id";
    private static final String NameOfExColumn = "Nazwa";
    private static final String DescriptionColumn = "Opis";
    private static final String CategoryColumn = "Kategoria";
    private static final String PercentColumn = "Poziom_trudności";
    private static final String NameofScenario = "Nazwa_scenariuszu";
    private static final String NameofExInScenario = "Nazwa_cwiczenia_w_scenariuszu";
    private static final String DescOfScenario = "Opis_scenariusza";
    private static final String Reps = "Powtórzenia";
    private static final String Series = "Serie";





    public MyDatabaseHelper(@Nullable Context context ) {
        super(context, dbName, null, versionOfDB);
        this.context=context;
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE IF NOT EXISTS " + tableName + " (" +
                ExIdColumn + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NameOfExColumn + " TEXT, " + DescriptionColumn +
                " TEXT, " + CategoryColumn + " TEXT, " +
                PercentColumn + " INTEGER) ;";
        String query1 = "CREATE TABLE " + table1Name + " (" +
                NameofScenario + " TEXT, " + DescOfScenario +
                " TEXT, " + NameofExInScenario + " TEXT, " + Reps + " INTEGER, " +
                Series + " INTEGER) ;";
        db.execSQL(query);
        db.execSQL(query1);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + tableName);
        db.execSQL("DROP TABLE IF EXISTS " + table1Name);
        onCreate(db);
    }



    void addEx(String cv_name, String cv_description, String cv_category, int cv_level){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(NameOfExColumn, cv_name);
        cv.put(DescriptionColumn, cv_description);
        cv.put(CategoryColumn, cv_category);
        cv.put(PercentColumn, cv_level);
        long result = db.insert(tableName, null, cv);
        if(result == -1){
            Toast.makeText(context, "Nie udało się dodać ćwiczenia", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Dodano nowe ćwiczenie", Toast.LENGTH_SHORT).show();
        }
        db.close();

    }

    Cursor injectData(String inject_category){
        String query = "SELECT * FROM " + tableName + " WHERE " +
                CategoryColumn + "=" + "\"" + inject_category + "\"";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    public void deleteRecord(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        //db.delete(dbName, "Nazwa=?", new String[]{row_id});
        db.execSQL("DELETE FROM " + tableName+ " WHERE "+NameOfExColumn+"="+ "\"" + row_id+"\"");
        Toast.makeText(context, "Usunięto ćwiczenie", Toast.LENGTH_SHORT).show();

        db.close();

    }

    void addScenario(String name, String descr, String exercise, int reps, int series){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(NameofScenario, name);
        cv.put(DescOfScenario, descr);
        cv.put(NameofExInScenario, exercise);
        cv.put(Reps, reps);
        cv.put(Series, series);

        long result = db.insert(table1Name, null, cv);
        if(result == -1){
            Toast.makeText(context, "Nie udało się dodać scenariusza", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Dodano nowy scenariusz", Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

    Cursor injectDataScenarios(){
        String query = "SELECT Scenarios.Nazwa_scenariuszu, " +
                "Scenarios.Opis_scenariusza, Scenarios.Nazwa_cwiczenia_w_scenariuszu, " +
                "Scenarios.Powtórzenia, Scenarios.Serie" +
                " FROM " + table1Name + " WHERE Scenarios.Serie = 0 ";
        //+ ", " + tableName +
          //      " WHERE Exercises.Nazwa = Scenarios.Nazwa_cwiczenia_w_scenariuszu" ;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
}
