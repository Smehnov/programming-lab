package com.company.existences;

public class Professor extends Gnome implements Researching{
    private int knowladgeLevel;
    public Professor(int x, int y, String name, int knowladgeLevel) {
        super(x, y, name);
        this.knowladgeLevel = knowladgeLevel;
    }

    public Professor(int x, int y, String name) {
        super(x, y, name);
    }

    public Professor(int x, int y) {
        super(x, y);
    }

    public void research(){
        this.knowladgeLevel+=Math.random()*5;
    }
}
