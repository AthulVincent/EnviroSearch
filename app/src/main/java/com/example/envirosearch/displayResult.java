package com.example.envirosearch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class displayResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_result);
        Bundle extras = getIntent().getExtras();
        ArrayList<searchResult> value = null;
        if (extras != null) {
           value = (ArrayList<searchResult>)getIntent().getSerializableExtra("key");
        }
        TextView txtView = (TextView)findViewById(R.id.textView);
        txtView.setText(value.get(0).title);
    }
}