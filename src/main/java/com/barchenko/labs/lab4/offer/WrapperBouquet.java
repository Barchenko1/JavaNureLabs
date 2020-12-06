package com.barchenko.labs.lab4.offer;

public class WrapperBouquet extends Bouquet {
    private int wrapperPrice = 200;

    @Override
    public int countPrice() {
        return wrapperPrice + super.countPrice();
    }

    public int getWrapperPrice() {
        return wrapperPrice;
    }

    public void setWrapperPrice(int wrapperPrice) {
        this.wrapperPrice = wrapperPrice;
    }
}
