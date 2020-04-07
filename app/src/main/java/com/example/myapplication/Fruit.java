package com.example.myapplication;

public class Fruit {
    private String name;
    private int ids;
    public Fruit(String name, int id) {
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
