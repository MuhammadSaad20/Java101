package com.practice.OOPs.Static;

public class Student {

    private int Id;
    private String name;

    //first run when class called

    public static final double PI;
    public static final int SSN=54312;

    static {
        System.out.println("Hello From Static Block!");
        PI=3.142;
    }

    //it shared among all instances
    private static  int count=0;

    public Student(){
        //If we do not initialize in static block, we can also initialize here
        //PI=3.142;
        count++;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //This method not able to use non-static method
    public static void getCount(){
        System.out.println("Count is : "+count);
    }
}
