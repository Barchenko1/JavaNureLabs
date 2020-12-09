package com.barchenko.labs.lab3c;

public class Fraction {

    private int numerator;
    private int denominator;

    public Fraction() {
        this.denominator = 1;
    }

    public Fraction(int numerator) {
        this();
        this.numerator = numerator;
    }

    public Fraction(int numerator, int denominator) {
        setFraction(numerator, denominator);
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
        reduce();
    }

    public final void setDenominator(int denominator)  {
        if (denominator != 0) {
            this.denominator = denominator;
            reduce();
        }
    }

    public final void setFraction(int numerator, int denominator) {
        this.numerator = numerator;
        setDenominator(denominator);
        reduce();
    }

    public final void reduce() {
        int nod = nod(Math.abs(numerator), Math.abs(denominator));
        numerator = numerator / nod;
        denominator = denominator / nod;
        if ((numerator < 0) && (denominator < 0)) {
            numerator = Math.abs(numerator);
            denominator = Math.abs(denominator);
        } else if (denominator < 0) {
            numerator = -1 * numerator;
            denominator = Math.abs(denominator);
        }
    }

    @Override
    public String toString() {
        String res;
        if (denominator != 1) {
            res = numerator + "/" + denominator;
        } else {
            res = String.valueOf(numerator);
        }
        return res;
    }

    private int nod(int a, int b) {
        int t;
        while (b > 0) {
            t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

}
