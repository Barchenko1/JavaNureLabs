package com.barchenko.labs.lab4.accessory;

public class Toy {
    private ToySize toySize;
    private int price = 200;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ToySize getToySize() {
        return toySize;
    }

    public void setToySize(ToySize toySize) {
        this.toySize = toySize;
    }
}
