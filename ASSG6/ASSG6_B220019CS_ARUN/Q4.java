
import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] o1 = sc.nextLine().split(", ");
        String[] o2 = sc.nextLine().split(", ");        
    
        double t1 =  Double.parseDouble(o1[1]);
        double t2 =  Double.parseDouble(o2[1]);

        Customer c1 = new Customer(o1[0]);
        PremiumCustomer c2 = new PremiumCustomer(o2[0]);

        System.out.println("Customer: " + c1.name);
        System.out.println("Total Order Cost: $" + c1.totalCost(t1));

        System.out.println("Customer: " + c2.name);
        System.out.println("Total Order Cost: $" + c2.totalCost(t2));
    }
}

class Customer{
    public String name;

    public Customer(String name){
        this.name = name;
    }

    public double totalCost(double foodCost){
        return foodCost+5;
    }
}

class PremiumCustomer extends Customer{

    public PremiumCustomer(String name){
        super(name);
    }

    public double totalCost(double foodCost){
        return foodCost;
    }
}