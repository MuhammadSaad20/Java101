package com.practice.OOPs.Inheritance;

public class Person {
    private String name;
    private int age;


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName(String name) {
        return name;
    }

    public int getAge(int age){
        return age;
    }

    public void displayInfo() {
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
    }


}
