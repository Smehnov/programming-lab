package com.company;

import com.company.exceptions.GettingNotExistingItem;
import com.company.existences.*;
import com.company.items.Food;
import com.company.items.Spacesuit;
import com.company.special.MapController;
import com.company.special.Squad;
import com.company.technics.Rocket;

public class Main {

    public static void main(String[] args) {


        MapController map = new MapController();
        System.out.println(map);


        Rocket nip = new Rocket(5, 5, "НИП");
        nip.spacesuitContainer.add(new Spacesuit());
        nip.spacesuitContainer.add(new Spacesuit());
        nip.spacesuitContainer.add(new Spacesuit());
        nip.foodContainer.add(new Food("Борщ", 30));
        nip.foodContainer.add(new Food("Котлеты", 40));
        nip.foodContainer.add(new Food("Пюрешка", 10));


        map.placeObjOnMap(nip);


        Gnome neznayka = new Gnome(6, 6, "Незнайка");
        Gnome ponchick = new Gnome(6, 7, "Пончик");


        nip.loadInCrew(neznayka, map);
        nip.loadInCrew(ponchick, map);


        map.printMap();


        try {
            while (true) {
                neznayka.eat(nip.foodContainer.get());
                ponchick.eat(nip.foodContainer.get());
            }
        } catch (GettingNotExistingItem e) {
            System.out.println(e.getMessage());
        }


        nip.unloadFromCrew(map);
        nip.unloadFromCrew(map);

        neznayka.becomeCosmonaut();
        ponchick.becomeCosmonaut();

        try {
            neznayka.wearItem(nip.spacesuitContainer.get());
            ponchick.wearItem(nip.spacesuitContainer.get());
        } catch (GettingNotExistingItem e) {
            System.out.println(e.getMessage());
        }


        neznayka.move(Direction.LEFT, map);
        ponchick.move(Direction.LEFT, map);
        neznayka.move(Direction.LEFT, map);
        ponchick.move(Direction.LEFT, map);
        neznayka.move(Direction.LEFT, map);
        ponchick.move(Direction.LEFT, map);

        map.printMap();


        Mechanic vintik = new Mechanic(1, 1, "Винтик");
        Mechanic shpuntik = new Mechanic(2, 1, "Шпунтик");
        Professor zvezdochkin = new Professor(1, 2, "Звездочкин");
        Astronomer steklyashkin = new Astronomer(2, 2, "Стекляшкин");
        Engineer klepki = new Engineer(3, 1, "Клепка");
        Architect cubiq = new Architect(4, 3, "Кубик");
        Painter tubik = new Painter(1, 3, "Тюбик");
        Musicion gusli = new Musicion(2, 3, "Гусли");
        Doctor pilulkin = new Doctor(3, 3, "Пилюлькин");
        Gnome fuksia = new Gnome(4, 1, "Фуксия");
        Gnome seledochka = new Gnome(4, 2, "Селедочка");
        Comandor znayka = new Comandor(3, 2, "Знайка");

        Rocket fis = new Rocket(2, 2, "ФИС");

        steklyashkin.findRocket(map);

        fis.loadInCrew(vintik, map);
        fis.loadInCrew(shpuntik, map);
        fis.loadInCrew(zvezdochkin, map);
        fis.loadInCrew(steklyashkin, map);
        fis.loadInCrew(klepki, map);
        fis.loadInCrew(cubiq, map);
        fis.loadInCrew(tubik, map);
        fis.loadInCrew(gusli, map);
        fis.loadInCrew(pilulkin, map);
        fis.loadInCrew(fuksia, map);
        fis.loadInCrew(seledochka, map);
        fis.loadInCrew(znayka, map);


        steklyashkin.findRocket(map);

        fis.electronicSelfRegulativeMachine.activateBreaks();


        map.placeObjOnMap(fis);


        map.printMap();

        System.out.println();

        seledochka.move(Direction.RIGHT, map);

        System.out.println();

        vintik.becomeCosmonaut();
        shpuntik.becomeCosmonaut();
        fuksia.becomeCosmonaut();
        seledochka.becomeCosmonaut();
        znayka.becomeCosmonaut();

        System.out.println();

        Spacesuit spacesuit1 = new Spacesuit();
        Spacesuit spacesuit2 = new Spacesuit();
        Spacesuit spacesuit3 = new Spacesuit();
        Spacesuit spacesuit4 = new Spacesuit();
        Spacesuit spacesuit5 = new Spacesuit();

        znayka.comand(vintik, "надеть скафандр");
        znayka.comand(shpuntik, "надеть скафандр");
        znayka.comand(fuksia, "надеть скафандр");
        znayka.comand(seledochka, "надеть скафандр");

        System.out.println();

        vintik.wearItem(spacesuit1);
        shpuntik.wearItem(spacesuit2);
        fuksia.wearItem(spacesuit3);
        seledochka.wearItem(spacesuit4);
        znayka.wearItem(spacesuit5);
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


        Squad squad = new Squad(znayka);
        squad.addToSquad(znayka, map);
        squad.addToSquad(vintik, map);
        squad.addToSquad(shpuntik, map);
        squad.addToSquad(fuksia, map);
        squad.addToSquad(seledochka, map);

        znayka.comand(squad, "разведать ракету");

        map.placeObjOnMap(squad);

        map.printMap();

        squad.move(Direction.UP, map);
        map.printMap();
        squad.checkTask();
        squad.move(Direction.UP, map);
        squad.checkTask();
        map.printMap();
        nip.loadInCrew(squad, map);
        map.printMap();


        if(!nip.isGnomeInRooms("Незнайка") && !nip.isGnomeInRooms("Пончик") && nip.foodContainer.isEmpty()){
            System.out.println("Незнайки и Пончика нет ни в одной из комнат ракеты, еды тоже нет, значит она закончилась, и они отправились на ее поиски!");
        }

        nip.unloadFromCrew(map);
        map.printMap();


    }


}
