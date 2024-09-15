import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine(); 

        Flipkart flipkart = new Flipkart();
        ArrayList<String[]> transactions = new ArrayList<>(); 

        for (int i = 0; i < n; i++) {
            String[] transactionDetails = sc.nextLine().split( " ");
            transactions.add(transactionDetails);
        }

        for (String[] transactionDetails : transactions) {
            String bankName = transactionDetails[0];
            double customerBalance = Double.parseDouble(transactionDetails[1]);
            double productPrice = Double.parseDouble(transactionDetails[2]);

            if (bankName.equalsIgnoreCase("HDFC")) {
                flipkart.transactionHDFC(customerBalance, productPrice);
            } else if (bankName.equalsIgnoreCase("ICICI")) {
                flipkart.transactionICICI(customerBalance, productPrice);
            } else {
                System.err.println("Bank not valid");
            }
        }

        sc.close();
    }
}

interface HDFC {
    void transactionHDFC(double customerBalance, double productPrice);
}

interface ICICI {
    void transactionICICI(double customerBalance, double productPrice);
}

class Flipkart implements HDFC, ICICI {
    private double flipkartAccountBalance;

    public Flipkart() {
        this.flipkartAccountBalance = 0;
    }

    @Override
    public void transactionHDFC(double customerBalance, double productPrice) {
        if (customerBalance >= productPrice) {
            flipkartAccountBalance += productPrice;
            customerBalance -= productPrice;
            System.out.println((int) flipkartAccountBalance + " " + (int) customerBalance);
        } else {
            System.out.println("Insufficient balance in HDFC account");
        }
    }

    @Override
    public void transactionICICI(double customerBalance, double productPrice) {
        if (customerBalance >= productPrice) {
            flipkartAccountBalance += productPrice;
            customerBalance -= productPrice;
            System.out.println((int) flipkartAccountBalance + " " + (int) customerBalance);
        } else {
            System.out.println("Insufficient balance in ICICI account");
        }
    }
}
