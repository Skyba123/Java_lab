package org.example;

import java.util.ArrayList;
import java.util.List;

public class Library implements IManageable {
    private List<Item> items;
    private List<Patron> patrons;

    public Library() {
        items = new ArrayList<>();
        patrons = new ArrayList<>();
    }
    public List<Patron> getPatrons() {
        return patrons;
    }
    public List<Item> getItems() {
        return items;
    }
    public void registerPatron(Patron patron) {
        patrons.add(patron);
    }

    public void lendItem(Patron patron, Item item) {
        if (!item.getIsBorrowed()) {
            patron.borrow(item);
            item.setBorrowed(true);
        }
    }

    public void returnItem(Patron patron, Item item) {
        patron.returnItem(item);
        item.returnItem();
    }

    public void add(Item item) {
        items.add(item);
    }

    public void remove(Item item) {
        items.remove(item);
    }

    public List<Item> listAvailable() {
        List<Item> availableItems = new ArrayList<>();
        for (Item item : items) {
            if (!item.getIsBorrowed()) {
                availableItems.add(item);
            }
        }
        return availableItems;
    }

    public List<Item> listBorrowed() {
        List<Item> borrowedItems = new ArrayList<>();
        for (Patron patron : patrons) {
            borrowedItems.addAll(patron.getBorrowedItems());
        }
        return borrowedItems;
    }
}
