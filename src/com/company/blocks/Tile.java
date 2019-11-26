package com.company.blocks;

public enum Tile {
    SPACE("Космос"),
    WALL("Стена"),
    FLOOR("Пол");
    private final String tileDescription;

    private Tile(String desc) {
        tileDescription = desc;
    }

    public String toString() {
        return tileDescription;
    }
}
