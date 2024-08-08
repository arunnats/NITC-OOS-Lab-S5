import java.util.*;

public class Q9 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Classroom classroom = new Classroom();

    System.out.print("Enter the number of students to add: ");
    int numStudents = sc.nextInt();
    sc.nextLine();

    for (int i = 0; i < numStudents; i++) {
      System.out.print("Enter roll number: ");
      int rollNumber = sc.nextInt();
      sc.nextLine(); 

      System.out.print("Enter full name: ");
      String fullName = sc.nextLine();

      System.out.print("Enter height: ");
      int height = sc.nextInt();

      System.out.print("Enter weight: ");
      int weight = sc.nextInt();
      sc.nextLine();

      classroom.displayTeacherOptions();
      System.out.print("Choose a teacher by ID: ");
      int teacherID = sc.nextInt();
      sc.nextLine(); 

      Teacher assignedTeacher = classroom.getTeacherByID(teacherID);
      if (assignedTeacher == null) {
          System.out.println("Invalid teacher ID.");
          continue;
      }

      Student student = new Student(rollNumber, fullName, height, weight, assignedTeacher);
      classroom.addStudent(student);
      System.out.println(fullName + " has been added to the student list.");
    }

    classroom.printStudentsSortedByHeight();
    classroom.printStudentNamesAndTeachers();

    sc.close();  
  }
}

class Classroom {
  private List<Teacher> teachers = new ArrayList<>();
  private List<Student> students = new ArrayList<>();

  public Classroom() {
    teachers.add(new Teacher(1, "Mr. Sabu"));
    teachers.add(new Teacher(2, "Ms. Jaya"));
    teachers.add(new Teacher(3, "Dr. Babu"));
  }

  public void addStudent(Student student) {
    students.add(student);
  }

  public void printStudentsSortedByHeight() {
    students.sort(Comparator.comparingDouble(Student::getHeight));
    System.out.println("All students sorted by height:");
    for (Student student : students) {
        System.out.println(student);
    }
  }

  public void printStudentNamesAndTeachers() {
    System.out.println("Student Names and their Assigned Teachers:");
    for (Student student : students) {
        System.out.println(student.getFullName() + " - " + student.getAssignedTeacher());
    }
  }

  public void displayTeacherOptions() {
      System.out.println("Available teachers:");
      for (Teacher teacher : teachers) {
          System.out.println(teacher.getTeacherID() + ". " + teacher.getTeacherName());
      }
  }

  public Teacher getTeacherByID(int id) {
    int left = 0;
    int right = teachers.size() - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      Teacher midTeacher = teachers.get(mid);

      if (midTeacher.getTeacherID() == id) {
        return midTeacher;
      } else if (midTeacher.getTeacherID() < id) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return null;
  }
}

class Student {
  private int rollNumber;
  private String fullName;
  private int height;
  private int weight;
  private Teacher assignedTeacher;

  public Student(int rollNumber, String fullName, int height, int weight, Teacher assignedTeacher) {
      this.rollNumber = rollNumber;
      this.fullName = fullName;
      this.height = height;
      this.weight = weight;
      this.assignedTeacher = assignedTeacher;
  }

  public int getRollNumber() {
      return rollNumber;
  }

  public String getFullName() {
      return fullName;
  }

  public int getHeight() {
      return height;
  }

  public int getWeight() {
      return weight;
  }

  public Teacher getAssignedTeacher() {
      return assignedTeacher;
  }

  @Override
  public String toString() {
      return "Roll Number: " + rollNumber + "\n" + "Full Name: " + fullName + "\n" + "Height: " + height + "\n" + "Weight: " + weight + "\n" + "Assigned Teacher: " + (assignedTeacher != null ? assignedTeacher.getTeacherName() : "None") + "\n";
  }
}

class Teacher {
  private int teacherID;
  private String teacherName;

  public Teacher(int teacherID, String teacherName) {
      this.teacherID = teacherID;
      this.teacherName = teacherName;
  }

  public int getTeacherID() {
      return teacherID;
  }

  public String getTeacherName() {
      return teacherName;
  }

  @Override
  public String toString() {
      return teacherName;
  }
}