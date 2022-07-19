package com.example.studentmanagementapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.nio.file.FileAlreadyExistsException;
import java.util.Date;

import io.bloco.faker.Faker;

public class Database {

    public static SQLiteDatabase db;
    public static String appPath;

    public static void initDB() {
        String path = appPath + "/studentDB";
        try {
            db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        } catch(Exception e) {
            e.printStackTrace();
        }
        db.beginTransaction();
        try {
            db.execSQL("drop table if exists Student");
            db.execSQL("create table if not exists Student(mssv integer PRIMARY KEY AUTOINCREMENT, name text, dateOfBirth text, email text)");
            Faker faker = new Faker();
            for (int i = 0; i < 100; i++) {
                String name = faker.name.name();
                String dateOfBirth = faker.date.birthday().toString();
                String email = faker.name.name() + "@gmail.com";

                String sql = "insert into Student(name, dateOfBirth, email) values(name, dateOfBirth, email)";
                db.execSQL(sql);
                Log.v("TAG", "" + i);
            }
            db.setTransactionSuccessful();

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    public static void getData() {
        String sql = "select * from Student";
        Cursor cs = db.rawQuery(sql, null);
        while (cs.moveToNext()) {
            int recID = cs.getInt(0);
            String name = cs.getString(1);
            String phone = cs.getString(2);

            Log.v("TAG", recID + " --- " +name + " --- " + phone);
        }

    }
}
