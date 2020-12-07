package com.barchenko.labs.lab7;

import java.util.Scanner;

public class Lab7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите номер буквы:");
        int n = in.nextInt();
        System.out.println("Введите символ для замены:");
        String k = in.next();
        String[] s = " В каждом слове текста k-ю букву заменить заданным символом. Если k больше длины слова, корректировку не выполнять".trim().split("\\s+");

        for (int i = 0; i < s.length; i++) {
            if (s[i].length() > n) {
                char charSmwl = s[i].charAt(n);
                s[i]=s[i].replace(charSmwl, k.charAt(0));

            }
        }
        for (String value : s) {
            System.out.print(value + " ");
        }

    }
}
