package com.company.existences;

public class Painter extends Gnome{
    public Painter(int x, int y, String name) {
        super(x, y, name);
    }

    public Painter(int x, int y) {
        super(x, y);
    }
    public void draw(){
        System.out.println("¯\\_(ツ)_/¯");
    }
}
