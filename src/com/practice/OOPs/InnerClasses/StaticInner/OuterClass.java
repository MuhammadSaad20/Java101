package com.practice.OOPs.InnerClasses.StaticInner;

/*
A static nested class is associated with the outer class rather than any specific instance.
It does not have access to non-static members of the outer class.

Key Characteristics:
- Defined with the static keyword.
- Can access only static members of the outer class.
- Can be instantiated without creating an instance of the outer class.

When to Use:
- Use a static nested class when the nested class does not need access to instance members of the outer class for better
  memory management

  Example: A utility class (like a helper for database operations) inside another class.

 */
public class OuterClass {

        private static String staticOuterField = "Static Outer Field";

        // Static Nested Class
        static class StaticNestedClass {
            void display() {
                System.out.println("Accessing: " + staticOuterField);
            }
        }
}
