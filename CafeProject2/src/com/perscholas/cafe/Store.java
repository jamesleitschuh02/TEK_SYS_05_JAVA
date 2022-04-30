package com.perscholas.cafe;

import java.util.ArrayList;
import java.util.List;

public class Store {
	
	// items list
	private List<Product> productList = new ArrayList<>();
	
	public List<Product> getProductsList() {
		productList.add(new Coffee("coffee", 3.5, "tasty"));
		productList.add(new Espresso("espresso", 4.5, "hot"));
		productList.add(new Cappuccino("cappuccino", 5.5, "extra tasty"));
		return productList;		
	}

}