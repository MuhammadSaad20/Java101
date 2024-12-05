package com.practice.OOPs.Static;

import java.util.SortedMap;

public class Test {
    public static void main(String[] args) {

        //First return static block
        Student.getCount(); //return count 0 because no instance created its first return 0

        Student std1= new Student();
        Student std2= new Student();
        Student std3= new Student();
        Student std4= new Student();
        Student std5= new Student();

        Student.getCount(); //return count 5 because 5 objects created return 5
        System.out.println(Student.PI);
        System.out.println(Student.SSN);
    }
}
