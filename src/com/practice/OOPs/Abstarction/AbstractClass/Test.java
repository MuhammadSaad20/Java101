package com.practice.OOPs.Abstarction.AbstractClass;

public class Test {

    public static void main(String[] args) {
        Payment payment1 = new CreditCard(100.0, "1234-5678-9012-3456");
        Payment payment2 = new Paypal(200.0, "user@example.com");
        payment1.processPayment();
        payment1.printReceipt();

        payment2.processPayment();
        payment2.printReceipt();

        // We cannot create an object of abstract class
        // Payment paymentObj= new Payment(220);
    }
}
