package com.practice.OOPs.Multthreading.Sync.RentalLocks;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
public class FarinessLock {

    //Add true will help to make sure fairness who OS picks first will run firsts
    private final ReentrantLock lock = new ReentrantLock(true);
    public void dummyFun(){
        try
        {
            if(lock.tryLock(10000, TimeUnit.MILLISECONDS))
            {
                    System.out.println("Do something...."+Thread.currentThread().getName());
            }
        }
        catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        finally { lock.unlock(); }
    }


    public static void main(String[] args) {

        FarinessLock obj = new FarinessLock();
        Runnable task = new Runnable() {
            @Override
            public void run() { obj.dummyFun(); }
        };

        Thread t1= new Thread(task,"Thread 1");
        Thread t2= new Thread(task,"Thread 2");
        Thread t3= new Thread(task,"Thread 3");

        //If you want in order so add Thread.sleep before stating the next thread by default,
        //It runs FIFO (Queue) based on which OS picks first

        t1.start();
        t2.start();
        t3.start();


    }
}
