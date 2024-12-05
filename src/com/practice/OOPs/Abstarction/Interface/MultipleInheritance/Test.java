package com.practice.OOPs.Abstarction.Interface.MultipleInheritance;

public class Test {
    public static void main(String[] args) {
        Smartphones sp= new Smartphones();
        sp.statCall("12345678900");
        System.out.println(sp.endCall());
        sp.recordVideo();
        sp.clickImage("1250x350");
        sp.bootBatmanTheme();
        System.out.println(sp.resetTheme());
    }
}
