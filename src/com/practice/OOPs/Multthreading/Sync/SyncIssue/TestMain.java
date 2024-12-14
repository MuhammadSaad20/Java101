package com.practice.OOPs.Multthreading.Sync.SyncIssue;

public class TestMain {
    public static void main(String[] args) {
        BankAccount meezan = new BankAccount();
        //Anonymous implementation of runnable interface
        Runnable task = new Runnable() {
            @Override
            public void run() {
                meezan.withdraw(100);
            }
        };

        Thread task1= new Thread(task,"Thread 1");
        Thread task2= new Thread(task, "Thread 2");
        task1.start();
        task2.start();
    }
}
