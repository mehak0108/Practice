package com.example.mehak.justjava;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    int numofc=0;

    private int calculateP(boolean a, boolean b)
    {
        int baseprice= 5;

        if(a){
            baseprice = baseprice+1;
        }

        if(b){
            baseprice = baseprice + 2;
        }

        return baseprice * numofc;
    }


    public void submitOrder(View view)
    {


        CheckBox whipped= (CheckBox)findViewById(R.id.check);
        boolean haswhipped= whipped.isChecked();

        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        EditText textf= (EditText)findViewById(R.id.name);
        String tvalue = textf.getText().toString();

        int price= calculateP(haswhipped,hasChocolate);
        String pricemsg= createOrderSum(price,haswhipped,hasChocolate, tvalue);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java app for"+ tvalue );
        intent.putExtra(Intent.EXTRA_TEXT, pricemsg );
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    public String createOrderSum(int price,boolean b,boolean a, String n)
    {
        String msg= getString(R.string.order_summary_name,n);
        msg = msg+ "\nAdd whipped cream?:" + b;
        msg += "\nAdd chocolate? " + a;
        msg=msg+ "\nQuantity:" + numofc;
        msg= msg+ "\nTotal:" + price;
        msg= msg + "\n" + getString(R.string.thank_you);
        return msg;
    }


    private void display(int number){
        TextView tv= (TextView) findViewById(
                R.id.q_tv
        );
        tv.setText("" + number);
    }

    public void increase(View view)
    {
        if(numofc <= 100) {
            numofc = numofc + 1;
            display(numofc);
        }
        else
            return;
    }
    public void decrease(View view)
    {
        if(numofc == 0) {
            numofc = 0;
            Toast.makeText(this,"The number of coffees can't be negative",Toast.LENGTH_SHORT).show();
        }
        else
            numofc=numofc-1;

        display(numofc);

    }





}
