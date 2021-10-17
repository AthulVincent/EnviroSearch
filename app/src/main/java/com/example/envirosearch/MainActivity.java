package com.example.envirosearch;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ImageView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {

    // Information pop-up buttons
    Button open;
    Dialog dialog;

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

    public void infoButtonClick(View view){
        openInfo("testing", "testtt");
    }

    public void infoClick(View view){
        dialog.dismiss();
    }

    // Clicking button for user input

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

    // Clicking info button
    private void openInfo(String example, String text) {
        Button close;
        TextView textView1;
        ImageView image;

        dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.information_popup);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        Window window = dialog.getWindow();
        window.setGravity(Gravity.CENTER);
        window.getAttributes().windowAnimations = R.style.DialogAnimation;

        close = dialog.findViewById(R.id.letsSearch);
        textView1 = dialog.findViewById(R.id.text);
        image = dialog.findViewById(R.id.image);

        dialog.setCancelable(true);
        window.setLayout(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
        dialog.show();
    }
}