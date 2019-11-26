package com.company.existences;

public abstract class Existence {
    private int x;
    private int y;
    private int health;

    public Existence(int x, int y) {
        this(x, y, 100);
    }

    public Existence(int x, int y, int health) {
        this.x = x;
        this.y = y;
        this.health = health;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setCoords(int x, int y) {
        this.x = x;
        this.y = y;
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

    @Override
    public String toString() {
        return "существо";
    }

}

