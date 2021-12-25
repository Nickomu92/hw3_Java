package com.nikomu_exercise1;

import java.io.*;
import java.util.*;

public class HumanListSerializer {
    private static String filePath;
    private static List<Human> newList;

    private static void fillHumanList() {
        newList = new ArrayList<>();

        newList.add(new Human("Ivan", 20, Speciality.DEVELOPER));
        newList.add(new Human("Petr", 33, Speciality.DEVELOPER));
        newList.add(new Human("Stepan", 18, Speciality.DESIGNER));
        newList.add(new Human("Viktoria", 40, Speciality.TESTER));
        newList.add(new Human("Olga", 18, Speciality.DESIGNER));
        newList.add(new Human("Artur", 55, Speciality.TESTER));
        newList.add(new Human("Artem", 15, Speciality.DEVELOPER));
        newList.add(new Human("Bob", 77, Speciality.DESIGNER));
    }

    public static void SerializeList(String fileInfo) {
        filePath = fileInfo;

        fillHumanList();

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(newList);
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
