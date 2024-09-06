import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double totalBalance = sc.nextDouble();

        ArrayList<Double> prices = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            prices.add(sc.nextDouble());
        }

        Bank bank = new Bank();
        double outstandingBalance = bank.calculateBalance(totalBalance, prices);

        if (outstandingBalance != -1) {
            System.out.println(outstandingBalance);
        }   

        sc.close();
    }
}

interface CurrencyConverter {
    double convertRupees(double amount);
    double convertDollars(double amount);
    double convertPounds(double amount);
}

class Bank implements CurrencyConverter{
    private static final double DOLLAR_TO_RUPEE = 70.0;
    private static final double POUND_TO_RUPEE = 100.0;

    @Override
    public double convertRupees(double amount) {
        return amount;
    }

    @Override
    public double convertDollars(double amount) {
        return amount * DOLLAR_TO_RUPEE;
    }

    @Override
    public double convertPounds(double amount) {
        return amount * POUND_TO_RUPEE;
    }

    public double calculateBalance(double totalBalance, ArrayList<Double> prices) {
        double totalPurchase = convertRupees(prices.get(0) + convertDollars(prices.get(1)) + convertPounds(prices.get(2)));

        if (totalPurchase > totalBalance) {
            System.out.println("Insufficient balance");
            return -1; 
        } else {
            return totalBalance - totalPurchase;
        }
    }
}
