package com.practice.OOPs.Generics;

public class GenericsMethods {

    public static void main(String[] args) {

        Integer [] arr1 = {1,2,3};
        String [] arr2= {"Hello","World"};
        GenericsMethods obj= new GenericsMethods();
        obj.printArray(arr1);
        obj.printArray(arr2);
        //overloading method
        obj.display(1230);
        obj.display("String");

    }

    public <T> void display(T value){
        System.out.println("Generic Method: "+value);
    }
    public void display(String value){
        System.out.println("Specific Method: "+value);
    }

    //constructor no time in method we add return type
    public <T> void printArray(T[] array){
        for(T element: array){
            System.out.println(element);
        }
    }
}
