package com.techelevator.view;

public abstract class Items {

    private String name;

    private double price;

    private int quantity;


    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity) {

        this.quantity = quantity;

    }

    public Items(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity= quantity;

    }

    public void incrementQuantity(){

        quantity--;
    }

    public abstract String sound();
}
