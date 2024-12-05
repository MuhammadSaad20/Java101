package com.practice.OOPs.InnerClasses.Anonymous;

public class OuterClass {

    private double paymnet;

   public OuterClass(double paymnet){
        this.paymnet=paymnet;
    }


    public  void  processPayment(Payment myPayment){
       myPayment.pay(paymnet);
    }

}
