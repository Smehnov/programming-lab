package com.company.items;

public class Spacesuit extends Item {
    public Spacesuit() {
        super(20, "Скафандр\nНеобходим для перемещения вне пола корабля");

    }

    @Override
    public String toString() {
        return "Скафандр массой " + this.getWeight();
    }
}
