package models;

import java.util.UUID;

public class ProductModel {
	private UUID code;
	private String name;
	private float price;
	private int quantity;
	
	public ProductModel(String name, float price, int quantity) {
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
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) throws IllegalArgumentException {
		if (price <= 0 ) {
			throw new IllegalArgumentException("The price must be more than zero.");
		}
		
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) throws IllegalArgumentException {
		if (quantity <= 0 ) {
			throw new IllegalArgumentException("The quantity must be more than zero.");
		}
		
		this.quantity = quantity;
	}
	
	public void displayProduct() {
		System.out.println("\n\t\t--- 📦 Product 📦 ---");
		System.out.println("\tCode: " + code);
		System.out.println("\tName: " + name);
		System.out.println("\tPrice: " + price);
		System.out.println("\tQuantity: " + quantity);
	}
}
