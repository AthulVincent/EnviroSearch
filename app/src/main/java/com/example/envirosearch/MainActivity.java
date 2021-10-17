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
        googleUtil obj = new googleUtil(this);
        obj.getSearchResults(companyName);
    }
}