package com.airtribe.studentmanagement.entity;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private String studentId;

    private List<Course> courses = new ArrayList<>();

    public void addCourse(Course course) {
        courses.add(course);
    }

    public List<Course> getCourses() {
        return new ArrayList<>(courses);
    }

    public Student(String studentId, String name, int age) {
        super(studentId, name, age); // or drop Person.id entirely
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    // Method overriding (Runtime polymorphism)
    @Override
    public void displayInfo() {
        System.out.println("Student: " + getName()
                + " (Student ID: " + getStudentId() + ")");
    }


}
