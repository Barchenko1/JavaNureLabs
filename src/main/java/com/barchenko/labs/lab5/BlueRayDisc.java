package com.barchenko.labs.lab5;

import java.util.Arrays;

public class BlueRayDisc {
    private String name;
    private Catalog catalog;

    public static class Catalog {
        private String catalogName;
        private int numberFolder;
        private String[] nameFolder;
        private int numberRecords;

        public Catalog(String name_cat, int numberFol, String[] nameFol, int numberRc){
            this.catalogName = name_cat;
            this.numberFolder = numberFol;
            this.numberRecords = numberRc;
            this.nameFolder = new String[numberFol];
            if (numberFol >= 0) System.arraycopy(nameFol, 0, this.nameFolder, 0, numberFol);
        }

        public String getCatalogName() {
            return catalogName;
        }

        public void setCatalogName(String catalogName) {
            this.catalogName = catalogName;
        }

        public int getNumberFolder() {
            return numberFolder;
        }

        public void setNumberFolder(int numberFolder) {
            this.numberFolder = numberFolder;
        }

        public String[] getNameFolder() {
            return nameFolder;
        }

        public void setNameFolder(String[] nameFolder) {
            this.nameFolder = nameFolder;
        }

        public int getNumberRecords() {
            return numberRecords;
        }

        public void setNumberRecords(int numberRecords) {
            this.numberRecords = numberRecords;
        }

        @Override
        public String toString() {
            return "Catalog{" +
                    "name_catalog='" + catalogName + '\'' +
                    ", numberFolder=" + numberFolder +
                    ", nameFolder=" + Arrays.toString(nameFolder) +
                    ", numberRecords=" + numberRecords +
                    '}';
        }
    }
    public BlueRayDisc(String nameDisc, String name_cat, int numberFol, String[] nameFol, int numberRc) {
        this.name = nameDisc;
        this.catalog = new Catalog(name_cat,numberFol,nameFol,numberRc);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void show(){
        System.out.println("Disk name : "+ name + " have catalog : " + catalog.toString());
    }

}
