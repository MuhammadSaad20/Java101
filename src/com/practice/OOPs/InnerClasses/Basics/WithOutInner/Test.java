package com.practice.OOPs.InnerClasses.Basics.WithOutInner;

public class Test {
    public static void main(String[] args) {

        OuterClass outerObj= new OuterClass("Saad");
        InnerClassTest innerObj= new InnerClassTest(outerObj);
        innerObj.test();

    }
}
