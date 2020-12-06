package com.barchenko.labs.lab4.accessory;

public class Balloon extends Accessory {

    private String color;
    private int price = 100;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
