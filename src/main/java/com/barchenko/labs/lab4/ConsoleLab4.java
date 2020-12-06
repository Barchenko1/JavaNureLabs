package com.barchenko.labs.lab4;

import com.barchenko.labs.lab4.accessory.Balloon;
import com.barchenko.labs.lab4.accessory.Toy;
import com.barchenko.labs.lab4.accessory.ToySize;
import com.barchenko.labs.lab4.entity.ColorType;
import com.barchenko.labs.lab4.entity.Flower;
import com.barchenko.labs.lab4.entity.FlowerType;
import com.barchenko.labs.lab4.entity.FreshnessLevel;
import com.barchenko.labs.lab4.offer.BasketBouquet;
import com.barchenko.labs.lab4.offer.BoxBouquet;
import com.barchenko.labs.lab4.offer.WrapperBouquet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.barchenko.labs.lab4.entity.FreshnessLevel.*;

public class ConsoleLab4 {

    private static WrapperBouquet wrapperBouquet;
    private static BoxBouquet boxBouquet;
    private static BasketBouquet basketBouquet;
    private static Toy toy;
    private static Balloon balloon;
    private static final int[] flowerLengths = {20, 40, 60, 80, 100};
    private static final FreshnessLevel[] flowerFreshLevels = {NEW, NORMAL, OLD};

    public static void main(String[] args) throws IOException {
        menu();
    }

    private static void menu() throws IOException {
        System.out.println("Меню:\n1.Выберите тип букета.\n2.Вывести тип аксессуары.\n3.Определить стоимость букета " +
                "\n4.Сортировать букет по типу свежести.\n5.Найти цветок соответствующий заданному диапазону\n" +
                "длин стеблей");
        int menuNumber;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do {
            menuNumber = Integer.parseInt(in.readLine());
        } while (menuNumber < 1 || menuNumber > 5);
        switch (menuNumber) {
            case 1:
                flowerType();
                break;
            case 2:
                addAccessory();
                break;
            case 3:
                calculatePrice();
                break;
            case 4:
                sortFlowers();
                break;
            case 5:
                searchFlowerByLength();
                break;
            default:
        }
        logYourOffer();
        menu();
    }

    private static void logYourOffer() {
        if (Objects.nonNull(wrapperBouquet)) {
            System.out.println(wrapperBouquet);
        }
        if (Objects.nonNull(boxBouquet)) {
            System.out.println(basketBouquet);
        }
        if (Objects.nonNull(basketBouquet)) {
            System.out.println(basketBouquet);
        }

    }

    private static void searchFlowerByLength() throws IOException {
        System.out.println("Введите диапозон длины цветов в букете : ");
        BufferedReader in1 = new BufferedReader(new InputStreamReader(System.in));
        int n1 = Integer.parseInt(in1.readLine());
        BufferedReader in2 = new BufferedReader(new InputStreamReader(System.in));
        int n2 = Integer.parseInt(in2.readLine());
        System.out.println("Найденные цветы в букете :");
        if (Objects.nonNull(wrapperBouquet)) {
            System.out.println(wrapperBouquet.filterFlowersByRange(n1, n2));
        }
        if (Objects.nonNull(boxBouquet)) {
            System.out.println(boxBouquet.filterFlowersByRange(n1, n2));
        }
        if (Objects.nonNull(basketBouquet)) {
            System.out.println(basketBouquet.filterFlowersByRange(n1, n2));
        }
    }

    private static void sortFlowers() {
        if (Objects.nonNull(wrapperBouquet)) {
            wrapperBouquet.flowersSortByFleshLevel();
        }
        if (Objects.nonNull(boxBouquet)) {
            boxBouquet.flowersSortByFleshLevel();
        }
        if (Objects.nonNull(basketBouquet)) {
            basketBouquet.flowersSortByFleshLevel();
        }
    }

    private static void calculatePrice() {
        if (Objects.nonNull(wrapperBouquet)) {
            System.out.println("Wrapper bouquet price is: " + wrapperBouquet.countPrice());
        }

        if (Objects.nonNull(boxBouquet)) {
            System.out.println("Box bouquet price is: " + boxBouquet.countPrice());
        }

        if (Objects.nonNull(basketBouquet)) {
            System.out.println("Basket bouquet price is: " + basketBouquet.countPrice());
        }

    }

    private static void flowerType() throws IOException {
        System.out.println("Тип букета:\n1.В обвертке.\n2.В коробке.\n3.В корзинке");
        int menuNumber;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        do {
            menuNumber = Integer.parseInt(in.readLine());
        } while (menuNumber < 1 || menuNumber > 3);
        switch (menuNumber) {
            case 1:
                wrapperBouquet = new WrapperBouquet();
                Flower flowerWrapper = new Flower();
                selectFlowerPrice(flowerWrapper);
                selectFlowerType(flowerWrapper);
                selectFlowerColor(flowerWrapper);
                wrapperBouquet.addAllFlowers(selectFlowersCount(flowerWrapper));
                break;
            case 2:
                boxBouquet = new BoxBouquet();
                Flower boxFlowers = new Flower();
                selectFlowerPrice(boxFlowers);
                selectFlowerType(boxFlowers);
                selectFlowerColor(boxFlowers);
                boxBouquet.addAllFlowers(selectFlowersCount(boxFlowers));
                break;
            case 3:
                basketBouquet = new BasketBouquet();
                Flower basketFlower = new Flower();
                selectFlowerPrice(basketFlower);
                selectFlowerType(basketFlower);
                selectFlowerColor(basketFlower);
                basketBouquet.addAllFlowers(selectFlowersCount(basketFlower));
                break;
            default:
        }
    }

