package com.example.cheatbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class RequestGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_game);

        getSupportActionBar().setTitle("Request Game");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}