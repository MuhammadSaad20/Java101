package com.practice.OOPs.Multthreading.Sync.RentalLocks.Basics;
import java.util.concurrent.locks.ReentrantLock;

public class RentalLocksBasics {

    private final ReentrantLock lock = new ReentrantLock();
    public  void outerMethod(){
        lock.lock();
        try
        {
            System.out.println("Outer method");
            innerMethod();
        }
        finally { lock.unlock(); } //unlocking lock count # 1

    }
    public void innerMethod(){
        lock.lock(); //Its already lock so what happen? actual renter lock maintains count of so it console lock count # 2
        //That why its name is ReentrantLock
        try{ System.out.println("Inner method"); }
        finally { lock.unlock();} //unlocking lock count # 2

    }

    public static void main(String[] args) {
        RentalLocksBasics obj= new RentalLocksBasics();
        obj.outerMethod();
    }
}
