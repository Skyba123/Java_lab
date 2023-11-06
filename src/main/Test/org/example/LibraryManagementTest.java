package org.example;

import static org.junit.Assert.*;

import org.example.Book;
import org.example.Library;
import org.junit.Before;
import org.junit.Test;



public class LibraryManagementTest {
    private Library library;

    @Before
    public void setUp() {
        library = new Library();
    }

    @Test
    public void testAddBook() {
        Book book = new Book("Test Book", "Test Author", "1234567890", 2023);
        library.addBook(book);
        assertEquals(1, library.getBooks().size());
    }

    @Test
    public void testFindBookByTitle() {
        Book book1 = new Book("Test Book 1", "Test Author 1", "1111111111", 2023);
        Book book2 = new Book("Test Book 2", "Test Author 2", "2222222222", 2023);
        library.addBook(book1);
        library.addBook(book2);

        Book foundBook = library.findBookByTitle("Test Book 1");
        assertNotNull(foundBook);
        assertEquals("Test Book 1", foundBook.getTitle());
    }

    @Test
    public void testFindBookByTitleNotFound() {
        Book book1 = new Book("Test Book 1", "Test Author 1", "1111111111", 2023);
        library.addBook(book1);

        Book foundBook = library.findBookByTitle("Non-existent Book");
        assertNull(foundBook);
    }

    @Test
    public void testRemoveBookByIsbn() {
        Book book1 = new Book("Test Book 1", "Test Author 1", "1111111111", 2023);
        Book book2 = new Book("Test Book 2", "Test Author 2", "2222222222", 2023);
        library.addBook(book1);
        library.addBook(book2);

        String isbnToRemove = "1111111111";
        library.removeBookByIsbn(isbnToRemove);

        assertNull(library.findBookByTitle("Test Book 1"));
        assertNotNull(library.findBookByTitle("Test Book 2"));
    }

    @Test
    public void testRemoveBookByIsbnNotFound() {
        Book book1 = new Book("Test Book 1", "Test Author 1", "1111111111", 2023);
        library.addBook(book1);

        String isbnToRemove = "2222222222";
        library.removeBookByIsbn(isbnToRemove);

        assertNotNull(library.findBookByTitle("Test Book 1"));
    }
}