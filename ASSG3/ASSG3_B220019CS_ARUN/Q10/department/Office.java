package Q10.department;

import Q10.company.Employee;
import Q10.company.Manager;

public class Office {
  public static void main(String[] args) {
    Manager manager = new Manager("Alice");

    System.out.println(manager.getName());
    manager.printName();
    // System.out.println( manager.name); // Compilation Error
  }
}
