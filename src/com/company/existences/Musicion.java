package com.company.existences;

public class Musicion extends Gnome{
    public Musicion(int x, int y, String name) {
        super(x, y, name);
    }

    public Musicion(int x, int y) {
        super(x, y);
    }

    public void play(){
        System.out.println("♫♫ ♫♫♫♫ ♫♫♫ ♫♫ ♫♫♫♫");
    }
}
