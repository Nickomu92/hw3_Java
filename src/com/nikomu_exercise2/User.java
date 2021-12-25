package com.nikomu_exercise2;

import com.nikomu.Color;

import java.io.*;

public class User implements Serializable {
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String eMail;
    private String country;

    public User(String firstName, String lastName, int age, String gender, String eMail, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.eMail = eMail;
        this.country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFullName(String fullName) {
        this.firstName = fullName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String fullName) {
        this.firstName = lastName;
    }

    public int getAge() {
        return age;
   }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return Color.ANSI_GREEN.getCode() + "User {" + Color.ANSI_RESET.getCode() +
                "firstName = '" + Color.ANSI_BLUE.getCode() + this.firstName + '\'' + Color.ANSI_RESET.getCode() +
                ", lastName = '" + Color.ANSI_BLUE.getCode() + this.lastName + '\'' + Color.ANSI_RESET.getCode() +
                ", age = " + Color.ANSI_BLUE.getCode() + this.age + Color.ANSI_RESET.getCode() +
                ", gender = '" + Color.ANSI_BLUE.getCode() + this.gender + '\'' + Color.ANSI_RESET.getCode() +
                ", eMail = '" + Color.ANSI_BLUE.getCode() + this.eMail + '\'' + Color.ANSI_RESET.getCode() +
                ", country = '" + Color.ANSI_BLUE.getCode() + this.country + '\'' + Color.ANSI_RESET.getCode() +
                Color.ANSI_GREEN.getCode() + '}' + Color.ANSI_RESET.getCode();
    }
}
