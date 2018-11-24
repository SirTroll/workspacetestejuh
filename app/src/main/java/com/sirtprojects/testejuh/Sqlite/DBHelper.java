package com.sirtprojects.testejuh.Sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static String NAME = "sqlitejuh.db";
    private static int VERSION = 1;

    public DBHelper (Context context){
        super(context, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(
            "CREATE TABLE [exercicio] (\n" +
            "[codigo] INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
            "[nome] VARCHAR(60)  NOT NULL,\n" +
            "[categoria] VARCHAR(60)  NOT NULL,\n" +
            "[nivel] VARCHAR(60)  NOT NULL,\n" +
            "[descricao] VARCHAR(256)  NOT NULL\n" +
            ")"
        );

        db.execSQL(
            "CREATE TABLE [treino] (\n" +
            "[codigo] INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
            "[nome] VARCHAR(60)  NOT NULL,\n" +
            "[exercicios] VARCHAR(256)  NOT NULL \n" +
            ")"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
