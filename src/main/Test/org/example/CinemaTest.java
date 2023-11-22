package org.example;

import org.junit.Assert;
import org.testng.annotations.Test;

import static org.junit.Assert.*;


    public class CinemaTest {
        @Test
        void bookSeats() {
            Cinema cinema = new Cinema(1, 3, 5);
            cinema.bookSeats(0, 1, new int[]{2, 3});
            assertTrue(cinema.seatingArrangement[0][0][1] == 1);
            assertTrue(cinema.seatingArrangement[0][0][2] == 1);
        }
        @Test
        public void cancelBooking() {
            Cinema cinema = new Cinema(1, 3, 5);
            cinema.bookSeats(0, 1, new int[]{2, 3});
            cinema.cancelBooking(0, 1, new int[]{2});
            assertEquals(0, cinema.seatingArrangement[0][0][0]);
            assertEquals(0, cinema.seatingArrangement[0][0][1]);
        }
        @Test
        public void testCheckAvailability() {
            Cinema cinema = new Cinema(2, 5, 10);
            int hallNumber = 1;
            int rowNumber = 1;
            int[] reservedSeats = {2, 3, 4};
            cinema.bookSeats(hallNumber, rowNumber, reservedSeats);
            boolean isAvailable = cinema.checkAvailability(hallNumber, 1, 2, 3, 4);
            cinema.printSeatingArrangement(hallNumber);
            assertFalse(isAvailable);
        }
            @Test
            void printSeatingArrangement () {
                Cinema cinema = new Cinema(1, 3, 5);
                cinema.printSeatingArrangement(0);
            }
        }

