package models;

import java.util.UUID;
import exceptions.EntityValidationException;


public class ProductModel {
	private UUID code;
	private String name;
	private double price;
	private int quantity;
	
	public ProductModel(String name, double price, int quantity) {
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
		if (price <= 0 ) {
			throw new EntityValidationException("The price must be more than zero.");
		}
		
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		if (quantity <= 0 ) {
			throw new EntityValidationException("The quantity must be more than zero.");
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
