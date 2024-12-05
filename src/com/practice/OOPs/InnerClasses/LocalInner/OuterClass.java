package com.practice.OOPs.InnerClasses.LocalInner;

/*
A local inner class is defined inside a method or a block and is scoped to that method/block.
It can only be used within the method where it is defined.

Key Characteristics:
- Cannot have static members.
- Can access final or effectively final local variables of the method.
- Cannot be accessed outside the method where it’s defined.

When to Use:
Use a local inner class when you need a helper class whose usage is confined to a specific method.
Example: A class for temporary sorting logic inside a method.

 */
public class OuterClass {

    void methodWithInnerClass() {
        int localVariable = 10; // Effectively final

        // Local Inner Class
        class LocalInnerClass {
            void display() {
                System.out.println("Local variable: " + localVariable);
            }
        }

        LocalInnerClass localInner = new LocalInnerClass();
        localInner.display();
    }
}
