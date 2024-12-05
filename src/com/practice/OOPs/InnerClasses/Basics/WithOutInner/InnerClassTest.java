package com.practice.OOPs.InnerClasses.Basics.WithOutInner;

public class InnerClassTest {

    private OuterClass obj;

    public InnerClassTest(OuterClass obj){
        this.obj=obj;
    }

    public void test(){
        obj.info();
    }

}
