package com.practice.OOPs.Abstarction.Interface.MultipleInheritance;

public class Smartphones  implements  Calling, Media, UI{
    @Override
    public void statCall(String number) {
        System.out.println("Calling : "+number);
    }

    @Override
    public boolean endCall() {
        return true;
    }

    @Override
    public String clickImage(String pixel) {
        return pixel;
    }

    @Override
    public void recordVideo() {
        System.out.println("Recording ...");
    }

    @Override
    public void bootBatmanTheme() {
        System.out.println("Loading Batman Theme.....");
    }

    @Override
    public boolean resetTheme() {
        return false;
    }
}
