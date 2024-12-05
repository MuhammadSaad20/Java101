package com.practice.OOPs.Inheritance;

public class Student extends Person {

    private int studentId;

    public void setStudentId(int studentId){
        this.studentId=studentId;
    }

    public void displayStudentInfo() {
        displayInfo();
        System.out.println("Student ID: " + studentId);
    }
}
