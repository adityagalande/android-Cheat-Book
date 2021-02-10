package com.example.cheatbook;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Objects;

public class About extends AppCompatActivity {

    private String version = "Version 1.0.0";
    private String content = "Nurtured from the seed of a single great idea - to empower the Gaming Enthusiast.\n" +
            "CheatBook is a pioneer in Gamer’s community.\n" +
            "Founded by Aditya Galande,\n" +
            "CheatBook came to life to support the Gaming enthusiast with Tips, Tricks, Hints and Cheat Codes comprehensive choices.\n" +
            "CheatBook also offering Tips, Tricks and Hints with different platforms like PC, Playstation3, PlayStation4, Xbox etc.\n";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        try {
            Objects.requireNonNull(this.getSupportActionBar()).hide();
        } catch (NullPointerException ignored) {
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);


        TextView textView = findViewById(R.id.about_content);
        textView.setText(content);

        TextView textViewVersion = findViewById(R.id.about_version);
        textViewVersion.setText(version);
    }
}