package Q10.company;

public class Manager extends Employee {

  public Manager(String name) {
      super(name);
  }

  public void printName() {
      System.out.println("Manager's name: " + name);
  }
}
