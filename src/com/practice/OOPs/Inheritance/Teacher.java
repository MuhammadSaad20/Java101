package com.practice.OOPs.Inheritance;

public class Teacher extends Person {

    private String subject;

    public void setSubject(String subject){
        this.subject=subject;
    }

    public void displayTeacherInfo() {
        displayInfo();
        System.out.println("Subject: " + subject);
    }
}
