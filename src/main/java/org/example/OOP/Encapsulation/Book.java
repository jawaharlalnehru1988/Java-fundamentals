package org.example.OOP.Encapsulation;

public class Book {
    private String title;
    private String author;
    private String ISBN;
    private double price;

    public Book(String title, String author, String isbn, double price){
        this.title = title;
        this.author = author;
        this.ISBN = isbn;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

@Override
    public String toString(){
        return "Book [Title =" + title + ", Auther: " + author + ", ISBN: " + ISBN + ", Price: " + price +  "]";
}

}
