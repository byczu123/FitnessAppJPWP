package com.example.fitness;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;
public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String dbName = "Exercises.db";
    private static final int versionOfDB = 1;
    private static final String tableName = "Exercises";

    private static final String ExIdColumn = "_id";
    private static final String NameOfExColumn = "Nazwa";
    private static final String DescriptionColumn = "Opis";
    private static final String CategoryColumn = "Kategoria";
    private static final String PercentColumn = "Poziom_trudności";


    public MyDatabaseHelper(@Nullable Context context ) {
        super(context, dbName, null, versionOfDB);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + tableName + " (" +
                ExIdColumn + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NameOfExColumn + " TEXT, " + DescriptionColumn +
                " TEXT, " + CategoryColumn + " TEXT, " +
                PercentColumn + " INTEGER)";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + tableName);
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
}
