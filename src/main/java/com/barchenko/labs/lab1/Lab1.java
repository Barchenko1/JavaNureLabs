package com.barchenko.labs.lab1;

import java.util.Scanner;

public class Lab1 {
    public void run() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter value: ");
        String str = in.nextLine();
        double d = 0;
        try {
            d = Double.parseDouble(str);
        } catch (NumberFormatException | NullPointerException nfe) {
            System.out.println("Wrong data format");
        }
        numberChecker(d);
    }

    private void numberChecker(double d) {
        if (d < 1) {
            return;
        }
        if (d % 2 == 0) {
            System.out.println("even");
        } else {
            System.out.println("odd");
        }
    }
}
