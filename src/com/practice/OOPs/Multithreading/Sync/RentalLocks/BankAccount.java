package com.practice.OOPs.Multthreading.Sync.RentalLocks;
import java.util.concurrent.TimeUnit;
import  java.util.concurrent.locks.ReentrantLock;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class BankAccount {

    private int balance= 1000;
    private  ReentrantLock lock= new ReentrantLock();
    //Issue is waiting one thread is wait for other

    public void withdraw(int amount)  {
        System.out.println(Thread.currentThread().getName()+" attempting to withdraw amount: "+amount);
        try {

            if(lock.tryLock(1000, MILLISECONDS)){
                if(balance>=amount)
                {
                    try
                    {
                        balance -= amount;
                        Thread.sleep(1000); //doing some business logic working in db
                        System.out.println(Thread.currentThread().getName() + " amount withdraw successfully");
                    }
                    catch (InterruptedException e) { Thread.currentThread().interrupt(); /* it helps tp log for monitoring code if this thread interrupted */ }
                    finally { lock.unlock(); }
                }
                else
                {
                    System.out.println(Thread.currentThread().getName()+" insufficient balance");
                }
            }
            else
            {
                System.out.println(Thread.currentThread().getName()+" Unable to get Lock");
            }
        }
        catch (InterruptedException e){ Thread.currentThread().interrupt(); /* it helps tp log for monitoring code if this thread interrupted */ }
    }
}
