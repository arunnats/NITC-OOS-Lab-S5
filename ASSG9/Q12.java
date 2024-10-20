package ASSG9;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q12 {
    public static void main(String[] args) {
        Student[] students = {
            new Student("arun", 20),
            new Student("aditya", 22),
            new Student("hafeez", 12),
            new Student("alenj", 21),
            new Student("shindu", 19)
        };

        Map<Integer, List<String>> studentsGroupedByAge = Arrays.stream(students)
                                                                .collect(Collectors.groupingBy(
                                                                    student -> student.age,
                                                                    Collectors.mapping(student -> student.name, Collectors.toList())
                                                                ));
        System.out.println(studentsGroupedByAge);
    }
}
