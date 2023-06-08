package com.techelevator.view;

public class Chips extends Items{
    public Chips(String name, double price, int quantity) {
        super(name, price, quantity);

    }
    @Override
    public String sound() {
        return "Crunch Crunch, Yum!";
    }
}
