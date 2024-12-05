package com.practice.OOPs.Abstarction.Interface;

public class BluetoothDevice implements Connectable{

    private String deviceName;

    public BluetoothDevice(String deviceName) {
        this.deviceName = deviceName;
    }

    @Override
    public void connect() {
        System.out.println("Connecting to Bluetooth device: " + deviceName);
    }
}
