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

    @Before
    public void setUp() {
        library = new Library();
        List<Item> borrowedItems = new ArrayList<>();
        book = new Book("Test Book", "12345", "Test Author");
        patron = new Patron("Name", "001", borrowedItems);
    }

    @Test
    public void testRegisterPatron() {
        library.registerPatron(patron);
        assertTrue(library.getPatrons().contains(patron));
    }

    @Test
    public void testAdd() {
        library.add(book);
        assertTrue(library.getItems().contains(book));
    }

    @Test
    public void testRemove() {
        library.add(book);
        library.remove(book);
        assertFalse(library.getItems().contains(book));
    }

    @Test
    public void testListAvailable() {
        library.add(book);
        List<Item> availableItems = library.listAvailable();
        assertTrue(availableItems.contains(book));
    }

    @Test
    public void testListBorrowed() {
        library.registerPatron(patron);
        library.lendItem(patron, book);
        List<Item> borrowedItems = library.listBorrowed();
        assertTrue(borrowedItems.contains(book));
    }

    @Test
    public void testLendItem() {
        library.add(book);
        library.registerPatron(patron);
        library.lendItem(patron, book);
        assertTrue(patron.getBorrowedItems().contains(book));
        assertTrue(book.getIsBorrowed());
    }

    @Test
    public void testReturnItem() {
        library.add(book);
        library.registerPatron(patron);
        library.lendItem(patron, book);
        library.returnItem(patron, book);
        assertFalse(patron.getBorrowedItems().contains(book));
        assertFalse(book.getIsBorrowed());
    }
}