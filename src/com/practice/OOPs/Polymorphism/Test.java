package com.practice.OOPs.Polymorphism;

public class Test {

    public static void main(String[] args) {
        // Demonstrating method overloading
        Shape shape = new Shape();
        System.out.println("Area of square: " + shape.area(5)); // Overloaded method 1
        System.out.println("Area of rectangle: " + shape.area(4, 6)); // Overloaded method 2
        System.out.println("Area of circle: " + shape.area(7, true)); // Overloaded method 3

        // Demonstrating method overriding
        Shape circle = new Circle(7);
        circle.draw(); // Calls overridden draw() in Circle

        Shape rectangle = new Rectangle(4, 6);
        rectangle.draw(); // Calls overridden draw() in Rectangle

        /*

Difference Between Using Parent Type and Specific Type

Aspect	                Parent Type (Shape)	                        Specific Type (Circle, Rectangle)
Polymorphism	        Enables runtime polymorphism	            No polymorphism, uses the specific type
Behavior at Runtime	    Method executed depends on the object type	Method executed depends only on the object type
Flexibility	            High:Can handle any subclass object	        Low: Can handle only specific type objects
Access to Methods	    Limited to parent class methods	            Full access to child class methods
----------------------------------------------------------------------------------------------------------------
Key Difference: Parent Type (Shape) vs. Specific Type
Aspect	                  Parent Type (Shape)	                           Specific Type (Circle, Rectangle)

Flexibility	              Treat all shapes uniformly	                   Requires explicit handling for each type
Access to Methods         Only parent class methods are accessible	       Both parent and child-specific methods are accessible
Collections Handling	  Easy to store mixed types (Shape[])	           Must declare separate arrays or lists for each type
Scalability	              Adding new shapes doesn’t affect existing code   New shape types require explicit updates


         */

        //specific type it's not specific to circle object
        Circle circle1= new Circle(10);
        circle1.draw();

        // shape collection
        Shape [] shapes = new Shape[]{ new Circle(2), new Rectangle(3,4)};
        for (Shape obj: shapes){
            obj.draw();
        }

    }
}
