package controllers;

import java.util.NoSuchElementException;
import java.util.UUID;
import views.MainView;
import views.StockView;
import models.Product;
import models.Stock;
import exceptions.EntityValidationException;

public class MainController {
	private static Stock stock = new Stock();
	private static int input = -1;

	public static void main(String[] args) {

		while (input != 0) {
			MainView.displayMenu();

			input = validateMenuInput();

			switch (input) {
			case 1:
				executeProductAdding();
				break;

			case 2:
				executeProductsListing();
				break;

			case 3:
				executeStockUpdating();
				break;

			case 4:
				executeProductRemoving();
				break;

			case 5:
				executeProductSearching();
				break;		// case default to be implemented
			}
		}
	}

	private static int validateMenuInput() {
		try {
			return MainView.getMenuInput();
		} catch (NumberFormatException exception) {
			System.out.println("\nAn error occurred: It wasn't possible to identify a valid option.");
			return -1;
		}
	}

	private static void executeProductAdding() {
		String name = StockView.getProductNameInput();

		try {
			double price = StockView.getProductPriceInput();
			int quantity = StockView.getProductQuantityInput();
			Product product = new Product(name, price, quantity);
			stock.addProduct(product);
		} catch (NumberFormatException exception) {
			System.out.println("\nAn error occurred: It wasn't possible to identify either a valid price or quantity.");
		} catch (EntityValidationException exception) {
			System.out.println("\nAn error occurred: " + exception.getMessage());
		}
	}

	private static void executeProductsListing() {
		try {
			stock.displayStock();
		} catch (NoSuchElementException exception) {
			System.out.println("\n" + exception.getMessage());
		}
	}

	private static void executeStockUpdating() {
		boolean isInbound = StockView.getInboundInput();

		try {
			UUID id = UUID.fromString(StockView.getProductIdInput());
			int quantity = StockView.getProductQuantityInput();
			stock.updateProduct(id, quantity, isInbound);
		} catch (NumberFormatException exception) {
			System.out.println("\nAn error occurred: It wasn't possible to identify a valid quantity.");
		} catch (IllegalArgumentException exception) {
			System.out.println("\nAn error occurred: It wasn't possible to identity a valid ID.");
		} catch (NoSuchElementException exception) {
			System.out.println("\nAn error occurred: " + exception.getMessage());
		} catch (EntityValidationException exception) {
			System.out.println("\nAn error occurred: " + exception.getMessage());
		}
	}

	private static void executeProductRemoving() {
		try {
			UUID id = UUID.fromString(StockView.getProductIdInput());
			stock.removeProduct(id);
		} catch (IllegalArgumentException exception) {
			System.out.println("\nAn error occurred: It wasn't possible to identity a valid ID.");
		} catch (NoSuchElementException exception) {
			System.out.println("\nAn error occurred: " + exception.getMessage());
		}
	}

	private static void executeProductSearching() {
		try {
			UUID id = UUID.fromString(StockView.getProductIdInput());
			stock.searchProduct(id);
		} catch (IllegalArgumentException exception) {
			System.out.println("\nAn error occurred: It wasn't possible to identity a valid ID.");
		} catch (NoSuchElementException exception) {
			System.out.println("\nAn error occurred: " + exception.getMessage());
		}
	}
}
