import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q7 {
  public static void main(String[] args) {
    BankingSystem system = new BankingSystem();
    system.run();
  }
}

class Account {
  private static int nextAccountNumber = 1001;
  private int accountNumber;
  private String accountHolderName;
  private double balance;

  public Account(String accountHolderName, double initialDeposit) {
      this.accountNumber = nextAccountNumber++;
      this.accountHolderName = accountHolderName;
      this.balance = initialDeposit;
  }

  public int getAccountNumber() {
      return accountNumber;
  }

  public String getAccountHolderName() {
      return accountHolderName;
  }

  public double getBalance() {
      return balance;
  }

  public void deposit(double amount) {
      if (amount > 0) {
          balance += amount;
          System.out.printf("Successfully deposited %.2f%n", amount);
      } else {
          System.out.println("Invalid deposit amount.");
      }
  }

  public void withdraw(double amount) {
      if (amount > 0 && amount <= balance) {
          balance -= amount;
          System.out.printf("Successfully withdrew %.2f%n", amount);
      } else {
          System.out.println("Invalid or insufficient funds for withdrawal.");
      }
  }
}

class BankingSystem {
  private Map<Integer, Account> accounts = new HashMap<>();

  public void run() {
      Scanner sc = new Scanner(System.in);
      boolean running = true;

      while (running) {
          System.out.println("Banking System Menu:");
          System.out.println("1. Create a new account");
          System.out.println("2. Deposit money");
          System.out.println("3. Withdraw money");
          System.out.println("4. Check balance");
          System.out.println("5. Exit");
          System.out.print("Choose an option: ");

          int choice = sc.nextInt();
          sc.nextLine(); 

          switch (choice) {
              case 1:
                  createAccount();
                  break;
              case 2:
                  depositMoney();
                  break;
              case 3:
                  withdrawMoney();
                  break;
              case 4:
                  checkBalance();
                  break;
              case 5:
                  running = false;
                  System.out.println("Exiting the banking system. Goodbye!");
                  break;
              default:
                  System.out.println("Invalid option. Please choose again.");
          }
      }
      sc.close();
  }

  private void createAccount() {
      Scanner sc = new Scanner(System.in);

      System.out.print("Enter account holder's name: ");
      String name = sc.nextLine();
      System.out.print("Enter initial deposit amount: ");
      double initialDeposit = sc.nextDouble();

      Account account = new Account(name, initialDeposit);
      accounts.put(account.getAccountNumber(), account);

      System.out.println("Account created successfully!");
      System.out.println("Account Number: " + account.getAccountNumber());
      System.out.println("Account Holder: " + account.getAccountHolderName());
      System.out.println("Balance: " + account.getBalance());

      sc.close();
  }

  private void depositMoney() {
      Scanner sc = new Scanner(System.in);

      System.out.print("Enter account number: ");
      int accountNumber = sc.nextInt();
      System.out.print("Enter deposit amount: ");
      double amount = sc.nextDouble();

      Account account = accounts.get(accountNumber);
      if (account != null) {
          account.deposit(amount);
          System.out.println("Updated account details:");
          System.out.println("Account Number: " + account.getAccountNumber());
          System.out.println("Account Holder: " + account.getAccountHolderName());
          System.out.println("Balance: " + account.getBalance());
      } else {
          System.out.println("Account not found.");
      }

      sc.close();
  }

  private void withdrawMoney() {
      Scanner sc = new Scanner(System.in);

      System.out.print("Enter account number: ");
      int accountNumber = sc.nextInt();
      System.out.print("Enter withdrawal amount: ");
      double amount = sc.nextDouble();

      Account account = accounts.get(accountNumber);
      if (account != null) {
          account.withdraw(amount);
          System.out.println("Updated account details:");
          System.out.println("Account Number: " + account.getAccountNumber());
          System.out.println("Account Holder: " + account.getAccountHolderName());
          System.out.println("Balance: " + account.getBalance());
      } else {
          System.out.println("Account not found.");
      }

      sc.close();
  }

  private void checkBalance() {
      Scanner sc = new Scanner(System.in);
  
      System.out.print("Enter account number: ");
      int accountNumber = sc.nextInt();

      Account account = accounts.get(accountNumber);
      if (account != null) {
          System.out.println("Account Number: " + account.getAccountNumber());
          System.out.println("Account Holder: " + account.getAccountHolderName());
          System.out.println("Balance: " + account.getBalance());
      } else {
          System.out.println("Account not found.");
      }

      sc.close();
  }
}