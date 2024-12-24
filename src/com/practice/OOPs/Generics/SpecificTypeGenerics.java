package com.practice.OOPs.Generics;

public class SpecificTypeGenerics implements Container<String>{

    @Override
    public void add(String item) {

    }

    @Override
    public String get() {
        return "Hello";
    }


    public static void main(String[] args) {
        SpecificTypeGenerics obj= new SpecificTypeGenerics();
        System.out.println(obj.get());
    }
}
