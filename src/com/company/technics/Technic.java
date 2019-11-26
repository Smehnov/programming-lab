package com.company.technics;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Technic technic = (Technic) o;
        return x == technic.x &&
                y == technic.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
