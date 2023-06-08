package com.techelevator.view;

public class Gum extends Items{
    public Gum(String name, double price, int quantity) {
        super(name, price, quantity);
    }
    @Override
    public String sound(){
        return "Chew Chew, Yum!";
    }
}
