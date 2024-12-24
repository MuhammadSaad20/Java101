package com.practice.OOPs.Multthreading.Sync.Deadlocks;

class Pen{
    public  synchronized void writeWithPenAndPaper(Paper  paper){
        System.out.println(Thread.currentThread().getName() + " is using "+  this + "& trying to used " + paper);
        paper.finishWriting();
    }

    public synchronized void finishWriting(){
        System.out.println(Thread.currentThread().getName()+" finish using pen "+this);
    }
}

class Paper{
    public  synchronized void writeWithPaperAndPen (Pen  pen){
        System.out.println(Thread.currentThread().getName() + " is using "+  this + "& trying to used " + pen);
        pen.finishWriting();
    }

    public synchronized void finishWriting(){
        System.out.println(Thread.currentThread().getName()+" finish using pen "+this);
    }
}


class Task1 implements Runnable{
    private Pen pen;
    private Paper paper;

    public Task1(Pen pen, Paper paper){
        this.pen=pen;
        this.paper=paper;
    }
    /**
     * Runs this operation.
     */

    @Override
    public void run() {
        pen.writeWithPenAndPaper(paper); // It calls PenAndPaper function that calls <-> pen.finishWriting() which waiting for pen deadlock
    }
}


class Task2 implements Runnable{
    private Pen pen;
    private Paper paper;

    public Task2(Pen pen, Paper paper) {
        this.pen = pen;
        this.paper = paper;
    }
    /**
     * Runs this operation.
     */
    @Override
    /*
    public void run() {
        paper.writeWithPaperAndPen(pen);
    }*/

    public void run(){
        synchronized (pen){
            paper.writeWithPaperAndPen(pen); //By default, synchronize function called from which its called
        }
    }
}

public class DeadlockExample {

    public static void main(String[] args) {
        Paper paper= new Paper();
        Pen pen= new Pen();
        Thread t1 = new Thread(new Task1(pen,paper),"Thread 1");
        Thread t2 = new Thread(new Task2(pen,paper),"Thread 2");
        t1.start();
        t2.start();
    }

}
