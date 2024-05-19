package com.example.mysql5;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBase extends SQLiteOpenHelper {

    public  static  String DATABASENAME="userCreation";
    public  static  int DATABASEVERSION=1;
    public  static  String TABLENAME="aditya";
    public static String ID="id";
    public static String PASSWORD="password";
    public static String NAME="Name";
    public static String EMAIL="email";

    Student student;


    public DataBase(@Nullable Context context) {
        super(context, DATABASENAME, null, DATABASEVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CreateTable="CREATE TABLE "+TABLENAME+"("+ID+" integer primary key, "+PASSWORD+" integer, "+NAME+" text, "+EMAIL+" text"+")";
        db.execSQL(CreateTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLENAME);
        onCreate(db);
    }

    public void putValueInDataBase(Student student)
    {
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(ID,student.getId());
        contentValues.put(PASSWORD,student.getPassword());
        contentValues.put(NAME,student.getName());
        contentValues.put(EMAIL,student.getEmail());

        database.insert(TABLENAME,null,contentValues);
        database.close();
    }


    public List<Student> getValueFromdataBase()
    {
        List<Student> createUserList=new ArrayList<>();
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor cursor=database.rawQuery(" SELECT  * FROM "+TABLENAME,null);
        if(cursor.moveToFirst())
        {
            do {
                student=new Student();
                student.setId(Integer.parseInt(cursor.getString(0)));
                student.setPassword(Integer.parseInt(cursor.getString(1)));
                student.setName(cursor.getString(2));
                student.setEmail(cursor.getString(3));
                createUserList.add(student);

            }while (cursor.moveToNext());

        }
        return createUserList;
    }



    public Boolean updateTheTable(int id,String name ,int password,String email)
    {
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(NAME,name);
        contentValues.put(PASSWORD,password);
        contentValues.put(EMAIL,email);
        database.update(TABLENAME, contentValues,ID + " = ? ", new String[]{String.valueOf(id)});
        return true;
    }


    public void DeleteTheTable(Student student)
    {
        SQLiteDatabase database=this.getWritableDatabase();
        database.delete(TABLENAME,ID+" =? ",new String[]{String.valueOf(student.getId())});

    }


    @SuppressLint("Range")
    public  int getLastCount()
    {
        int count=0;
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor cursor=database.rawQuery(" SELECT * FROM "+TABLENAME,null);
        if(cursor!=null && !cursor.isClosed())
        {
            cursor.moveToLast();
            if(cursor.getCount()==0)
            {
                count=1;
            }
            else {
                count=cursor.getInt(cursor.getColumnIndex(ID));
            }
        }
        return count;
    }



}
