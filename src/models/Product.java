package models;

import java.util.UUID;
import exceptions.EntityValidationException;

public class Product {
	private UUID code;
	private String name;
	private double price;
	private int quantity;

	public Product(String name, double price, int quantity) {
		code = UUID.randomUUID();
		this.name = name;
		setPrice(price);
		setQuantity(quantity);
	}

	public UUID getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (price <= 0) {
			throw new EntityValidationException("The price must be more than zero.");
		}

		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		if (quantity <= 0) {
			throw new EntityValidationException("The quantity must be more than zero.");
		}

		this.quantity = quantity;
	}

	public void displayProduct() {
		System.out.println("\n\t\t\t	📦 PRODUCT 📦");
		System.out.println("\tCode:\t\t" + code);
		System.out.println("\tName:\t\t" + name);
		System.out.println("\tPrice:\t\t" + price);
		System.out.println("\tQuantity:	" + quantity);
	}
}
