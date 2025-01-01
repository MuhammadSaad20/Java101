package com.practice.OOPs.Generics;

class Box1{
    public <T> Box1(T value){
        System.out.println(value);
    }
}


class Box2{

    public <T extends Number> Box2(T value){
        System.out.println(value);
    }

}

class Box3<T>{

    private T value;
    public Box3(T value){
        this.value=value;
    }

    public T getValue() {
        return value;
    }
}

public class GenericsConstructor {
    public static void main(String[] args) {

        Box1 obj1= new Box1("Hello");
        Box1 obj2= new Box1("123");

        Box2 objBox2= new Box2(100);

        Box3 objBox3= new Box3(99.99f);
        System.out.println(objBox3.getValue());

    }
}
