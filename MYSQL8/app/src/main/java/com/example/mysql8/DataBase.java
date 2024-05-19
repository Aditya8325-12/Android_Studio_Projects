package com.example.mysql8;

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

    private static final int DATABASEVERSION=1;
    private static final String DATABASENAME="MYTABLEADITYA";
    private  static final String TABLENAME=" mytableaditya ";
    private static final String ID="id";
    private  static final String NAME="name";

    public DataBase(@Nullable Context context) {
        super(context, DATABASENAME, null, DATABASEVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CreateTable=" CREATE TABLE "+TABLENAME+" ( "+ID+" INTEGER PRIMARY KEY, "+NAME+" TEXT "+" ) ";
        db.execSQL(CreateTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS "+TABLENAME);
        onCreate(db);
    }

    public void addStudent(Student student)
    {
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(ID,student.getId());
        contentValues.put(NAME,student.getName());
        database.insert(TABLENAME,null,contentValues);
        database.close();
    }

    public  Student getStudent(int id)
    {
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery(" SELECT * FROM "+ TABLENAME+" WHERE id="+id+"",null);

        if(cursor !=null)
        {
            cursor.moveToFirst();
            student=new Student(Integer.parseInt(cursor.getString(0)),cursor.getString(1));
        }
        return  student;
    }

    public List<Student> getAllStudent()
    {
        List<Student> students=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery(" SELECT * FROM "+TABLENAME,null);
        if(cursor.moveToFirst())
        {
            do {

                student=new Student();
                student.setId(cursor.getInt(0));
                student.setName(cursor.getString(1));
                students.add(student);
            }while (cursor.moveToNext());
        }

        return students;
    }

    public Boolean updateValue(int id,String name)
    {
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(ID,id);
        contentValues.put(NAME,name);
        database.update(TABLENAME,contentValues,ID +" = ? ",new String[]{String.valueOf(id)});
        database.close();
        return  true;
    }


    public  boolean DeleteValue(Student student)
    {
        SQLiteDatabase database=this.getReadableDatabase();
        database.delete(TABLENAME,ID+" = ? ",new String[]{String.valueOf(student.getId())});
        database.close();
        return true;
    }








}
