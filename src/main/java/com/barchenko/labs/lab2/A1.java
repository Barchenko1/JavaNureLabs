package com.barchenko.labs.lab2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A1 {
    private final List<Integer> numberList = new ArrayList<>();

    public void task1() {
        while (true) {
            try {
                enterNumber();
            } catch (RuntimeException e) {
                break;
            }
        }
        System.out.println(numberList);
        List<Integer> sortedList = customBubbleSort(numberList);
        System.out.println(sortedList);
        System.out.println("less value is - " + sortedList.get(0) + " Length - " + getNumberLength(sortedList.get(0)));
        System.out.println("larges value is - " + sortedList.get(sortedList.size() - 1) + " Length - " + getNumberLength(sortedList.get(sortedList.size() - 1) ));

    }

    private void enterNumber() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number value: ");
        String str = in.nextLine();
        int number = 0;
        try {
            number = Integer.parseInt(str);
        } catch (NumberFormatException | NullPointerException nfe) {
            throw new RuntimeException();
        }
        numberList.add(number);
    }

    private List<Integer> customBubbleSort(List<Integer> array) {
        for (int i = 0; i < array.size()-1; i++) {
            for (int j = 0; j < array.size() - i - 1; j++) {
                if (array.get(j) > array.get(j + 1)) {
                    // swap arr[j+1] and arr[j]
                    int temp = array.get(j);
                    array.set(j, array.get(j + 1));
                    array.set(j + 1, temp);
                }
            }
        }
        return array;
    }

    private int getNumberLength(long number) {
        int count = (number == 0) ? 1 : 0;
        while (number != 0) {
            count++;
            number /= 10;
        }
        return count;
    }
}
