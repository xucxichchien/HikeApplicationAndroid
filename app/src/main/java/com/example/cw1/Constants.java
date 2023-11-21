package com.example.cw1;

public class Constants {
    //db
    public static final String DATABASE_NAME = "Hiking";
    public static final int DATABASE_VERSION = 1;

    //table
    public static final  String TABLE_NAME = "Hike_table";

    //table column/field
    public static final  String C_ID = "ID";
    public static final String C_HIKE = "HIKE";
    public static final String C_LOCATION = "LOCATION";
    public static final String C_DATE = "DATE";
    public static final String C_PARKING = "PARKING";
    public static final String C_LENGTH = "LENGTH";
    public static final String C_LEVEL = "LEVEL";
    public static final String C_DESC = "DESC";
    public static final String C_ADDED_TIME ="ADDED_TIME";
    public static final String C_UPDATED_TIME = "UPDATED_TIME";

    //query create
    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +
            "( " + C_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + C_HIKE + " TEXT, "
            +C_LOCATION + " TEXT, "
            + C_DATE + " TEXT,"
            + C_PARKING + " TEXT,"
            + C_LENGTH + " TEXT,"
            + C_LEVEL + " TEXT,"
            + C_DESC + " TEXT,"
            + C_ADDED_TIME + " TEXT, "
            + C_UPDATED_TIME + " TEXT " + ");";

    // Create database helper class for CRUD Query and Database

}
