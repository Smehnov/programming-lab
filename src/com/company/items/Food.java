package com.company.items;

public class Food {
    private int energy;
    private String name;

    public int getEnergy(){
        return this.energy;
    }

    public String getName(){
        return name;
    }

    public Food(String name, int energy){
        this.name = name;
        this.energy = energy;
    }
}
