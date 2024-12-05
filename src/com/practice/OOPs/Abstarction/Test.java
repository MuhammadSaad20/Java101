package com.practice.OOPs.Abstarction;

public class Test {
    public static void main(String[] args) {
        Vehicle vehicle;

        vehicle = new Car();
        vehicle.start(); // Output: Car started
        vehicle.stop();  // Output: Vehicle stopped

        vehicle = new Bike();
        vehicle.start(); // Output: Bike started
        vehicle.stop();

        /*
        Abstract methods define behavior without specifying the details.
        Child classes provide specific implementations.
         */
    }
}
