package com.airtribe.studentmanagement.entity;

public class GraduateStudent extends Student {
    private String thesisTopic;

    public GraduateStudent(String id, String name, int age, String studentId, String thesisTopic) {
        super(id, name, age);
        this.thesisTopic = thesisTopic;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();  // super keyword usage
        System.out.println("Graduate - Thesis: " + thesisTopic);
    }
}
