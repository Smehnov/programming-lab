package com.company.existences;

import com.company.blocks.Tile;
import com.company.items.Item;
import com.company.items.Spacesuit;
import com.company.special.MapController;
import com.company.technics.Rocket;

import java.util.Objects;

public class Gnome extends Existence implements Movable {

    private boolean isCosmonaut;
    private Item wearedItem;
    private String name;
    private String currentTask = "";
    private boolean meetedRocked;

    public Gnome(int x, int y) {
        this(x, y, "Безымянный");

    }

    public Gnome(int x, int y, String name) {
        super(x, y);
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public Item getWearedItem() {
        return wearedItem;
    }

    public void becomeCosmonaut() {
        this.isCosmonaut = true;
        System.out.println(this.toString() + " теперь космонавт");
    }

    public void wearItem(Item item) {
        if (!this.hasWearedItem()) {
            if(!item.getIsWeared()) {
                if (!(item instanceof Spacesuit) || this.isCosmonaut) {
                    this.wearedItem = item;
                    item.setWeared();
                    System.out.println(this.toString() + " надел предмет " + item.toString());
                }else{
                    System.out.println(this.toString()+" не космонавт");
                }
            }else{
                System.out.println(item.toString() + " уже используется");
            }
        } else {
            System.out.println(this.toString()+" уже носит "+this.getWearedItem());
        }
    }

    public void unwearItem() {
        this.wearedItem.setUnweared();
        this.wearedItem = null;
    }

    public boolean hasWearedItem() {
        return this.wearedItem != null;
    }

    public void takeTask(String task, Gnome comandor) {
        if (comandor instanceof Comandor) {
            this.currentTask = task;
            System.out.println(this.toString() + " получил новое задание от " + comandor.toString() + ": " + task);
        }
    }

    public void checkTask() {
        switch (this.currentTask) {
            case "надеть скафандр":
                if (this.wearedItem instanceof Spacesuit) {
                    System.out.println(this.toString() + " выполнил задание " + this.currentTask);
                    this.currentTask = "";
                } else System.out.println(this.toString() + " НЕ выполнил задание " + this.currentTask);
                break;
            case "разведать ракету":
                if (meetedRocked) {
                    System.out.println(this.toString() + " выполнил задание " + this.currentTask);
                    this.currentTask = "";
                } else System.out.println(this.toString() + " НЕ выполнил задание " + this.currentTask);
                break;
        }
    }

    public void move(Direction direction, MapController map) {
        int aimX = this.getX();
        int aimY = this.getY();
        switch (direction) {
            case UP:
                aimY++;
                break;
            case DOWN:
                aimY--;
                break;
            case LEFT:
                aimX--;
                break;
            case RIGHT:
                aimX++;
                break;
        }
        if (aimX < 0 || aimX >= map.getSizeW() || aimY < 0 || aimY > map.getSizeH()) {
            System.out.println("ЭЭЭЭЙ, КУДА ПАШОЛ?????");
        } else {
            Object obj = map.getObjByCoordinate(aimX, aimY);
            Tile tile = map.getTileByCoordinate(aimX, aimY);
            if (obj != null) {
                System.out.println("Ход " + this.toString() + " невозможен, на пути стоит " + obj.toString());
            } else if (tile == Tile.WALL) {
                System.out.println("Ход " + this.toString() + " невозможен, на пути стоит " + tile.toString());

            } else if (tile == Tile.FLOOR) {
                this.setCoords(aimX, aimY);
                map.moveObj(this.getX(), this.getY(), aimX, aimY);
                System.out.println(this.toString() + " переместился на точку (" + aimX + ";" + aimY + ")");

            } else if (tile == Tile.SPACE) {
                if (this.wearedItem instanceof Spacesuit) {

                    map.moveObj(this.getX(), this.getY(), aimX, aimY);
                    this.setCoords(aimX, aimY);
                    System.out.println(this.toString() + " переместился на точку (" + aimX + ";" + aimY + ")");
                } else {
                    System.out.println(this.toString() + " не надел скафандр");
                }
            }
            int x = this.getX();
            int y = this.getY();
            if (map.getObjByCoordinate(x + 1, y) instanceof Rocket || map.getObjByCoordinate(x - 1, y) instanceof Rocket || map.getObjByCoordinate(x, y + 1) instanceof Rocket || map.getObjByCoordinate(x, y - 1) instanceof Rocket) {
                this.meetedRocked = true;
            }

        }
    }


    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + this.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Gnome gnome = (Gnome) o;
        return isCosmonaut == gnome.isCosmonaut &&
                meetedRocked == gnome.meetedRocked &&
                Objects.equals(wearedItem, gnome.wearedItem) &&
                Objects.equals(name, gnome.name) &&
                Objects.equals(currentTask, gnome.currentTask);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isCosmonaut, wearedItem, name, currentTask, meetedRocked);
    }
}


