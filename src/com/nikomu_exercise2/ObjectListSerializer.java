package com.nikomu_exercise2;

import com.nikomu.Color;

import java.io.*;
import java.util.*;

public class ObjectListSerializer {

    private String filePath;
    private List<User> arrayList;

    public ObjectListSerializer(String filePath) {
        this.filePath = filePath;
        arrayList = new ArrayList<>();
        arrayList.add(new User("Иван", "Иванов",17, Gender.MASCULINITY.getGenderValueRu(), "ivanov@email.com", Country.RUSSIA.getCountryNameRu()));
        arrayList.add(new Employee("Микола","Миколайчук",38, Gender.MASCULINITY.getGenderValueRu(), "mukolaychuk@gmail.com", Country.UKRAINE.getCountryNameRu(), 2400.0F, Position.MARKETER, Department.HR));
        arrayList.add(new User("Евгения", "Евгеньева", 16, Gender.FEMININITY.getGenderValueRu(), "evgeneva@gmail.com", Country.UKRAINE.getCountryNameRu()));
        arrayList.add(new Employee("Andrzej", "Andrzejewsky", 39, Gender.MASCULINITY.getGenderValueRu(), "anrzejewsky@gmail.com", Country.POLAND.getCountryNameRu(), 3400.0F, Position.ACCOUNTANT, Department.ACCOUNTING));
        arrayList.add(new User("John", "J",14, Gender.MASCULINITY.getGenderValueRu(), "jj@gmail.com",Country.UNITED_STATES.getCountryNameRu()));
        arrayList.add(new Employee("Алла", "Аллина", 18, Gender.FEMININITY.getGenderValueRu(), "allina@gmail.com", Country.UKRAINE.getCountryNameRu(), 900.0F, Position.MARKETER, Department.HR));
        arrayList.add(new User("Николай", "Николаев", 56, Gender.MASCULINITY.getGenderValueRu(), "nikolaev@email.com", Country.RUSSIA.getCountryNameRu()));
        arrayList.add(new Employee("Виктория", "Викторьева", 22, Gender.FEMININITY.getGenderValueRu(), "viktorova@gmail.com", Country.UKRAINE.getCountryNameRu(), 1600.0F, Position.QA, Department.IT));
        arrayList.add(new User("Олександр", "Олександрійчук",14, Gender.MASCULINITY.getGenderValueRu(), "oleksandiychuck@email.com", Country.UKRAINE.getCountryNameRu()));
        arrayList.add(new Employee("Артем", "Артемчук", 29, Gender.MASCULINITY.getGenderValueRu(), "artemchuck@gmail.com", Country.UKRAINE.getCountryNameRu(), 2900.0F, Position.DIRECTOR, Department.MANAGING));
        arrayList.add(new User("Александр", "Александров", 62, Gender.MASCULINITY.getGenderValueRu(), "alexandrow@email.com",Country.RUSSIA.getCountryNameRu()));
        arrayList.add(new Employee("Александра", "Александрова", 32, Gender.FEMININITY.getGenderValueRu(), "aleksandrova@gmail.com", Country.UKRAINE.getCountryNameRu(), 2000.0F, Position.TESTER, Department.IT));
        arrayList.add(new User("Alex", "A", 12, Gender.MASCULINITY.getGenderValueRu(), "alexa@email.com", Country.UNITED_KINGDOM.getCountryNameRu()));
        arrayList.add(new Employee("Виталина", "Витальева", 42, Gender.FEMININITY.getGenderValueRu(), "vitalieva@email.com", Country.UKRAINE.getCountryNameRu(), 4800.0F, Position.DIRECTOR, Department.MANAGING));
        arrayList.add(new User("Степан", "Степанченко", 10, Gender.MASCULINITY.getGenderValueRu(), "stepanchenko@email.com", Country.UKRAINE.getCountryNameRu()));
        arrayList.add(new Employee("Андрей", "Андреев", 26, Gender.MASCULINITY.getGenderValueRu(), "andreev@gmail.com", Country.RUSSIA.getCountryNameRu(),2400.0F, Position.DEVELOPER, Department.IT));
        arrayList.add(new User("Анрій", "Андрійчук", 17, Gender.MASCULINITY.getGenderValueRu(), "andriychuck@email.com", Country.UKRAINE.getCountryNameRu()));
        arrayList.add(new Employee("Наталья", "Натальева", 21, Gender.FEMININITY.getGenderValueRu(), "nataleva@gmail.com", Country.UKRAINE.getCountryNameRu(),1800.0F, Position.HR, Department.HR));
        arrayList.add(new User("Борис", "Борисенко", 13, Gender.MASCULINITY.getGenderValueRu(), "borisenko@gmail.com", Country.UKRAINE.getCountryNameRu()));
        arrayList.add(new Employee("Mike", "M", 49, Gender.MASCULINITY.getGenderValueRu(), "mm@email.com", Country.UNITED_STATES.getCountryNameRu(),3800.0F, Position.DEVELOPER, Department.IT));
        arrayList.add(new User("Alice", "A", 15, Gender.FEMININITY.getGenderValueRu(), "alicea@email.com", Country.UNITED_KINGDOM.getCountryNameRu()));
        arrayList.add(new Employee("Agneshka", "A", 19, Gender.FEMININITY.getGenderValueRu(), "agna@gmail.com", Country.POLAND.getCountryNameRu(),1100.0F, Position.TESTER, Department.IT));
        arrayList.add(new Employee("Agneshka", "Ag", 29, Gender.FEMININITY.getGenderValueRu(), "agneshka@gmail.com", Country.POLAND.getCountryNameRu(),1100.0F, Position.TESTER, Department.IT));
        arrayList.add(new Employee("Алла", "Алина", 28, Gender.FEMININITY.getGenderValueRu(), "alina@gmail.com", Country.UKRAINE.getCountryNameRu(), 900.0F, Position.MARKETER, Department.HR));
    }

    public void Serialize() {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(arrayList);
            System.out.println(Color.ANSI_BLUE.getCode() + "\nArrayList объектов успешно сериализован" + Color.ANSI_RESET.getCode());
        }
        catch(Exception ex) {
            System.out.println("Ошибка сериализации ArrayList объектов!");
            System.out.println(ex.getMessage());
        }
    }
}
