import java.util.*;

public class Q6 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter name: ");
    String name = sc.next();

    System.out.print("Are you a guest? (yes/no): ");
    boolean isGuest = sc.next().equalsIgnoreCase("yes");

    System.out.print("Are you vegetarian? (yes/no): ");
    boolean isVegetarian = sc.next().equalsIgnoreCase("yes");

    int numberOfDays = 0;
    while (true) {
      System.out.print("Enter the number of days: ");
      if (sc.hasNextInt()) {
        numberOfDays = sc.nextInt();
        if (numberOfDays > 0) {
          break;
        } else {
          System.out.println("Please enter a positive number of days.");
        }
      } else {
        System.out.println("Invalid input. Please enter an integer.");
        sc.next();
      }
    }

    Person p;

    if(isGuest) {
      p = new Guest(name, isVegetarian, numberOfDays);
    } else {
      p = new Employee(name, isVegetarian, numberOfDays);
    }

    double totalBill = p.calculateBill();

    System.out.printf("Total bill for %s is: %.2f%n", p.getName(), totalBill);
    sc.close();
  }
}

abstract class Person{
  String name;
  boolean isVegetarian;
  int numberOfDays;
  static final int VEGETARIAN_RATE = 100;
  static final int NON_VEGETARIAN_RATE = 120;

  public Person(String name, boolean isVegetarian, int numberOfDays){
    this.name = name;
    this.isVegetarian = isVegetarian;
    this.numberOfDays = numberOfDays;
  }

  abstract double calculateBill();

  public String getName() {
    return name;
  }
}

class Employee extends Person {
  public Employee(String name, boolean isVegetarian, int numberOfDays) {
      super(name, isVegetarian, numberOfDays);
  }

  @Override
  double calculateBill() {
    if (isVegetarian) {
      return numberOfDays * VEGETARIAN_RATE;
    }
    return numberOfDays * NON_VEGETARIAN_RATE;
  }
}

class Guest extends Person {
  public Guest(String name, boolean isVegetarian, int numberOfDays) {
    super(name, isVegetarian, numberOfDays);
  }

  @Override
  double calculateBill() {
    double total;
    if (isVegetarian) {
        total = numberOfDays * VEGETARIAN_RATE;
    } else {
        total = numberOfDays * NON_VEGETARIAN_RATE;
    }
    return total + (total * 0.10); 
  }
}

