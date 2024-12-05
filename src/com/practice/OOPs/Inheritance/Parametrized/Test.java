package com.practice.OOPs.Inheritance.Parametrized;



public class Test {
    public static void main(String[] args) {

        Person person= new Person("Saad", 25);
        person.displayInfo();

        Student student = new Student("student",25,1234);
        student.displayStudentInfo();

        Teacher teacher = new Teacher("teacher", 30, "OOP");
        teacher.displayTeacherInfo();

    }
}
