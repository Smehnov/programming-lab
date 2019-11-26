package com.company.existences;

import java.util.Objects;

public class Astronomer extends Gnome implements Researching {
    private int knowladgeLevel;
    private int openedSpaceBodies;

    public Astronomer(int x, int y, String name, int knowladgeLevel) {
        super(x, y, name);
        this.knowladgeLevel = knowladgeLevel;
    }

    public Astronomer(int x, int y, String name) {
        super(x, y, name);
    }

    public Astronomer(int x, int y) {
        super(x, y);
    }

    public void research() {
        this.openedSpaceBodies += (Math.random() / 10) * knowladgeLevel;
        this.knowladgeLevel += 1 + 0.2*openedSpaceBodies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Astronomer that = (Astronomer) o;
        return knowladgeLevel == that.knowladgeLevel &&
                openedSpaceBodies == that.openedSpaceBodies;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), knowladgeLevel, openedSpaceBodies);
    }
}
