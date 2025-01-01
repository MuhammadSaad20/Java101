package com.practice.OOPs.Generics;

interface PrintMessage{
    void  printMsg();
}

class MyNumber<T> extends Number implements PrintMessage{

    private final T value;

    MyNumber(T value){
        this.value=value;
    }

    @Override
    public void printMsg() {
        System.out.println("hello");

    }

    @Override
    public int intValue() {
        return 0;
    }

     @Override
    public long longValue() {
        return 0;
    }


    @Override
    public float floatValue() {
        return 0;
    }


    @Override
    public double doubleValue() {
        return 0;
    }
}

//Multiple bounds tests class always extend the class Number & implement Interface
// print interface
class Test <M , T extends Number & PrintMessage>{

    private M test;
    Test(M test){
        this.test=test;
    }
    public M getValue(){
        return test;
    }
}

public class MultipleBoundExample {
    public static void main(String[] args) {

        MyNumber<Integer> obj= new MyNumber(5);
        Test<Integer,MyNumber> testObj = new Test<>(50);
        System.out.println(testObj.getValue());
        obj.printMsg();


    }
}
