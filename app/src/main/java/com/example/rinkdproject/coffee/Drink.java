package com.example.rinkdproject.coffee;

import com.google.firebase.database.Query;

public class Drink {
    private String image;
    private String cafename;
    private String drinkname;
    private int price;
    private String kind;

    public Drink(){}

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCafename() {
        return cafename;
    }

    public void setCafename(String cafename) {
        this.cafename = cafename;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDrinkname(){
        return drinkname;
    }

    public void setDrinkname(String drinkname){
        this.drinkname = drinkname;
    }

    public String getKind(){return kind;}
    public void setKind(String kind){this.kind=kind;}

}
