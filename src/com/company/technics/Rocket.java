package com.company.technics;

import com.company.blocks.Tile;
import com.company.exceptions.GettingNotExistingItem;
import com.company.items.Food;
import com.company.items.Spacesuit;
import com.company.special.MapController;
import com.company.special.ObjectWithCoordinates;

import java.util.ArrayList;
import java.util.Objects;

public class Rocket extends Technic {
    private int power;
    private String name;
    private int capacity;
    private int crewFullness;
    private ObjectWithCoordinates[] crew;
    public SpacesuitContainer spacesuitContainer;
    public FoodContainer foodContainer;

    public Rocket(int x, int y, String name) {
        this(x, y, 100, name, 5);
    }

    Rocket(int x, int y, int power, String name, int capacity) {
        super(x, y);
        this.power = power;
        this.name = name;
        this.capacity = capacity;
        this.crew = new ObjectWithCoordinates[capacity];
        this.crewFullness = 0;
        this.spacesuitContainer = this.new SpacesuitContainer();
        this.foodContainer = this.new FoodContainer();

    }

    public class SpacesuitContainer {
        private ArrayList<Spacesuit> spacesuits = new ArrayList<Spacesuit>();


        public void add(Spacesuit item) {
            spacesuits.add(item);
        }

        public Spacesuit get() throws GettingNotExistingItem {
            if (this.spacesuits.size() <= 0) {
                throw new GettingNotExistingItem("Попытка достать несуществующий скафандр");
            } else {
                Spacesuit s = spacesuits.get(spacesuits.size() - 1);
                spacesuits.remove(spacesuits.size() - 1);
                return s;
            }

        }


    }

    public class FoodContainer {
        private ArrayList<Food> foods = new ArrayList<Food>();


        public void add(Food food) {
            foods.add(food);
        }

        public boolean isEmpty() {
            return foods.size() == 0;
        }

        public Food get() throws GettingNotExistingItem {
            if (!isEmpty()) {
                Food f = foods.get(foods.size() - 1);
                foods.remove(foods.size() - 1);
                return f;
            } else {
                throw new GettingNotExistingItem("Попытка достать несуществующую еду");
            }

        }


    }

    public void loadInCrew(ObjectWithCoordinates objectWithCoordinates, MapController map) {
        if (this.crewFullness < this.capacity) {
            this.crew[crewFullness] = objectWithCoordinates;
            this.crewFullness++;
            System.out.println(objectWithCoordinates.toString() + " загружен в " + this.toString());
            map.deleteObjFromMap(objectWithCoordinates.getX(), objectWithCoordinates.getY());

        } else {
            System.out.println("Ракета уже заполнена");
        }
    }

    public void unloadFromCrew(MapController map) {
        if (this.crewFullness > 0) {
            int x = this.getX();
            int y = this.getY();
            ObjectWithCoordinates objectWithCoordinates = this.crew[crewFullness - 1];
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
                objectWithCoordinates.setX(aimX);
                objectWithCoordinates.setY(aimY);
                map.placeObjOnMap(objectWithCoordinates, aimX, aimY);
                System.out.println(objectWithCoordinates.toString() + " выгружен из " + this.toString());
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
