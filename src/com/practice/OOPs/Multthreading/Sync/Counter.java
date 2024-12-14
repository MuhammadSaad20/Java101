package com.practice.OOPs.Multthreading.Sync;

public class Counter {

    public int counter=0; //shared resource


    //The Critical Area of our code
    //Synchronize keyword basically locks, so one thread used one at a time

    /*
    If we removed synchronized keyword so its not losing may be data loss
    public  void increment(){
        counter++;
    }
     */

    /*

    //Another way to do it either right in function signature or write inside function
    public synchronized void increment()  { counter++ ;}

     */
    public  void increment(){

        synchronized (this){
            counter++;
        }

    }


    public int getCount(){
        return counter;
    }
}
