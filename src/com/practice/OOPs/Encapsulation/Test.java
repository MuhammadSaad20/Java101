package com.practice.OOPs.Encapsulation;

public class Test {

    public static void main(String[] args) {
        BankAccount obj= new BankAccount();
        obj.deposit(200);
        System.out.println(obj.getBalance());
        obj.withdraw(100);
        System.out.println(obj.getBalance());

    }
}