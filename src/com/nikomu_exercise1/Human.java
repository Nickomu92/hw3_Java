package com.nikomu_exercise1;

import java.io.Serializable;

// Класс Human, представляющий сущность человека
public class Human implements Serializable {
    // Статическое поле (свойство), представляющее имя человека
    private String name;
    // Статическое поле (свойство), представляющее возраст человека
    private int age;
    // Статическое поле (свойство), представляющее специальность человека
    private Speciality speciality;

    // Конструктор с параметрами
    public Human(String name, int age, Speciality speciality) {
        this.name = name;
        this.age = age;
        this.speciality = speciality;
    }

    // Метод для получения имени человека
    public String getName() {
        return name;
    }

    // Метод для изменения имени человека
    public void setName(String name) {
        this.name = name;
    }

    // Метод для получения возраста человека
    public int getAge() {
        return age;
    }

    // Метод для изменения возраста человека
    public void setAge(int age) {
        this.age = age;
    }

    // Метод для получения специальности человека
    public Speciality getSpeciality() {
        return speciality;
    }

    // Метод для изменения специальности человека
    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    // Переопределенный метод toString()
    @Override
    public String toString() {
        return this.name + " " + this.age + " " + this.speciality;
    }
}
