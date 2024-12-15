package org.example.OOP.Abstractions;

 class Developer extends Employee{
    private double baseSalary;
    private double bonus;
    private double autoAllowance;

    Developer(String name, int id, double baseSalary, double bonus){
        super(name, id);
        this.baseSalary = baseSalary;
        this.bonus = bonus;
        this.autoAllowance = 500.00;
    }

    @Override
    double calculateSalary(){
        return baseSalary + bonus + autoAllowance;
    }

    @Override
    String getRole(){
        return "Developer";
    }
}
