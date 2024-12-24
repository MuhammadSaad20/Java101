package com.practice.OOPs.Generics;

public class GenericsClass<T> {

    private T data;

    public GenericsClass(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public static void main(String[] args) {

        GenericsClass<String> obj1= new GenericsClass<>("Hello");
        System.out.println(obj1.getData());
        GenericsClass<Integer> obj2= new GenericsClass<>(120);
        System.out.println(obj2.getData());

    }
}
