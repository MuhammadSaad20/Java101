package com.practice.OOPs.Encapsulation;


/*

Encapsulation: Wrapping data (variables) and methods (functions) into a single unit (class).
It ensures that the data is not directly accessible; instead, controlled access is provide

Example: Why Encapsulation? Imagine you building a bank application.
You don’t want users to directly access or modify account balance variables because
it can lead to inconsistent or invalid states.


How-To?
Private variables ensure security.
Public methods control how the balance is modified, preventing invalid transactions.

 */
public class BankAccount {

    private double balance; // hidden data

    // Public methods to access the private data
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Invalid transaction");
        }
    }

    public double getBalance() {
        return balance;
    }

}
