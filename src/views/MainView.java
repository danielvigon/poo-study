package views;

import java.util.LinkedHashMap;
import util.Keyboard;

public class MainView {
	public static void displayMenu() {
		LinkedHashMap<Integer, String> menu = new LinkedHashMap<>();
		menu.put(1, "Add product");
		menu.put(2, "List products");
		menu.put(3, "Update stock");
		menu.put(4, "Remove product");
		menu.put(5, "Search product");
		menu.put(0, "Quit");

		System.out.println("\n\tMenu");
		menu.forEach((key, value) -> System.out.println(key + " - " + value));
	}
	
	public static int getMenuInput() {
		return Keyboard.readIntDataType("\nChoose a menu's option: ");
	}
}
