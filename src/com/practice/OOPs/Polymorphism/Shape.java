package com.practice.OOPs.Polymorphism;

public class Shape {

    // Overloaded area methods()
    public double area(double side) { // Square
        return side * side;
    }

    public double area(double length, double width) { // Rectangle
        return length * width;
    }

    public double area(double radius, boolean isCircle) { // Circle
        return Math.PI * radius * radius;
    }

    // Method to be overridden
    public void draw() {
        System.out.println("Drawing a generic shape.");
    }
}
