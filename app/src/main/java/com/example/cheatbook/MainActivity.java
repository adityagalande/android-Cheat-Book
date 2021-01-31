package com.example.cheatbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SearchView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import GameContent.GameContents;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //variable
    static final float END_SCALE = 0.7f;

    ImageView menuIcon;

    RelativeLayout pcButton;
    RelativeLayout ps3Button;
    RelativeLayout ps4Button;
    RelativeLayout xboxButton;

    LinearLayout contentView;


    public static final ArrayList<GameData> mostPopular = new ArrayList<GameData>();
    SearchView searchView;
    private ListView listView;
    //    private final String selectFilter = "all";
    private String currentSearchText = "";

    //Drawer Menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);

        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException ignored) {
        }

        setContentView(R.layout.activity_main);

        //Menu hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_header_container);
        contentView = findViewById(R.id.content);


        menuIcon = (ImageView) findViewById(R.id.menu_icon);
        pcButton = (RelativeLayout) findViewById(R.id.pc_button);
        ps3Button = (RelativeLayout) findViewById(R.id.ps3_button);
        ps4Button = (RelativeLayout) findViewById(R.id.ps4_button);
        xboxButton = (RelativeLayout) findViewById(R.id.xbox_button);

        initSearchWidgets();
        mostPopular.add(new GameData("0", "Red Dead Redemption II", "26 October 2018", "4.7", R.drawable.red_dead_redemption_2, GameContents.Red_Dead_Redemption_II_PC));
        mostPopular.add(new GameData("1", "Assassin's Creed Valhalla", "10 November 2020", "3.8", R.drawable.assassins_creed_valhalla, GameContents.Assassins_Creed_Valhalla_PC));
        mostPopular.add(new GameData("2", "Cyberpunk 2077", "10 December 2020", "4.5", R.drawable.cyberpunk_2077, GameContents.Cyberpunk_2077_PC));
        mostPopular.add(new GameData("3", "Inside", "29 June 2016", "4.8", R.drawable.inside, GameContents.Inside_PC));
        mostPopular.add(new GameData("4", "Among Us", "15 Jun 2018", "4.5", R.drawable.amongus, GameContents.Among_Us_PC));
        mostPopular.add(new GameData("5", "Grand Theft Auto V", "17 September 2013", "4.9", R.drawable.grand_theft_auto_v, GameContents.Grand_Theft_Auto_V_Pc));
        mostPopular.add(new GameData("6", "Fortnite", "21 July 2017", "3.5", R.drawable.fortnite, GameContents.Fortnite_PC));
        mostPopular.add(new GameData("7", "Fall Guys: Ultimate Knockout", "04 Aug 2020", "3.7", R.drawable.fall_guys, GameContents.Fall_Guys_Ultimate_Knockout_PC));
        mostPopular.add(new GameData("8", "Rocket League", " 7 July 2015", "4.1", R.drawable.rocket_league, GameContents.Rocket_League_PC));
        mostPopular.add(new GameData("9", "PlayerUnknown's Battlegrounds", "23 March 2017", "4.5", R.drawable.playersunknowns_battlegrounds, GameContents.PlayerUnknowns_Battlegrounds_PC));
        mostPopular.add(new GameData("10", "Alien: Isolation", "6 October 2014", "4.7", R.drawable.alien_isolation, GameContents.Alien_Isolation_PC));
        mostPopular.add(new GameData("11", "Assassin's Creed Odyssey", "2 October 2018", "4.3", R.drawable.assassins_creed_odyssey, GameContents.Assassins_Creed_Odyssey_PC));
        mostPopular.add(new GameData("12", "Minecraft", "18 November 2011", "3.4", R.drawable.minecraft, GameContents.Minecraft_PC));

        listView = (ListView) findViewById(R.id.mostPopularView);
        GameDataAdapter gameDataAdapter = new GameDataAdapter(this, 0, mostPopular);
        listView.setAdapter(gameDataAdapter);

        setOnClickListenerForButton();
        setUpOnClickListener();
        navigationDrawer();
    }

    //Navigation Drawer function
    private void navigationDrawer() {
        //Navigation Drawer
        navigationView.bringToFront(); //to interact with that nav.drawer
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });

        animateNavigationDrawer();


    }

    private void animateNavigationDrawer() {

//        If you want to add color to right side of nav.Drawer
//        drawerLayout.setScrimColor(getResources().getColor(R.color.yellow));
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                //super.onDrawerSlide(drawerView, slideOffset);

                //scale the view based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                //Translation the view, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id) {

            case R.id.nav_home:
                if (drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                break;

            case R.id.nav_request_game:
                Intent navRequestGame = new Intent(MainActivity.this, RequestGame.class);
                startActivity(navRequestGame);
                break;

//            case R.id.nav_share:
//                break;
//
//            case R.id.nav_rate_us:
//                break;
//
            case R.id.nav_feedback:
                Intent navFeedback = new Intent(MainActivity.this, Feedback.class);
                startActivity(navFeedback);
                break;
//            case R.id.nav_contact_us:


            case R.id.nav_about:
                Intent navAbout = new Intent(MainActivity.this, About.class);
                startActivity(navAbout);
                break;

        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
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

    private void setOnClickListenerForButton() {
        pcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent number = new Intent(MainActivity.this, PCActivity.class);
                startActivity(number);
//                This code for Animation for spcific activity
//                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        ps3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent family = new Intent(MainActivity.this, PS3Activity.class);
                startActivity(family);
            }
        });

        ps4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent color = new Intent(MainActivity.this, PS4Activity.class);
                startActivity(color);
            }
        });

        xboxButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phrases = new Intent(MainActivity.this, XboxActivity.class);
                startActivity(phrases);
            }
        });
    }

    private void setUpOnClickListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                GameData gameData = (GameData) (listView.getItemAtPosition(position));
                Intent intent = new Intent(getApplicationContext(), DetailCustomLayout.class);
                intent.putExtra("Id", gameData.getId());
                startActivity(intent);
                Log.v("MainActivity", "-----------------------------------------------------------setUpOnClickListener");
            }
        });

    }

}