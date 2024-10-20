package ASSG9;

import java.util.Arrays;
import java.util.Comparator;

public class Q11 {
    public static void main(String[] args) {
        Student[] students = {
            new Student("arun", 20),
            new Student("aditya", 22),
            new Student("hafeez", 12),
            new Student("alenj", 21),
            new Student("shindu", 19)
        };

        Arrays.stream(students)
              .sorted(Comparator.comparingInt(student -> student.age))
              .forEach(student -> System.out.println(student.name + ": " + student.age));
    }
}
