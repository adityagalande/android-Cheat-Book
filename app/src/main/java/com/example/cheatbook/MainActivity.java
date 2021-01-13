package com.example.cheatbook;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout pcButton = (RelativeLayout) findViewById(R.id.pc_button);
        RelativeLayout ps3Button = (RelativeLayout) findViewById(R.id.ps3_button);
        RelativeLayout ps4Button = (RelativeLayout) findViewById(R.id.ps4_button);
        RelativeLayout xboxButton = (RelativeLayout) findViewById(R.id.xbox_button);

        pcButton.setOnClickListener(this);
        ps3Button.setOnClickListener(this);
        ps4Button.setOnClickListener(this);
        xboxButton.setOnClickListener(this);


        final ArrayList<GameData> mostPopular = new ArrayList<>();
        mostPopular.add(new GameData("Red Dead Redemption II", "26 October 2018", "4.7", R.drawable.red_dead_redemption_2));
        mostPopular.add(new GameData("Assassin's Creed Valhalla", "10 November 2020", "3.8", R.drawable.assassins_creed_valhalla));
        mostPopular.add(new GameData("Cyberpunk 2077", "10 December 2020", "4.5", R.drawable.cyberpunk_2077));
        mostPopular.add(new GameData("Inside", "29 June 2016", "4.8", R.drawable.inside));
        mostPopular.add(new GameData("Among Us", "15 Jun 2018", "4.5", R.drawable.amongus));
        mostPopular.add(new GameData("Grand Theft Auto V", "17 September 2013", "4.9", R.drawable.grand_theft_auto_v));
        mostPopular.add(new GameData("Fortnite", "21 July 2017", "3.5", R.drawable.fortnite));
        mostPopular.add(new GameData("Fall Guys: Ultimate Knockout", "04 Aug 2020", "3.7", R.drawable.fall_guys));
        mostPopular.add(new GameData("Rocket League", " 7 July 2015", "4.1", R.drawable.rocket_league));
        mostPopular.add(new GameData("PlayerUnknown's Battlegrounds", "23 March 2017", "4.5", R.drawable.playersunknowns_battlegrounds));
        mostPopular.add(new GameData("Alien: Isolation", "6 October 2014", "4.7", R.drawable.alien_isolation));
        mostPopular.add(new GameData("Assassin's Creed Odyssey", "2 October 2018", "4.3", R.drawable.assassins_creed_odyssey));
        mostPopular.add(new GameData("Minecraft", "18 November 2011", "3.4", R.drawable.minecraft));

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