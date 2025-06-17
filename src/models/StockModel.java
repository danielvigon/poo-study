package models;

import java.util.ArrayList;
import java.util.UUID;
import java.util.NoSuchElementException;

public class StockModel {
	public ArrayList<ProductModel> stock = new ArrayList<>();

	public void addProduct(String name, float price, int quantity) {
		try {
			ProductModel product = new ProductModel(name, price, quantity);
			stock.add(product);
		} catch (IllegalArgumentException exception) {
			System.out.println("An error occurred: " + exception.getMessage());
		}
	}

	public ProductModel searchProduct(UUID code) {
		for (ProductModel product : stock) {
			if (product.getCode() == code) {
				return product;
			}
		}
		return null;
	}

	public void updateProduct(UUID code, int quantity, boolean isInbound) throws NoSuchElementException {
		var product = searchProduct(code);
		if (product == null) {
			throw new NoSuchElementException("It wasn't possible to find any product with the code " + code + " to be updated.");
		}

		if (isInbound) {
			product.setQuantity(product.getQuantity() + quantity);
		} else {
			try {
				product.setQuantity(product.getQuantity() - quantity);		// bug-prone code
			} catch (IllegalArgumentException exception) {
				System.out.println("An error occurred: " + exception.getMessage());
			}
		}
		stock.set(stock.indexOf(product), product);
	}

	public void removeProduct(UUID code) throws NoSuchElementException {
		var product = searchProduct(code);
		if (product == null) {
			throw new NoSuchElementException("It wasn't possible to find any product with the code " + code + " to be removed.");
		}

		stock.remove(product);
	}

	public void displayStock() {
		stock.forEach(product -> product.displayProduct());
	}

	public boolean isStockFilled() throws NoSuchElementException {
		if (stock.isEmpty()) {
			throw new NoSuchElementException("The stock is empty.");
		}

		return true;
	}
}
