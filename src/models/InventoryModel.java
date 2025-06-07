package models;

import java.util.ArrayList;
import java.util.UUID;
import java.util.NoSuchElementException;

public class InventoryModel {
	public ArrayList<ProductModel> inventory  = new ArrayList<>();
	
	public void addProduct(String name, float price, int quantity) {
		try {
		ProductModel product = new ProductModel(name, price, quantity);
		inventory.add(product);
		}
		catch (IllegalArgumentException exception) {
			System.out.println("Error: " + exception.getMessage());
		}
	}
	
	public ProductModel searchProduct(UUID code) throws NoSuchElementException  {
		if(inventory.isEmpty()) {
			throw new NoSuchElementException("The inventory is empty.");
		}
		
		for(ProductModel product: inventory) {
			if(product.getCode().equals(code)) {
				return product;
			}
		}
		return null;
	}
	
	public void removeProduct(UUID code) {
		try {
			var product = searchProduct(code);
			if(product != null) {
				inventory.remove(product);
			}
		}
		catch(NoSuchElementException exception) {
			System.out.println("Error: " + exception.getMessage());
		}
	}
	
	public void updateInventory(UUID code, int quantity, boolean isInbound) {
		var product = searchProduct(code);
		if(product != null) {
			if(isInbound) {
				product.setQuantity(product.getQuantity() + quantity);		// code smells
			}
		}
	}
	
	public void displayInventory() {
		inventory.forEach(product -> product.displayProduct());
	}
}
