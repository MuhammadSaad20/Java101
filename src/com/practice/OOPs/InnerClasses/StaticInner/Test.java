package com.practice.OOPs.InnerClasses.StaticInner;

public class Test {
    public static void main(String[] args) {
        OuterClass.StaticNestedClass nested = new OuterClass.StaticNestedClass(); // Direct instantiation
        nested.display();
    }
}
