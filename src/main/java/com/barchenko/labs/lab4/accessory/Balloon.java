package com.barchenko.labs.lab4.accessory;

public class Balloon extends Accessory {

    private String color;

    @Override
    public int calculateCost() {
        price = 100;
        return price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
