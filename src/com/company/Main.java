package com.company;

import com.company.existences.*;
import com.company.items.Spacesuit;
import com.company.special.MapController;
import com.company.technics.Rocket;

public class Main {

    public static void main(String[] args) {
        MapController map = new MapController();
        System.out.println(map);

        Rocket nip = new Rocket(5, 5, "НИП");
        map.placeObjOnMap(nip);

        Mechanic vintik = new Mechanic(1, 1, "Винтик");
        Mechanic shpuntik = new Mechanic(2, 1, "Шпунтик");
        Professor zvezdochkin = new Professor(1, 2, "Звездочкин");
        Astronomer steklyashkin = new Astronomer(2, 2, "Стекляшкин");
        Engineer klepki = new Engineer(3, 1, "Клепка");
        Architect cubiq = new Architect(3, 2, "Кубик");
        Painter tubik = new Painter(1, 3, "Тюбик");
        Musicion gusli = new Musicion(2, 3, "Гусли");
        Doctor pilulkin = new Doctor(3, 3, "Пилюлькин");
        Gnome fuksia = new Gnome(4, 1, "Фуксия");
        Gnome seledochka = new Gnome(4, 2, "Селедочка");
        Comandor znayka = new Comandor(4, 3, "Знайка");

        map.placeObjOnMap(vintik);
        map.placeObjOnMap(shpuntik);
        map.placeObjOnMap(zvezdochkin);
        map.placeObjOnMap(steklyashkin);
        map.placeObjOnMap(klepki);
        map.placeObjOnMap(cubiq);
        map.placeObjOnMap(tubik);
        map.placeObjOnMap(gusli);
        map.placeObjOnMap(pilulkin);
        map.placeObjOnMap(fuksia);
        map.placeObjOnMap(seledochka);
        map.placeObjOnMap(znayka);

        map.printMap();

        System.out.println();

        seledochka.move(Direction.RIGHT, map);

        System.out.println();

        vintik.becomeCosmonaut();
        shpuntik.becomeCosmonaut();
        fuksia.becomeCosmonaut();
        seledochka.becomeCosmonaut();

        System.out.println();

        Spacesuit spacesuit1 = new Spacesuit();
        Spacesuit spacesuit2 = new Spacesuit();
        Spacesuit spacesuit3 = new Spacesuit();
        Spacesuit spacesuit4 = new Spacesuit();

        znayka.comand(vintik, "надеть скафандр");
        znayka.comand(shpuntik, "надеть скафандр");
        znayka.comand(fuksia, "надеть скафандр");
        znayka.comand(seledochka, "надеть скафандр");

        System.out.println();

        vintik.wearItem(spacesuit1);
        shpuntik.wearItem(spacesuit2);
        fuksia.wearItem(spacesuit3);
        seledochka.wearItem(spacesuit4);

        System.out.println();

        vintik.checkTask();
        shpuntik.checkTask();
        fuksia.checkTask();
        seledochka.checkTask();
        System.out.println();
        znayka.wearItem(spacesuit4);
        seledochka.unwearItem();
        znayka.wearItem(spacesuit4);
        seledochka.move(Direction.RIGHT, map);
        seledochka.wearItem(spacesuit4);
        System.out.println();


        znayka.comand(vintik, "разведать ракету");
        znayka.comand(shpuntik, "разведать ракету");
        znayka.comand(fuksia, "разведать ракету");
        znayka.comand(seledochka, "разведать ракету");

        seledochka.move(Direction.RIGHT, map);
        map.printMap();
        seledochka.move(Direction.UP, map);
        map.printMap();
        seledochka.checkTask();
        seledochka.move(Direction.UP, map);
        seledochka.checkTask();


        map.printMap();
        nip.loadInCrew(seledochka, map);
        map.printMap();
        nip.unloadFromCrew(map);
        map.printMap();
    }
}
