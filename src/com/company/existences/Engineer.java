package com.company.existences;

import com.company.items.Item;

public class Engineer extends Mechanic{
    public Engineer(int x, int y, String name) {
        super(x, y, name);
    }

    public Engineer(int x, int y) {
        super(x, y);
    }

    public Item constructItem(int weight, String description){
        return new Item(weight, description);
    }
}
