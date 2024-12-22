package com.practice.OOPs.Multthreading.ExcuterFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestWithoutFramework {

    public static void factorialWithoutThread() throws InterruptedException {
        long startTime= System.currentTimeMillis();// 1 Jan 1970

        for(int i=1;i<=10;i++){
            Thread.sleep(1000);
            System.out.println("Factorial of "+i +" is: " +calculateFact(i));
        }
        System.out.println("Total Time: "+ (System.currentTimeMillis()-startTime) +" ms ");
    }


    public static void factorialWithThread() throws InterruptedException {
        long startTime= System.currentTimeMillis();// 1 Jan 1970
        Thread [] threads = new Thread[9];
        for(int i=1;i<=10;i++){
           // Thread.sleep(1000);
            int finalI=i;
             threads[i-1] = new Thread( ()->{
                System.out.println("Factorial of "+finalI +" is: " +calculateFact(finalI));
            });
             threads[i-1].start();
        }

        for( Thread thread: threads){
            try{
                thread.join();
            }catch (InterruptedException ex){
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Total Time: "+ (System.currentTimeMillis()-startTime) +" ms ");

    }


    public static void factorialWithExciterFramework() throws InterruptedException {
        long startTime= System.currentTimeMillis();// 1 Jan 1970
        ExecutorService executorService = Executors.newFixedThreadPool(9);
        for(int i=1;i<=10;i++){
            // Thread.sleep(1000);
            int finalI=i;
            executorService.submit(()->{
                System.out.println("Factorial of "+finalI +" is: " +calculateFact(finalI));

            });
        }
        executorService.shutdown();
        try{
         executorService.awaitTermination(1000, TimeUnit.MILLISECONDS);
        }catch (InterruptedException ex){
            System.out.println(ex);
        }
        System.out.println("Total Time: "+ (System.currentTimeMillis()-startTime) +" ms ");

    }

    private static long calculateFact(long n){
       long result =1;
        for(int i=1;i<=n;i++){ //3 1= 1*1 -> 1 = 1 * 2 -> 2= 2 *3
            result *= i;
        }
        return result;
    }


    public static void main(String[] args) {
        try
        {
            /* Without Thread code needs taking time */
            // factorialWithoutThread();
            /* With Thread Code manual creates Thread and manage stuff */
            // factorialWithThread();
            /* Using Executor Framework to manage thread creation and stopping of threads */
            factorialWithExciterFramework();

        }
        catch (InterruptedException ex){System.out.println(ex);}
    }
}
