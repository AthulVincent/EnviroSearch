package com.example.envirosearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    // User input variable declarations
    String companyName;
    EditText companyNameInput;
    Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent myIntent = new Intent(this, displayResult.class);

    }

    public void onBtnClick(View view){
        companyNameInput = (EditText)findViewById(R.id.companyNameInput);

        companyName = companyNameInput.getText().toString();
        Pattern p = Pattern.compile("([a-zA-Z]+([\\-][a-zA-Z]+)*)");
        Matcher m = p.matcher(companyName);
        TextView txtView = (TextView) findViewById(R.id.Error);
        if (!m.matches())
            txtView.setVisibility(View.VISIBLE);
        else {
            txtView.setVisibility(View.INVISIBLE);
            googleUtil obj = new googleUtil(this);
            obj.getSearchResults(companyName);
        }
    }
}