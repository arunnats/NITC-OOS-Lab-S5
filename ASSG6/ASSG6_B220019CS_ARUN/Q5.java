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

abstract class BasePayment {
    abstract public void processPayment();

    abstract public String getPaymentMethod();

    abstract public double calculateTransactionFee();
}

class CardPayment extends BasePayment {
    public void processPayment() {
        System.out.println("Processing card payment...");
    }

        public String getPaymentMethod() {
            return "Credit Card";
        }

        public double calculateTransactionFee(double PaymentAmount) {
        return PaymentAmount + (PaymentAmount * 2)/100;
    }
}

class SecureCardPayment extends BasePayment {
    public void processPayment() {
        System.out.println("Adding extra security layers to card payment..");
    }

    public String getPaymentMethod() {
        return "Secure Credit Card";
    }

    public double calculateTransactionFee(double PaymentAmount) {
        return PaymentAmount + 1 + (PaymentAmount * 2)/100;
    }
}