package com.barchenko.labs.lab2;

import java.util.Scanner;

public class B1 {
    private int n;
    private int m;

    public void task1() {
        System.out.print("enter n : ");
        n = enterNumber();
        System.out.print("enter m : ");
        m = enterNumber();
        System.out.print("enter k : ");
        int k = enterNumber();
        checkScope1(k);
        checkScope2(k);
        checkScope3(k);
        checkScope4(k);

    }

    private void checkScope1(int number) {
        boolean isContains = false;
        for (int i = n + 1; i <= m; i++) {
            if (i == number) {
                isContains = true;
                break;
            }
        }
        System.out.println("Scope (n, m] - " + isContains);
    }

    private void checkScope2(int number) {
        boolean isContains = false;
        for (int i = n; i < m; i++) {
            if (i == number) {
                isContains = true;
                break;
            }
        }
        System.out.println("Scope [n, m) - " + isContains);
    }

    private void checkScope3(int number) {
        boolean isContains = false;
        for (int i = n + 1; i < m; i++) {
            if (i == number) {
                isContains = true;
                break;
            }
        }
        System.out.println("Scope (n, m) - " + isContains);
    }

    private void checkScope4(int number) {
        boolean isContains = false;
        for (int i = n; i <= m; i++) {
            if (i == number) {
                isContains = true;
                break;
            }
        }
        System.out.println("Scope [n, m] - " + isContains);
    }

    private int enterNumber() {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int number = 0;
        try {
            number = Integer.parseInt(str);
        } catch (NumberFormatException | NullPointerException nfe) {
            throw new RuntimeException();
        }
        return number;
    }
}
