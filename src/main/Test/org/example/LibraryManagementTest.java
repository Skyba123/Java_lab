package org.example;

import static org.junit.Assert.*;

public class LibraryManagementTest {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook(new Book("Metro 2033", "D. A. Glukhovsky", "978-966-10-6112-4", 2002));
        library.addBook(new Book("Adventures of Sherlock Holmes", "Arthur Conan Doyle", "978-617-7025-69-5", 1892));
        library.addBook(new Book("Harry Potter", "Joan Rowling", "978-966-7047-39-9", 1997));

        library.showAllBooks();


        String searchTitle = "Metro 2033";
        Book foundBook = library.findBookByTitle(searchTitle);
        if (foundBook != null) {
            System.out.println("Found book: " + foundBook);
        } else {
            System.out.println("Book with title '" + searchTitle + "' not found in the library.");
        }

        String isbnToRemove = "978-617-7025-69-5";
        library.removeBookByIsbn(isbnToRemove);

        library.showAllBooks();
    }
}