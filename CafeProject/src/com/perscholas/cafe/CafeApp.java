package com.perscholas.cafe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CafeApp {

	public static void main(String[] args) {

		Product coffee = new Product("coffee", 3.5, "tasty");
		Product espresso = new Product("espresso", 4.5, "hot");
		Product cappuccino = new Product("cappuccino", 5.5, "extra tasty");
		
		try{
		Scanner sc = new Scanner(System.in);

		System.out.println("What is the quantity of coffe?");
		int coffeeNumber = sc.nextInt();

		System.out.println("What is the quantity of expresso?");
		int espressoNumber = sc.nextInt();

		System.out.println("What is the quantity of cappuccino?");
		int cappuccinoNumber = sc.nextInt();

		sc.close();

		coffee.setQuantity(coffeeNumber);
		espresso.setQuantity(espressoNumber);
		cappuccino.setQuantity(cappuccinoNumber);

		System.out.println(coffee.getName() + " " + coffee.getDescription() + " " + coffee.ProductTotal());
		System.out.println(espresso.getName() + " " + espresso.getDescription() + " " + espresso.ProductTotal());
		System.out.println(cappuccino.getName() + " " + cappuccino.getDescription() + " " + cappuccino.ProductTotal());
		}catch(InputMismatchException ime) {
			System.out.println("Must input correct type of data");
			ime.printStackTrace();
		}
	}

}
