package views;

import util.Keyboard;

public class StockView {
	public static String getProductNameInput() {
		return Keyboard.readStringDataType("\nInsert the product's name: ");
	}
	
	public static double getProductPriceInput() {
		return Keyboard.readDoubleDataType("\nInsert the product's price: ");
	}
	
	public static int getProductQuantityInput() {
		return Keyboard.readIntDataType("\nInsert the product's quantity: ");
	}
	
	public static String getProductIdInput() {
		return Keyboard.readStringDataType("\nInsert the product's id: ");
	}
	
	public static boolean getInboundInput() {
		return Keyboard.readBooleanDataType("\nInsert true for the product's inbound: ");
	}
}
