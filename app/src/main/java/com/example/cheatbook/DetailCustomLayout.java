package com.example.cheatbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Objects;

public class DetailCustomLayout extends AppCompatActivity {
    GameData gameData;
    FloatingActionButton shareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_detail_custom_layout);

        shareButton = (FloatingActionButton) findViewById(R.id.share);

         //To hide Title Bar
        try {
            Objects.requireNonNull(this.getSupportActionBar()).hide();
        } catch (NullPointerException ignored) {
        }


//        getSupportActionBar().setTitle("Most Popular");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSelectedShape();
        setValues();

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String shareData = gameData.getTitle() + "\n\n" + gameData.getGameCheatDetails();
                shareText(shareData);
            }
        });
    }








    private void shareText(String textToShare) {
        // COMPLETED (2) Create a String variable called mimeType and set it to "text/plain"
        /*
         * You can think of MIME types similarly to file extensions. They aren't the exact same,
         * but MIME types help a computer determine which applications can open which content. For
         * example, if you double click on a .pdf file, you will be presented with a list of
         * programs that can open PDFs. Specifying the MIME type as text/plain has a similar affect
         * on our implicit Intent. With text/plain specified, all apps that can handle text content
         * in some way will be offered when we call startActivity on this particular Intent.
         */
        String mimeType = "text/plain";

        // COMPLETED (3) Create a title for the chooser window that will pop up
        /* This is just the title of the window that will pop up when we call startActivity */
        String title = "Share CheatBook Code!";

        // COMPLETED (4) Use ShareCompat.IntentBuilder to build the Intent and start the chooser
        /* ShareCompat.IntentBuilder provides a fluent API for creating Intents */
        ShareCompat.IntentBuilder
                /* The from method specifies the Context from which this share is coming from */
                .from(this)
                .setType(mimeType)
                .setChooserTitle(title)
                .setText(textToShare)
                .startChooser();
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
        gameDesc.setText(gameData.getGameCheatDetails()+"\n\n\n");
    }
}