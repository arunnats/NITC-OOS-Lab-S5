public class Q2 {
    public static void main(String[] args){
        DomesticShipment domestic = new DomesticShipment(10, 500, "Air");
        ShippingCostCalculator calculator = new ShippingCostCalculator();
        System.out.println("Domestic Shipment Cost: " + calculator.calculateCost(domestic));

        InternationalShipment international = new InternationalShipment(15, 1000, 200);
        System.out.println("International Shipment Cost: " + calculator.calculateCost(international));

        ExpressShipment express = new ExpressShipment(5, 300, "Road", 50);
        System.out.println("Express Shipment Cost: " + calculator.calculateCost(express));
    
    }    
}

class Shipment{
    public double weight;
    public double distance;

    public Shipment(double weight, double distance){
        this.weight = weight;
        this.distance = distance;
    }
}

class DomesticShipment extends Shipment{
    public String transportMode;

    public DomesticShipment(double weight, double distance, String transportMode){
        super(weight, distance);
        this.transportMode = transportMode;
    }

    public double calculateCost(DomesticShipment domesticShipment){
        System.out.println("Total Cost: " + (this.weight*1.5 + this.distance*0.5));
        return this.weight*1.5 + this.distance*0.5;
    }
}

class ExpressShipment extends DomesticShipment{
    public double expressFee;

    public ExpressShipment(double weight, double distance, String transportMode, double expressFee){
        super(weight, distance, transportMode);
        this.expressFee = expressFee; 
    }

    public double calculateCost(ExpressShipment expressShipment){
        System.out.println("Total Cost: " + (this.weight*1.5+this.distance*0.5+this.expressFee));
        return this.weight*1.5+this.distance*0.5+this.expressFee;
    }
}

class InternationalShipment extends Shipment{
    public double customsDuties;

    public InternationalShipment(double weight, double distance, double customsDuties){
        super(weight, distance);
        this.customsDuties = customsDuties;
    }

    public double calculateCost(InternationalShipment internationalShipment){
        System.out.println("Total Cost: " + (this.weight*2 + this.distance*0.8 + this.customsDuties));
        return this.weight*2 + this.distance*0.8 + this.customsDuties;
    }
}

class ShippingCostCalculator {

    public double calculateCost(DomesticShipment shipment) {
        return shipment.calculateCost(shipment);
    }

    public double calculateCost(InternationalShipment shipment) {
        return shipment.calculateCost(shipment);
    }

    public double calculateCost(ExpressShipment shipment) {
        return shipment.calculateCost(shipment);
    }
}
