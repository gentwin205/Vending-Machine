package com.techelevator;

import com.techelevator.view.ItemInventory;
import com.techelevator.view.Items;
import com.techelevator.view.Menu;

import java.io.File;
import java.lang.module.FindException;
import java.nio.file.FileSystemNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class VendingMachineCLI {
    int counter = 5;
    double currentMoney = 0.00;

    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";
    private static final String MAIN_MENU_SECRET_OPTION = "*Sales Report";

    private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";

    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT, MAIN_MENU_SECRET_OPTION};
    private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};


    private Menu menu;
    private ItemInventory itemInventory;


    public VendingMachineCLI(Menu menu) {
        this.menu = menu;
    }

    public void run() {
        while (true) {
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
                // display vending machine items
                this.itemInventory = new ItemInventory();
                for (Map.Entry<String, Items> item : itemInventory.getVendingItems().entrySet()) {
                    System.out.println(item.getKey() + " " + item.getValue().getName() + " " + item.getValue().getPrice() + " " + item.getValue().getQuantity());
                }


            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                // do purchase
                String choice2 = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

                if (choice2.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
                    System.out.println("FeedMoney");
                } else if (choice2.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
                    System.out.println("Select Product");
                } else if (choice2.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
                    System.out.println("Finish Transaction");

                }

            }

        }


    }


    public static void main(String[] args) {
        Menu menu = new Menu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.run();


    }
}
