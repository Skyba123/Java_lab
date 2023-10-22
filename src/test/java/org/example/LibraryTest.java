package org.example;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;



public class LibraryTest {
    private Library library;
    private Item book;
    private Item dvd;

    @Before
    public void setUp() {
        library = new Library();
        book = new Book("Test Book", "12345", "Test Author");
        dvd = new DVD("Test DVD", "67890", 120);
    }

    @Test
    public void testAddAndRemoveItem() {
        library.add(book);
        assertTrue(library.listAvailable().contains(book));

        library.remove(book);
        assertFalse(library.listAvailable().contains(book));
    }

    @Test
    public void testLendAndReturnItem() {
        Patron patron = new Patron("Test Patron", "P123", new ArrayList<>());

        library.add(book);
        assertFalse(book.getIsBorrowed());

        library.lendItem(patron, book);
        assertTrue(book.getIsBorrowed());
        assertTrue(patron.getBorrowedItems().contains(book));

        library.returnItem(patron, book);
        assertFalse(book.getIsBorrowed());
        assertFalse(patron.getBorrowedItems().contains(book));
    }
}