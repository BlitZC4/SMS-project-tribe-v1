package com.airtribe.studentmanagement.mainpkg;


import com.airtribe.studentmanagement.entity.Course;
import com.airtribe.studentmanagement.entity.GraduateStudent;
import com.airtribe.studentmanagement.entity.Person;
import com.airtribe.studentmanagement.entity.Student;
import com.airtribe.studentmanagement.service.StudentService;
import com.airtribe.studentmanagement.util.ConsoleUtil;


public class StudentManagementApp {
    public static void main(String[] args) {
        System.out.println("Student Management System Started");
        ConsoleUtil.demoDataTypes();  // Data types demo

        int choice;

        do {
            showMenu();
            choice = ConsoleUtil.getIntInput("Enter choice: ");

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> StudentService.viewAllStudents();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> searchStudent();
                case 6 -> addCourseToStudent();
                case 7 -> demoOOP();
                case 0 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    private static void showMenu() {
        System.out.println("\n=== STUDENT MANAGEMENT ===");
        System.out.println("1. Add Student");
        System.out.println("2. View All");
        System.out.println("3. Update Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Search Student");
        System.out.println("6. Add Course to Student");
        System.out.println("7. OOP Demo");
        System.out.println("0. Exit");
    }

    private static void addStudent() {
        String name = ConsoleUtil.getInput("Name: ");
        int age = ConsoleUtil.getIntInput("Age: ");
        String id = ConsoleUtil.getInput("Student ID: ");
        StudentService.addStudent(name, age, id);
        System.out.println("Student added!");
    }

    private static void addCourseToStudent() {
        String studentId = ConsoleUtil.getInput("Student ID: ");
        String code = ConsoleUtil.getInput("Course code: ");
        String title = ConsoleUtil.getInput("Course title: ");

        Course course = new Course(code, title);
        boolean ok = StudentService.addCourseToStudent(studentId, course);
        if (ok) {
            System.out.println("Course added to student.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void updateStudent() {
        String id = ConsoleUtil.getInput("Student ID to update: ");
        String name = ConsoleUtil.getInput("New name: ");
        if (StudentService.updateStudent(id, name)) {
            System.out.println("Updated!");
        } else {
            System.out.println("Not found!");
        }
    }

    private static void deleteStudent() {
        String id = ConsoleUtil.getInput("Student ID to delete: ");
        if (StudentService.deleteStudent(id)) {
            System.out.println("Deleted!");
        } else {
            System.out.println("Not found!");
        }
    }

    private static void searchStudent() {
        String query = ConsoleUtil.getInput("Search by ID/Name: ");
        StudentService.searchStudents(query).forEach(s -> s.displayInfo());
    }

    // Advanced OOP Demo (Abstraction, Interface, Polymorphism)
    private static void demoOOP() {
        // Polymorphism with base reference
        Person[] people = {
                new Student("P1", "John", 20),
                new GraduateStudent("P2", "Jane", 25, "STU002", "AI Thesis")
        };

        for (Person p : people) {
            p.displayInfo();  // Dynamic dispatch
        }

        // Interface demo (Java 8+ default methods)
        Drawable student = new StudentDrawable();
        student.draw();  // Default method
    }
}

// Interface with default method (Abstraction)
interface Drawable {
    default void draw() {
        System.out.println("Drawing entity...");
    }
}

class StudentDrawable implements Drawable {

}
