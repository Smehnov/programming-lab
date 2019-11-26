package com.company.existences;

public class Comandor extends Gnome{
    public Comandor(int x, int y, String name) {
        super(x, y, name);
    }

    public Comandor(int x, int y) {
        super(x, y);
    }

    public void comand(Gnome executor, String task){
        executor.takeTask(task, this);
        //System.out.println(this.toString() + " дал "+executor.toString()+" задание: "+task);
    }
}
