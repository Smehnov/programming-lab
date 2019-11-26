package com.company.items;

public class Item {
    private int weight;
    private String description;
    private int frazzle;

    public Item(int weight, String description) {
        this.weight = weight;
        this.description = description;
        this.frazzle = 0;
    }

    public int getWeight() {
        return this.weight;
    }

    public String getDescription() {
        return this.description;
    }

    public void addFrazzle(){
        this.frazzle+=1;
    }

    public void removeFrazzle(){
        this.frazzle = 0;
    }

    @Override
    public String toString() {
        return this.getDescription();
    }

}
