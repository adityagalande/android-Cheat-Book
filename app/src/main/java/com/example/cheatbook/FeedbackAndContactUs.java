package com.example.cheatbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class FeedbackAndContactUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_and_contact_us);

        getSupportActionBar().setTitle("----------------");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}