package com.example.mysqlexample3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBase extends SQLiteOpenHelper {

    public  static  String DataBaseName="Student";
    public static  int DataBaseVersion=1;

    public  static  String TABLENAME=" tablestudent";
    public  static String USERNAME="username";
    public  static String PASSWORD="password";
    public  static String EMAIL="email";

    CreateAccount createAccount;

    public DataBase(@Nullable Context context) {
        super(context, DataBaseName, null, DataBaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CreateTable="CREATE TABLE "+TABLENAME+" ( "+USERNAME+" INTEGER PRIMARY KEY, "+PASSWORD+ " INTEGER, "+ EMAIL +" VARCHAR(50) "+")";
        db.execSQL(CreateTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLENAME);
        onCreate(db);
    }



    public void putValueInDataBase(CreateAccount createAccount)
    {
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("username",USERNAME);
        contentValues.put("password",PASSWORD);
        contentValues.put("Email",EMAIL);

        database.insert(TABLENAME,null,contentValues);
        database.close();
    }


    public List<CreateAccount> getAllElement()
    {

        List<CreateAccount> createAccountslist=new ArrayList<>();
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor cursor=database.rawQuery("SELECT * FROM "+TABLENAME,null);
        if(cursor.moveToFirst())
        {
            do {
                createAccount.setUName(Integer.parseInt(cursor.getString(0)));
                createAccount.setPWord(Integer.parseInt(cursor.getString(1)));
                createAccount.setEmail(cursor.getString(2));
                createAccountslist.add(createAccount);
            }while (cursor.moveToNext());
        }
        return createAccountslist;
    }


    public int getcount()
    {
        int counte=0;
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor cursor=database.rawQuery("SELECT * FROM "+TABLENAME,null);
        if(cursor!=null && !cursor.isClosed())
        {
            counte=cursor.getCount();
            cursor.close();
        }
        return counte;
    }



}

