package ASSG9;

import java.util.Arrays;
import java.util.Optional;

public class Q14 {
    public static void main(String[] args) {
        Student[] students = {
            new Student("arun", 20),
            new Student("aditya", 22),
            new Student("hafeez", 12),
            new Student("alenj", 21),
            new Student("shindu", 19)
        };

        Optional<Student> oldestStudent = Arrays.stream(students)
                                                .reduce((s1, s2) -> s1.age > s2.age ? s1 : s2);

        oldestStudent.ifPresent(student -> System.out.println("Oldest student: " + student.name + ", Age: " + student.age));
    }
}
