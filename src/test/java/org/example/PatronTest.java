package org.example;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


import java.util.List;
import java.util.ArrayList;

public class PatronTest {
    private Patron patron;
    private Item book;

    @Before
    public void setUp() {
        List<Item> borrowedItems = new ArrayList<>();
        patron = new Patron("Name", "001", borrowedItems);
        book = new Book("Test Book", "12345", "Test Author");
    }

    @Test
    public void testBorrow() {
        patron.borrow(book);
        assertTrue(patron.getBorrowedItems().contains(book));
    }

    @Test
    public void testReturnItem() {
        patron.borrow(book);
        patron.returnItem(book);
        assertFalse(patron.getBorrowedItems().contains(book));
    }
}