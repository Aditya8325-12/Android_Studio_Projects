package com.example.tictoktoegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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
        if(((Button)view).getText().toString().equals(""))
        {

            if(p1)
            {
                ((Button)view).setText("x");
            }
            else
            {
                ((Button)view).setText("0");
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
                return true;
            }
            if (f[0][i].equals(f[1][i]) && f[0][i].equals(f[2][i]) && !f[0][i].equals("")) {
                return true;
            }
        }
        if (f[0][0].equals(f[1][1]) && f[0][0].equals(f[2][2]) && !f[0][0].equals("")) {
            return true;
        }
        if (f[0][2].equals(f[1][1]) && f[0][2].equals(f[2][0]) && !f[0][2].equals("")) {
            return true;
        }
        return false;
    }
}