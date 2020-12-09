package com.barchenko.labs.lab3c;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;


public class Polinom implements  Serializable, Cloneable {

    TreeMap<Integer, Fraction> poly;

    public Polinom(TreeMap<Integer, Fraction> poly) {
        this.poly = poly;
        simplify();
    }

    public TreeMap<Integer, Fraction> getPoly() {
        return poly;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Map.Entry<Integer, Fraction> item : poly.entrySet()) {
            if (item.getValue().getNumerator() >= 0) {
                res.append("+");
            }
            res.append(item.getValue().toString());
            res.append("x^");
            res.append(item.getKey());
        }
        if (!poly.isEmpty()) {
            if (res.charAt(0) == '+') {
                res.deleteCharAt(0);
            }
            if(poly.containsKey(0)) {
                res.delete(res.length() - 3, res.length());
            }
        }
        return res.toString();
    }

    private void simplify(){
        TreeMap<Integer, Fraction> temp = new TreeMap<>((Integer i1,Integer i2)->i2-i1);
        for(Map.Entry<Integer, Fraction> item : this.poly.entrySet()){
            if (item.getValue().getNumerator() != 0) {
                temp.put(item.getKey(), item.getValue());
            }
        }
        this.poly = temp;
    }
}