package views;

import java.util.Map;
import util.Keyboard;

public class MainView {
	public static void displayMenu() {
		Map<Integer, String> menu = Map.of(
				1, "Add product",
				2, "List products",
				3, "Update stock",
				4, "Remove product",
				5, "Search product",
				0, "Quit");

		System.out.println("\n\tMenu");
		
		menu.forEach((key, value) -> System.out.println(key + " - " + value));
	}
	
	public static int getMenuInput() {
		return Keyboard.readIntDataType("\nChoose a menu's option: ");
	}
}
