package com.practice.OOPs.Abstarction.AbstractClass;

public class Paypal extends  Payment{

    private String email;

    public Paypal(double amount, String email) {
        super(amount);
        this.email = email;
    }

    @Override
    public void processPayment() {
        System.out.println("Processing PayPal Payment for $" + getAmount());
        System.out.println("Using email: " + email);
    }
}
