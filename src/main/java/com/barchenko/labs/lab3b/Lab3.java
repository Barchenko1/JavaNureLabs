package com.barchenko.labs.lab3b;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab3 {
    private boolean flag = true;

    public void taskB1() {
        Fraction[] array = new Fraction[10];
        int i = 0;
        while (flag) {
            Fraction fraction = new Fraction();
            enterM(fraction);
            enterN(fraction);
            array[i] = fraction;
            i++;
            isEnd();
        }
        List<Fraction> fractionList = copyArrayToList(array);
        System.out.println("your fractional array");
        showArray(fractionList);
        calculate(fractionList);
        System.out.println("your calculated fractional array");
        showArray(fractionList);
    }

    private void calculate(List<Fraction> fractions) {
        for (int i = 0; i < fractions.size(); i++) {
            if (i % 2 == 0 && i != fractions.size() - 1) {
                fractions.set(i, fractionSum(fractions.get(i), fractions.get(i + 1)));
            }
        }

    }

    private List<Fraction> copyArrayToList(Fraction[] fractions) {
        List<Fraction> fractionList = new ArrayList<>();
        for (Fraction fraction : fractions) {
            if (fraction != null) {
                fractionList.add(fraction);
            }
        }
        return fractionList;
    }

    private Fraction fractionSum(Fraction f1, Fraction f2) {
        Fraction fraction = new Fraction();
        int lcm = lcm(f1.getN(), f2.getN());
        fraction.setM(f1.getM() * (lcm / f1.getN()) + f2.getM() * (lcm / f2.getN()));
        fraction.setN(lcm);
        return fraction;
    };

    private int lcm(int a,int b){
        return a / gcd(a,b) * b;
    }

    private int gcd(int a, int b){
        return b == 0 ? a : gcd(b,a % b);
    }

    private void enterM(Fraction fraction){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter m value: ");
        String str = in.nextLine();
        int number = 0;
        try {
            number = Integer.parseInt(str);
        } catch (NumberFormatException | NullPointerException nfe) {
            System.out.println("Wrong data format");
        }
        fraction.setM(number);
    }

    private void enterN(Fraction fraction){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter n value: ");
        String str = in.nextLine();
        int number = 0;
        try {
            number = Integer.parseInt(str);
        } catch (NumberFormatException | NullPointerException nfe) {
            System.out.println("Wrong data format");
        }
        fraction.setN(number);
    }

    private void showArray(List<Fraction> fractions) {
        for (Fraction fraction : fractions) {
            System.out.println(fraction);
        }
    }

    private void isEnd() {
        Scanner in = new Scanner(System.in);
        System.out.print("to stop press q : ");
        String str = in.nextLine();
        if (str.equals("q")) {
            flag = false;
        }
    }

}
