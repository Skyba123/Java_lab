package org.example;

import java.util.ArrayList;
import java.util.List;

public class Patron {
    private String name;
    private String ID;
    private List<Item> borrowedItems;

    public Patron(String name, String ID, List<Item> borrowedItems){
        this.name = name;
        this.ID = ID;
        this.borrowedItems = new ArrayList<>();
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getID(){
        return ID;
    }
    public void setID(String ID){
        this.ID = ID;
    }
    public List<Item> getBorrowedItems(){
        return borrowedItems;
    }
    public void setBorrowedItems(List<Item> borrowedItems){
        this.borrowedItems = new ArrayList<Item>(borrowedItems);
    }
    public void borrow(Item item){
        borrowedItems.add(item);
    }
    public void returnItem(Item item){
        borrowedItems.remove(item);
    }
}
