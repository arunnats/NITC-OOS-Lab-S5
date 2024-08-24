import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Employee employee = new Employee("John", 50000.0, 30);
        Analyst analyst = new Analyst("Alice", 60000.0, 28, "Data Analysis");
        Salesperson salesperson = new Salesperson("Bob", 45000.0, 32, "Northwest");

        System.out.println("Employee Info:");
        employee.displayInfo();

        System.out.println("\nAnalyst Info:");
        analyst.displayAnalystInfo();

        System.out.println("\nSalesperson Info:");
        salesperson.displaySalespersonInfo();

        employee.raiseSalary();
        analyst.raiseSalary();
        salesperson.raiseSalary();

        System.out.println("\nAfter Raise in Employee Info:");
        employee.displayInfo();

        System.out.println("\nAfter Raise in Analyst Info:");
        analyst.displayAnalystInfo();

        System.out.println("\nAfter Raise in Salesperson Info:");
        salesperson.displaySalespersonInfo();

        System.out.println("\nTotal Employees: " + Employee.getEmployeeCount());
    }
}

class Employee {
    private String name;
    private double salary;
    private int age;
    private static int employeeCount = 0;

    public Employee(String name, double salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        employeeCount++;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public void raiseSalary() {
        this.salary *= 1.2; // Raises salary by 20%
    }

    public static int getEmployeeCount() {
        return employeeCount;
    }

    public void displayInfoBase() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);
    }

    public void displayInfo() {
        System.out.println("Employee Info:");
        displayInfoBase();
    }
}

class Analyst extends Employee {
    private String specialization;

    public Analyst(String name, double salary, int age, String specialization) {
        super(name, salary, age);
        this.specialization = specialization;
    }

    public void displayAnalystInfo() {
        System.out.println("Analyst Info:");
        displayInfoBase();
        System.out.println("Specialization: " + specialization);
    }
}

class Salesperson extends Employee {
    private String region;

    public Salesperson(String name, double salary, int age, String region) {
        super(name, salary, age);
        this.region = region;
    }

    public void displaySalespersonInfo() {
        System.out.println("Salesperson Info:");
        displayInfoBase();
        System.out.println("Region: " + region);
    }
}

