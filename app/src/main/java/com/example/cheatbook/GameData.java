package com.example.cheatbook;

public class GameData {

    private String Id;
    private String title;
    private String date;
    private String ratings;
    private int imageID;
    private String gameCheatDetails;

    public GameData(String Id, String title, String date, String ratings, int imageID, String gameCheatDetails) {
        this.Id = Id;
        this.title = title;
        this.date = date;
        this.ratings = ratings;
        this.imageID = imageID;
        this.gameCheatDetails = gameCheatDetails;
    }

    public String getId() {
        return Id;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return "Release Date : " + date;
    }

    public String getRatings() {
        return ratings;
    }

    public String getTextRatings() {
        return "(" + ratings + ")";
    }

    public int getImageID() {
        return imageID;
    }

    public String getGameCheatDetails() {
        return gameCheatDetails;
    }
}
