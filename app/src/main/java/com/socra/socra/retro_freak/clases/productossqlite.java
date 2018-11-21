package com.socra.socra.retro_freak.clases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class productossqlite extends SQLiteOpenHelper {

    String sqlCreate = "CREATE TABLE productos(descipcion TEXT, precio TEXT)";


    public productossqlite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS productos");

        db.execSQL(sqlCreate);

    }
}
