package com.nikomu_exercise1;

import com.nikomu.Color;

import java.util.*;
import java.util.stream.Collectors;

public class Exercise1 {
    public static void main(String[] args) {
        String fileInfo = "humans.dat";
        List<Human> humans = new ArrayList<>();

        // Если мы получили какие-то данные из базы данных, то записываем их в наш список "humans"
        if(!DatabaseEntity.getListFromDB().isEmpty()) {
            humans = DatabaseEntity.getListFromDB();
            System.out.println(Color.ANSI_YELLOW.getCode() + "\nСписок получен из БД при помощи DatabaseEntity" + Color.ANSI_RESET.getCode());
        }

        // Иначе если мы получили какие-то данные при десериализации списка объектов из файла fileInfo, то записываем их в наш список "humans"
        else if(!HumanListDeserializer.getDeserializeList(fileInfo).isEmpty()) {
            humans = HumanListDeserializer.getDeserializeList(fileInfo);
            System.out.println(Color.ANSI_GREEN.getCode() + "\nСписок получен при помощи сериализациии/десериализации списка объектов" + Color.ANSI_RESET.getCode());
        }

        // Иначе заполняем в программе наш список "humans"
        else {
            humans = HumanListCreator.getHumans();
            System.out.println(Color.ANSI_BLUE.getCode() + "\nСписок получен при помощи метода-создателя"+ Color.ANSI_RESET.getCode());
        }

        System.out.printf("%s\n\tДекларативный подход%s\n", Color.ANSI_RED.getCode(), Color.ANSI_RESET.getCode());

        // Группировка объектов Human по специальностям в декларативном стиле (с использованием Stream API)
        Map<Speciality, List<Human>> mapDeclarative = humans
                .stream()
                .collect(Collectors.groupingBy(Human::getSpeciality));

        // Перебор списка (типа ключ-значение) в декларативном стиле при помощи 2 методов forEach
        mapDeclarative.forEach(((speciality, group) -> {
            System.out.printf("%s\n\t%s%s\n", Color.ANSI_CYAN.getCode(), speciality, Color.ANSI_RESET.getCode());
            group.forEach(System.out::println);
        }));

        System.out.printf("%s\n\tИмперативный подход%s\n", Color.ANSI_RED.getCode(), Color.ANSI_RESET.getCode());

        // Императивный подход
        Map<Speciality, List<Human>> mapImperative = new HashMap<>();

        // Группировка объектов Human по специальностям в императивном стиле
        for(Human item : humans) {
            if(!mapImperative.keySet().contains(item.getSpeciality())) {
                List<Human> newList = new ArrayList<>();

                for(int i = 0; i < humans.size(); i++) {
                    if (humans.get(i).getSpeciality().equals(item.getSpeciality())) {
                        newList.add(humans.get(i));
                    }
                }

                mapImperative.putIfAbsent(item.getSpeciality(), newList);
            }
        }

        // Перебор списка (типа ключ-значение) в императивном стиле при помощи 2 циклов foreach
        for(Map.Entry<Speciality, List<Human>> entry : mapImperative.entrySet()) {

            System.out.printf("\n\t%s%s%s\n", Color.ANSI_CYAN.getCode(), entry.getKey(), Color.ANSI_RESET.getCode());

            for (Human item : entry.getValue()) {
                System.out.println(item);
            }
        }
    }
}
