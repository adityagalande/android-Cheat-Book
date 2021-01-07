package com.example.cheatbook;

public class GameData {

    private String title;
    private String date;
    private String ratings;
    private int imageID;

    public GameData(String title, String date, String ratings, int imageID) {
        this.title = title;
        this.date = date;
        this.ratings = ratings;
        this.imageID = imageID;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getRatings() {
        return ratings;
    }

    public int getImageID() {
        return imageID;
    }
}
