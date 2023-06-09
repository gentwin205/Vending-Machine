package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ItemInventory {
    String input = "vendingmachine.csv";
    File vending = new File(input);


    public Map<String, Items> getVendingItems() {
        return vendingItems;
    }

    Map<String, Items> vendingItems;

    public ItemInventory() {
        vendingItems = new HashMap<>();
        try (
                Scanner read = new Scanner(vending)) {
            while (read.hasNextLine()) {
                String line = read.nextLine();
                String[] newLine = line.split("\\|");

                vendingItems.put(newLine[0], new Chips(newLine[1], Double.parseDouble(newLine[2]), 5));
            }
            } catch(FileNotFoundException e){
                throw new RuntimeException(e);

            }
        }
    }



