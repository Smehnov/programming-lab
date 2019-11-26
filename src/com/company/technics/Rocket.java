package com.company.technics;

import com.company.blocks.Tile;
import com.company.existences.Existence;
import com.company.special.MapController;

import java.util.Map;
import java.util.Objects;

public class Rocket extends Technic {
    private int power;
    private String name;
    private int capacity;
    private int crewFullness;
    private Existence[] crew;

    public Rocket(int x, int y, String name) {
        this(x, y, 100, name, 5);
    }

    Rocket(int x, int y, int power, String name, int capacity) {
        super(x, y);
        this.power = power;
        this.name = name;
        this.capacity = capacity;
        this.crew = new Existence[capacity];
        this.crewFullness = 0;
    }

    public void loadInCrew(Existence existence, MapController map) {
        if (this.crewFullness < this.capacity) {
            this.crew[crewFullness] = existence;
            this.crewFullness++;
            System.out.println(existence.toString() + " загружен в " + this.toString());
            map.deleteObjFromMap(existence.getX(), existence.getY());

        } else {
            System.out.println("Ракета уже заполнена");
        }
    }

    public void unloadFromCrew(MapController map) {
        if (this.crewFullness > 0) {
            int x = this.getX();
            int y = this.getY();
            Existence existence = this.crew[crewFullness - 1];
            int aimX = x;
            int aimY = y;
            boolean canUnload = true;
            if ((map.getTileByCoordinate(x + 1, y) == Tile.FLOOR && map.getObjByCoordinate(x + 1, y) == null)) {
                aimX = x + 1;
                aimY = y;
            } else if (map.getTileByCoordinate(x - 1, y) == Tile.FLOOR && map.getObjByCoordinate(x - 1, y) == null) {
                aimX = x - 1;
                aimY = y;
            } else if (map.getTileByCoordinate(x, y + 1) == Tile.FLOOR && map.getObjByCoordinate(x, y + 1) == null) {
                aimX = x;
                aimY = y + 1;
            } else if (map.getTileByCoordinate(x, y - 1) == Tile.FLOOR && map.getObjByCoordinate(x, y - 1) == null) {
                aimX = x;
                aimY = y - 1;
            } else {
                canUnload = false;
            }

            if (canUnload) {
                this.crew[crewFullness - 1] = null;
                this.crewFullness--;
                existence.setX(aimX);
                existence.setY(aimY);
                map.placeObjOnMap(existence, aimX, aimY);
                System.out.println(existence.toString() + " выгружен из " + this.toString());
            } else {
                System.out.println("Нет места для выгрузки");
            }


        } else {
            System.out.println("В ракете никого нет");

        }

    }

    public int getPower() {
        return power;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return (this.getClass().getSimpleName() + " " + this.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rocket rocket = (Rocket) o;
        return power == rocket.power &&
                Objects.equals(name, rocket.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(power, name);
    }
}
