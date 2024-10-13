package ASSG7;

public class Q1 {
    public static void main(String[] args) {
        SmartPhone myPhone = new SmartPhone("IPhone 14 Pro");

        myPhone.powerOn(); 
        myPhone.connectToNetwork("Arun_980384"); 
        System.out.println(myPhone); 

        myPhone.disconnectFromNetwork(); 
        myPhone.powerOff(); 
        System.out.println(myPhone); 
    }
}

interface PoweredDevice {
    void powerOn();
    void powerOff();
}

interface NetworkEnabled {
    void connectToNetwork(String networkName);
    void disconnectFromNetwork();
}

class SmartPhone implements PoweredDevice, NetworkEnabled {
    private String model;
    private boolean isPoweredOn;
    private String connectedNetwork;

    public SmartPhone(String model) {
        this.model = model;
        this.isPoweredOn = false; 
        this.connectedNetwork = null; 
    }

    @Override
    public void powerOn() {
        if (!isPoweredOn) {
            isPoweredOn = true;
            System.out.println(model + " is powered on.");
        } else {
            System.out.println(model + " is already powered on.");
        }
    }

    @Override
    public void powerOff() {
        if (isPoweredOn) {
            isPoweredOn = false;
            System.out.println(model + " is powered off.");
            connectedNetwork = null; 
        } else {
            System.out.println(model + " is already powered off.");
        }
    }

    @Override
    public void connectToNetwork(String networkName) {
        if (isPoweredOn) {
            if (connectedNetwork == null) {
                connectedNetwork = networkName;
                System.out.println(model + " connected to network: " + networkName);
            } else {
                System.out.println(model + " is already connected to network: " + connectedNetwork);
            }
        } else {
            System.out.println("Cannot connect to a network. " + model + " is powered off.");
        }
    }

    @Override
    public void disconnectFromNetwork() {
        if (isPoweredOn && connectedNetwork != null) {
            System.out.println(model + " disconnected from network: " + connectedNetwork);
            connectedNetwork = null;
        } else if (!isPoweredOn) {
            System.out.println("Cannot disconnect from network. " + model + " is powered off.");
        } else {
            System.out.println(model + " is not connected to any network.");
        }
    }

    @Override
    public String toString() {
        String powerState = isPoweredOn ? "On" : "Off";
        String networkState = connectedNetwork != null ? connectedNetwork : "No Network Connected";
        return "SmartPhone Model: " + model + " | Power State: " + powerState + " | Connected Network: " + networkState;
    }
}