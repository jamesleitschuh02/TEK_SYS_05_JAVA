package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {

	public static void main(String[] args) throws CustomExceptionFile {
		
		// Exceptions
		
		// try {} catch {} finally {}

		try {
		File myFile = new File("text.txt");
		FileReader fr = new FileReader(myFile);
		int num[] = {1,2,3,4};
		System.out.println(num[1]);
		}
		catch(FileNotFoundException e) {
		e.printStackTrace();
		}
		catch(ArrayIndexOutOfBoundsException ea){
			ea.printStackTrace();
		}
		finally {
			System.out.println("Everything is working");
		}
		

	} //public static void main


	// public static void withdraw(double amount) throws CustomExceptionFile{
	// 	if (amount <= balance) {
	// 		balance -= amount;
	// 	} else {
	// 		double accountBelow = amount - balance;
	// 		throw new CustomExceptionFile(accountBelow);
	// 	}
	// }
 
} // main