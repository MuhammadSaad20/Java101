package com.practice.OOPs.Abstarction.AbstractClass;

public class CreditCard extends  Payment{
    private String cardNumber;

    public CreditCard(double amount, String cardNumber) {
        super(amount);
        this.cardNumber = cardNumber;
    }

    @Override
    public void processPayment() {
        System.out.println("Processing Credit Card Payment for $" + getAmount());
        System.out.println("Using card number: " + cardNumber);
    }
}
