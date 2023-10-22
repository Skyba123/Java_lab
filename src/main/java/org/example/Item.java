package org.example;

public abstract class Item {
    private String title;
    private String uniqueID;
    protected boolean isBorrowed;
    public Item(String title, String uniqueID){
        this.title = title;
        this.uniqueID= uniqueID;
        this.isBorrowed = false;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getUniqueID(){
        return uniqueID;
    }
    public void setUniqueID(String uniqueID){
        this.uniqueID = uniqueID;
    }
    public boolean getIsBorrowed(){
        return isBorrowed;
    }
    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public abstract void borrowItem();
    public abstract void returnItem();
}
