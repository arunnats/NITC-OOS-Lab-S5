public class Q9 {
  public static void main(String[] args) {
    SavingsAccount mySavings = new SavingsAccount("537635987", 0.15);
    
    mySavings.deposit(100000);
    mySavings.addInterest();
    
    System.out.println("Current balance in " + mySavings.getAccNum() + ": Rupees" + mySavings.getBalance());
  }
}

class Account {
  private String accountNumber;
  protected double balance;

  public Account(String accountNumber) {
      this.accountNumber = accountNumber;
      this.balance = 0;
  }

  public void deposit(double amount) {
      if (amount > 0) {
          balance += amount;
      }
  }

  public double getBalance() {
      return balance;
  }

  public String getAccNum() {
    return accountNumber;
}
}

class SavingsAccount extends Account {
  protected double interestRate;

  public SavingsAccount(String accountNumber, double interestRate) {
      super(accountNumber);
      this.interestRate = interestRate;
  }

  public void addInterest() {
      double interest = balance * interestRate;
      deposit(interest);
  }
}