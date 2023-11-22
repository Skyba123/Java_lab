package org.example;

public class Cinema {
    public int[][][] seatingArrangement;

    public Cinema(int halls, int rows, int seats) {
        seatingArrangement = new int[halls][rows][seats];
        initializeSeatingArrangement();
    }
    private void initializeSeatingArrangement() {
        for (int i = 0; i < seatingArrangement.length; i++) {
            for (int j = 0; j < seatingArrangement[i].length; j++) {
                for (int k = 0; k < seatingArrangement[i][j].length; k++) {
                    seatingArrangement[i][j][k] = 0;
                }
            }
        }
    }
    public void bookSeats(int hallNumber, int row, int[] seats) {
        for (int seat : seats) {
            if (seat >= 1 && seat <= seatingArrangement[hallNumber][row - 1].length) {
                if (seatingArrangement[hallNumber][row - 1][seat - 1] == 1) {
                    System.out.println("Місце " + seat + " в ряду " + row + " вже заброньоване.");
                } else {
                    seatingArrangement[hallNumber][row - 1][seat - 1] = 1;
                    System.out.println("Місце " + seat + " в ряду " + row + " успішно заброньоване.");
                }
            } else {
                System.out.println("Невірний номер місця: " + seat);
            }
        }
    }

    public void cancelBooking(int hallNumber, int row, int[] seats) {
        for (int seat : seats) {
            if (seat >= 1 && seat <= seatingArrangement[hallNumber][row - 1].length) {
                if (seatingArrangement[hallNumber][row - 1][seat - 1] == 1) {
                    seatingArrangement[hallNumber][row - 1][seat - 1] = 0;
                    System.out.println("Бронювання для місця " + seat + " в ряду " + row + " скасовано.");
                }

            } else {
                System.out.println("Невірний номер місця: " + seat);
            }
        }
    }

    public boolean checkAvailability(int hallNumber, final int... seats) {
        int maxRowNumber = seatingArrangement[hallNumber].length;
        int maxSeatNumber = seatingArrangement[hallNumber][0].length;
        for (int i = 0; i < maxRowNumber; i++) {
            System.out.print("Доступні місця в залі " + hallNumber + " в ряду " + (i + 1) + ": ");
            for (int j = 0; j < maxSeatNumber; j++) {
                int currentSeat = j;
                if (isSeatInArray(seats, currentSeat + 1)) {
                    if (seatingArrangement[hallNumber][i][currentSeat] == 1) {

                    } else {
                        System.out.print((currentSeat + 1) + " ");
                    }
                }
            }
            System.out.println();
        }
        return false;
    }

    private boolean isSeatInArray(int[] seats, int seatToCheck) {
        for (int seat : seats) {
            if (seat == seatToCheck) {
                return true;
            }
        }
        return false;
    }

    public void printSeatingArrangement(int hallNumber) {
        int maxRowNumber = seatingArrangement[hallNumber].length;
        int maxSeatNumber = seatingArrangement[hallNumber][0].length;

        System.out.print("    ");
        for (int i = 1; i <= maxSeatNumber; i++) {
            System.out.print(String.format("%4d", i));
        }
        System.out.println();
        for (int i = 0; i < maxRowNumber; i++) {
            System.out.print(String.format("%2d |", (i + 1)));
            for (int j = 0; j < maxSeatNumber; j++) {
                String seatStatus = seatingArrangement[hallNumber][i][j] == 1 ? "1" : "0";
                System.out.print(String.format("%4s", seatStatus));
            }
            System.out.println(String.format("| %2d", (i + 1)));
        }
        System.out.print("    ");
        for (int i = 1; i <= maxSeatNumber; i++) {
            System.out.print(String.format("%4d", i));
        }
        System.out.println();
    }
}
