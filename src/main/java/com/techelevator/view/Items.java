package com.techelevator.view;

public abstract class Items {

    private String name;

    private double price;

    private  int quantity;


    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity(){
        return quantity;
    }



    public Items(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;

    }

    public abstract String sound();
}
