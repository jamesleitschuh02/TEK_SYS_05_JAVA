package com.perscholas.java;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// Core Java - Control Flow
		
		// 1
		
		int x = 7;
		
		if (x < 10) {
			System.out.println("Less than 10");
		};
		
		x = 15;
		
		if (x < 10) {
			System.out.println("Less than 10");
		};
		
		// 2
		
		x = 7;
		
		if (x < 10) {
			System.out.println("Less than 10");
		} else {
			System.out.println("Greater than 10");
		};
		
		x = 15;
		
		if (x < 10) {
			System.out.println("Less than 10");
		} else {
			System.out.println("Greater than 10");
		};
		
		// 3
		
		x = 15;

		if (x < 10) {
		System.out.println("Less than 10");
		} 
		else if ((x > 10) && (x < 20)){
			System.out.println("Between 10 and 20");
		}
		else {
			System.out.println("Greater than or equal to 20");
		};
		
		// 4
		
		x = 15;
		
		if ((x < 10) || (x > 20)) {
			System.out.println("Out of range");
		}
		else {
			System.out.println("In range");
		}
		
		// 5
		
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("Enter a value");
		x = userInput.nextInt();
		

		
		if ((x >= 0) && (x < 60)) {
			System.out.println("F");
		} 
		else if (x < 70) {
			System.out.println("D");
		}
		else if (x < 80) {
			System.out.println("C");
		}
		else if (x < 90) {
			System.out.println("B");
		}
		else if (x <= 100){
			System.out.println("A");
		}
		else {
			System.out.println("Out of range");
		}
		
		// 6 
		
		System.out.println("Enter value between 1 and 7");
		x = userInput.nextInt();
		
		switch(x) {
		case 1:
			System.out.println("MON");
			break;
		case 2:
			System.out.println("TUES");
			break;
		case 3:
			System.out.println("WED");
			break;
		case 4:
			System.out.println("THUR");
			break;
		case 5:
			System.out.println("FRI");
			break;
		case 6:
			System.out.println("SAT");
			break;
		case 7:
			System.out.println("SUN");
			break;
		default:
			System.out.println("OUT OF RANGE");
			break;
		}
		
		userInput.close();

	} // public
} // main
