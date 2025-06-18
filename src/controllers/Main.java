package controllers;

import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		
	}
	
	public void displayMenu() {
		HashMap<Integer, String> menu = new HashMap<>();
		menu.put(1, "Add product");
		menu.put(2, "Search product");
		menu.put(3, "Update product");
		menu.put(4, "remove product");
		menu.put(5, "Display stock");
		menu.put(0, "Quit");
	}
}
