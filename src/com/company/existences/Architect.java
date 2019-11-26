package com.company.existences;

public class Architect extends Gnome{
    public Architect(int x, int y, String name) {
        super(x, y, name);
    }

    public Architect(int x, int y) {
        super(x, y);
    }

    public void plan(){
        System.out.println("Тип проектирует здание");
    }
}
