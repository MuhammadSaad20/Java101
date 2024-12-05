package com.practice.OOPs.Inheritance.Parametrized;

public class Student extends Person {

    private int studentId;

    public Student( String name, int age, int studentId){
        super(name,age);
        this.studentId=studentId;
    }
    public void displayStudentInfo() {
        displayInfo();
        System.out.println("Student ID: " + studentId);
    }
}
