package com.nikomu_exercise1;

import java.util.*;

public class HumanListCreator {
    public static List<Human> getHumans() {
        List<Human> newList = new ArrayList<>();
        newList.add(new Human("Ivan", 20, Speciality.DEVELOPER));
        newList.add(new Human("Petr", 33, Speciality.DEVELOPER));
        newList.add(new Human("Stepan", 18, Speciality.DESIGNER));
        newList.add(new Human("Viktoria", 40, Speciality.TESTER));
        newList.add(new Human("Olga", 18, Speciality.DESIGNER));
        newList.add(new Human("Artur", 55, Speciality.TESTER));
        newList.add(new Human("Artem", 15, Speciality.DEVELOPER));
        newList.add(new Human("Bob", 77, Speciality.DESIGNER));

        return newList;
    }
}
