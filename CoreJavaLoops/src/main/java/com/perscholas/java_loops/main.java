package com.perscholas.java_loops;

public class main {

	public static void main(String[] args) {
		// Core Java - Loops
		
		int x;
		
		// 1
		
		for (x = 1; x <= 10; x++) {
			System.out.println(x);
		}
		
		// 2
		
		for (x = 0; x <= 100; x = x + 10) {
			System.out.println(x);
		}
		
		// 3
		
		x = 1;
		do {
			System.out.println(x);
			x++;
		}while(x <= 10);
		
		// 4
		
		for (x = 1; x <= 100; x++) {
			if ((x >= 25) && (x <= 75)) {
				continue;
			}
			else if (x % 5 == 0) {
				System.out.println(x);
			}
			else {
				continue;
			}
		}
		
		// 5
		
		for (x = 1; x <= 100; x++) {
			if (x > 50) {
				break;
			}
			else if (x % 5 == 0) {
				System.out.println(x);
			}
		}
		
		// 6
		
		for (int y = 1; y <= 2; y++) {
			System.out.println("Week " + y);
			for (x = 1; x <= 5; x++) {
				System.out.println("Day " + x);
			}
		}
		
		// 7
	
		for (x = 10; x <= 200; x++) {
			int num = x;
			int r = 0;
			while(num != 0) {
				int remainder = num % 10;
				r = r * 10 + remainder;
				num = num / 10;
			}
			if (x == r) {
				System.out.println(x);
			}
		}
		
		// 8
		
		int firstNum = 0;
		int secondNum = 1;
		for (int y = 1; y <= 10; y++) {
			System.out.print(firstNum + ", ");		
			int nextNum = firstNum + secondNum;
			firstNum = secondNum;
			secondNum = nextNum;
		}
		
		// 9
		
		for (x=0; x <= 5; x++) {
			for (int y = 0; y <= 5; y++) {
				System.out.println("Inner loop: y: " + y + " Inner loop: x: " + x);
			}
		}
		
		
		
	} //

} //