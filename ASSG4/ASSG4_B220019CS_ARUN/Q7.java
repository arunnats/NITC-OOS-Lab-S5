public class Q7 {
    public static void main(String[] args) {
        Manager manager = new Manager("Alice", 75000, "IT");
        manager.displayDetails();

        Developer developer = new Developer("Bob", 60000, "Java");
        developer.displayDetails();
    }
}

class Employee {
    protected String name;
    protected double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
    }
}

class Manager extends Employee {
    private String departmentName;

    public Manager(String name, double salary, String departmentName) {
        super(name, salary);
        this.departmentName = departmentName;
    }

    @Override
    public void displayDetails() {
        System.out.println("Manager Details:");
        super.displayDetails(); 
        System.out.println("Department Name: " + departmentName);
        System.out.println();
    }
}

class Developer extends Employee {
    private String programmingLanguage;

    public Developer(String name, double salary, String programmingLanguage) {
        super(name, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public void displayDetails() {
        System.out.println("Developer Details:");
        super.displayDetails(); 
        System.out.println("Programming Language: " + programmingLanguage);
        System.out.println();
    }
}
