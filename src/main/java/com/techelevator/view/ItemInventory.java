package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ItemInventory {
    String input = "vendingmachine.csv";
    File vending = new File(input);

    private final int MAX = 5;


    public Map<String, Items> getVendingItems() {
        return vendingItems;
    }

    Map<String, Items> vendingItems;

    public ItemInventory() {
        vendingItems = new LinkedHashMap<>();
        try (
                Scanner read = new Scanner(vending)) {
            while (read.hasNextLine()) {
                String line = read.nextLine();
                String[] newLine = line.split("\\|");

                if (newLine[3].contains("Chip")){
                    vendingItems.put(newLine[0], new Chips(newLine[1], Double.parseDouble(newLine[2]), MAX));


                }
                else if(newLine[3].contains("Candy")){
                    vendingItems.put(newLine[0], new Candy(newLine[1], Double.parseDouble(newLine[2]), MAX));
                }
                else if(newLine[3].contains("Drink")){
                    vendingItems.put(newLine[0], new Drinks(newLine[1], Double.parseDouble(newLine[2]), MAX));

                }
                else if(newLine[3].startsWith("Gum")){
                    vendingItems.put(newLine[0], new Gum(newLine[1], Double.parseDouble(newLine[2]), MAX));
                }
            }
            } catch(FileNotFoundException e){
                throw new RuntimeException(e);

            }
        }

    public Items getVendingItems(String slot) {
        return vendingItems.get(slot);
    }
}



