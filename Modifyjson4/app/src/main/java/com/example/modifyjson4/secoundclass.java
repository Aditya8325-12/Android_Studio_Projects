package com.example.modifyjson4;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class secoundclass {

HttpURLConnection httpURLConnection=null;
URL url=null;

    public  String getthedata(String webUrl)
    {
        try {
            url=new URL(webUrl);
            httpURLConnection=(HttpURLConnection) url.openConnection();
            InputStream inputStream=httpURLConnection.getInputStream();
            InputStream inputStream1=new BufferedInputStream(inputStream);

            String convertedString=convertthedata(inputStream1);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return  null;

    }


    public  String convertthedata(InputStream inputStream)
    {

        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
        try {
            StringBuilder stringBuilder=new StringBuilder();
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
