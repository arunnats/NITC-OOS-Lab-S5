public class Q7 {
    public static void main(String[] args) {
        Professor professor = new Professor("Dr. John Doe", "P123", "Computer Science", 3, 2);
        Student student = new Student("Alice Smith", "S456", "Electrical Engineering", 18, 3.8);
        AdministrativeStaff adminStaff = new AdministrativeStaff("Mr. Mark Johnson", "A789", "Administration", 10);
        System.out.println(professor.getDetails());
        System.out.println("Role: " + professor.getRole());
        System.out.println("Workload: " + professor.calculateWorkload());
        professor.listResponsibilities();
        System.out.println("\n" + student.getDetails());
        System.out.println("Role: " + student.getRole());
        System.out.println("Workload: " + student.calculateWorkload());
        System.out.println("\n" + adminStaff.getDetails());
        System.out.println("Role: " + adminStaff.getRole());
        System.out.println("Workload: " + adminStaff.calculateWorkload());
        adminStaff.listResponsibilities(); }
}

abstract class Person {
    protected String name;
    protected String id;
    protected String department;

    public Person(String name, String id, String department) {
        this.name = name;
        this.id = id;
        this.department = department;
    }

        public abstract String getRole();
    public abstract double calculateWorkload();
    
    public String getDetails() {
        return "Name: " + name + ", ID: " + id + ", Department: " + department;
    }
}

interface Responsibility {
    void listResponsibilities();
}

class Professor extends Person implements Responsibility {
    private int coursesTaught;
    private int researchProjects;

    public Professor(String name, String id, String department, int coursesTaught, int researchProjects) {
        super(name, id, department);
        this.coursesTaught = coursesTaught;
        this.researchProjects = researchProjects;
    }

    @Override
    public String getRole() {
        return "Professor";
    }

    @Override
    public double calculateWorkload() {
        return (coursesTaught * 3) + (researchProjects * 2);
    }

    @Override
    public void listResponsibilities() {
        System.out.println("Responsibilities: Teaching, Research, Mentoring Students");
    }
}

class Student extends Person {
    private int creditsEnrolled;
    private double gpa;

    public Student(String name, String id, String department, int creditsEnrolled, double gpa) {
        super(name, id, department);
        this.creditsEnrolled = creditsEnrolled;
        this.gpa = gpa;
    }

    @Override
    public String getRole() {
        return "Student";
    }

    @Override
    public double calculateWorkload() {
        return creditsEnrolled;
    }
}

class AdministrativeStaff extends Person implements Responsibility {
    private int tasksHandled;

    public AdministrativeStaff(String name, String id, String department, int tasksHandled) {
        super(name, id, department);
        this.tasksHandled = tasksHandled;
    }

    @Override
    public String getRole() {
        return "Administrative Staff";
    }

    @Override
    public double calculateWorkload() {
        return tasksHandled * 1.5;
    }

    @Override
    public void listResponsibilities() {
        System.out.println("Responsibilities: Managing Files, Organizing Events, Supporting Faculty");
    }
}

