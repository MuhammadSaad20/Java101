package com.practice.OOPs.InnerClasses.Anonymous;

public class Test {
    public static void main(String[] args) {
        OuterClass obj=new OuterClass(1500);
        //Anonymous class we do not have created a class that implement payment method
        obj.processPayment(new Payment() {
            @Override
            public void pay(double amount) {
                System.out.println("Amount is Payed: "+amount);
            }
        });

        /*
Anonymous Inner Class
An anonymous inner class is a class without a name,
    typically used to create a one-time implementation of an interface or an abstract class.
Key Characteristics:
    - Defined inline, often as an argument to a method.
    - Can extend a class or implement an interface but cannot do both simultaneously.
    - Great for simplifying code by avoiding full class definitions.

    When to Use:
Use an anonymous inner class for short-lived objects or implementations of interfaces/abstract classes.
Example: Handling events in a UI framework or creating a custom Comparator.
         */



    }
}

