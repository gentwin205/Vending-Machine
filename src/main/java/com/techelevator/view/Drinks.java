package com.techelevator.view;

public class Drinks extends Items{
    public Drinks(String name, double price, int quantity) {
        super(name, price, quantity);
    }
    @Override
    public String sound() {
        return "Glug Glug, Yum!";


    }
}
