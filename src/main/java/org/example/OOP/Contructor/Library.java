package org.example.OOP.Contructor;

import java.util.ArrayList;
import java.util.List;

public class Library {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Bhagavad gita", "Srila Prabhupada", 250.00));
        books.add(new Book("Ramayana", "Valmiki", 350.00));
        books.add(new Book("bhagavatham", "Vyasadeva", 350.00));
        books.add(new Book("Science of self Realization", "Srila Prabhupada", 100));

        System.out.println("Library Book Collection: ");
        for(Book book : books){
            book.displayBookDetails();
        }

    }
}
