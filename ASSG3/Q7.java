public class Q7 {
  public static void main(String[] args) {
    
  }
}

class Vehicle{
  private String make;
  private String model;
  private int year;
  private String color;
  private int currentSpeed;
  
  public void accelerate(){
    System.out.println("Vrooooom");
  }

  public void brake(){
    System.out.println("Stopping");
  }

  public void turnLeft(){
    System.out.println("Turn right");
  }

  public void turnRight(){
    System.out.println("Turn left");
  }
}

class Car extends Vehicle{
  private int numDoors;
  private double trunkCapacity;

  public void brake(){
    System.out.println("Opening trunk");
  }

  public void turnLeft(){
    System.out.println("Closing trunk");
  }
}

class Bus extends Vehicle{
  private int numSeats;
  private String routeNumber;
  private boolean isDoubleDecker;

  public void brake(){
    System.out.println("Opening doors");
  }

  public void turnLeft(){
    System.out.println("Closing doors");
  }
}
class SUV extends Car {
  private boolean offRoadCapability;

  public void engage4WD(){
    System.out.println("Wow i climb hill");
  }
}

class Sedan extends Car {
  private boolean luxuryInterior;

  public void activateMassageSeats(){
    System.out.println("OMG so comfy");
  }
}

class ElectricCar extends Car {
  private int batteryCapacity;

  public void chargeBattery(){
    System.out.println("Tesla needs juice");
  }

  @Override
  public void accelerate(){
    System.out.println("MORE VROOOOM");
  }
}

class SportsCar extends Car {
  private int topSpeed;

  @Override
  public void accelerate(){
    System.out.println("MORE FASTER VROOOOM");
  }
}
