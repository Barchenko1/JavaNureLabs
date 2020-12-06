package com.barchenko.labs.lab4.accessory;

public abstract class Accessory {
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Accessory{" +
                "price=" + price +
                '}';
    }
}
