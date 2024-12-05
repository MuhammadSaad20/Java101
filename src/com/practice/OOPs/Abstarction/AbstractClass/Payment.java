package com.practice.OOPs.Abstarction.AbstractClass;

/*

Payment is abstract and defines common behavior (printReceipt).
Subclasses (CreditCard, Paypal) implement the processPayment method differently.

What is an Abstract Class?
An abstract class is a class that:

Cannot be instantiated (you can’t create objects of it directly).

Can have both OR only one:
    Abstract methods (methods without a body, meant to be implemented by subclasses).
    Concrete methods (methods with implementation).
    It serves as a blueprint for other classes.


Why Use an Abstract Class?
    When you need to share common functionality among related classes.
    When you want to enforce certain methods to be implemented in all subclasses.


 */

abstract class Payment {

    private double amount; // Encapsulation

    public Payment(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    // Abstract method: must be implemented by subclasses
    public abstract void processPayment();

    // Concrete method: shared by all subclasses
    public void printReceipt() {
        System.out.println("Receipt: Payment of $" + amount);
    }
}
