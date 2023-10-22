package org.example;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BookTest {
    private Book book;

    @Before
    public void setUp() {
        book = new Book("Test Book", "12345", "Test Author");
    }

    @Test
    public void testBorrowItem() {
        assertFalse(book.getIsBorrowed());
        book.borrowItem();
        assertTrue(book.getIsBorrowed());
    }

    @Test
    public void testReturnItem() {
        book.borrowItem();
        assertTrue(book.getIsBorrowed());
        book.returnItem();
        assertFalse(book.getIsBorrowed());
    }
}