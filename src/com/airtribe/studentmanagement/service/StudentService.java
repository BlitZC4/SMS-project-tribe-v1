package com.airtribe.studentmanagement.service;

import com.airtribe.studentmanagement.entity.Course;
import com.airtribe.studentmanagement.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentService {
    private static List<Student> students = new ArrayList<>();
    private static int nextId = 1;

    // CREATE
    public static void addStudent(String name, int age, String studentId) {
        Student student = new Student("P" + nextId++, name, age);
        students.add(student);
    }

    // READ
    public static void viewAllStudents() {
        students.forEach(s -> {
            s.displayInfo();
            System.out.println("Courses: " + s.getCourses());
            System.out.println();
        });
    }

    // find by studentId
    public static Student findByStudentId(String studentId) {
        return students.stream()
                .filter(s -> s.getId().equals(studentId) || s.getStudentId().equals(studentId))
                .findFirst()
                .orElse(null);
    }

    // add course to student
    public static boolean addCourseToStudent(String studentId, Course course) {
        Student s = findByStudentId(studentId);
        if (s == null) {
            return false;
        }
        s.addCourse(course);
        return true;
    }



    // UPDATE
    public static boolean updateStudent(String id, String newName) {
        return students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .map(s -> {
                    s.setName(newName);
                    return true;
                }).orElse(false);
    }

    // DELETE
    public static boolean deleteStudent(String id) {
        return students.removeIf(s -> s.getId().equals(id));
    }

    // SEARCH
    public static List<Student> searchStudents(String query) {
        return students.stream()
                .filter(s -> s.getId().contains(query) || s.getName().contains(query))
                .collect(Collectors.toList());
    }
}
