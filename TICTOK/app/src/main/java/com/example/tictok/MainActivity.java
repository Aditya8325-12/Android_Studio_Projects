package com.example.tictok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    TextView player1,player2;
    Button reset;
    boolean p1=true;
    Button[][] b=new Button[3][3];
    int count1=0;

    int p1point=0;
    int p2point=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player1=findViewById(R.id.player1);
        player2=findViewById(R.id.player2);
        reset=findViewById(R.id.reset);


        int i,j;
        for(i=0;i<3;i++)
        {
            for(j=0;j<3;j++)
            {
                String bid="b"+i+j;
                int ide=getResources().getIdentifier(bid,"id",getPackageName());
                b[i][j]=findViewById(ide);
                b[i][j].setOnClickListener(this);

            }
        }

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hardgamereset();
            }
        });
    }

    @Override
    public void onClick(View view) {
        if(((Button)view).getText().toString().equals("")  )
        {

            if(p1)
            {
                ((Button)view).setText("x");
                ((Button)view).setBackgroundResource(R.drawable.o);
            }
            else
            {
                ((Button)view).setText("0");
                ((Button)view).setBackgroundResource(R.drawable.x);

            }
            count1++;

            if(chwckwin())
            {
                if(p1)
                {
                    player1wins();
                }
                else {
                    player2wins();
                }
            }
            else if(count1 == 9)
            {
                draw();
                count1=0;
            }
            else{
                p1=!p1;
            }
        }

    }

    public void draw()
    {
        Toast.makeText(this, "Game will be Draw", Toast.LENGTH_SHORT).show();
        gamereset();
    }
    public void player1wins()
    {
        Toast.makeText(this, "Player 1 Wins", Toast.LENGTH_SHORT).show();
        p1point++;
        count1=0;
        updatepoint();
        gamereset();
    }
    public void player2wins()
    {
        Toast.makeText(this, "Player 2 Wins", Toast.LENGTH_SHORT).show();
        p2point++;
        count1=0;
        updatepoint();
        gamereset();
    }
    public void updatepoint()
    {
        player1.setText("Player :"+p1point);
        player2.setText("Player :"+p2point);
    }


    public  void  gamereset()
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                b[i][j].setText("");
                b[i][j].setBackgroundResource(R.drawable.blacnk);
            }
        }
    }
    public  void  hardgamereset()
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                b[i][j].setText("");
                b[i][j].setBackgroundResource(R.drawable.blacnk);
            }
        }
        p1point=0;
        p2point=0;
        player1.setText("Player :"+p1point);
        player2.setText("Player :"+p2point);

    }


    public boolean chwckwin() {

        String[][] f = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                f[i][j] = b[i][j].getText().toString();
            }
        }

        for (int i = 0; i < 3; i++) {
            if (f[i][0].equals(f[i][1]) && f[i][0].equals(f[i][2]) && !f[i][0].equals("")) {
                Animation fin= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
                b[i][0].startAnimation(fin);
                b[i][1].startAnimation(fin);
                b[i][2].startAnimation(fin);
                return true;
            }
            if (f[0][i].equals(f[1][i]) && f[0][i].equals(f[2][i]) && !f[0][i].equals("")) {
                String s=b[0][0].getText().toString();
                Animation fin= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
                b[0][0].startAnimation(fin);
                b[i][1].startAnimation(fin);
                b[i][2].startAnimation(fin);
                return true;
            }
        }
        if (f[0][0].equals(f[1][1]) && f[0][0].equals(f[2][2]) && !f[0][0].equals("")) {
            Animation fin= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
            b[0][0].startAnimation(fin);
            b[1][1].startAnimation(fin);
            b[2][2].startAnimation(fin);
            return true;
        }
        if (f[0][2].equals(f[1][1]) && f[0][2].equals(f[2][0]) && !f[0][2].equals("")) {
            Animation fin= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
            b[0][2].startAnimation(fin);
            b[1][1].startAnimation(fin);
            b[2][0].startAnimation(fin);
            return true;

        }
        return false;
    }
}