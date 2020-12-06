package com.barchenko.labs.lab4.offer;

public class BasketBouquet extends Bouquet{

    private final int price = 500;

    public int getPrice() {
        return price;
    }

    @Override
    public int countPrice() {
        return price + super.countPrice();
    }
}
