package com.techelevator.view;

public class MoneyFeeder {
    private double moneyGiven;

    private double totalMoney;

    private double returnMoney;

    private double itemCost;

    public double getReturnMoney() {
        return returnMoney;
    }

    public MoneyFeeder(double moneyGiven, double totalMoney, double returnMoney) {
        this.moneyGiven = moneyGiven;
        this.totalMoney = totalMoney;
        this.returnMoney = returnMoney;
    }

    public double getMoneyGiven() {
        return moneyGiven;
    }

    public double getTotalMoney() {
        return totalMoney;
    }
    public double change (double changeGiven){
        totalMoney += moneyGiven;
        itemCost -= totalMoney;
        return changeGiven;



    }

}
