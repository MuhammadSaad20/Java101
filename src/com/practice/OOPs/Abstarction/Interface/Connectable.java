package com.practice.OOPs.Abstarction.Interface;

public interface Connectable {

    // Abstract method: must be implemented by classes
    void connect();

    //All fields are public final by default
    //It accessible either form implemented class obj or interface itself (recommended)

    public final String version="1.0";

    //All methods are public in Java by default
    //It accessible from interface
    public static void Info(){
        System.out.println("Connectable Interface Running ");
    }

    // Default method: provides a default implementation
    // We can use we have to implement something without breaking implementation classes
    // It is accessible using implemented class
    //It runs implemented instances so which instance is called its this method also work in there context
    default void status() {
        System.out.println("Class Name who is using this : "+this.getClass());
        System.out.println("Connection status: Unknown");
    }
}

/*

Both WiFiDevice and BluetoothDevice implement Connectable.
The connect method is implemented differently for each class.
The status method is overridden in WiFiDevice but uses the default implementation in BluetoothDevice.
 */
/*
What is an Interface?
An interface is a completely abstract type in Java that:

Defines a contract that classes must follow.
        Contains:
                Abstract methods (implicitly public abstract).
                Default methods (introduced in Java 8, with a body).
                Static methods.
All fields in an interface are public static final by default (constants).
*/