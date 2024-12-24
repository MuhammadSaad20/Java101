package com.practice.OOPs.Multthreading.LambdaExpressions;

public class LambdaExp {
    public static void main(String[] args) {
        //Anonymous class
        Runnable task1= new Runnable() {
            @Override
            public void run() {
                System.out.println("Run Task 1");
            }
        };

        //Lambda Expression

        Runnable task2= ()->{
            System.out.println("Run Task 2");
        };

        Thread t1= new Thread(task1);
        Thread t2= new Thread(task2);

        //Anonymous function
        Thread t3= new Thread(()-> System.out.println("Run Task 3") );

        t1.start();
        t2.start();
        t3.start();

    }
}
