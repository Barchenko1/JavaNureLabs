package com.barchenko.labs.lab6;

public class PartTimeStudent extends Student {

    private int salary = 5000;
    private int studyPay = 2500;

    @Override
    public void enterToUniversity() {
        System.out.println("Give " + super.showDocuments() + " to the commission give pay for studying - " + this.studyPay);
    }

    @Override
    public void liveForTime() {
        System.out.println("I can pay to live in one room apartments");
    }

    public void doWorkToPayForStudying() {
        System.out.println("I'm working somewhere to pay for studying my salary is - " + this.salary);
    }


}
