package com.practice.OOPs.Multthreading.ThreadMethods;

public class YeildThreadMethod extends  Thread{

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " is running...");
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        YeildThreadMethod t1 = new YeildThreadMethod();
        YeildThreadMethod t2 = new YeildThreadMethod();
        t1.start();
        t2.start();
    }
    
    
}
