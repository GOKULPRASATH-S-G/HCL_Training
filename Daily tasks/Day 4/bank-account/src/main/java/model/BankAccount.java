package model;

public class BankAccount {

    private String accountNumber;
    private double balance;

    private static int accountCount = 0;

    public BankAccount() {
        this("UNKNOWN");
    }

    public BankAccount(String accountNumber) {
        this(accountNumber, 0.0);
    }

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        accountCount++;
    }

    public void deposit(double amount) {

        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than 0.");
            return;
        }

        balance += amount;

        System.out.println("Deposited: " + amount);
        System.out.println("Current Balance: " + balance);
    }

    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than 0.");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient balance.");
            return;
        }

        // Intentional bug for debugger practice
        balance -= amount;

        System.out.println("Withdrawn: " + amount);
        System.out.println("Current Balance: " + balance);
    }

    public static int getAccountCount() {
        return accountCount;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof BankAccount)) {
            return false;
        }

        BankAccount other = (BankAccount) obj;

        return accountNumber.equals(other.accountNumber);
    }

    @Override
    public int hashCode() {
        return accountNumber.hashCode();
    }
}