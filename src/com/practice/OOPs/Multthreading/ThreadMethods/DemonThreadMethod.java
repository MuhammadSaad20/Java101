package com.practice.OOPs.Multthreading.ThreadMethods;

public class DemonThreadMethod extends  Thread{

    @Override
    public void run() {
        while (true) {
            System.out.println("Hello! ");
        }
    }

    public static void main(String[] args) {
        DemonThreadMethod myThread = new DemonThreadMethod();
        myThread.setDaemon(true); // myThread is daemon thread ( like Garbage collector ) now
        DemonThreadMethod t1 = new DemonThreadMethod();
        t1.start(); // t1 is user thread
        myThread.start();
        System.out.println("Main Done");
    }
}
