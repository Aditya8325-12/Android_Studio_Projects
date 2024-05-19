package com.example.mysql6;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBase extends SQLiteOpenHelper {


    Student student;

    public  static  String DATABASENAME="mydatabase";
    public  static int DATABASEVERSION=1;

   public static String TABLENAME="MyTable";
   public static String NAME="name";
   public static String ID="id";

    public DataBase(@Nullable Context context) {
        super(context, DATABASENAME, null, DATABASEVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CreateTable=" CREATE TABLE "+TABLENAME+"("+ID+"INTEGER PRIMARY KEY, "+NAME+" TEXT  "+")";
        db.execSQL(CreateTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(" DROP TABLE IF EXISTS "+TABLENAME);
        onCreate(db);
    }


    public void putValueInDataBase(Student student)
    {
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(ID,student.getId());
        contentValues.put(NAME,student.getName());
        database.insert(TABLENAME,null,contentValues);
        database.close();
    }


    public List<Student> GetValueFromDataBase()
    {
        List<Student> studentList=new ArrayList<>();
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor cursor=database.rawQuery(" SELECT  * FROM "+TABLENAME,null);
        if(cursor.moveToFirst())
        {
            do {

                student=new Student();
                student.setId(Integer.parseInt(cursor.getString(0)));
                student.setName(cursor.getString(1));
                studentList.add(student);

            }while (cursor.moveToNext());
        }

        return studentList;

    }


}
