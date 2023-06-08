package com.techelevator.view;

public class Candy extends Items{
    public Candy(String name, double price, int quantity) {
        super(name, price, quantity);
    }
    @Override
    public String sound(){
        return "Munch Munch, Yum!";

    }
}
