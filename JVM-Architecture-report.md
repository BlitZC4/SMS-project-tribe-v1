JVM Architecture Report
1. Overview
The Java Virtual Machine (JVM) is the runtime environment that executes compiled Java bytecode and makes Java platform‑independent. Java source files are compiled by javac into .class files, and the JVM loads and runs this bytecode instead of native machine code.​

2. Main Components
2.1 Class Loader Subsystem
The class loader finds .class files and loads them into memory when they are first needed. It then links them (verification, preparation, resolution) and initializes static data. In this project it loads classes such as Person, Student, GraduateStudent, StudentService, and StudentManagementApp at runtime.​

2.2 Runtime Data Areas
The JVM defines several memory areas that exist while the program runs:​

Method Area – Stores class metadata and bytecode of methods for all loaded classes (for example, addStudent, displayInfo, main).

Heap – Shared area where all objects are created, such as Student, ArrayList<Student>, and Course instances.

Java Stacks – Each thread has its own stack of frames holding local variables and intermediate results for method calls.

PC Register – Per‑thread register indicating the current bytecode instruction.

Native Method Stack – Used when Java code calls native (non‑Java) methods.

Garbage collection runs in the heap to automatically reclaim memory from objects that are no longer reachable.​

2.3 Execution Engine
The Execution Engine reads bytecode from the Method Area and executes it.​

Interpreter executes bytecode instruction by instruction, which gives fast startup.

Just‑In‑Time (JIT) compiler detects frequently executed (“hot”) code and compiles it to optimized native machine code for better performance.​

Together they run all the logic of the Student Management System, such as the menu loop and CRUD operations.

3. Bytecode Execution Flow
Java source code in this project is compiled by javac into .class bytecode files.

The JVM starts, and the class loader loads StudentManagementApp and other referenced classes.​

Runtime data areas are created; objects like Student and Course are allocated on the heap as the user interacts with the menu.

The Execution Engine interprets or JIT‑compiles methods and the Garbage Collector frees memory for objects that are no longer used.​

4. “Write Once, Run Anywhere”
Java follows the principle of “Write Once, Run Anywhere” because source code is compiled into platform‑independent bytecode that any compatible JVM can execute. The same compiled Student Management System can run on Windows, Linux, or macOS without changes to the Java code, as long as a JVM is installed.
