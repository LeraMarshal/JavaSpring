package de.marshal.javaspring.entities;

import java.util.UUID;

public class Employee {
    private String id;
    private String name;
    private String surname;
    private int age;

    public Employee(String id, String name, String surname, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Employee(String name, String surname, int age) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    protected Employee() {
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
