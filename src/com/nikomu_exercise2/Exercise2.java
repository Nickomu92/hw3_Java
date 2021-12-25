package com.nikomu_exercise2;

import com.nikomu.Color;

import java.util.*;
import java.util.stream.Collectors;
import java.util.IntSummaryStatistics;

public class Exercise2 {
    public static void main(String[] args) {

        ObjectListSerializer ols = new ObjectListSerializer("people.dat");
        ols.Serialize();

        ObjectListDeserializer old = new ObjectListDeserializer("people.dat");
        ArrayList<User> personArrayList = old.Deserializer();

        System.out.println(Color.ANSI_YELLOW.getCode() + "\n\tСписок всех персон\n" + Color.ANSI_RESET.getCode());
        personArrayList.forEach(System.out::println);


        System.out.println(Color.ANSI_YELLOW.getCode() + "\n\tПолучить arraylist только с пользователями (экземпляры класса User, не Employee)\n" + Color.ANSI_RESET.getCode());
        List<User> users = personArrayList
                .stream()
                .filter(user -> !(user instanceof Employee))
                .toList();
        users.forEach(System.out::println);


        System.out.println(Color.ANSI_YELLOW.getCode() + "\n\tПолучить средний возраст всех\n" + Color.ANSI_RESET.getCode());
        IntSummaryStatistics averageAge = personArrayList
                .stream()
                .collect(Collectors.summarizingInt(User::getAge));
        System.out.printf("Средний возраст, лет: %s;\n", Math.round(averageAge.getAverage()));


        System.out.println(Color.ANSI_YELLOW.getCode() + "\n\tПолучить средний возраст среди несовершеннолетних\n" + Color.ANSI_RESET.getCode());
        IntSummaryStatistics teenagersAverageAge = personArrayList
                .stream()
                .filter(user -> user.getAge() < 18)
                .collect(Collectors.summarizingInt(User::getAge));
        System.out.printf("Средний возраст среди несовершеннолетних, лет: %s;\n", Math.round(teenagersAverageAge.getAverage()));


        System.out.println(Color.ANSI_YELLOW.getCode() + "\n\tПолучить средний оклад на каждый отдел\n" + Color.ANSI_RESET.getCode());
        Map<Department, List<Employee>> departmentList = personArrayList
                .stream()
                .filter(p -> p instanceof Employee)
                .map(Employee.class::cast)
                .collect(Collectors.groupingBy(Employee::getDepartment));

        departmentList.forEach((department, averageSalary) -> {
            System.out.printf("\t%s%s%s\n", Color.ANSI_PURPLE.getCode(), department.getDepartmentNameRu(), Color.ANSI_RESET.getCode());
            DoubleSummaryStatistics aSalary= averageSalary
                    .stream()
                    .collect(Collectors.summarizingDouble(Employee::getSalary));
            System.out.println("Средний оклад " + aSalary.getAverage());
        });

        System.out.println(Color.ANSI_YELLOW.getCode() + "\n\tПолучить пользователей у которых почта \"gmail.com\"\n" + Color.ANSI_RESET.getCode());
        List<User> gmailList = personArrayList
                .stream()
                .filter(user -> !(user instanceof Employee) && user.getEMail().contains("gmail.com"))
                .toList();
        gmailList.forEach(System.out::println);


        System.out.println(Color.ANSI_YELLOW.getCode() + "\n\tПолучить отсортированный по полному имени список женщин среди сотрудников\n" + Color.ANSI_RESET.getCode());
        List<User> fullNameWomenSortedList = personArrayList
                .stream()
                .filter(employee -> employee instanceof Employee && employee.getGender().equals("женский"))
                .sorted(Comparator.comparing(User::getLastName).thenComparing(User::getFirstName))
                .toList();

        fullNameWomenSortedList.forEach(System.out::println);

        System.out.println(Color.ANSI_YELLOW.getCode() + "\n\tПолучить электронные почты всех совершеннолетних женщин, не старше 30 лет, проживающих в Украине, которые являются сотрудниками\n" + Color.ANSI_RESET.getCode());

        List<String> ukrainianWomenEmails = personArrayList
                .stream()
                .filter(ukrWoman -> (ukrWoman instanceof Employee) && ukrWoman.getAge() >= 18 && ukrWoman.getAge() <= 30 && ukrWoman.getGender().equals("женский") && ukrWoman.getCountry().equals("Украина"))
                .map(User::getEMail)
                .toList();

        ukrainianWomenEmails.forEach(System.out::println);
    }
}
