package com.practice.OOPs.Polymorphism;

public class Circle extends Shape{

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    // Overriding draw method
    @Override
    public void draw() {
        System.out.println("Drawing a circle with radius: " + radius);
    }

}
