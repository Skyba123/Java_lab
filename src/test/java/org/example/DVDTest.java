package org.example;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DVDTest {
    private DVD dvd;

    @Before
    public void setUp() {
        dvd = new DVD("Test DVD", "67890", 120);
    }

    @Test
    public void testBorrowItem() {
        assertFalse(dvd.getIsBorrowed());
        dvd.borrowItem();
        assertTrue(dvd.getIsBorrowed());
    }

    @Test
    public void testReturnItem() {
        dvd.borrowItem();
        assertTrue(dvd.getIsBorrowed());
        dvd.returnItem();
        assertFalse(dvd.getIsBorrowed());
    }
}