package com.company.items;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return weight == item.weight &&
                frazzle == item.frazzle &&
                Objects.equals(description, item.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, description, frazzle);
    }
}
