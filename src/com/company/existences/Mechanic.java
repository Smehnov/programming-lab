package com.company.existences;

import com.company.items.Item;

public class Mechanic extends Gnome {
    public Mechanic(int x, int y, String name) {
        super(x, y, name);
    }

    public Mechanic(int x, int y) {
        super(x, y);
    }

    public void repairItem(Item item){
        item.removeFrazzle();
    }
}
