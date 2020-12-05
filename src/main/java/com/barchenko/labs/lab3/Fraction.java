package com.barchenko.labs.lab3;

public class Fraction {
    private int m;
    private int n;

    private Fraction sum(Fraction f1, Fraction f2) {
        Fraction fraction = new Fraction();
        fraction.setM(f1.getM() + f2.getM());
        fraction.setN(f1.getN() + f2.getN());
        return fraction;
    };

    public Fraction() {
    }

    public Fraction(int m, int n) {
        this.m = m;
        this.n = n;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return "Fraction{" +
                "view = " + m+"/"+n + "}";
    }
}
