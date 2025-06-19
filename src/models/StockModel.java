package models;

import java.util.ArrayList;
import java.util.UUID;
import java.util.NoSuchElementException;

public class StockModel {
	private ArrayList<ProductModel> stock = new ArrayList<>();

	public void addProduct(ProductModel product) {
		stock.add(product);
	}

	public ProductModel searchProduct(UUID code) {
		for (ProductModel product : stock) {
			if (product.getCode().equals(code)) {
				return product;
			}
		}

		throw new NoSuchElementException("It wasn't possible to find any product with the code " + code + "for this operation.");
	}

	public void updateProduct(UUID code, int quantity, boolean isInbound) {
		var product = searchProduct(code);

		if (isInbound) {
			product.setQuantity(product.getQuantity() + quantity);
		} else {
			product.setQuantity(product.getQuantity() - quantity); // bug-prone code
		}

		stock.set(stock.indexOf(product), product);
	}

	public void removeProduct(UUID code) {
		var product = searchProduct(code);
		stock.remove(product);
	}

	public void displayStock() {
		if (stock.isEmpty()) {
			throw new NoSuchElementException("The inventory has " + stock.size() + " stocked product.");
		}

		stock.forEach(product -> product.displayProduct());
	}
}
