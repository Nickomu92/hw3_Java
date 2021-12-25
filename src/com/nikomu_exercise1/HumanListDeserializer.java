package com.nikomu_exercise1;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.*;

public class HumanListDeserializer {
    // Статическое поле (свойство) представляющее путь к файлу с названием файла и его расширением
    private static String filePath;
    // Статический список объектов "Human"
    private static List<Human> newList;

    // Статический метод для десериализации списка объектов "Human"
    public static List<Human> getDeserializeList(String fileInfo) {
        newList = new ArrayList<>();
        filePath = fileInfo;

        HumanListSerializer.SerializeList(filePath);

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            newList = (ArrayList<Human>)ois.readObject();
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }

        return newList;
    }
}
