package com.practice.OOPs.InnerClasses.Basics;

public class Test {
    public static void main(String[] args) {
        OuterClass outer = new OuterClass(); // Outer class instance
        OuterClass.InnerClass inner = outer.new InnerClass(); // Inner class instance
        inner.display();
    }
}
