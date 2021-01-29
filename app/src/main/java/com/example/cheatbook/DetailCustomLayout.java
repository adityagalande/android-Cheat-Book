package com.example.cheatbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailCustomLayout extends AppCompatActivity {
    GameData gameData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_custom_layout);

        getSupportActionBar().setTitle("Most Popular");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSelectedShape();
        setValues();
        Log.v("DetailCustomLayout","-----------------------------------------------------------OnCreate");
    }

    private void getSelectedShape(){
        Intent previousIntent = getIntent();
        String parsedId = previousIntent.getStringExtra("Id");
        gameData = MainActivity.mostPopular.get(Integer.parseInt(parsedId));
        Log.v("DetailCustomLayout","-----------------------------------------------------------getSelectedShape");
    }

    private void setValues(){
        TextView gametitle = (TextView) findViewById(R.id.gameTitle);
        TextView gameDesc = (TextView) findViewById(R.id.gameDescription);
        ImageView gameTitleImage = (ImageView) findViewById(R.id.gameImageTitle);

        Log.v("DetailCustomLayout","-----------------------------------------------------------setValues");
        gameTitleImage.setImageResource(gameData.getImageID());
        gametitle.setText(gameData.getTitle());
        gameDesc.setText(gameData.getGameCheatDetails());
    }
}