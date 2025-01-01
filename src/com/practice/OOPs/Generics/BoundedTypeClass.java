package com.practice.OOPs.Generics;

class Box<T extends Number>{

    private T value;

    Box(T value){
        this.value= value;
    }
    T getValue(){
        return  value;
    }
}

public class BoundedTypeClass {
    public static void main(String[] args) {
        Box<Integer> obj1= new Box<>(5);
        System.out.println(obj1.getValue());
        Box<Float> obj2= new Box<>(3.142f);
        System.out.println(obj2.getValue());

        //Type parameter not bound exception

        /*
        *
        Box<String> obj3= new Box<String>("Hi");
        System.out.println(obj3.getValue());
         */


    }
}
