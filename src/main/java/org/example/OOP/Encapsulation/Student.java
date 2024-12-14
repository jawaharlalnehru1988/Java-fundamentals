package org.example.OOP.Encapsulation;

public class Student {
    private String name;
    private int age;
    private char grade;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public  char getGrade(){
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    public static void main(String[] args) {
        Student student = new Student();

        student.setName("Hare");
        student.setAge(16);
        student.setGrade('A');

        System.out.printf("Name: %s, Age: %d, Grade: %c", student.getName(), student.getAge(), student.getGrade());
    }
}
