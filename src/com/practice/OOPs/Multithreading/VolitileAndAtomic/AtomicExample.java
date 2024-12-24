package com.practice.OOPs.Multithreading.VolitileAndAtomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {

      static class AtomicClass{

         // private volatile int cnt=0;
         // both shared it creates an exclusive lock

         private final AtomicInteger cnt= new AtomicInteger(0);
         public void inc(){
             cnt.incrementAndGet();
         }
         public int getCnt(){
             return cnt.get();
         }
    }
    public static void main(String[] args) throws InterruptedException {

         AtomicClass obj = new AtomicClass();
         Thread t1 = new Thread(()->{
            for(int i=0;i<1000;i++){
                obj.inc();
            }
         });
        Thread t2 = new Thread(()->{
            for(int i=0;i<1000;i++){
                obj.inc();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(obj.cnt);

    }
}
