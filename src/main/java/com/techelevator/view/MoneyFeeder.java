package com.techelevator.view;

public class MoneyFeeder {
    private double moneyGiven;

    private double totalMoney;

    public MoneyFeeder(double moneyGiven, double totalMoney) {
        this.moneyGiven = moneyGiven;
        this.totalMoney = totalMoney;
    }

    public double getMoneyGiven() {
        return moneyGiven;
    }

    public double getTotalMoney() {
        return totalMoney;
    }
}
