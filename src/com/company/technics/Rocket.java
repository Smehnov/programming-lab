package com.company.technics;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rocket rocket = (Rocket) o;
        return power == rocket.power &&
                Objects.equals(name, rocket.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(power, name);
    }
}
