package com.barchenko.labs.lab3b;

public class Fraction {
    private int m;
    private int n;

    public Fraction() {
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
