package org.example.OOP.Inheritances;

public class Child extends Parent{
    private String school;

    public Child(String firstName, String lastName, String job, int age, String school) {
        super(firstName, lastName, job, age);
        this.school = school;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void printDetails(){
        super.printDetails();
        System.out.println("School: " + school);
    }
}
