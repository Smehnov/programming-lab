package com.company.existences;

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
}
