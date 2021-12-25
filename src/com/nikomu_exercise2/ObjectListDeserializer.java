package com.nikomu_exercise2;

import java.io.*;
import java.util.ArrayList;

public class ObjectListDeserializer {

    private ArrayList<User> objectArrayList;
    private String filePath;

    public ObjectListDeserializer(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<User> Deserializer() {
       this.objectArrayList = new ArrayList<>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            this.objectArrayList = (ArrayList<User>)ois.readObject();
        }
        catch(Exception ex) {
            System.out.println("Ошибка десериализации!");
            System.out.println(ex.getMessage());
        }
        return this.objectArrayList;
    }
}
