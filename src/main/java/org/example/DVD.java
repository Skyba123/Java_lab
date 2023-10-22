package org.example;

public class DVD extends Item{
    private int duration;
    public DVD(String title, String uniqueID, int duration){
        super(title, uniqueID);
        this.duration = duration;
    }
    public void borrowItem() {
        setBorrowed(true);
    }
    public void returnItem() {
        setBorrowed(false);
    }

}
