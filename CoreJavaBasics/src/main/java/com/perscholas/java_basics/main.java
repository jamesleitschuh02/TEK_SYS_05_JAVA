package com.perscholas.java_basics;

public class main {

	public static void main(String[] args) {
		
		// 1
		 
		int num1 = 1;
		int num2 = 2;
		
		int num3 = num1 + num2;
		System.out.println(num3);
		
		// 2
		
		double dub1 = 1;
		double dub2 = 2;
		double dub3 = dub1 + dub2;
		System.out.println(dub3);
		
		// 3
		
		int num4 = 1;
		double dub4 = 2.6;
		double mix = num4 + dub4;
		System.out.println(mix);
		// Variable type is a double
		
		// 4
		
		int x = 3;
		double y = 5.5;
		double div = x / y;
		System.out.println(div);
		
		// Need to change variable type to DOUBLE to make a decimal number. 
		
		// 5
		
		double a = 5.1;
		double b = 8.6;
		double c = b / a;
		System.out.println(c);
		int d = (int) c; //Manual Cast into integer
		System.out.println(d);
		
		// 6
		
		int xx = 5;
		int yy = 6;
		int q = yy / xx;
		System.out.println(q);
		
		// 7
		
		final int CONS1 = 10;
		System.out.println(CONS1 / 2);
		
		// 8
		
		double coffee = 3.5;
		double cappuccino = 4.5;
		double greenTea = 2;
		
		final double SALES_TAX = 0.4;
		
		double subTotal = (coffee * 3) + (cappuccino * 4) + (greenTea * 2);
		
		double totalSale = subTotal + (subTotal * SALES_TAX);
		
		System.out.println(totalSale);

	}

}
