package org.example;

public class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema(5, 10, 20);

        // Бронювання місць
        cinema.bookSeats(1, 3, new int[]{5, 6, 7,8});
        cinema.printSeatingArrangement(1);

        // Скасування бронювання
        cinema.cancelBooking(1, 3, new int[]{5, 6, 7});
       cinema.printSeatingArrangement(1);
        // Перевірка наявності місць
        boolean isAvailable = cinema.checkAvailability(1,3, 8);

  }
}
