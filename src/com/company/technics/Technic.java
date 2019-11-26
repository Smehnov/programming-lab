package com.company.technics;

public class Technic {
    private int x;
    private int y;

    Technic(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return (this.getClass().getSimpleName());
    }
}
