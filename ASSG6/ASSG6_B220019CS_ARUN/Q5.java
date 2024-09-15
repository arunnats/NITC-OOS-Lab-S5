public class Q5 {
    public static void main(String[] args) {
        CardPayment cardPayment = new CardPayment();
        System.out.println("Card Payment Method: " + cardPayment.getPaymentMethod());
        cardPayment.processPayment();
        double cardFee = cardPayment.calculateTransactionFee(100.0);
        System.out.println("Card Payment Transaction Fee: $" + cardFee);

        System.out.println();

        SecureCardPayment securePayment = new SecureCardPayment();
        System.out.println("Secure Payment Method: " + securePayment.getPaymentMethod());
        securePayment.processPayment();
        double secureFee = securePayment.calculateTransactionFee(100.0);
        System.out.println("Secure Payment Transaction Fee: $" + secureFee);
    }
}

class Payment {
    public void processPayment() {
        System.out.println("Processing payment...");
    }

    public String getPaymentMethod() {
        return "Generic Payment Method";
    }

    public double calculateTransactionFee(double paymentAmount) {
        return 0.0; 
    }
}

class CardPayment extends Payment {
    @Override
    public void processPayment() {
        System.out.println("Processing card payment...");
    }

    @Override
    public String getPaymentMethod() {
        return "Credit Card";
    }

    @Override
    public double calculateTransactionFee(double paymentAmount) {
        return paymentAmount * 0.02; 
    }
}

class SecureCardPayment extends CardPayment {
    @Override
    public final void processPayment() {
        super.processPayment();
        System.out.println("Adding extra security layers to card payment...");
    }

    @Override
    public double calculateTransactionFee(double paymentAmount) {
        double originalFee = super.calculateTransactionFee(paymentAmount);
        return originalFee + 1.00;
    }

    @Override
    public String getPaymentMethod() {
        return "Secure Credit Card";
    }
}
