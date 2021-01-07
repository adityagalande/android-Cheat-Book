package com.example.cheatbook;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout pcButton = (RelativeLayout ) findViewById(R.id.pc_button);
        RelativeLayout ps3Button = (RelativeLayout ) findViewById(R.id.ps3_button);
        RelativeLayout ps4Button = (RelativeLayout ) findViewById(R.id.ps4_button);
        RelativeLayout xboxButton = (RelativeLayout ) findViewById(R.id.xbox_button);

        pcButton.setOnClickListener(this);
        ps3Button.setOnClickListener(this);
        ps4Button.setOnClickListener(this);
        xboxButton.setOnClickListener(this);


        final ArrayList<GameData> mostPopular = new ArrayList<>();
        mostPopular.add(new GameData("Age of Empire III","18 October 2005","3.5", R.mipmap.age_of_empire_3));
        mostPopular.add(new GameData("Age of Empire III","18 October 2005","1.5", R.mipmap.age_of_empire_2_the_age_of_king));
        mostPopular.add(new GameData("Age of Empire III","18 October 2005","4.5", R.mipmap.age_of_empire_2_the_conqurors_expansion));
        mostPopular.add(new GameData("Age of Empire III","18 October 2005","2.5", R.mipmap.age_of_mythology));

        ListView listView = (ListView) findViewById(R.id.mostPopularView);
        GameDataAdapter gameDataAdapter = new GameDataAdapter(this, mostPopular);
        listView.setAdapter(gameDataAdapter);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.pc_button:
                Intent number = new Intent(this, PCActivity.class);
                startActivity(number);
                break;

            case R.id.ps3_button:
                Intent family = new Intent(this, PS3Activity.class);
                startActivity(family);
                break;

            case R.id.ps4_button:
                Intent color = new Intent(this, PS4Activity.class);
                startActivity(color);
                break;

            case R.id.xbox_button:
                Intent phrases = new Intent(this, XboxActivity.class);
                startActivity(phrases);
                break;
        }

    }
}