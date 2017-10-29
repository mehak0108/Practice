package com.example.mehak.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** public void submitOrder(View view)
    {
        displayPrice(numofc * 5);
    }*/

    public void submitOrder(View view)
    {
        /** displayPrice(numofc * 5);*/
        int price= numofc*5;
        String pricemsg="Total :$" + price;
        pricemsg = pricemsg + "\nThank you!";

        displayMsg(pricemsg);

    }

    private void display(int number){
        TextView tv= (TextView) findViewById(
                R.id.q_tv
        );
        tv.setText("" + number);
    }

    private void displayPrice(int num){
        TextView priceTextview=(TextView) findViewById(R.id.price_tv);
        priceTextview.setText(NumberFormat.getCurrencyInstance().format(num));

    }
    int numofc=0;
    public void increase(View view)
    {

        numofc=numofc+1;
        display(numofc);

    }
    public void decrease(View view)
    {
        if(numofc == 0)
            numofc = 0;
        else
            numofc=numofc-1;

        display(numofc);

    }

    public void displayMsg(String msg){
        TextView priceTextview=(TextView) findViewById(R.id.price_tv);
        priceTextview.setText(msg);
    }



}
