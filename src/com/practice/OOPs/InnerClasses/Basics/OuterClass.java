package com.practice.OOPs.InnerClasses.Basics;
/*

A non-static inner class is associated with an instance of the enclosing (outer) class.
It cannot have static members and can only be instantiated after the outer class is instantiated.

Key Characteristics:
- Requires an instance of the enclosing class.
- Can access all members (including private) of the outer class.
- Used when the inner class logically depends on the outer class instance.


When to Use:
Use a non-static inner class when the inner class logically depends on an instance of the outer class.
Example: Modeling a Car (outer class) with its Engine (inner class).

 */
public class OuterClass {
    private String outerField = "Outer Class Field";

    // Non-static Inner Class
    class InnerClass {
        void display() {
            System.out.println("Accessing: " + outerField);
        }
    }


}
