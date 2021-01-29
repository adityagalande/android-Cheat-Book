package com.example.cheatbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

public class PCActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pc);
//
//        getSupportActionBar().setTitle("Personal Computer");
//        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

//    @Override
//    public void finish() {
//     This code for Animation for spcific activity
//        super.finish();
//        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
//    }
}