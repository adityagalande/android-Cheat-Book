package com.example.cheatbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class GameDataAdapter extends ArrayAdapter<GameData> {
    public GameDataAdapter(@NonNull Context context, int resource, @NonNull List<GameData> GameObject) {
        super(context, resource, GameObject );
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Get the object located at this position
        GameData itemPosition = getItem(position);
        //Check if existing view is reused, Otherwise create the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.custom_item_layout, parent, false);
        }

        TextView gameTitleTextView = (TextView) listItemView.findViewById(R.id.gameTitleView);
        gameTitleTextView.setText(itemPosition.getTitle());

        TextView gameDateTextView = (TextView) listItemView.findViewById(R.id.gameDateTextView);
        gameDateTextView.setText(itemPosition.getDate());

        TextView gameRatingsTextView = (TextView) listItemView.findViewById(R.id.gameRatingTextView);
        gameRatingsTextView.setText(itemPosition.getTextRatings());

        ImageView gameImageView = (ImageView) listItemView.findViewById(R.id.gameImageView);
        gameImageView.setImageResource(itemPosition.getImageID());

        RatingBar gameRatingsBar = (RatingBar) listItemView.findViewById(R.id.gameRatingView);
        gameRatingsBar.setRating(Float.parseFloat(itemPosition.getRatings()));

        return listItemView;
    }
}
