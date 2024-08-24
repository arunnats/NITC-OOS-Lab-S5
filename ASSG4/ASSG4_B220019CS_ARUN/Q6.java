public class Q6 {
    public static void main(String[] args) {
        Tesla myTesla = new Tesla("Electric", "Model S", 90, "1.2");
        myTesla.start();
    }
}

class Vehicle {
    private String type;

    public Vehicle(String type) {
        this.type = type;
    }

    public void start() {
        System.out.println("Vehicle is starting...");
    }
}

class Car extends Vehicle {
    private String model;

    public Car(String type, String model) {
        super(type);
        this.model = model;
    }

    @Override
    public void start() {
        super.start();  
        System.out.println("Car model " + model + " is starting...");
    }
}

class ElectricCar extends Car {
    private int batteryLevel;

    public ElectricCar(String type, String model, int batteryLevel) {
        super(type, model);  
        this.batteryLevel = batteryLevel;
    }

    @Override
    public void start() {
        super.start(); 
        System.out.println("ElectricCar with battery level " + batteryLevel + "% is starting...");
    }
}

class Tesla extends ElectricCar {
    private String autopilotVersion;

    public Tesla(String type, String model, int batteryLevel, String autopilotVersion) {
        super(type, model, batteryLevel); 
        this.autopilotVersion = autopilotVersion;
    }

    @Override
    public void start() {
        super.start(); 
        System.out.println("Tesla with Autopilot version " + autopilotVersion + " is starting...");
    }
}

