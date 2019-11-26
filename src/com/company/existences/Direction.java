package com.company.existences;

public enum Direction{
    UP("Вверх"),
    DOWN("Вниз"),
    LEFT("Влево"),
    RIGHT("Вправо");
    private final String directionDescription;

    private Direction(String desc) {
        directionDescription = desc;
    }

    public String toString() {
        return directionDescription;
    }
}