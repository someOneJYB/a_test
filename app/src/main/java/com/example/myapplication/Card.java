package com.example.myapplication;

public class Card {
    private String name;
    private int ids;
    public Card(String name, int id) {
        this.name = name;
        this.ids = id;
    }
    public String getName(){
        return this.name;
    }
    public int getIds(){
        return this.ids;
    }
}
