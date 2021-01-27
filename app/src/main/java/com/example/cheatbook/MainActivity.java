package com.example.cheatbook;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SearchView;

import java.util.ArrayList;

import GameContent.GameContents;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final ArrayList<GameData> mostPopular = new ArrayList<GameData>();
    SearchView searchView;
    private ListView listView;
    private final String selectFilter = "all";
    private String currentSearchText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
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

        initSearchWidgets();
        mostPopular.add(new GameData("0","Red Dead Redemption II", "26 October 2018", "4.7", R.drawable.red_dead_redemption_2, GameContents.Red_Dead_Redemption_II_PC));
        mostPopular.add(new GameData("1","Assassin's Creed Valhalla", "10 November 2020", "3.8", R.drawable.assassins_creed_valhalla, GameContents.Assassins_Creed_Valhalla_PC));
        mostPopular.add(new GameData("2","Cyberpunk 2077", "10 December 2020", "4.5", R.drawable.cyberpunk_2077, GameContents.Cyberpunk_2077_PC));
        mostPopular.add(new GameData("3","Inside", "29 June 2016", "4.8", R.drawable.inside, GameContents.Inside_PC));
        mostPopular.add(new GameData("4","Among Us", "15 Jun 2018", "4.5", R.drawable.amongus, GameContents.Among_Us_PC));
        mostPopular.add(new GameData("5","Grand Theft Auto V", "17 September 2013", "4.9", R.drawable.grand_theft_auto_v, GameContents.Grand_Theft_Auto_V_Pc));
        mostPopular.add(new GameData("6","Fortnite", "21 July 2017", "3.5", R.drawable.fortnite, GameContents.Fortnite_PC));
        mostPopular.add(new GameData("7","Fall Guys: Ultimate Knockout", "04 Aug 2020", "3.7", R.drawable.fall_guys, GameContents.Fall_Guys_Ultimate_Knockout_PC));
        mostPopular.add(new GameData("8","Rocket League", " 7 July 2015", "4.1", R.drawable.rocket_league, GameContents.Rocket_League_PC));
        mostPopular.add(new GameData("9","PlayerUnknown's Battlegrounds", "23 March 2017", "4.5", R.drawable.playersunknowns_battlegrounds, GameContents.PlayerUnknowns_Battlegrounds_PC));
        mostPopular.add(new GameData("10","Alien: Isolation", "6 October 2014", "4.7", R.drawable.alien_isolation, GameContents.Alien_Isolation_PC));
        mostPopular.add(new GameData("11","Assassin's Creed Odyssey", "2 October 2018", "4.3", R.drawable.assassins_creed_odyssey, GameContents.Assassins_Creed_Odyssey_PC));
        mostPopular.add(new GameData("12","Minecraft", "18 November 2011", "3.4", R.drawable.minecraft, GameContents.Minecraft_PC));

        listView = (ListView) findViewById(R.id.mostPopularView);
        GameDataAdapter gameDataAdapter = new GameDataAdapter(this, 0, mostPopular);
        listView.setAdapter(gameDataAdapter);

        setUpOnClickListener();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mostPopular.clear();
        Log.v("MainActivity", "-----------------------------------------------------------OnDestroyed");
    }

    private void initSearchWidgets() {
        searchView = (SearchView) findViewById(R.id.search_bar);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String newText) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                currentSearchText = newText;
                ArrayList<GameData> filterShapes = new ArrayList<>();

                for (GameData gameData : mostPopular) {
                    if (gameData.getTitle().toLowerCase().contains(newText.toLowerCase())) {
                        filterShapes.add(gameData);
                    }
                }
                GameDataAdapter adapter = new GameDataAdapter(getApplicationContext(), 0, filterShapes);
                listView.setAdapter(adapter);

                return false;
            }
        });
    }


    private void setUpOnClickListener(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                GameData gameData = (GameData) (listView.getItemAtPosition(position));
                Intent intent = new Intent(getApplicationContext(), DetailCustomLayout.class);
                intent.putExtra("Id", gameData.getId());
                startActivity(intent);
                Log.v("MainActivity","-----------------------------------------------------------setUpOnClickListener");
            }
        });

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