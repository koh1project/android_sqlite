package com.example.db;

import androidx.annotation.NonNull;

public class Item {


    private String name;
    private int price;

    public Item(){
    }

    public Item( String name , int price  ){

        this.name = name;
        this.price = price;

    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @NonNull
    @Override
    public String toString() {
        return this.name +"(" + this.price + "円)";
    }
}
