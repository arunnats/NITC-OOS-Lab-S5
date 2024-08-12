import java.util.*;

public class Q6 {
  public static void main(String[] args) {
    University university = new University();
    
    Department CSED = new Department("Computer Science");
    Department EED = new Department("Electrical Engineering");
    
    university.addDepartment(CSED);
    university.addDepartment(EED);
    
    Professor profBob = new Professor("Dr. Bob", "P001", CSED);
    Professor profRob = new Professor("Dr. Rob", "P002", EED);
    
    CSED.addProfessor(profBob);
    EED.addProfessor(profRob);
    
    Student Arun = new Student("Arun", "S001", "Computer Science");
    Student Hafeez = new Student("Hafeez", "S002", "Electrical Engineering");
    
    CSED.addStudent(Arun);
    EED.addStudent(Hafeez);
    
    System.out.println("Departments:");
    university.viewDepartments();
    
    System.out.println("\nProfessors in Computer Science Department:");
    CSED.viewProfessors();
    
    System.out.println("\nProfessors in Electrical Engineering Department:");
    EED.viewProfessors();
    
    System.out.println("\nStudents in Computer Science Department:");
    CSED.viewStudents();
    
    System.out.println("\nStudents in Electrical Engineering Department:");
    EED.viewStudents();
  }
}

class University {
  private List<Department> departments;

  public University() {
      this.departments = new ArrayList<>();
  }

  public void addDepartment(Department department) {
      departments.add(department);
  }

  public void viewDepartments() {
    for (Department dept : departments) {
        System.out.println("Department: " + dept.getName());
    }
  }
}

class Department {
  private String name;
  private List<Professor> professors;
  private List<Student> students;

  public Department(String name) {
    this.name = name;
    this.professors = new ArrayList<>();
    this.students = new ArrayList<>();
  }

  public String getName() {
      return name;
  }

  public void addProfessor(Professor professor) {
      professors.add(professor);
  }

  public void addStudent(Student student) {
      students.add(student);
  }

  public void viewProfessors() {
    if (professors.isEmpty()) {
      System.out.println("No professors");
    } else {
      for (Professor prof : professors) {
        System.out.println("Name: " + prof.getName() + ", ID: " + prof.getId());
      }
    }
  }

  public void viewStudents() {
    if (students.isEmpty()) {
      System.out.println("No students");
    } else {
      for (Student student : students) {
        System.out.println("Name: " + student.getName() + ", ID: " + student.getId() + ", Major: " + student.getMajor());
      }
    }
  }
}

class Professor {
  private String name;
  private String id;
  private Department department;

  public Professor(String name, String id, Department department) {
      this.name = name;
      this.id = id;
      this.department = department;
  }

  public String getName() {
      return name;
  }

  public String getId() {
      return id;
  }

  public String getDepartment() {
    return department.getName();
  }
}

class Student {
  private String name;
  private String id;
  private String major;

  public Student(String name, String id, String major) {
      this.name = name;
      this.id = id;
      this.major = major;
  }

  public String getName() {
      return name;
  }

  public String getId() {
      return id;
  }

  public String getMajor() {
      return major;
  }
}
