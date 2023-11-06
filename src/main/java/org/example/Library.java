package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library {

        private List<Book> books;

        public Library() {
            books = new ArrayList<>();
        }
        public void addBook(Book book) {
            books.add(book);
        }

        public List<Book> getBooks() {
            return books;
        }

        public void showAllBooks() {
            System.out.println("Library Catalog:");
            for (Book book : books) {
                System.out.println(book);
            }
        }

        public Book findBookByTitle(String title) {
            for (Book book : books) {
                if (book.getTitle().equalsIgnoreCase(title)) {
                    return book;
                }
            }
            return null;
        }

        public void removeBookByIsbn(String isbn) {
            Iterator<Book> iterator = books.iterator();
            while (((Iterator<?>) iterator).hasNext()) {
                Book book = iterator.next();
                if (book.getIsbn().equals(isbn)) {
                    iterator.remove();
                    System.out.println("Book with ISBN " + isbn + " has been removed from the library.");
                    return;
                }
            }
            System.out.println("Book with ISBN " + isbn + " not found in the library.");
        }
    }


