import java.util.*;

public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();  
        sc.nextLine();  

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] studentDetails = sc.nextLine().split(" ");
            String name = studentDetails[1];
            int rollno = Integer.parseInt(studentDetails[0]);
            String address = studentDetails[2];

            students.add(new Student(name, rollno, address));
        }

        Student studentInstance = new Student("", 0, "");
        studentInstance.OrderByRollno(students);
        studentInstance.OrderByName(students);

        sc.close();
    }
}

interface OrderStudents {
    void OrderByRollno(List<Student> students);
    void OrderByName(List<Student> students);
}

class Student implements OrderStudents {
    private String name;
    private int rollno;
    private String address;

    public Student(String name, int rollno, String address) {
        this.name = name;
        this.rollno = rollno;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getRollno() {
        return rollno;
    }

    public String getAddress() {
        return address;
    }

    public void display() {
        System.out.println(rollno + " " + name + " " + address);
    }

    @Override
    public void OrderByRollno(List<Student> students) {
        Collections.sort(students, Comparator.comparingInt(Student::getRollno));

        System.out.println("// Sorted by Rollno");
        for (Student student : students) {
            student.display();
        }
    }

    @Override
    public void OrderByName(List<Student> students) {
        Collections.sort(students, Comparator.comparing(Student::getName));

        System.out.println("// Sorted by Name");
        for (Student student : students) {
            student.display();
        }
    }
}
