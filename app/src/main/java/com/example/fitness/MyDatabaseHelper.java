package com.example.fitness;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
                ExIdColumn + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NameOfExColumn + " TEXT, " + DescriptionColumn +
                " TEXT, " + CategoryColumn + " TEXT, " +
                PercentColumn + " INTEGER)";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
