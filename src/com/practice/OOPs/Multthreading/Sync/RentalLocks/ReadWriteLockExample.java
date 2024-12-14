package com.practice.OOPs.Multthreading.Sync.RentalLocks;
import java.util.concurrent.locks.Lock;
import  java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {

    private final ReentrantReadWriteLock myLock = new ReentrantReadWriteLock();
    private Lock readLock= myLock.readLock();
    private Lock writeLock=myLock.writeLock();
    private  int count=0;

    public void incCount(){
        writeLock.lock();
        try{count+=1;}
        catch (RuntimeException ex){ Thread.currentThread().interrupt(); }
        finally { writeLock.unlock(); }
    }
    public int getCount(){
        readLock.lock();
        try{ return count; }
        finally { readLock.unlock(); }
    }

    public static void main(String[] args) throws InterruptedException {

        ReadWriteLockExample obj = new ReadWriteLockExample();
        Runnable writeTask = new Runnable() {
            @Override
            public void run() {
                for(int i=0 ;i<10;i++){
                    obj.incCount();
                    System.out.println(Thread.currentThread().getName());
                }
            }
        };

        Runnable readTask = new Runnable() {
            @Override
            public void run() {
                for(int i=0 ;i<10;i++){
                    System.out.println(Thread.currentThread().getName()+ " :  count is: "+obj.getCount());
                }

            }
        };

        Thread t1= new Thread(writeTask,"Thread 1 Write");
        Thread t2= new Thread(readTask,"Thread 2 Read");
        Thread t3= new Thread(readTask,"Thread 3 Read");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();


        System.out.println( "Final Count : "+obj.getCount());
    }

}
