package com.practice.OOPs.Multthreading.ThreadMethods;

public class LifeCycles  extends  Thread {

    @Override
    public void run() {
        System.out.println("RUNNING"); // RUNNING
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LifeCycles t1 = new LifeCycles();
        System.out.println(t1.getState()); // NEW
        t1.start();
        System.out.println(t1.getState()); // RUNNABLE | runnable and running both are same state n Java running is runnable state
        Thread.sleep(100);
        System.out.println(t1.getState()); // TIMED_WAITING
        t1.join();
        System.out.println(t1.getState()); // TERMINATED
    }
}
