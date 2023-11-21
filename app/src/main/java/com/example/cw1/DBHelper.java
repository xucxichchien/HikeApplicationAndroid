package com.example.cw1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.ColorSpace;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context) {
        super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //create table on database
        db.execSQL(Constants.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        //upgrade table if any structure change in db
        //drop table if exists
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_NAME);

        //create table again
        onCreate(db);

    }

    // Insert func to insert data
    public long insertHike(String hikename, String location, String date, String parking,
                           String level, String length, String desc, String addedTime, String updatedTime){
        //get writable database to write data in db
        SQLiteDatabase db = this.getWritableDatabase();

        //create ContentValue class object to save data
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constants.C_HIKE, hikename);
        contentValues.put(Constants.C_LOCATION, location);
        contentValues.put(Constants.C_DATE, date);
        contentValues.put(Constants.C_PARKING, parking);
        contentValues.put(Constants.C_LEVEL, level);
        contentValues.put(Constants.C_LENGTH, length);
        contentValues.put(Constants.C_DESC, desc);
        contentValues.put(Constants.C_ADDED_TIME, addedTime);
        contentValues.put(Constants.C_UPDATED_TIME, updatedTime);

        //insert data in row, it will return id of record
        long id = db.insert(Constants.TABLE_NAME, null,contentValues);

        //close db
        db.close();

        //return id
        return id;
    }

    //getdata
    public ArrayList<ModelHike> getAllData(){
        //create arrayLisyt
        ArrayList<ModelHike> arrayList = new ArrayList<>();
        //sql command
        String selectQuery = "SELECT * FROM "+ Constants.TABLE_NAME;

        //get readable db
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
            ////loop through all record and add to list
        if (cursor.moveToFirst()){
            do{
                ModelHike modelHike = new ModelHike(
                    ""+cursor.getInt(cursor.getColumnIndexOrThrow(Constants.C_ID)),
                        ""+cursor.getString(cursor.getColumnIndexOrThrow(Constants.C_HIKE)),
                        ""+cursor.getString(cursor.getColumnIndexOrThrow(Constants.C_LOCATION)),
                        ""+cursor.getString(cursor.getColumnIndexOrThrow(Constants.C_DATE)),
                        ""+cursor.getString(cursor.getColumnIndexOrThrow(Constants.C_PARKING)),
                        ""+cursor.getString(cursor.getColumnIndexOrThrow(Constants.C_LENGTH)),
                        ""+cursor.getString(cursor.getColumnIndexOrThrow(Constants.C_DESC)),
                        ""+cursor.getString(cursor.getColumnIndexOrThrow(Constants.C_LEVEL)),
                        ""+cursor.getString(cursor.getColumnIndexOrThrow(Constants.C_ADDED_TIME)),
                        ""+cursor.getString(cursor.getColumnIndexOrThrow(Constants.C_UPDATED_TIME))
                );
                arrayList.add(modelHike);
            }while(cursor.moveToNext());

        }
        db.close();
        return arrayList;
}
}
