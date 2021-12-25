package com.nikomu_exercise1;

import java.sql.*;
import java.util.*;

// Класс DatabaseEntity, представляющий сущность БД
public class DatabaseEntity {
    // Статическое поле (свойство), представляющее URL-адрес к БД
    private static final String url = "jdbc:mysql://localhost:3307/hw3_java";
    // Статическое поле (свойство), представляющее имя пользователя (логин) от БД
    private static final String username = "root";
    // Статическое поле (свойство), представляющее пароль пользователя от БД
    private static final String password = "1111";

    // Метод для подключения к БД
    private static boolean connectToDB(String sqlQuery) {
        boolean result = true;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            try(Connection connection = DriverManager.getConnection(url, username, password)) {

                Statement statement = connection.createStatement();

                statement.executeUpdate(sqlQuery);
            }
        }
        catch(Exception ex) {
            System.out.println("Ошибка подключения к БД!");
            System.out.println(ex.getMessage());
            result = false;
        }

        return result;
    }

    // Метод для создания таблицы "Humans" в БД "Hw3_Java"
    private static boolean createTable() {
        boolean result;

        // Строка SQL запроса на создание таблицы "Humans"
        String sqlCreateTable = "CREATE TABLE IF NOT EXISTS humans (Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, Name NVARCHAR(50) NOT NULL, Age INT NOT NULL, Speciality NVARCHAR(200) NOT NULL)";

        // Создаем в БД таблицу "Humans"
        result = connectToDB(sqlCreateTable);
        return result;
    }

    // Метод для очистки таблицы "Humans" в БД "Hw3_Java"
    private static void truncateTable() {
        String sqlTruncate = "TRUNCATE TABLE Humans";
        connectToDB(sqlTruncate);
    }

    // Метод для заполнения таблицы "Humans" данными
    private static boolean insertData() {
        boolean result = false;

        // Если таблица в БД создана, то заполняем её
        if (createTable()) {
            // Строка SQL запроса на добавление данных в таблицу "Humans"
            String sqlInsert = "INSERT Humans (Name, Age, Speciality) VALUES" +
                    String.format("('%s', %d, '%s'),", "Ivan", 20, Speciality.DEVELOPER) +
                    String.format("('%s', %d, '%s'),", "Petr", 33, Speciality.DEVELOPER) +
                    String.format("('%s', %d, '%s'),", "Stepan", 18, Speciality.DESIGNER) +
                    String.format("('%s', %d, '%s'),", "Viktoria", 40, Speciality.TESTER) +
                    String.format("('%s', %d, '%s'),", "Olga", 18, Speciality.DESIGNER) +
                    String.format("('%s', %d, '%s'),", "Artur", 55, Speciality.TESTER) +
                    String.format("('%s', %d, '%s'),", "Artem", 15, Speciality.DEVELOPER) +
                    String.format("('%s', %d, '%s');", "Bob", 77, Speciality.DESIGNER);

            // Заполняем таблицу "Humans" данными
            result = connectToDB(sqlInsert);
        }

        return result;
    }

    // Метод для получения списка объектов "Human" из БД "Hw3_java"
    public static List<Human> getListFromDB() {
        truncateTable();

        List<Human> newList = new ArrayList<>();

        if(insertData()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

                try(Connection connection = DriverManager.getConnection(url, username, password)) {
                    Statement statement = connection.createStatement();

                    ResultSet resultSet = statement.executeQuery("SELECT * FROM Humans");

                    // Пока в таблице "Humans" есть записи получаем их
                    while(resultSet.next()) {
                        // Получаем имя
                        String name = resultSet.getString(2);
                        // Получаем возраст
                        int age = resultSet.getInt(3);
                        // Получаем строковое представление специальности
                        String spec = resultSet.getString(4);
                        // Получаем специальность
                        Speciality speciality = Speciality.getSpecialityItem(spec);

                        // Добавляем новый объект (экземпляр) Human в список
                        newList.add(new Human(name, age, speciality));
                    }
                }
            }
            catch(Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        return newList;
    }
}
