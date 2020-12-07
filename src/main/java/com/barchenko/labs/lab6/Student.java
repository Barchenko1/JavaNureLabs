package com.barchenko.labs.lab6;

public abstract class Student implements Enrolly {

    protected String passport = "myPassport";
    protected String inn = "myINN";


    @Override
    public void enterToUniversity() {
        System.out.println("Give " + showDocuments() + " to the commission.");
    }

    public void liveForTime() {
        System.out.println("Living and studying in student hotel");
    }

    protected String showDocuments() {
        return "this is my documents : " + this.passport + " inn : " + this.inn;
    }
}
