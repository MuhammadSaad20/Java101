package com.practice.OOPs.Abstarction.Interface;

public class WiFiDevice implements  Connectable{
    private String ssid;

    public WiFiDevice(String ssid) {
        this.ssid = ssid;
    }

    @Override
    public void connect() {
        System.out.println("Connecting to Wi-Fi network: " + ssid);
    }

    @Override
    public void status() {
        System.out.println("Wi-Fi connection established to: " + ssid);
    }
}
