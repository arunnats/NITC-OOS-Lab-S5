public class Q4 {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("SA123", 1200, "John Doe");
        savings.calculateInterest();
        savings.withdraw(300);
        savings.getMonthlyStatement();
    }
}

abstract class Bank {
    public abstract void calculateInterest();
    public abstract void withdraw(double amount);
    public abstract void deposit(double amount);
    public abstract void getMonthlyStatement();
}

class Account extends Bank {
    protected String accountNumber;
    protected double balance;
    protected String customerName;

    public Account(String accountNumber, double balance, String customerName) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerName = customerName;
    }

    public void calculateInterest() {

    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Insufficient funds for withdrawal.");
        }
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. New balance: " + balance);
    }

    public void getMonthlyStatement() {
        System.out.println("Monthly statement for account: " + accountNumber);
        System.out.println("Customer: " + customerName);
        System.out.println("Balance: " + balance);
    }
}

class SavingsAccount extends Account {
    private double interestRate = 0.05;  
    private double minimumBalance = 1000;
    private double penalty = 50;

    public SavingsAccount(String accountNumber, double balance, String customerName) {
        super(accountNumber, balance, customerName);
    }

    public void calculateInterest() {
        if (balance >= minimumBalance) {
            balance += balance * interestRate;
            System.out.println("Interest applied. New balance: " + balance);
        } else {
            System.out.println("Balance below minimum. No interest applied.");
        }
    }

    public void withdraw(double amount) {
        super.withdraw(amount);
        if (balance < minimumBalance) {
            balance -= penalty;
            System.out.println("Penalty applied for falling below minimum balance. New balance: " + balance);
        }
    }
}

class CheckingAccount extends Account {
    private double overdraftLimit = 500;
    private double transactionFee = 5;
    private double overdraftInterestRate = 0.02; 

    public CheckingAccount(String accountNumber, double balance, String customerName) {
        super(accountNumber, balance, customerName);
    }

    public void withdraw(double amount) {
        double totalWithdrawal = amount + transactionFee;
        if (balance + overdraftLimit >= totalWithdrawal) {
            balance -= totalWithdrawal;
            System.out.println("Withdrawal successful with transaction fee. New balance: " + balance);
            if (balance < 0) {
                balance -= balance * overdraftInterestRate;  // Apply interest on overdraft
                System.out.println("Overdraft interest applied. New balance: " + balance);
            }
        } else {
            System.out.println("Withdrawal exceeds overdraft limit.");
        }
    }

    public void getMonthlyStatement() {
        super.getMonthlyStatement();
        System.out.println("Overdraft limit: " + overdraftLimit);
    }
}

class InternationalAccount extends Account {
    private double conversionFee = 2.5;  // Conversion fee in percentage

    public InternationalAccount(String accountNumber, double balance, String customerName) {
        super(accountNumber, balance, customerName);
    }

    public void deposit(double amount, String currency) {
        double conversionRate = getConversionRate(currency);
        double convertedAmount = amount * conversionRate;
        double finalAmount = convertedAmount - (convertedAmount * (conversionFee / 100));
        balance += finalAmount;
        System.out.println("Deposit successful in " + currency + ". New balance: " + balance);
    }

    private double getConversionRate(String currency) {
        switch (currency) {
            case "USD":
                return 0.84;  
            case "GBP":
                return 1.15;  
            default:
                return 1.0;   
        }
    }

    public void getMonthlyStatement() {
        super.getMonthlyStatement();
        System.out.println("International account with currency conversion.");
    }
}


