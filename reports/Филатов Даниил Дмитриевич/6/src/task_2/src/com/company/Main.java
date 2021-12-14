package com.company;

public class Main {
    public static void main(String[] args) {
        SamsungTV samsungTV = new SamsungTV(50, 500, true);
        samsungTV.printCharacteristic();
        SamsungRemote samsungRemote = new SamsungRemote(samsungTV);
        samsungRemote.turnOn();
        samsungRemote.increaseVolume();
        LGTV lgtv = new LGTV(48, 320, false);
        lgtv.printCharacteristic();
        LGRemote lgRemote = new LGRemote(lgtv);
        lgRemote.turnOn();
        lgRemote.switchChannel(7);
        lgRemote.turnOff();
    }
}

interface Remote {
    void turnOn();
    void turnOff();
    void switchChannel(int chanelId);
    void increaseVolume();
    void increaseDecrease();
}

interface TV {
    void printCharacteristic();
    void turnOn();
    void turnOff();
}

class LGRemote implements Remote {
    private LGTV tv;
    public LGRemote(LGTV tv) {
        this.tv = tv;
    }
    @Override
    public void turnOn() {
        System.out.println("TV LG is going to turn on by remote.");
    }
    @Override
    public void turnOff() {
        System.out.println("TV LG is going to turn off by remote.");
    }
    @Override
    public void switchChannel(int chanelId) {
        System.out.println("TV LG is going to switch channel on '" + chanelId + "' by remote.");
    }
    @Override
    public void increaseVolume() {
        System.out.println("TV LG is going to increase volume by remote.");
    }
    @Override
    public void increaseDecrease() {
        System.out.println("TV LG is going to decrease volume by remote.");
    }
}

class LGTV implements TV {
    private double diagonalSize;
    private int brightness;
    private boolean isWiFiExist;
    public LGTV(double diagonalSize, int brightness, boolean isWiFiExist) {
        this.diagonalSize = diagonalSize;
        this.brightness = brightness;
        this.isWiFiExist = isWiFiExist;
    }
    @Override
    public void printCharacteristic() {
        System.out.println("TV LG:\n\tdiagonal size: " + diagonalSize
                + "\n\tbrightness: " + brightness
                + "\n\tisWiFiExist: " + isWiFiExist);
    }
    @Override
    public void turnOn() {
        System.out.println("TV LG is going to turn on.");
    }
    @Override
    public void turnOff() {
        System.out.println("TV LG is going to turn off.");
    }
}

class SamsungRemote implements Remote {
    private SamsungTV samsungTV;
    public SamsungRemote(SamsungTV samsungTV) {
        this.samsungTV = samsungTV;
    }
    @Override
    public void turnOn() {
        System.out.println("TV Samsung is going to turn on by remote.");
    }
    @Override
    public void turnOff() {
        System.out.println("TV Samsung is going to turn off by remote.");
    }
    @Override
    public void switchChannel(int chanelId) {
        System.out.println("TV Samsung is going to switch channel on '" + chanelId + "' by remote.");
    }
    @Override
    public void increaseVolume() {
        System.out.println("TV Samsung is going to increase volume by remote.");
    }
    @Override
    public void increaseDecrease() {
        System.out.println("TV Samsung is going to decrease volume by remote.");
    }
}

class SamsungTV implements TV {
    private double diagonalSize;
    private int brightness;
    private boolean isWiFiExist;
    public SamsungTV(double diagonalSize, int brightness, boolean isWiFiExist) {
        this.diagonalSize = diagonalSize;
        this.brightness = brightness;
        this.isWiFiExist = isWiFiExist;
    }
    @Override
    public void printCharacteristic() {
        System.out.println("TV Samsung:\n\tdiagonal size: " + diagonalSize
                + "\n\tbrightness: " + brightness
                + "\n\tisWiFiExist: " + isWiFiExist);
    }
    @Override
    public void turnOn() {
        System.out.println("TV Samsung is going to turn on.");
    }
    @Override
    public void turnOff() {
        System.out.println("TV Samsung is going to turn off.");
    }
}