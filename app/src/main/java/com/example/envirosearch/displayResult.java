package com.example.envirosearch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import java.util.*;

public class displayResult extends AppCompatActivity {

    LinkedList<String> Titles;
    LinkedList<String> URLs;
    LinkedList<String> Dates;
    LinkedList<String> Snippets;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_result);
    }
}