package com.company.technics;

public class Rocket extends Technic{
    private int power;
    private String name;


    public Rocket(int x, int y,String name) {
        this(x,y,100, name);
    }

    Rocket(int x, int y, int power, String name) {
        super(x, y);
        this.power = power;
        this.name = name;
    }

    public int getPower(){
        return power;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return (this.getClass().getSimpleName() + " "+ this.getName());
    }

}
