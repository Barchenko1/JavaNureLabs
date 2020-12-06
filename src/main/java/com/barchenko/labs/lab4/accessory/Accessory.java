package com.barchenko.labs.lab4.accessory;

public abstract class Accessory {
    protected int price;

    public int calculateCost() {
        return price;
    }

    @Override
    public String toString() {
        return "Accessory{" +
                "price=" + price +
                '}';
    }
}
