package com.company.special;

import com.company.blocks.Tile;
import com.company.exceptions.CoordinatesOutOfMap;
import com.company.existences.*;
import com.company.items.Spacesuit;
import com.company.technics.Rocket;

import java.util.ArrayList;

public class Squad extends ObjectWithCoordinates implements Movable, Executor {

    private ArrayList<Gnome> gnomes = new ArrayList<>();
    private String currentTask = "";
    private boolean meetedRocket;

    public Squad(Gnome leader) {
        super(leader.getX(), leader.getY());

    }

    public void addToSquad(Gnome gnome, MapController map) {
        gnomes.add(gnome);
        map.deleteObjFromMap(gnome.getX(), gnome.getY());
    }

    public void takeTask(String task, Gnome comandor) {
        if (comandor instanceof Comandor) {
            this.currentTask = task;
            System.out.println(this.toString() + " получил новое задание от " + comandor.toString() + ": " + task);
        }
    }

    public void checkTask() {
        if ("разведать ракету".equals(this.currentTask)) {
            if (meetedRocket) {
                System.out.println(this.toString() + " выполнил задание " + this.currentTask);
                this.currentTask = "";
            } else System.out.println(this.toString() + " НЕ выполнил задание " + this.currentTask);
        }
    }

    public void deleteFromSquad(MapController map) {
        if (this.gnomes.size() > 0) {
            int x = this.getX();
            int y = this.getY();
            Gnome gnome = this.gnomes.get(this.gnomes.size() - 1);
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
                this.gnomes.remove(this.gnomes.size() - 1);
                gnome.setX(aimX);
                gnome.setY(aimY);
                map.placeObjOnMap(gnome, aimX, aimY);
                System.out.println(gnome.toString() + " выгружен из " + this.toString());
            } else {
                System.out.println("Нет места для выгрузки");
            }


        } else {
            System.out.println("В Отряде никого нет");

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

        try {
            Object obj = map.getObjByCoordinate(aimX, aimY);
            Tile tile = map.getTileByCoordinate(aimX, aimY);
            if (obj != null) {
                System.out.println("Ход " + this.toString() + " невозможен, на пути стоит " + obj.toString());
            } else if (tile == Tile.WALL) {
                System.out.println("Ход " + this.toString() + " невозможен, на пути стоит " + tile.toString());

            } else if (tile == Tile.FLOOR) {
                map.moveObj(this.getX(), this.getY(), aimX, aimY);
                this.setCoords(aimX, aimY);

                System.out.println(this.toString() + " переместился на точку (" + aimX + ";" + aimY + ")");

            } else if (tile == Tile.SPACE) {

                map.moveObj(this.getX(), this.getY(), aimX, aimY);
                this.setCoords(aimX, aimY);
                System.out.println(this.toString() + " переместился на точку (" + aimX + ";" + aimY + ")");

            }
            int x = this.getX();
            int y = this.getY();
            if (map.getObjByCoordinate(x + 1, y) instanceof Rocket || map.getObjByCoordinate(x - 1, y) instanceof Rocket || map.getObjByCoordinate(x, y + 1) instanceof Rocket || map.getObjByCoordinate(x, y - 1) instanceof Rocket) {
                this.meetedRocket = true;
            }

        } catch (CoordinatesOutOfMap e) {
            System.out.println(e.getMessage());
        }
    }

    public String toString() {
        return "Отряд ";
    }

}
