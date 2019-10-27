package com.example.insert_update_delete;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDatabaseConnection extends SQLiteOpenHelper {

    public static final String DATBASE_NAME="Learning_Mode_T.db";
    public static final String TABLE_NAME="Authenticate_T";
    public static final String Col_1="ID";
    public static final String Col_2="Full_Name";
    public static final String Col_3="Email";
    public static final String Col_4="Phone";
    public static final String Col_5="Gender";

    public MyDatabaseConnection(@Nullable Context context) {
        super(context, DATBASE_NAME, null, 1);

    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL( "CREATE TABLE " +TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT, Full_Name TEXT,Email TEXT,Phone TEXT,Gender TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }



    public boolean insertdata(String name, String email,String phone,String gender){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col_2,name);
        contentValues.put(Col_3,email);
        contentValues.put(Col_4,phone);
        contentValues.put(Col_5,gender);

        long result = db.insert(TABLE_NAME,null,contentValues);

        if(result == -1)
            return  false;
        else
            return true;
    }

}
