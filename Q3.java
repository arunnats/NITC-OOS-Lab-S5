import java.util.*;

class Student {
    String name;
    int rollNumber;

    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber;
    }
}

class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < n; i++) {
            System.out.print("Enter name of student " + (i + 1) + ": ");
            String name = scanner.nextLine();
            System.out.print("Enter roll number of student " + (i + 1) + ": ");
            int rollNumber = scanner.nextInt();
            scanner.nextLine(); 

            students.add(new Student(name, rollNumber));
        }

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Integer.compare(s1.rollNumber, s2.rollNumber);
            }
        });

        System.out.println("\nSorted list of students by roll number:");
        for (Student student : students) {
            System.out.println(student);
        }

        scanner.close();
    }
}
