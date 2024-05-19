package com.example.sqlddatabaseexample1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
public class dataBase extends SQLiteOpenHelper {
    Studentclass studentclass;
    public  static  String DataBaseName="aditya";
    public  static  int DataBaseVersion=1;
    public  static String TableName="student";
    public  static  String ID="ID";
    public  static String NAME="NAME";
    public  static String AGE="AGE";
    public  static String CITY="CITY";



    public dataBase(@Nullable Context context) {
        super(context, DataBaseName,null,DataBaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CreateTable="CREATE TABLE "+TableName+" ( "+ID+" integer PRIMARY KEY , " +NAME+" text ,"+AGE+" text ,"+CITY+" text" + ")";
        db.execSQL(CreateTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" drop table if exists "+TableName);
        onCreate(db);
    }

    public void putValueInDataBase(Studentclass studentclass)
    {
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(ID,studentclass.getId());
        contentValues.put(NAME,studentclass.getName());
        contentValues.put(AGE,studentclass.getAge());
        contentValues.put(CITY,studentclass.getCity());
        database.insert(TableName,null,contentValues);
        database.close();
    }

    public Studentclass getValueFromDataBase(int id)
    {
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor cursor=database.rawQuery(" SELECT  * FROM "+TableName+" WHERE  ID="+id,null);
        if(cursor!=null)
        {
            cursor.moveToFirst();
             studentclass=new Studentclass(cursor.getInt(0), cursor.getString(1),cursor.getInt(2) , cursor.getString(2));
        }
        return studentclass;
    }

    public List<Studentclass> getAllStudents(){

        List<Studentclass> listStudent=new ArrayList<>();
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor cursor=database.rawQuery(" SELECT * FROM "+TableName,null);
        if(cursor.moveToFirst())
        {
            do {
                studentclass=new Studentclass();
                studentclass.setId(Integer.parseInt(cursor.getString(0)));
                studentclass.setName(cursor.getString(1));
                studentclass.setAge(Integer.parseInt(cursor.getString(2)));
                studentclass.setCity(cursor.getString(3));
                listStudent.add(studentclass);
            }while (cursor.moveToNext());
        }

        return listStudent;
    }


    public  int getStudentsCount()
    {
        int count =0;
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor cursor=database.rawQuery(" SELECT * FROM "+TableName,null);

        if(cursor!=null && !cursor.isClosed())
        {
            count= cursor.getCount();
            cursor.close();
        }
        return count;
    }

}
