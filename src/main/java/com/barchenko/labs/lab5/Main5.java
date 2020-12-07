package com.barchenko.labs.lab5;

import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter disk name: ");
        String nameDisc = scan.next();
        System.out.println("Enter catalog name: ");
        String catalogName = scan.next();
        System.out.println("Enter catalog count: ");
        int numberFol = scan.nextInt();
        System.out.println("Enter folders name: ");
        String[] nameFol = new String[numberFol];
        for(int i=0 ,j=0; i < numberFol; i++, j++){
            System.out.println("Enter folder " + (j+1) + " name : " );
            nameFol[i] = scan.next();
        }
        System.out.println("Enter counts of data: ");
        int numberRc = scan.nextInt();
        BlueRayDisc disc = new BlueRayDisc(nameDisc, catalogName, numberFol, nameFol, numberRc);

        disc.show();

        scan.close();
    }
}
