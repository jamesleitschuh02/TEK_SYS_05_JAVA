package com.perscholas.cafe;

public abstract class Product {
    private String name;
	protected double price;
	private String description;
	protected int quantity;
	
	public Product() {
		super();
	}

	public Product(String name, double price, String description) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public abstract boolean getModifierOne();
	
	public abstract boolean getModifierTwo();
	
	public abstract String getModifierOneName();
	
	public abstract String getModifierTwoName();
	
	public abstract double ProductTotal();
	
	public abstract void setModifiers(boolean one, boolean two);

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", description=" + description + ", quantity=" + quantity
				+ "]";
	}

}
