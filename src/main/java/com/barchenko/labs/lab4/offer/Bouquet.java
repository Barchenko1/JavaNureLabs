package com.barchenko.labs.lab4.offer;

import com.barchenko.labs.lab4.accessory.Accessory;
import com.barchenko.labs.lab4.entity.Flower;

import java.util.ArrayList;
import java.util.List;

public abstract class Bouquet {
    private List<Flower> flowers = new ArrayList<>();
    private List<Accessory> accessories = new ArrayList<>();

    public int countPrice() {
        int cost = 0;
        for (Flower flower : flowers) {
            cost += flower.getPrice();
        }
        for (Accessory accessory: accessories) {
            cost += accessory.getPrice();
        }
        return cost;
    }

    public void addFlower(Flower flower) {
        flowers.add(flower);
    }

    public void addAccessory(Accessory accessory) {
        accessories.add(accessory);
    }

    @Override
    public String toString() {
        return "Bouquet{" +
                "flowers=" + flowers +
                ", accessories=" + accessories +
                '}';
    }
}
