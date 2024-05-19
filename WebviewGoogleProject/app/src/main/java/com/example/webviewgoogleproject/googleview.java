package com.example.webviewgoogleproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class googleview extends AppCompatActivity {

    WebView webView;
    String url="https://www.google.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_googleview);

        webView=findViewById(R.id.WebView2);

        WebSettings webSettings=webView.getSettings();

        webSettings.setJavaScriptEnabled(true);


        webView.setWebViewClient(new WebViewClient()
        {
            public  boolean overideurl(String url,WebView webView){
                webView.loadUrl(url);

                return true;
            }
        });

        webView.loadUrl(url);

    }
}