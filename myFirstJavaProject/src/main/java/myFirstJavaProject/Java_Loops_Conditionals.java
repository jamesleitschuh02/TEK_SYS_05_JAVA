package myFirstJavaProject;

import java.util.Scanner;

public class Java_Loops_Conditionals {

	public static void main(String[] args) {
		// Java Loops and Conditionals
		
		// AND = &&, OR = ||
		// + - ? * %
		
		int num = 12;
		
		int num2 = 7;
		
		// boolean
		boolean isEven = num % 2 == 0;
		
		// if statement
		if (isEven) {
			System.out.println("yes");
		}
		
		// if else statement
		int age = 18;
		
		if (age > 15 && age < 18) {
			System.out.println("Can't buy game");
		}
		else if(age > 18 && age < 25){
			System.out.println("You are old enough!");
		}
		else {
			System.out.println("Not in range");
		}
		
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("Hi, what is your name? ");
		String firstName = userInput.nextLine();
		
		System.out.println("What is your age? ");
		int userAge = userInput.nextInt();
		
		if(userAge > 17) {
			System.out.println("You may pass");
		}
		else {
			System.out.println("You shall not pass, " + firstName);
		}
		
		userInput.close();
		
		
		// Switch Statements
		int day = 1;
		
		switch(day) {
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
		default:
			System.out.println("Default Statement");
			break;
			
		}
		
		// Ternary operator
		
		// (8 > 9) ? "yes" : "no"
		
		boolean exp = (3 == 10) ? true : false;
		
		// Loops - while loop, do while loops, for loops, break $ continue
		
		// while loop
		boolean flag = true;
		int count = 0;
		while(count < 20) {
			System.out.println(count);
			count++;
		}
		
		// do-while loop
		count = 0;
		do {
			System.out.println(count);
			count++;			
		} while(count<15);
		
		// for loop
		
		for (int count2 = 0; count2 < 10; count2++) {
			System.out.println(count2 + " count");
		}

	} 

}
