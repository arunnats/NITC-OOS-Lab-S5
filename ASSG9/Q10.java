package ASSG9;

import java.util.Arrays;

class Student {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class Q10 {
    public static void main(String[] args) {
        Student[] students = {
            new Student("arun", 20),
            new Student("aditya", 22),
            new Student("hafeez", 12),
            new Student("alenj", 21),
            new Student("shindu", 19)
        };

        double averageAge = Arrays.stream(students)
                                  .mapToInt(student -> student.age)
                                  .average()
                                  .orElse(0);
        System.out.println("Average age: " + averageAge);
    }
}
