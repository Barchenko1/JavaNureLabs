package com.barchenko.labs.lab4;

import com.barchenko.labs.lab4.accessory.Accessory;
import com.barchenko.labs.lab4.accessory.Balloon;
import com.barchenko.labs.lab4.accessory.Toy;
import com.barchenko.labs.lab4.accessory.ToySize;
import com.barchenko.labs.lab4.entity.ColorType;
import com.barchenko.labs.lab4.entity.Flower;
import com.barchenko.labs.lab4.entity.FlowerType;
import com.barchenko.labs.lab4.offer.BasketBouquet;
import com.barchenko.labs.lab4.offer.BoxBouquet;
import com.barchenko.labs.lab4.offer.WrapperBouquet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

import static com.barchenko.labs.lab4.entity.FreshnessLevel.*;

public class ConsoleLab4 {

    private static WrapperBouquet wrapperBouquet;
    private static BoxBouquet boxBouquet;
    private static BasketBouquet basketBouquet;
    private static Toy toy;
    private static Balloon balloon;

    public static void main(String[] args) throws IOException {
//        Flower flower = new Flower();
//        flower.setFlowerType(FlowerType.ROSE);
//        flower.setColor(ColorType.PINK);
//        flower.setPrice(50);
//        flower.setLength(10);
//
//        Sweet accessory = new Sweet();
//        accessory.setPrice(10);
//        accessory.setType("Chocolate");
//
//        BoxBouquet bouquet = new BoxBouquet();
//        bouquet.addFlower(flower);
//        bouquet.addAccessory(accessory);
//        bouquet.setBoxPrice(300);
//        System.out.println(bouquet);
//        System.out.println(bouquet.countPrice());


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
        menu();
    }

    private static void searchFlowerByLength() {

    }

    private static void sortFlowers() {

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
                selectFreshLevel(flowerWrapper);
                selectFlowerType(flowerWrapper);
                selectFlowerColor(flowerWrapper);
                selectFlowerLength(flowerWrapper);
                selectFlowersCount(flowerWrapper);

                break;
            case 2:
                boxBouquet = new BoxBouquet();
                Flower boxFlowers = new Flower();
                selectFlowerPrice(boxFlowers);
                selectFreshLevel(boxFlowers);
                selectFlowerType(boxFlowers);
                selectFlowerColor(boxFlowers);
                selectFlowerLength(boxFlowers);

                break;
            case 3:
                basketBouquet = new BasketBouquet();
                Flower basketFlower = new Flower();
                selectFlowerPrice(basketFlower);
                selectFreshLevel(basketFlower);
                selectFlowerType(basketFlower);
                selectFlowerColor(basketFlower);
                selectFlowerLength(basketFlower);

                break;
            default:
        }
    }

    private static void selectFlowersCount(Flower flower) throws IOException {
        System.out.println("Количество цветов: ");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int menuNumber = Integer.parseInt(in.readLine());
        for (int i = 0; i < menuNumber; i++) {
            wrapperBouquet.addFlower(flower);
        }
    }

    private static void selectFlowerPrice(Flower flower) throws IOException {
        System.out.println("Цена цветов:\n1.90.\n2.75.\n3.60\n4.40");
        int menuNumber;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do {
            menuNumber = Integer.parseInt(in.readLine());
        } while (menuNumber < 1 || menuNumber > 3);
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
            case 34:
                flower.setPrice(40);
                break;
            default:
        }
    }

    private static void selectFreshLevel(Flower flower) throws IOException {
        System.out.println("Степень вежести цветов:\n1.новые.\n2.нормальные.\n3.старые");
        int menuNumber;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do {
            menuNumber = Integer.parseInt(in.readLine());
        } while (menuNumber < 1 || menuNumber > 3);
        switch (menuNumber) {
            case 1:
                flower.setFreshnessLevel(NEW);
                break;
            case 2:
                flower.setFreshnessLevel(NORMAL);
                break;
            case 3:
                flower.setFreshnessLevel(OLD);
                break;
            default:
        }
    }

    private static void selectFlowerLength(Flower flower) throws IOException {
        System.out.println("Длина цветов:\n1.40.\n2.60.\n3.100");
        int menuNumber;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do {
            menuNumber = Integer.parseInt(in.readLine());
        } while (menuNumber < 1 || menuNumber > 3);
        switch (menuNumber) {
            case 1:
                flower.setLength(40);
                break;
            case 2:
                flower.setLength(60);
                break;
            case 3:
                flower.setLength(100);
                break;
            default:
        }
    }

    private static void selectFlowerColor(Flower flower) throws IOException {
        System.out.println("Цвет цветов:\n1.Красные.\n2.Белые.\n3.Розовые " +
                "\n4.Георгина.\n5.Хризантема");
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
                break;
            case 2:
                toy = new Toy();
                selectToySize();
                break;
            default:
        }
    }

    private static void selectToySize() throws IOException {
        System.out.println("Размер игрушки:\n1.S.\n2.M.\n3.L.\n4.XL." +
                "\n4.Георгина.\n5.Хризантема");
        int menuNumber;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do {
            menuNumber = Integer.parseInt(in.readLine());
        } while (menuNumber < 1 || menuNumber > 3);
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
        System.out.println("Цвет шариков:\n1.Стиний.\n2.Зеленыйа.\n3.Желтый " +
                "\n4.Георгина.\n5.Хризантема");
        int menuNumber;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do {
            menuNumber = Integer.parseInt(in.readLine());
        } while (menuNumber < 1 || menuNumber > 3);
        switch (menuNumber) {
            case 1:
                balloon.setColor("красные");
                break;
            case 2:
                balloon.setColor("зеленые");
                break;
            case 3:
                balloon.setColor("желтые");
                break;
            default:
        }
    }
}
