package org.example;

public class Book extends Item{
    private String author;

    public Book(String title, String uniqueID, String author) {
        super(title, uniqueID);
        this.author = author;
    }


    public void borrowItem() {
        setBorrowed(true);
    }


    public void returnItem() {
        setBorrowed(false);
    }
}
