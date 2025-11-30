package com.airtribe.studentmanagement.util;

import java.util.Scanner;

public class ConsoleUtil {
    private static Scanner scanner = new Scanner(System.in);

    // Primitive data types demo
    public static void demoDataTypes() {
        // Primitives
        byte b = 127; short s = 32767; int i = 2147483647; long l = 9223372036854775807L;
        float f = 3.14f; double d = 3.14159; char c = 'A'; boolean bool = true;

        System.out.println("Primitives: " + b + ", " + s + ", " + i + ", " + l + ", " + f + ", " + d + ", " + c + ", " + bool);

        // Type casting
        int implicit = s;  // Implicit widening
        double explicit = (double) i;  // Explicit narrowing

        // Static vs Instance
        staticVar = 100;  // Static access
        InstanceDemo demo = new InstanceDemo();
        demo.instanceVar = 200;
    }

    public static String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static int getIntInput(String prompt) {
        return Integer.parseInt(getInput(prompt));
    }

    // Static variable demo
    public static int staticVar;
}

class InstanceDemo {
    int instanceVar;
}
