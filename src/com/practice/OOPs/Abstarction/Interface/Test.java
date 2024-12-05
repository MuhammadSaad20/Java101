package com.practice.OOPs.Abstarction.Interface;

public class Test {
    public static void main(String[] args) {
        Connectable wifi = new WiFiDevice("MyNetwork");
        Connectable bluetooth = new BluetoothDevice("Headphones");

        System.out.println(Connectable.version);
        Connectable.Info(); //static void method


        wifi.connect();
        wifi.status();

        bluetooth.connect();
        bluetooth.status(); // Uses default implementation bcz bluebonnet class don't have any status method
    }
}
