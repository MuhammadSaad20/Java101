package com.practice.OOPs.Generics;

public class GenericTypeClass<T> implements Container<T>{
    private T item;
    @Override
    public void add(T item) {
        this.item=item;
    }

    @Override
    public T get() {
        return item;
    }

    public static void main(String[] args) {
        GenericTypeClass obj= new GenericTypeClass();
        obj.add("HELLO");
        System.out.println(obj.get());

    }
}
