public class Q8 {
  public static void main(String[] args) {
    Officer officer = new Officer("Arun Nats", 20, "123 Kattangal", "9080068577", 5000.0, "Cybersecurity");
    Manager manager = new Manager("Hafeeeez", 21, "456 Kattangal", "9080068588", 7000.0, "IT Department");

    officer.getDetails();
    System.out.println("Specialization: " + officer.getSpecialization());
    officer.updateSpecialization("Network Security");
    System.out.println("Updated Specialization: " + officer.getSpecialization());
    System.out.println("Officer's Annual Salary: $" + officer.calculateAnnualSalary());

    System.out.println();

    manager.getDetails();
    System.out.println("Department: " + manager.getDepartment());
    manager.updateDepartment("HR Department");
    System.out.println("Updated Department: " + manager.getDepartment());
    System.out.println("Manager's Annual Salary: $" + manager.calculateAnnualSalary());
  }
}

class Employee {
  private String name;
  private int age;
  private String address;
  private String phone;
  private Double salary;

  public Employee(String name, int age, String address, String phone, Double salary) {
    this.name = name;
    this.age = age;
    this.address = address;
    this.phone = phone;
    this.salary = salary;
  }

  public void getDetails() {
    System.out.println("Name: " + name);
    System.out.println("Age: " + age);
    System.out.println("Address: " + address);
    System.out.println("Phone: " + phone);
    System.out.println("Salary: " + salary);
  }

  public void updateDetails(String name, int age, String address, String phone, Double salary) {
    this.name = name;
    this.age = age;
    this.address = address;
    this.phone = phone;
    this.salary = salary;
  }

  public double calculateAnnualSalary() {
    return salary * 12;
  }
}

class Officer extends Employee {
  private String specialization;

  public Officer(String name, int age, String address, String phone, Double salary, String specialization) {
    super(name, age, address, phone, salary);
    this.specialization = specialization;
  }

  public String getSpecialization() {
    return specialization;
  }

  public void updateSpecialization(String specialization) {
    this.specialization = specialization;
  }

  @Override
  public double calculateAnnualSalary() {
    double bonus = 0.0;
    if ("Cybersecurity".equals(specialization)) {
      bonus = 1000.0;
    }
    return (super.calculateAnnualSalary() + bonus);
  }
}

class Manager extends Employee {
  private String department;

  public Manager(String name, int age, String address, String phone, Double salary, String department) {
    super(name, age, address, phone, salary);
    this.department = department;
  }

  public String getDepartment() {
    return department;
  }

  public void updateDepartment(String department) {
    this.department = department;
  }

  @Override
  public double calculateAnnualSalary() {
    double bonus = 0.0;
    if ("IT Department".equals(department)) {
      bonus = 2000.0;
    }
    return (super.calculateAnnualSalary() + bonus);
  }
}
