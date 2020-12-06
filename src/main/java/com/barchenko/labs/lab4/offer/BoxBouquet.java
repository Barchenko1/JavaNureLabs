package com.barchenko.labs.lab4.offer;

public class BoxBouquet extends Bouquet{
    private int boxPrice = 300;

    @Override
    public int countPrice() {
        return boxPrice + super.countPrice();
    }

    public int getBoxPrice() {
        return boxPrice;
    }

    public void setBoxPrice(int boxPrice) {
        this.boxPrice = boxPrice;
    }

    @Override
    public String toString() {
        return "BoxBouquet{" + super.toString() +
                ", boxPrice=" + boxPrice +
                '}';
    }
}
