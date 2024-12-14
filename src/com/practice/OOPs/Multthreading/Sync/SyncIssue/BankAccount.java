package com.practice.OOPs.Multthreading.Sync.SyncIssue;

public class BankAccount {

    private int balance= 1000;
    //Issue is waiting one thread is wait for other

    public synchronized void  withdraw(int amount){

        System.out.println(Thread.currentThread().getName()+" attempting to withdraw amount: "+amount);
        if(balance>=amount){
            try{
                balance-=amount;
                Thread.sleep(10000); //doing some business logic working in db
                System.out.println(Thread.currentThread().getName()+" amount withdraw successfully");


            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            System.out.println(Thread.currentThread().getName()+" insufficient balance");

        }
    }
}
