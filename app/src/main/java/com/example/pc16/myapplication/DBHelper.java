package com.example.pc16.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by PC16 on 1/16/2018.
 */

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper (Context ctx){
        super(ctx,"DBI", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table contacts(id integer primary key, name text, phone text)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    void addRow(int id, String n, String p){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id",id);
        cv.put("name",n);
        cv.put("phone",p);
        db.insert("contacts",null,cv);
    }
    String readContact(int id){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c =db.rawQuery("select * from contacts where id="+id, null);
        c.moveToNext();
        return c.getString(1);
    }
    String getAllNames(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from contacts", null);
        String total ="";
        while (c.moveToNext()){
            total += c.getString(1)+"\n";
        }
        return total;
    }
}
