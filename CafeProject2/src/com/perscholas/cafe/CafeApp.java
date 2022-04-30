package com.perscholas.cafe;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CafeApp {

	public static void main(String[] args) {
		
//		Product coffee = new Coffee("coffee", 3.5, "tasty", false, false);
//		Product espresso = new Espresso("espresso", 4.5, "hot", true, false);
//		Product cappuccino = new Cappuccino("cappuccino", 5.5, "extra tasty", true, true);
//		
//		try{
//		Scanner sc = new Scanner(System.in);
//
//		System.out.println("What is the quantity of coffe?");
//		int coffeeNumber = sc.nextInt();
//
//		System.out.println("What is the quantity of espresso?");
//		int espressoNumber = sc.nextInt();
//
//		System.out.println("What is the quantity of cappuccino?");
//		int cappuccinoNumber = sc.nextInt();
//
//		sc.close();
//
//		coffee.setQuantity(coffeeNumber);
//		espresso.setQuantity(espressoNumber);
//		cappuccino.setQuantity(cappuccinoNumber);
//
//		System.out.println(coffee.getName() + " " + coffee.getDescription() + " " + coffee.ProductTotal());
//		System.out.println(espresso.getName() + " " + espresso.getDescription() + " " + espresso.ProductTotal());
//		System.out.println(cappuccino.getName() + " " + cappuccino.getDescription() + " " + cappuccino.ProductTotal());
//		}catch(InputMismatchException ime) {
//			System.out.println("Must input correct type of data");
//			ime.printStackTrace();
//		}
		
		
		
		
//			try{

//			}catch(InputMismatchException ime) {
//				System.out.println("Incorrect type of answer, try again");
//				ime.printStackTrace();
//		}
		
		// Create flag to end loop
		boolean orderFlag = true;
		
		// Create store object and retrieve items list
		Store store = new Store();
		List<Product> productList = store.getProductsList();
		
		// Create shopping cart object
		ShoppingCart myCart = new ShoppingCart();
		
		// Create sub total and initialize to 0
		double subtotal = 0;
		
		// Initialize Sales Tax
		double tax = 1.03;
		
		// Initialize purchase total
		double purchaseTotal;
		
		
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("\nPlease make an order. Select the appropiate number.\n1) Coffee\n2) Espresso\n3) Cappuccino\n4) Checkout");
			int answer = sc.nextInt();
			
			switch(answer){
			case 1:
				Product Coffee = productList.get(0);
				
				System.out.println("How many Coffees would you like?");
				int cNum = sc.nextInt();
				Coffee.setQuantity(cNum);
				
				System.out.println("Do you want to add milk?");
				boolean cMilk = sc.nextBoolean();
				
				System.out.println("Do you want to add sugar?");
				boolean cSugar = sc.nextBoolean();
				
				Coffee.setModifiers(cMilk, cSugar);
				
				// Sub total
				subtotal = subtotal + Coffee.ProductTotal();
				
				// Add to cart
				myCart.addItem(Coffee);
								
				break;
			case 2:
				Product Espresso = productList.get(1);
				
				System.out.println("How many Espressos would you like?");
				int eNum = sc.nextInt();
				Espresso.setQuantity(eNum);
				
				System.out.println("Do you want to add an extra shot?");
				boolean extraShot = sc.nextBoolean();
				
				System.out.println("Do you want to add macchiato?");
				boolean macchiato = sc.nextBoolean();
				
				Espresso.setModifiers(extraShot, macchiato);
				
				// Sub total
				subtotal = subtotal + Espresso.ProductTotal();
				
				// Add to cart
				myCart.addItem(Espresso);
								
				break;
			case 3:
				Product Cappuccino = productList.get(2);
				
				System.out.println("How many Cappuccinos would you like?");
				int capNum = sc.nextInt();
				Cappuccino.setQuantity(capNum);
				
				System.out.println("Do you want to add Peppermint?");
				boolean pepMint = sc.nextBoolean();
				
				System.out.println("Do you want to add Whipped Cream?");
				boolean wCream = sc.nextBoolean();
				
				Cappuccino.setModifiers(pepMint, wCream);
				
				// Sub total
				subtotal = subtotal + Cappuccino.ProductTotal();
				
				// Add to cart
				myCart.addItem(Cappuccino);
								
				break;
			case 4:
				System.out.println("Thank you for ordering!\n");
				orderFlag = false;
				break;
			default:
				System.out.println("Thank you for ordering!\n");
				break;
			}
		}while(orderFlag);
		
		sc.close();
		
		purchaseTotal = subtotal + (tax*subtotal);

		
		for(int i = 0; i < myCart.cartSize(); i++) {
			
			System.out.println("\n| Item: " + myCart.getItem(i).getName() 
					+ " | Price: " + myCart.getItem(i).getPrice()
					+ " | Qty: " + myCart.getItem(i).getQuantity()
					+ " | Subtotal: " + subtotal + " |"
					+ "\n| " + myCart.getItem(i).getModifierOneName() + myCart.getItem(i).getModifierOne()
					+ " | " + myCart.getItem(i).getModifierTwoName() + myCart.getItem(i).getModifierTwo() + "                    |"							
					);
		}
		
		System.out.println("\nSubtotal: " + subtotal);
		System.out.println("Sales Tax: " + tax);
		System.out.println("Purchase Total: " + purchaseTotal);
					
			
	}

}