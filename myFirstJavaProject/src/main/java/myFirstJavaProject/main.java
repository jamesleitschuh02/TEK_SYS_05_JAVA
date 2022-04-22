package myFirstJavaProject;

import java.util.Scanner;

public class main {

	//Start
	//Runner
	//Slide 11
	//slide 18
	//slide 19
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "James";
		
		//Execute Statement
		System.out.print("Hello! " + name);
		
		// whole numbers only
		int number = 120;
		
		//Wrapper
		Integer num = 203;
		
		//primitive data types
		int number2= 1;
		char charValue = 'a';
		byte byteNumber = 41;
		long longNumber = 123456789;
		boolean truthOrFalse = true;
		
		double radius;
		double area;
		
		radius = 20;
		
		area = radius * radius * 3.14159;
		
		System.out.println(" The area is " + area);
		
		char a = 'b';
		float paycheck = 1234.897f;
		
		int x = 5;
		int result = x + 5;
		System.out.println(result);
		
		//Scanner class - Create Scanner using Keyword
		Scanner userInput = new Scanner(System.in);
		
		//Open Scanner
		System.out.println("Enter your name: ");
		String firstName = userInput.nextLine();
		
		System.out.println(firstName);
		
		//Close Scanner
		userInput.close();

}
}
