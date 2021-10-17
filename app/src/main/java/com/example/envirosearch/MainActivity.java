package com.example.envirosearch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
<<<<<<< Updated upstream
=======
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.regex.*;
>>>>>>> Stashed changes

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onChange(View view){
        companyNameInput = (EditText)findViewById(R.id.companyNameInput);
        companyName = companyNameInput.getText().toString();
        Pattern p= Pattern.compile("([a-zA-Z]+([\\-][a-zA-Z]+)*)");
        Matcher m=p.matcher(companyName);
        TextView txtView = (TextView)findViewById(R.id.Error);
        if (!m.matches())
            txtView.setVisibility(View.INVISIBLE);
        else
            txtView.setVisibility(View.VISIBLE);
    }
}