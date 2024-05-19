package com.example.saloun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Home extends AppCompatActivity {

    LinearLayout Home, Contact, MyProfile,Services;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Home =findViewById(R.id.Home);
        Contact =findViewById(R.id.Con);
        MyProfile =findViewById(R.id.Contact);
        Services=findViewById(R.id.Service);

        Services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Home.this,Services.class);
                startActivity(intent);
            }
        });

//        Home.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(Home.this,home.class);
//                startActivity(intent);
//            }
//        });
        Contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Home.this,Contact.class);
                startActivity(intent);
            }
        });
        MyProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Home.this,MyProfile.class);
                startActivity(intent);
            }
        });


}
}