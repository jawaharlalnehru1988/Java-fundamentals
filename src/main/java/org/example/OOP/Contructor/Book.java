package org.example.OOP.Contructor;

public class Book {
    private String title;
    private String author;
    private double price;

    Book(){
        title = "Unknown";
        author = "Unknown";
        price = 0.0;
    }

    Book(String title, String author, double price){
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void displayBookDetails(){
//        System.out.println("Title: " + this.title + ", Author: " + this.author + ", Price: " + this.price);
        System.out.printf("Title: %s, Author: %s, Price: %.2f%n", title, author, price);
    }
}
