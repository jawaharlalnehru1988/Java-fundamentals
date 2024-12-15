package org.example.OOP.Abstractions;

 class Manager extends Employee{
    private double baseSalary;
    private double bonus;

     public Manager(String name, int id, double baseSalary, double bonus) {
         super(name, id);
         this.baseSalary = baseSalary;
         this.bonus = bonus;
     }

     @Override
     double calculateSalary() {
         return baseSalary + bonus;
     }

     @Override
     String getRole() {
         return "Manager";
     }
 }
