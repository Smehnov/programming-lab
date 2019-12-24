package com.company.existences;

import com.company.special.MapController;
import com.company.special.ObjectWithCoordinates;
import com.company.technics.Rocket;
import org.w3c.dom.ls.LSOutput;

import java.util.Objects;

public class Astronomer extends Gnome implements Researching {
    private int knowladgeLevel;
    private int openedSpaceBodies;

    public Astronomer(int x, int y, String name, int knowledgeLevel) {
        super(x, y, name);
        this.knowladgeLevel = knowledgeLevel;
    }

    public Astronomer(int x, int y, String name) {
        super(x, y, name);
    }

    public Astronomer(int x, int y) {
        super(x, y);
    }

    public void findRocket(MapController map) {
        System.out.println("Начат поиск корабля");
        boolean found = false;
        for (int i = map.getSizeW() - 1; i >= 0; i--) {
            System.out.println("Совершено " + (map.getSizeW() - i) + " витков вокруг луны...");
            for (int j = 0; j < map.getSizeH(); j++) {
                ObjectWithCoordinates obj = map.getObjByCoordinate(i, j);
                if (obj instanceof Rocket && ((Rocket) obj).getName() == "НИП") {
                    System.out.println("Найдена ракета с координатами (" + i + ":" + j + ")");
                    found = true;
                    break;
                }

            }
            if (found) break;

        }
    }

    public void research() {
        this.openedSpaceBodies += (Math.random() / 10) * knowladgeLevel;
        this.knowladgeLevel += 1 + 0.2 * openedSpaceBodies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Astronomer that = (Astronomer) o;
        return knowladgeLevel == that.knowladgeLevel &&
                openedSpaceBodies == that.openedSpaceBodies;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), knowladgeLevel, openedSpaceBodies);
    }
}
