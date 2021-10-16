package com.example.envirosearch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.text.method.LinkMovementMethod;

import java.util.*;

public class displayResult extends AppCompatActivity {

    /*LinkedList<String> Titles;
    LinkedList<String> URLs;
    LinkedList<String> Snippets;
    */



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_result);

        Bundle extras = getIntent().getExtras();
        ArrayList<searchResult> SR = null;
        if (extras != null) {
            SR = (ArrayList<searchResult>) getIntent().getSerializableExtra("key");
        }
        TextView txtView = (TextView)findViewById(R.id.textView);
        txtView.setText(SR.get(0).title);


        TextView hyper1= (TextView) findViewById(R.id.textView2);
        hyper1.setMovementMethod(LinkMovementMethod.getInstance());

        TextView hyper2= (TextView) findViewById(R.id.textView5);
        hyper2.setMovementMethod(LinkMovementMethod.getInstance());

        TextView hyper3= (TextView) findViewById(R.id.textView8);
        hyper3.setMovementMethod(LinkMovementMethod.getInstance());

        TextView hyper4= (TextView) findViewById(R.id.textView11);
        hyper4.setMovementMethod(LinkMovementMethod.getInstance());

        TextView hyper5= (TextView) findViewById(R.id.textView14);
        hyper5.setMovementMethod(LinkMovementMethod.getInstance());

        // or do: for(int i =0, int j = 2; i < 5; i++, j=j+3)
    }

    public displayResult(LinkedList<searchResult> results){

    }

    public static void main(String args[]){
        //displayResult all_results = new displayResult();

    }
}