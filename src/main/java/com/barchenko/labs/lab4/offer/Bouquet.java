package com.barchenko.labs.lab4.offer;

import com.barchenko.labs.lab4.accessory.Accessory;
import com.barchenko.labs.lab4.entity.Flower;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Bouquet {
    private List<Flower> flowers = new ArrayList<>();
    private List<Accessory> accessories = new ArrayList<>();

    public int countPrice() {
        int cost = 0;
        for (Flower flower : flowers) {
            cost += flower.getPrice();
        }
        for (Accessory accessory: accessories) {
            cost += accessory.calculateCost();
        }
        return cost;
    }

    public List<Flower> filterFlowersByRange(int n1, int n2) {
        return flowers.stream()
                .filter(f -> f.getLength() >= n1 && f.getLength() <= n2)
                .collect(Collectors.toList());
    }

    public void flowersSortByFleshLevel() {
        flowers.sort(new Comparator<Flower>() {
            @Override
            public int compare(Flower o1, Flower o2) {
                return o1.getFreshnessLevel().compareTo(o2.getFreshnessLevel());
            }
        });
    }

    public void addFlower(Flower flower) {
        flowers.add(flower);
    }

    public void addAllFlowers(List<Flower> flowerList) {
        flowers.addAll(flowerList);
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
