package com.example.envirosearch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

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

        // or do: for(int i =0, int j = 2; i < 5; i++, j=j+3)

        int[] textviewids = {(R.id.textview2), (R.id.textview3), (R.id.textview4), (R.id.textview5), (R.id.textview6),
                (R.id.textview7), (R.id.textview8), (R.id.textview9), (R.id.textview10), (R.id.textview11),
                        (R.id.textview12), (R.id.textview13), (R.id.textview14), (R.id.textview15), (R.id.textview16),
                (R.id.textview17), (R.id.textview18), (R.id.textview19), (R.id.textview20), (R.id.textview21)
                        (R.id.textview22), (R.id.textview23), (R.id.textview24), (R.id.textview25), (R.id.textview26),
                (R.id.textview27), (R.id.textview28), (R.id.textview29), (R.id.textview30), (R.id.textview31)};

        int i = 0;

        ArrayList<TextView> textviewarray = new ArrayList<TextView>();

        for(; i <= 31; i++){
            textviewarray.add((TextView)findViewById(textviewids[i]));
        }

        for(int j = 2; j <= 29; j = j+3){
            textviewarray.get(j).setMovementMethod(LinkMovementMethod.getInstance());
        }

        Bundle extras = getIntent().getExtras();
        ArrayList<searchResult> SR = null;
        if (extras != null) {
            SR = (ArrayList<searchResult>) getIntent().getSerializableExtra("key");
        }

        for(int j = 0; j < SR.size(); j++){
            textviewarray.get(j*3).setText(SR.get(j).title);
            textviewarray.get(j*3+1).setText(SR.get(j).URL);
            textviewarray.get(j*3+2).setText(SR.get(j).Snippet);
        }

    }



}