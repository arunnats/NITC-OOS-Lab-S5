import java.util.*;

public class Q7 {
    private static List<Vehicle> vehicles = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Vehicle");
            System.out.println("2. Display Vehicles");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addVehicle(sc);
                    break;
                case 2:
                    displayVehicles();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void addVehicle(Scanner sc) {
        System.out.println("a. Car");
        System.out.println("b. Truck");
        System.out.print("Enter your choice: ");
        String vehicleType = sc.nextLine();

        if (vehicleType.equalsIgnoreCase("a")) {
            System.out.print("ModelNumber: ");
            String modelNumber = sc.nextLine();
            System.out.print("Rate: ");
            double rateBought = sc.nextDouble();
            sc.nextLine(); 
            System.out.print("FuelType(petrol/diesel): ");
            String fuelType = sc.nextLine();
            System.out.print("Passengers: ");
            int numberOfPassengers = sc.nextInt();
            vehicles.add(new Car(modelNumber, rateBought, fuelType, numberOfPassengers));
        } else if (vehicleType.equalsIgnoreCase("b")) {
            System.out.print("ModelNumber: ");
            String modelNumber = sc.nextLine();
            System.out.print("Rate: ");
            double rateBought = sc.nextDouble();
            sc.nextLine(); 
            System.out.print("FuelType(petrol/diesel): ");
            String fuelType = sc.nextLine();
            System.out.print("LoadLimit: ");
            int loadLimit = sc.nextInt();
            vehicles.add(new Truck(modelNumber, rateBought, fuelType, loadLimit));
        } else {
            System.out.println("Invalid vehicle type.");
        }
    }

    private static void displayVehicles() {
        Collections.sort(vehicles, (v1, v2) -> Double.compare(v2.calculateTax(), v1.calculateTax()));

        for (Vehicle vehicle : vehicles) {
            vehicle.displayInfo();
        }
    }
}

interface TaxCalculatable {
    double calculateTax();
}

abstract class Vehicle implements TaxCalculatable {
    protected String modelNumber;
    protected double rateBought;
    protected String fuelType;
    protected int numberOfWheels;

    public Vehicle(String modelNumber, double rateBought, String fuelType, int numberOfWheels) {
        this.modelNumber = modelNumber;
        this.rateBought = rateBought;
        this.fuelType = fuelType;
        this.numberOfWheels = numberOfWheels;
    }

    public abstract void displayInfo();
}

class Car extends Vehicle {
    private int numberOfPassengers;

    public Car(String modelNumber, double rateBought, String fuelType, int numberOfPassengers) {
        super(modelNumber, rateBought, fuelType, 4); 
        this.numberOfPassengers = numberOfPassengers;
    }

    @Override
    public double calculateTax() {
        double taxRate = fuelType.equalsIgnoreCase("petrol") ? 0.5 : 0.4;
        return (rateBought * 0.1 * numberOfPassengers) * taxRate;
    }

    @Override
    public void displayInfo() {
        System.out.println(modelNumber + " " + fuelType + " " + (int) calculateTax());
    }
}

class Truck extends Vehicle {
    private int loadLimit;

    public Truck(String modelNumber, double rateBought, String fuelType, int loadLimit) {
        super(modelNumber, rateBought, fuelType, 6);
        this.loadLimit = loadLimit;
    }

    @Override
    public double calculateTax() {
        double taxRate = fuelType.equalsIgnoreCase("petrol") ? 0.5 : 0.4;
        return (rateBought * 0.1 * loadLimit * 0.002) * taxRate;
    }

    @Override
    public void displayInfo() {
        System.out.println(modelNumber + " " + fuelType + " " + (int) calculateTax());
    }
}