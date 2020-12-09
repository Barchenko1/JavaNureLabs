package com.barchenko.labs.lab3c;

import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        Polinom[] pArr=new Polinom[2];

        TreeMap<Integer, Fraction> poly1 = new TreeMap<>((Integer i1, Integer i2)->i2-i1);
        poly1.put(3,new Fraction(1,9));
        poly1.put(2,new Fraction(4,9));
        poly1.put(0,new Fraction(-7,9));
        // перебор элементов

        TreeMap<Integer, Fraction> poly2 = new TreeMap<Integer, Fraction>((Integer i1, Integer i2)->i2-i1);
        poly2.put(3,new Fraction(1,9));
        poly2.put(2,new Fraction(5,7));
        poly2.put(1,new Fraction(-8,9));
        pArr[0] = new Polinom(poly1);
        pArr[1] = new Polinom(poly2);

        System.out.println("polinoms");
        System.out.println(showPolinom(pArr));

        System.out.println("sum");
        System.out.println(sumArray(pArr));

    }

    public static Polinom sumArray(Polinom[] array) {
        Polinom sumResult = null;
        if (array.length > 0) {
            sumResult = new Polinom(array[0].getPoly());
            for (int i = 1; i < array.length; i++) {
                sumResult = sum(sumResult, array[i]);
            }
        }
        return sumResult;
    }

    public static String showPolinom(Polinom[] pArr) {
        StringBuilder res=new StringBuilder();
        for (Polinom polinom : pArr) {
            res.append(polinom);
            res.append("\n");
        }
        return res.toString();
    }

    public static Fraction sumFraction(Fraction f1, Fraction f2) {
        int numerator;
        int denominator;
        if (f1.getDenominator() != f2.getDenominator()) {
            numerator = f1.getNumerator() * f2.getDenominator() + f2.getNumerator() * f1.getDenominator();
            denominator = f1.getDenominator() * f2.getDenominator();
        } else {
            numerator = f1.getNumerator() + f2.getNumerator();
            denominator = f1.getDenominator();
        }
        return new Fraction(numerator, denominator);
    }

    public static Polinom sum(Polinom p1, Polinom p2) {
        TreeMap<Integer, Fraction> sum = new TreeMap<>(p1.getPoly());
        for(Map.Entry<Integer, Fraction> item : p2.getPoly().entrySet()){
            Integer key = item.getKey();
            if(sum.containsKey(key)){
                sum.put(key,sumFraction(p1.getPoly().get(key),p2.getPoly().get(key)));
            }
            else {
                sum.put(key, item.getValue());
            }
        }
        return new Polinom(sum);
    }
}
