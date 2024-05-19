package com.example.jsonmodify1;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Jsonclass {

    public  static String getTheDataFromUrl(String url)
    {
        URL url1=null;
        HttpURLConnection httpURLConnection=null;
        try{

            url1=new URL(url);
            httpURLConnection=(HttpURLConnection)url1.openConnection();

            InputStream inputStream= httpURLConnection.getInputStream();
            InputStream inputStream1=new BufferedInputStream(inputStream);
            String GetIngTheDataInStringFormate=convertbytestostring(inputStream1);

            return  GetIngTheDataInStringFormate;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;

    }

    public static String convertbytestostring(InputStream inputStream)
    {

        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));

        StringBuilder stringBuilder=new StringBuilder();

        try {
            int i=bufferedReader.read();
            while (i!=-1)
            {
                stringBuilder.append((char)i );
                i=bufferedReader.read();
            }

            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }






}
