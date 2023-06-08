package com.techelevator;

import com.techelevator.view.Items;
import com.techelevator.view.Menu;

import java.util.*;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String MAIN_MENU_SECRET_OPTION = "*Sales Report";

	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";

	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT, MAIN_MENU_SECRET_OPTION };
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};


	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}

	Items doritosNacho = new Items("DoritosNachoCheese", 1.00);
	Items laysSourCream = new Items("SourCream&Onions",1.00);
	Items laysSaltAndVinegar = new Items("Salt&Vinegar", 1.00);
	Items fritos = new Items("Fritos",1.00);
	Items doritosCoolRanch = new Items("DoritosCoolRanch",1.00);
	Items spearMintGum = new Items("SpearMint", .50);
	Items winterGreen = new Items("WinterGreen", .50);
	Items bazookaBubbleGum = new Items("BazookaGum", .50);
	Items juicyFruit = new Items("JuicyFruit", .50);
	Items pepperMint = new Items("PepperMintGum",.50);
	Items snickers = new Items("snickers", 1.25);
	Items reeses = new Items("ReesesCup",1.25);
	Items twix = new Items("TwixBar", 1.25);
	Items skittles = new Items("Skittles",1.50);
	Items gushers = new Items("Gushers", 2.00);
	Items mountaindew = new Items("MountainDew", 3.00);
	Items pepsi = new Items("Pepsi",3.00);
	Items redBull = new Items("Redbull",5.00);
	Items coke = new Items("CocoaCola", 3.00);
	Items gatorade = new Items("Gatorade",4.00);

}
