public class Q7 {
  public static void main(String[] args) {

    Car car = new Car("Toyota", "Corolla", 2020, "Red", 60, 4, 12.0);
    Bus bus = new Bus("Mercedes", "Sprinter", 2019, "Blue", 50, 30, "42B", true);
    SUV suv = new SUV("Jeep", "Wrangler", 2022, "Black", 55, 4, 15.0, true);
    ElectricCar electricCar = new ElectricCar("Tesla", "Model S", 2021, "Silver", 65, 4, 12.0, 100);
    SportsCar sportsCar = new SportsCar("Ferrari", "488", 2023, "Red", 90, 4, 15.0, 210);

    car.accelerate();
    car.turnRight();

    bus.accelerate();
    bus.turnRight();

    suv.engage4WD();
    suv.brake();

    electricCar.accelerate();
    electricCar.chargeBattery();

    sportsCar.accelerate();
  }
}

class Vehicle {
  private String make;
  private String model;
  private int year;
  private String color;
  private int currentSpeed;

  public Vehicle(String make, String model, int year, String color, int currentSpeed) {
    this.make = make;
    this.model = model;
    this.year = year;
    this.color = color;
    this.currentSpeed = currentSpeed;
  }

  public void accelerate() {
    System.out.println("Vrooooom");
  }

  public void brake() {
    System.out.println("Stopping");
  }

  public void turnLeft() {
    System.out.println("Turning left");
  }

  public void turnRight() {
    System.out.println("Turning right");
  }
}

class Car extends Vehicle {
  private int numDoors;
  private double trunkCapacity;

  public Car(String make, String model, int year, String color, int currentSpeed, int numDoors, double trunkCapacity) {
    super(make, model, year, color, currentSpeed);
    this.numDoors = numDoors;
    this.trunkCapacity = trunkCapacity;
  }

  @Override
  public void brake() {
    System.out.println("Opening trunk");
  }

  @Override
  public void turnLeft() {
    System.out.println("Closing trunk");
  }
}

class Bus extends Vehicle {
  private int numSeats;
  private String routeNumber;
  private boolean isDoubleDecker;

  public Bus(String make, String model, int year, String color, int currentSpeed, int numSeats, String routeNumber, boolean isDoubleDecker) {
    super(make, model, year, color, currentSpeed);
    this.numSeats = numSeats;
    this.routeNumber = routeNumber;
    this.isDoubleDecker = isDoubleDecker;
  }

  @Override
  public void brake() {
    System.out.println("Opening doors");
  }

  @Override
  public void turnLeft() {
    System.out.println("Closing doors");
  }
}

class SUV extends Car {
  private boolean offRoadCapability;

  public SUV(String make, String model, int year, String color, int currentSpeed, int numDoors, double trunkCapacity, boolean offRoadCapability) {
    super(make, model, year, color, currentSpeed, numDoors, trunkCapacity);
    this.offRoadCapability = offRoadCapability;
  }

  public void engage4WD() {
    System.out.println("Wow I climb hills");
  }
}

class Sedan extends Car {
  private boolean luxuryInterior;

  public Sedan(String make, String model, int year, String color, int currentSpeed, int numDoors, double trunkCapacity, boolean luxuryInterior) {
    super(make, model, year, color, currentSpeed, numDoors, trunkCapacity);
    this.luxuryInterior = luxuryInterior;
  }

  public void activateMassageSeats() {
    System.out.println("OMG so comfy");
  }
}

class ElectricCar extends Car {
  private int batteryCapacity;

  public ElectricCar(String make, String model, int year, String color, int currentSpeed, int numDoors, double trunkCapacity, int batteryCapacity) {
    super(make, model, year, color, currentSpeed, numDoors, trunkCapacity);
    this.batteryCapacity = batteryCapacity;
  }

  @Override
  public void accelerate() {
    System.out.println("MORE VROOOOM");
  }

  public void chargeBattery() {
    System.out.println("Tesla needs juice");
  }
}

class SportsCar extends Car {
  private int topSpeed;

  public SportsCar(String make, String model, int year, String color, int currentSpeed, int numDoors, double trunkCapacity, int topSpeed) {
    super(make, model, year, color, currentSpeed, numDoors, trunkCapacity);
    this.topSpeed = topSpeed;
  }

  @Override
  public void accelerate() {
    System.out.println("MORE FASTER VROOOOM");
  }
}
