package com.example.mysql4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBase extends SQLiteOpenHelper {

    public  static  String DATABASENAME="userCreatio";
    public  static  int DATABASEVERSION=1;
    public  static  String TABLENAME="aditya";
    public static String ID="id";
    public static String PASSWORD="password";
    public static String NAME="Name";
    public static String EMAIL="email";



    CreateUser createUser;

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


    public  void putValueInDataBase(CreateUser createUser)
    {
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

            contentValues.put(ID,createUser.getId());
            contentValues.put(PASSWORD,createUser.getPassword());
            contentValues.put(NAME,createUser.getName());
            contentValues.put(EMAIL,createUser.getEmail());

        database.insert(TABLENAME,null,contentValues);
        database.close();
    }


    public List<CreateUser> getValueFromDataBase()
    {

        List<CreateUser> createUserList=new ArrayList<>();
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor cursor=database.rawQuery(" SELECT  * FROM "+TABLENAME,null);
        if(cursor.moveToFirst())
        {
            do {
                createUser =new CreateUser();
                createUser.setId(Integer.parseInt(cursor.getString(0)));
                createUser.setPassword(Integer.parseInt(cursor.getString(1)));
                createUser.setName(cursor.getString(2));
                createUser.setEmail(cursor.getString(3));
                createUserList.add(createUser);

            }while (cursor.moveToNext());

        }
        return createUserList;
    }

    public  int getStudentsCount()
    {
        int count =0;
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor cursor=database.rawQuery(" SELECT * FROM "+TABLENAME,null);

        if(cursor!=null && !cursor.isClosed())
        {
            count= cursor.getCount();
            cursor.close();
        }
        return count;
    }


    public  CreateUser getSingleValue(int id)
    {
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor cursor=database.rawQuery(" SELECT  * FROM "+TABLENAME+" WHERE  ID="+id,null);
        if(cursor!=null)
        {
            cursor.moveToFirst();
            createUser=new CreateUser();
            createUser.setId(Integer.parseInt(cursor.getString(0)));
            createUser.setPassword(Integer.parseInt(cursor.getString(1)));
            createUser.setName(cursor.getString(2));
            createUser.setEmail(cursor.getString(3));
        }
        return createUser;
    }


    public  void deleteDataBase(CreateUser createUser)
    {

    }




}
