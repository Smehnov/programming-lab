package com.company.special;

import com.company.blocks.Tile;
import com.company.exceptions.CoordinatesOutOfMap;
import com.company.existences.Existence;

import java.util.Arrays;
import java.util.Objects;

public class MapController {
    private ObjectWithCoordinates[][] objMap;
    private Tile[][] tileMap;
    private int sizeW;
    private int sizeH;

    public MapController() {
        this(25, 25);
    }

    public MapController(int sizeW, int sizeH) {
        this.sizeW = sizeW;
        this.sizeH = sizeH;
        this.objMap = new ObjectWithCoordinates[sizeW][sizeH];
        this.tileMap = new Tile[sizeW][sizeH];
        for (int i = 0; i < sizeW; i++) {
            for (int j = 0; j < sizeH; j++) {
                //objMap[i][j] = null;
                this.tileMap[i][j] = Tile.SPACE;
                if (i <= 4 && j <= 6) {
                    this.tileMap[i][j] = Tile.FLOOR;
                } else if ((i > 5 && i <= 9) && (j < 8 && j > 4)) {
                    this.tileMap[i][j] = Tile.MOONSEA;
                }
                this.tileMap[5][6] = Tile.FLOOR;
            }
        }
    }

    public int getSizeW() {
        return sizeW;
    }

    public int getSizeH() {
        return sizeH;
    }

    public void placeObjOnMap(ObjectWithCoordinates obj, int x, int y) {
        this.objMap[x][y] = obj;
        System.out.println(obj.toString() + " был добавлен на карту");
    }


    public void placeObjOnMap(ObjectWithCoordinates object) {
        this.objMap[object.getX()][object.getY()] = object;
        System.out.println(object.toString() + " был добавлен на карту");
    }


    public ObjectWithCoordinates getObjByCoordinate(int x, int y) {
        return this.objMap[x][y];
    }

    public Tile getTileByCoordinate(int x, int y) {
        return this.tileMap[x][y];
    }

    public void moveObj(int x, int y, int aimX, int aimY) throws CoordinatesOutOfMap {

        if (aimX < 0 || aimX >= this.getSizeW() || aimY < 0 || aimY > this.getSizeH()) {
            throw new CoordinatesOutOfMap("Туда нельзя");
        }

        ObjectWithCoordinates o = this.getObjByCoordinate(x, y);
        this.objMap[aimX][aimY] = o;
        this.objMap[x][y] = null;
    }

    public void deleteObjFromMap(int x, int y) {
        this.objMap[x][y] = null;
    }

    public void printMap() {

        String s = "Map:\n";
        for (int i = this.sizeH - 1; i >= 0; i--) {
            for (int j = 0; j < this.sizeW; j++) {
                String c = " ";
                Object obj = this.getObjByCoordinate(j, i);
                Tile tile = this.getTileByCoordinate(j, i);
                if (obj != null) {
                    c = "" + obj.getClass().getSimpleName().toCharArray()[0];
                } else {
                    switch (tile) {
                        case FLOOR:
                            c = "⬜";
                            break;
                        case SPACE:
                            c = ".";
                            break;
                        case WALL:
                            c = "⬛";
                            break;
                        case MOONSEA:
                            c = "~";
                            break;
                    }

                }
                s += c;

            }
            s += "\n";
        }
        System.out.println(s);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapController that = (MapController) o;
        return sizeW == that.sizeW &&
                sizeH == that.sizeH &&
                Arrays.equals(objMap, that.objMap) &&
                Arrays.equals(tileMap, that.tileMap);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(sizeW, sizeH);
        result = 31 * result + Arrays.hashCode(objMap);
        result = 31 * result + Arrays.hashCode(tileMap);
        return result;
    }

    @Override
    public String toString() {

        return ("Карта мира " + this.sizeW + "x" + this.sizeH);
    }

}
