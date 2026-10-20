package ATM;

import java.util.ArrayList;

public class Account {
    private String accountNumber;
    private int pin;
    private double balance;
    private ArrayList<String> transactionHistory;

    public Account(String accountNumber, int pin, double initialBalance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        this.transactionHistory.add("Account created with initial balance: ₹" + initialBalance);
    }

    public boolean validatePin(int enteredPin) {
        return this.pin == enteredPin;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: ₹" + amount);
            System.out.println("Successfully deposited ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: ₹" + amount);
            System.out.println("Successfully withdrew ₹" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void printTransactionHistory() {
        System.out.println("\n--- Transaction History ---");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}