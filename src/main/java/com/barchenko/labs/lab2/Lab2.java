package com.barchenko.labs.lab2;

import java.util.Random;
import java.util.Scanner;

public class Lab2 {

    public void run()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter value: ");
        String str = in.nextLine();
        int number = 0;
        try {
            number = Integer.parseInt(str);
        } catch (NumberFormatException | NullPointerException nfe) {
            System.out.println("Wrong data format");
        }
        int n = number, m = number, temp = 0;
        System.out.println("n =" + n + " ;m =" + m);
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = getRandom(-100, 100);
            }
        }
        System.out.println("--------Created Matrix (Random)--------");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
        // bubble sort
        for (int i = 0; i < n * m - 1; i++) {
            for (int j = i; j < m * n; j++) {
                if (a[i / m][i % m] > a[j / m][j % m]) {
                    temp = a[i / m][ i % m];
                    a[i / m][i % m] = a[j / m][j % m];
                    a[j / m][j % m] = temp;
                }
            }
        }
        System.out.println("--------New Matrix--------");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private int getRandom(int min, int max) {
        Random ran = new Random();
        int n = max - min + 1;
        int i = ran.nextInt() % n;
        if (i < 0)
            i = -i;
        return min + i;
    }
}