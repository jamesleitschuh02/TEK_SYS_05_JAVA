package Main;

public class Main {

	public static void main(String[] args) {
		
		// Test Case 1
		Employee one = new Manager(126534,"Peter","Chennai India",237844,65000);
		System.out.println(one.calculateSalary());
		
		//Test Case 2
		Employee two = new Trainee(29846,"Jack","Mumbai India",442085,25000);
		System.out.println(two.calculateSalary());
	}

}
