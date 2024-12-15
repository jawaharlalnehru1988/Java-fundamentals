package org.example.OOP.Encapsulation;

import java.util.List;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Book book1 = new Book("Bhagavad Gita", "Vyasadeva", "ISBN1234", 250.00);
        Book book2 = new Book("Bhagavatham", "Vyasadeva", "ISBN4231", 500.00);
        Book book3 = new Book("Chaitanya Charitamrutham", "Krishna das Kaviraj", "ISBN42334", 600.83);
        Book book4 = new Book("Science of Self Realization", "Srila Prabhupada", "ISBN23452", 100.33);

        //Add books to the library
        library.addBooks(book1);
        library.addBooks(book2);
        library.addBooks(book3);
        library.addBooks(book4);

        //print all books
        library.printAllBooks();

        //search books by title

        String bookToSearch = "Bhagavad Geeta";
        List<Book> matchingbooks = library.searchBytitle(bookToSearch);

        if(matchingbooks.isEmpty()){
            System.out.println("No books found with the title: " + bookToSearch);
        } else {
            System.out.println("books found");
            for (Book book : matchingbooks){
                System.out.println(book);
            }
        }
    }
}
