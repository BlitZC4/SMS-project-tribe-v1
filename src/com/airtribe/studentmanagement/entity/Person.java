package com.airtribe.studentmanagement.entity;

public abstract class Person {
    private String id;
    private String name;
    protected int age;  // Protected for inheritance access

    // Default constructor
    public Person() {}

    // Parameterized constructor
    public Person(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Copy constructor
    public Person(Person other) {
        this.id = other.id;
        this.name = other.name;
        this.age = other.age;
    }

    // Getters/Setters (Encapsulation)
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public abstract void displayInfo();  // Abstraction
}