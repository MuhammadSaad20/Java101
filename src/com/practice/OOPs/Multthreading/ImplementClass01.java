package com.practice.OOPs.Multthreading;

public class ImplementClass01 implements  Runnable {
    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        while (true){
            System.out.println("My Thread Running!");
        }
    }

    public static void main(String[] args) {
        ImplementClass01 obj = new ImplementClass01();
        //Create object pass Thread Object class which also implemented Runnable Interface
        //Use when we want our class to implement other interfaces or extends class

        Thread thread_obj= new Thread(obj);
        thread_obj.start();
        while (true){
            System.out.println("Main Thread!");
        }
    }
}
