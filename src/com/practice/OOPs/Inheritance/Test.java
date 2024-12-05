package com.practice.OOPs.Inheritance;

public class Test {
    public static void main(String[] args) {

        Person person= new Person();

        person.setName("Saad");
        person.setAge(25);
        person.displayInfo();

        Student student = new Student();
        //If we do not, this Name and age for a student will be null amd zero respectively
        student.setName("M Saad");
        student.setAge(20);
        student.setStudentId(100);
        student.displayStudentInfo();

        Teacher teacher = new Teacher();
        //If we do not, this Name and age for a student will be null amd zero respectively
        teacher.setName("MS");
        teacher.setAge(25);
        teacher.setSubject("DSA");
        teacher.displayTeacherInfo();

    }
}