    private static List<Flower> selectFlowersCount(Flower flower) throws IOException {
        System.out.println("Количество цветов: ");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int menuNumber = Integer.parseInt(in.readLine());
        List<Flower> flowerList = new ArrayList<>();
        for (int i = 0; i < menuNumber; i++) {
            Flower randomFlower = new Flower();
            randomFlower.setColor(flower.getColor());
            randomFlower.setPrice(flower.getPrice());
            randomFlower.setLength(getRandomLength());
            randomFlower.setFlowerType(flower.getFlowerType());
            randomFlower.setFreshnessLevel(getRandomFreshLevel());
            flowerList.add(randomFlower);
        }
        return flowerList;
    }

    private static FreshnessLevel getRandomFreshLevel() {
        int a = (int) (Math.random() * 3);
        return flowerFreshLevels[a];
    }

    private static int getRandomLength() {
        int a = (int) (Math.random() * 5);
        return flowerLengths[a];
    }

    private static void selectFlowerPrice(Flower flower) throws IOException {
        System.out.println("Цена цветов:\n1.90.\n2.75.\n3.60\n4.40");
        int menuNumber;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do {
            menuNumber = Integer.parseInt(in.readLine());
        } while (menuNumber < 1 || menuNumber > 4);
        switch (menuNumber) {
            case 1:
                flower.setPrice(90);
                break;
            case 2:
                flower.setPrice(75);
                break;
            case 3:
                flower.setPrice(60);
                break;
            case 4:
                flower.setPrice(40);
                break;
            default:
        }
    }


    private static void selectFlowerColor(Flower flower) throws IOException {
        System.out.println("Цвет цветов:\n1.Красные.\n2.Белые.\n3.Розовые");
        int menuNumber;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do {
            menuNumber = Integer.parseInt(in.readLine());
        } while (menuNumber < 1 || menuNumber > 3);
        switch (menuNumber) {
            case 1:
                flower.setColor(ColorType.RED);
                break;
            case 2:
                flower.setColor(ColorType.WHITE);
                break;
            case 3:
                flower.setColor(ColorType.PINK);
                break;
            default:
        }
    }

    private static void selectFlowerType(Flower flower) throws IOException {
        System.out.println("Тип цветов:\n1.Розы.\n2.Ромашка.\n3.Орхидея " +
                "\n4.Георгина.\n5.Хризантема");
        int menuNumber;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do {
            menuNumber = Integer.parseInt(in.readLine());
        } while (menuNumber < 1 || menuNumber > 6);
        switch (menuNumber) {
            case 1:
                flower.setFlowerType(FlowerType.ROSE);
                break;
            case 2:
                flower.setFlowerType(FlowerType.CHAMOMILE);
                break;
            case 3:
                flower.setFlowerType(FlowerType.ORCHID);
                break;
            case 4:
                flower.setFlowerType(FlowerType.DAHLIA);
                break;
            case 5:
                flower.setFlowerType(FlowerType.CHRYSANTHEMUM);
                break;
            default:
        }
    }

    private static void addAccessory() throws IOException {
        System.out.println("Тип аксессуара:\n1.Шарики.\n2.Мягкая игрушка.");
        int menuNumber;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        do {
            menuNumber = Integer.parseInt(in.readLine());
        } while (menuNumber < 1 || menuNumber > 3);
        switch (menuNumber) {
            case 1:
                balloon = new Balloon();
                selectBalloonColour();
                if (Objects.nonNull(wrapperBouquet)) {
                    wrapperBouquet.addAccessory(balloon);
                }

                if (Objects.nonNull(boxBouquet)) {
                    boxBouquet.addAccessory(balloon);
                }

                if (Objects.nonNull(basketBouquet)) {
                    basketBouquet.addAccessory(balloon);
                }
                break;
            case 2:
                toy = new Toy();
                selectToySize();
                if (Objects.nonNull(wrapperBouquet)) {
                    wrapperBouquet.addAccessory(toy);
                }

                if (Objects.nonNull(boxBouquet)) {
                    boxBouquet.addAccessory(toy);
                }

                if (Objects.nonNull(basketBouquet)) {
                    basketBouquet.addAccessory(toy);
                }
                break;
            default:
        }

    }

    private static void selectToySize() throws IOException {
        System.out.println("Размер игрушки:\n1.S.\n2.M.\n3.L.\n4.XL.");
        int menuNumber;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do {
            menuNumber = Integer.parseInt(in.readLine());
        } while (menuNumber < 1 || menuNumber > 4);
        switch (menuNumber) {
            case 1:
                toy.setToySize(ToySize.S);
                break;
            case 2:
                toy.setToySize(ToySize.M);
                break;
            case 3:
                toy.setToySize(ToySize.L);
            case 4:
                toy.setToySize(ToySize.XL);
                break;
            default:
        }
    }

    private static void selectBalloonColour() throws IOException {
        System.out.println("Цвет шариков:\n1.Синий.\n2.Зеленыйа.\n3.Желтый");
        int menuNumber;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do {
            menuNumber = Integer.parseInt(in.readLine());
        } while (menuNumber < 1 || menuNumber > 3);
        switch (menuNumber) {
            case 1:
                balloon.setColor("Синий");
                break;
            case 2:
                balloon.setColor("Зеленыйа");
                break;
            case 3:
                balloon.setColor("Желтый");
                break;
            default:
        }
    }
}
