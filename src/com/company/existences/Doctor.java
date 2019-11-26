package com.company.existences;

public class Doctor extends Gnome{
    public Doctor(int x, int y, String name) {
        super(x, y, name);
    }

    public Doctor(int x, int y) {
        super(x, y);
    }

    public void healSelf() {
        this.heal(20);
    }

    public void healOther(Existence existence) {
        existence.heal(20);
    }
}
