package com.example.ordinariopuntodeventa;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLITEHelper extends SQLiteOpenHelper {

    public AdminSQLITEHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table productos(idprod integer primary key autoincrement,nombreproducto text,precio int, cantidad decimal, imagen blob,fecha DATE default(datetime('now','localtime')))");
   db.execSQL("create table venta(idventa integer primary key autoincrement, idprod integer,cantidad decimal,precio decimal, importe decimal)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
