package com.practice.OOPs.Multthreading;

public class ExtendClass01 extends Thread {

    /**
     * This method is run by the thread when it executes. Subclasses of {@code
     * Thread} may override this method.
     *
     * <p> This method is not intended to be invoked directly. If this thread is a
     * platform thread created with a {@link Runnable} task then invoking this method
     * will invoke the task's {@code run} method. If this thread is a virtual thread
     * then invoking this method directly does nothing.
     *
     * @implSpec The default implementation executes the {@link Runnable} task that
     * the {@code Thread} was created with. If the thread was created without a task
     * then this method does nothing.
     */
    @Override
    public void run() {
        while (true) {
            System.out.println("My Thread Running!");
        }

    }

    public static void main(String[] args) {
        ExtendClass01 obj = new ExtendClass01();
        obj.start(); // start is entry point of thread it invokes run methode
        while (true){
            System.out.println("Main Thread!");
        }
    }
}
