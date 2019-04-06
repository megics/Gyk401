package com.example.gyk401;

public class Food {

    String FoodName;
    Double Calori;
    int ImageID;

    public Food(String foodName, Double calori, int imageID) {
        FoodName = foodName;
        Calori = calori;
        ImageID = imageID;
    }

    public int getImageID() {
        return ImageID;
    }

    public void setImageID(int imageID) {
        ImageID = imageID;
    }

    public String getFoodName() {
        return FoodName;
    }

    public void setFoodName(String foodName) {
        FoodName = foodName;
    }

    public Double getCalori() {
        return Calori;
    }

    public void setCalori(Double calori) {
        Calori = calori;
    }
}
