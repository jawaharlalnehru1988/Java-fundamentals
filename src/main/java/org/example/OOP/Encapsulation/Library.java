package org.example.OOP.Encapsulation;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    Library(){
        books = new ArrayList<>();
    }

   void addBooks(Book book){
        books.add(book);
       System.out.println("Book added: " + book.getTitle());
   }

   List<Book> searchBytitle(String title){
        List<Book> matchingBooks = new ArrayList<>();

        for(Book book: books){
            if(book.getTitle().equalsIgnoreCase(title)){
                matchingBooks.add(book);
            }
        }
        return matchingBooks;
   }

   public void printAllBooks(){
        if(books.isEmpty()){
            System.out.println("No books in the library");
        } else {
            System.out.println("books in the library:");
            for (Book book : books){
                System.out.println(book);
            }
        }

   }


}
