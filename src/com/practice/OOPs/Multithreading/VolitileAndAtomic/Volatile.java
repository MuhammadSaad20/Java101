package com.practice.OOPs.Multithreading.VolitileAndAtomic;

public class Volatile {

    static class SharedObject{

        // Usually it creates a copy of Thread in cache for each thread, for perf
        // Volatile its flag, which tell do not create copy
        private   volatile boolean flag= false;

        public void setFlagTrue(){
            flag= true;
            System.out.println("Flag is set to TRUE");
        }

        public String getFlagStatus(){
           while(!flag){
               //do nothing
           }
            return  "Flag status is  "+flag +" ";
        }

    }


    public static void main(String[] args) {

        SharedObject obj= new SharedObject();

        Thread writerThread = new Thread(()->{
            try{
                Thread.sleep(1000);
            }catch (RuntimeException | InterruptedException ex){
                System.out.println(ex);
            }
            obj.setFlagTrue();
        });

        Thread readerThread= new Thread(()->{
            System.out.println(obj.getFlagStatus());
        });

        writerThread.start();
        readerThread.start();

    }
}
