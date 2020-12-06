package com.barchenko.labs.lab4.accessory;

public class Toy extends Accessory{
    private ToySize toySize;
    private int price = 200;

    @Override
    public int calculateCost() {
        int cost = 0;
        if (toySize.equals(ToySize.S)) {
            cost = price * 2;
        }
        if (toySize.equals(ToySize.M)) {
            cost = price * 3;
        }
        if (toySize.equals(ToySize.L)) {
            cost = price * 4;
        }
        if (toySize.equals(ToySize.XL)) {
            cost = price * 5;
        }
        return cost;
    }

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
