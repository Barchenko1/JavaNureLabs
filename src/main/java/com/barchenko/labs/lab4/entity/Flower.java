package com.barchenko.labs.lab4.entity;

public class Flower {
    private ColorType color;
    private int price;
    private int length;
    private FlowerType flowerType;
    private FreshnessLevel freshnessLevel;

    public ColorType getColor() {
        return color;
    }

    public void setColor(ColorType color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public FlowerType getFlowerType() {
        return flowerType;
    }

    public void setFlowerType(FlowerType flowerType) {
        this.flowerType = flowerType;
    }

    public FreshnessLevel getFreshnessLevel() {
        return freshnessLevel;
    }

    public void setFreshnessLevel(FreshnessLevel freshnessLevel) {
        this.freshnessLevel = freshnessLevel;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "color=" + color +
                ", price=" + price +
                ", length=" + length +
                ", flowerType=" + flowerType +
                ", freshnessLevel=" + freshnessLevel +
                '}';
    }
}
