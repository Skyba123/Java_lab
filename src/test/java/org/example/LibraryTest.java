package org.example;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;

public class LibraryTest {
    private Library library;
    private Item book;
    private Patron patron;

    private DVD dvd;

    @Before
    public void setUp() {
        library = new Library();
        List<Item> borrowedItems = new ArrayList<>();
        book = new Book("Test Book", "12345", "Test Author");
        patron = new Patron("Name", "001", borrowedItems);
        dvd = new DVD("Test DVD", "67890", 120);
    }

    @Test
    public void testRegisterPatron() {
        library.registerPatron(patron);
        List<Patron> registeredPatrons = library.getPatrons();
        assertTrue(registeredPatrons.contains(patron));
    }

    @Test
    public void testLendItem() {
        library.registerPatron(patron);
        library.add(book);
        library.lendItem(patron, book);
        assertTrue(book.getIsBorrowed());
        List<Item> borrowedItems = patron.getBorrowedItems();
        assertTrue(borrowedItems.contains(book));
    }

    @Test
    public void testReturnItem() {
        library.registerPatron(patron);
        library.add(book);
        library.lendItem(patron, book);
        library.returnItem(patron, book);
        assertFalse(book.getIsBorrowed());
        List<Item> borrowedItems = patron.getBorrowedItems();
        assertFalse(borrowedItems.contains(book));
    }

    @Test
    public void testAdd() {
        library.add(book);
        List<Item> addedItems = library.getItems();
        assertTrue(addedItems.contains(book));
    }

    @Test
    public void testRemove() {
        library.add(book);
        library.remove(book);
        List<Item> addedItems = library.getItems();
        assertFalse(addedItems.contains(book));
    }

    @Test
    public void testListAvailable() {
        library.add(book);
        library.add(dvd);
        List<Item> availableItems = library.listAvailable();
        assertTrue(availableItems.contains(book));
        assertTrue(availableItems.contains(dvd));
    }

    @Test
    public void testListBorrowed() {
        library.registerPatron(patron);
        library.add(book);
        library.add(dvd);
        library.lendItem(patron, book);
        library.lendItem(patron, dvd);
        List<Item> borrowedItems = library.listBorrowed();
        assertTrue(borrowedItems.contains(book));
        assertTrue(borrowedItems.contains(dvd));
    }
}