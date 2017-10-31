package com.example.mehak.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int scoreA = 0;
    int scoreB=0;

    public void displayForA(int score){
        TextView scoreView= (TextView) findViewById(R.id.a_score);
        scoreView.setText(String.valueOf(score));
    }
    public void displayForB(int score){
        TextView scoreView= (TextView) findViewById(R.id.b_score);
        scoreView.setText(String.valueOf(score));
    }


    public void show3(View view){
        scoreA = scoreA +3;
        displayForA(scoreA);
    }
    public void show2(View view){
        scoreA = scoreA +2;
        displayForA(scoreA);

    }
    public void showFree(View view){
        scoreA = scoreA +1;
        displayForA(scoreA);

    }

    public void show3b(View view){
        scoreB = scoreB +3;
        displayForB(scoreB);
    }
    public void show2b(View view){
        scoreB = scoreB +2;
        displayForB(scoreB);

    }
    public void showFreeb(View view){
        scoreB = scoreB +1;
        displayForB(scoreB);

    }
    public void resetFxn(View v){
       // TextView ta= (TextView) findViewById(R.id.a_score);

        displayForB(0);
        displayForA(0);
    }
}
