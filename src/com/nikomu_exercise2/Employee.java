package com.nikomu_exercise2;

import com.nikomu.Color;

import java.io.*;

public class Employee extends User implements Serializable {
    private double salary;
    private Position position;
    private Department department;

    public Employee(String firstName, String lastName, int age, String gender, String eMail, String country, float salary, Position position, Department department) {
        super(firstName, lastName, age, gender, eMail, country);
        this.salary = salary;
        this.position = position;
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return Color.ANSI_BLUE.getCode() + "Employee {" + Color.ANSI_RESET.getCode() +
                "firstName = '" + Color.ANSI_GREEN.getCode() + super.getFirstName() + '\'' + Color.ANSI_RESET.getCode() +
                ", lastName = '" + Color.ANSI_GREEN.getCode() + super.getLastName() + '\'' + Color.ANSI_RESET.getCode() +
                ", age = " + Color.ANSI_GREEN.getCode() + super.getAge() + Color.ANSI_RESET.getCode() +
                ", gender = '" + Color.ANSI_GREEN.getCode() + super.getGender() + '\'' + Color.ANSI_RESET.getCode() +
                ", eMail = '" + Color.ANSI_GREEN.getCode() + super.getEMail() + '\'' + Color.ANSI_RESET.getCode() +
                ", country = '" + Color.ANSI_GREEN.getCode() + super.getCountry() + '\'' + Color.ANSI_RESET.getCode() +
                ", salary = " + Color.ANSI_GREEN.getCode() + this.salary + Color.ANSI_RESET.getCode() +
                ", position = '" + Color.ANSI_GREEN.getCode() + this.position.getPositionNameRu() + '\'' + Color.ANSI_RESET.getCode() +
                ", department = '" + Color.ANSI_GREEN.getCode() + this.department.getDepartmentNameRu() + '\'' + Color.ANSI_RESET.getCode() +
                Color.ANSI_BLUE.getCode() + '}' + Color.ANSI_RESET.getCode();
    }
}
