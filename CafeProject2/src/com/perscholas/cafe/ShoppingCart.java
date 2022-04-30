package com.perscholas.cafe;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart extends Store{
	
	// array list - cart items
	private List<Product> myCart = new ArrayList<>();

	
	// add an item
	public void addItem(Product item) {
		myCart.add(item);
	}
	
	// return cart
	public List<Product> returnList() {
		return myCart;
	}
	
	// return cart item
	public Product getItem(int i) {
		return myCart.get(i);
	}

	public int cartSize() {
		return myCart.size();
	}
}
