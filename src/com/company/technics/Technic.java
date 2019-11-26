package com.company.technics;

import com.company.special.ObjectWithCoordinates;

import java.util.Objects;

public class Technic extends ObjectWithCoordinates {
    public Technic(int x, int y){
        super(x, y);
    }

    @Override
    public String toString() {
        return ("Техника");
    }
}
