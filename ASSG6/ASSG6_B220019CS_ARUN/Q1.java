import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Ecommerce E = new Ecommerce();

        System.out.println("Total price of quantity 5 and price 2");
        System.out.println(E.calculateTotalPrice(5,2 ));

        System.out.println("Total price of quantity 5 and price 2 with 10% discount");
        System.out.println(E.calculateTotalPrice(E.calculateTotalPrice(5,2 ), 10.0));

        ArrayList<Integer> p = new ArrayList<>(Arrays.asList(5, 10, 30));
        ArrayList<Integer> q = new ArrayList<>(Arrays.asList(5, 20, 500));

        System.out.println("Total price of above quantites and prices");
        System.out.println(E.calculateTotalPrice(q, p));

        System.out.println("Total price of above quantites and prices with discount 10%");
        System.out.println(E.calculateTotalPrice(E.calculateTotalPrice(q,p ), 10.0));
    }
}

class Ecommerce {
    public int calculateTotalPrice(int quantity, int price) {
        return quantity * price;
    }

    public int calculateTotalPrice(ArrayList<Integer> quantities, ArrayList<Integer> prices) {
        int total = 0;
        for (int i = 0; i < quantities.size(); i++ ) {
            total += quantities.get(i) * prices.get(i);
        }
        return total;
    }

    public double calculateTotalPrice(int totalPrice, double discount) {
        return totalPrice - (totalPrice * discount)/100;
    }
}