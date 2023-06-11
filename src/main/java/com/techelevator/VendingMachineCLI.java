package com.techelevator;

import com.techelevator.view.*;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class VendingMachineCLI {
    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";
    private static final String MAIN_MENU_SECRET_OPTION = "*Sales Report";

    private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";

    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT, MAIN_MENU_SECRET_OPTION};
    private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};
    DateTimeFormatter timeFormatterForLog = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    String timeLog = timeFormatterForLog.format(LocalDateTime.now());
    File log = new File("log.txt");
    FileWriter logFile;

    {
        try {
            logFile = new FileWriter(log, true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    PrintWriter logWriter = new PrintWriter(logFile);

    private Menu menu;
    private ItemInventory itemInventory;
    double remaining = 0.00;
    double currentMoney = 0.00;
    int amount = 0;
    String slot = "";
    String choice2 ="";
    Double quarter = .25;
    Double dime = .10;
    Double nickel =.05;
    int quarterCounter = 0;
    int nickelCounter = 0;
    int dimeCounter = 0;
    Map<String, Items> item = new LinkedHashMap<>();




    public VendingMachineCLI(Menu menu) {
        this.menu = menu;
        this.itemInventory = new ItemInventory();
    }

    public void vendingMachineItems(){
        //this.itemInventory = new ItemInventory();
        printInventoryItems();
    }

    private void printInventoryItems() {
        for (Map.Entry<String, Items> item : itemInventory.getVendingItems().entrySet()) {
            System.out.println(item.getKey() + " " + item.getValue().getName() + " " + item.getValue().getPrice() + " " + item.getValue().getQuantity());
        }
    }

    public void dispense(){


        Items item = itemInventory.getVendingItems(slot);
        if (item == null){
            System.out.println("Item does not exist");
        }else{
            double price = item.getPrice();
            String name = item.getName();

            String sound = item.sound();







         if (currentMoney < price){
            System.out.println("Insufficient funds");
        }else if(item.getQuantity() <= 0){
            System.out.println("Sold Out");


        } else {
             item.incrementQuantity();
        System.out.println(name);
        System.out.println(price);
        System.out.println(sound);



        currentMoney -= price;
             logWriter.println(timeLog +" " + item.getName() + " " + slot + " " + "$" + amount + " " + "$" + currentMoney );
             logWriter.flush();



             System.out.println("Amount remaining $" + currentMoney+"\n");
         }
        }
    }

    public void run() {
        while (true) {

            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
                // display vending machine items
                vendingMachineItems();


            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                // do purchase
                while(true){
                System.out.println("Current Money Provided: $" + currentMoney + "");
              choice2 = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
                Scanner scan = new Scanner(System.in);


                if (choice2.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
                    System.out.println("Please enter a dollar amount to add");
                    double amount = scan.nextDouble();
                    currentMoney += amount;
                    logWriter.println(timeLog +  " FEED MONEY: " + "$" + amount + " $" + currentMoney);
                    logWriter.flush();

                } else if (choice2.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {


                    printInventoryItems();

                    System.out.println("Please enter a key");
                    slot = scan.nextLine();
                    dispense();



                } else if (choice2.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {

                    double amountDue = currentMoney;
                    while (amountDue >= quarter){

                            amountDue -= quarter;
                            quarterCounter++;

                    }
                    while (amountDue >= dime){

                            amountDue -= dime;
                            dimeCounter++;


                    } while (amountDue >= nickel){

                            currentMoney -= nickel;
                            nickelCounter++;






                }
                     System.out.println("You're change is " + quarterCounter +" quarters " + nickelCounter +" nickels "+ dimeCounter +" dimes.");
                    logWriter.println(timeLog + " " + "GIVE CHANGE:" + " " + currentMoney + "$0.00" );
                    logWriter.flush();
                    currentMoney = 0.00;
                     quarterCounter=0;
                     dimeCounter=0;
                     nickelCounter=0;

                     break;
                }
            }
            } else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
                System.out.println("Thank You for using the Vendo-Matic 800");
                System.out.println("Goodbye!");

                break;
            }

        }
    }



    public static void main(String[] args) {
        Menu menu = new Menu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.run();


    }

}
