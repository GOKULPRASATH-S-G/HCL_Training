package app;

import model.BankAccount;

public class Main {

    public static void main(String[] args) {

        BankAccount account = new BankAccount("ACC001", 1000.0);

        System.out.println("Before Withdrawal");
        account.withdraw(200.0);

        System.out.println("After Withdrawal");
    }
}