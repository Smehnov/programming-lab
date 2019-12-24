package com.company.existences;

import com.company.items.Food;
import com.company.special.ObjectWithCoordinates;

import java.util.Objects;

public abstract class Existence extends ObjectWithCoordinates {
    private int health;


    public Existence(int x, int y) {
        this(x, y, 100);
    }

    public Existence(int x, int y, int health) {
        super(x, y);
        this.health = health;
    }


    public int getHealth() {
        return this.health;
    }

    public void applyDamage(int damage) {
        this.health -= Math.max(damage, 0);
    }

    public void heal(int hp) {
        this.health += Math.max(hp, 0);
        if (this.health > 100) {
            this.health = 100;
        }
    }

    public void eat(Food food) {
        System.out.println("Съедено " + food.getName() + " с энергией " + food.getEnergy());
    }


    @Override
    public String toString() {
        return "существо";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Existence existence = (Existence) o;
        return health == existence.health;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), health);
    }
}

