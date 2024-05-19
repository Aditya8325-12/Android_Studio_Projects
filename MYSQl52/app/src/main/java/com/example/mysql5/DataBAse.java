package com.example.mysql5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBAse  extends SQLiteOpenHelper {

    Student student;

    public  static  String DATABASENAME="userCreation1";
    public  static  int DATABASEVERSION=1;
    public  static  String TABLENAME="aditya";
    public static String ID="id";
    public static String PASSWORD="password";
    public static String NAME="Name";
    public static String EMAIL="email";


    public DataBAse(@Nullable Context context) {
        super(context, DATABASENAME, null, DATABASEVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CreateTable="CREATE TABLE "+TABLENAME+"("+ID+" INTEGER PRIMARY KEY, "+NAME+" VARCHAR(100), "+PASSWORD+" INTEGER, "+EMAIL+" VARCHAR(100) "+")";
        db.execSQL(CreateTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLENAME);
        onCreate(db);
    }


    public  void PutValueInDataBase(Student student)
    {
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(ID,student.getId());
        contentValues.put(NAME,student.getName());
        contentValues.put(PASSWORD,student.getPassword());
        contentValues.put(EMAIL,student.getEmail());

        database.insert(TABLENAME,null,contentValues);
        database.close();
    }

    public Student getStudent(int id)
    {
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor cursor=database.rawQuery(" SELECT * FROM "+TABLENAME+" WHERE id="+id,null);


        if(cursor!=null)
        {
            cursor.moveToFirst();
            student=new Student(cursor.getInt(0),cursor.getString(1),cursor.getInt(2),cursor.getString(3));
        }

        return student;
    }


    public List<Student> getAllStudent()
    {
        List<Student> students=new ArrayList<>();
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor cursor=database.rawQuery(" SELECT * FROM "+TABLENAME,null);
        if(cursor.moveToFirst())
        {
            do {
                student =new Student();
                student.setId(Integer.parseInt(cursor.getString(0)));
                student.setName(cursor.getString(1));
                student.setPassword(Integer.parseInt(cursor.getString(2)));
                student.setEmail(cursor.getString(3));
                students.add(student);

            }while (cursor.moveToNext());
        }
        return students;
    }



    public  Boolean UpdateDataBase(int id,String name,int password,String email)
    {
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(ID,id);
        contentValues.put(NAME,name);
        contentValues.put(PASSWORD, password);
        contentValues.put(EMAIL,email);
        database.update(TABLENAME,contentValues,"id = ?"+id,new String[]{String.valueOf(id)});
        database.close();
        return true;
    }


    public int getCount()
    {
        int count=0;
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor cursor=database.rawQuery("SELECT * FROM "+TABLENAME,null);
        if(cursor!=null && cursor.isClosed())
        {
            cursor.moveToLast();
            count=cursor.getCount();
        }
        return count;
    }





}
