package com.company.special;

import com.company.blocks.Tile;
import com.company.existences.Existence;
import com.company.existences.Gnome;
import com.company.technics.Technic;

public class MapController {
    private Object[][] objMap;
    private Tile[][] tileMap;
    private int sizeW;
    private int sizeH;

    public MapController() {
        this(25, 25);
    }

    public MapController(int sizeW, int sizeH) {
        this.sizeW = sizeW;
        this.sizeH = sizeH;
        this.objMap = new Object[sizeW][sizeH];
        this.tileMap = new Tile[sizeW][sizeH];
        for (int i = 0; i < sizeW; i++) {
            for (int j = 0; j < sizeH; j++) {
                //objMap[i][j] = null;
                tileMap[i][j] = Tile.SPACE;
                if (i <= 4 && j <= 6) {
                    tileMap[i][j] = Tile.FLOOR;
                }
            }
        }
    }

    public int getSizeW() {
        return sizeW;
    }

    public int getSizeH() {
        return sizeH;
    }

    public void placeObjOnMap(Object obj, int x, int y) {
        this.objMap[x][y] = obj;
        System.out.println(obj.toString() + " был добавлен на карту");
    }


    public void placeObjOnMap(Existence existence) {
        this.objMap[existence.getX()][existence.getY()] = existence;
        System.out.println(existence.toString() + " был добавлен на карту");
    }

    public void placeObjOnMap(Technic technic) {
        this.objMap[technic.getX()][technic.getY()] = technic;
        System.out.println(technic.toString() + " был добавлен на карту");
    }

    public Object getObjByCoordinate(int x, int y) {
        return this.objMap[x][y];
    }

    public Tile getTileByCoordinate(int x, int y) {
        return this.tileMap[x][y];
    }

    public void moveObj(int x, int y, int aimX, int aimY) {
        Object o = this.getObjByCoordinate(x, y);
        this.objMap[aimX][aimY] = o;
        this.objMap[x][y] = 0;
    }

    public void deleteObjFromMap(int x, int y) {
        this.objMap[x][y] = null;
    }

    @Override
    public String toString() {/*
        String s = "Map:\n";
        for (int i = 0; i < this.sizeH; i++) {
            for (int j = 0; j < this.sizeW; j++) {
                String c = " ";
                Object obj = this.getObjByCoordinate(j, i);
                Tile tile = this.getTileByCoordinate(j, i);
                if (obj != null) {
                    c = obj.toString();
                } else {
                    c = tile.toString();
                }
                s += c;

            }
            s+="\n";
        }
        return s;*/

        return ("Карта мира " + this.sizeW + "x" + this.sizeH);
    }

}
