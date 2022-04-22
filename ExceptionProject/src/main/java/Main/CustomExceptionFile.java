package Main;

public class CustomExceptionFile extends Exception {
	
	private double amount;
	
	public CustomExceptionFile(double amount) {
		this.amount = amount;
	}
	
	public double getAmount() {
		return amount;
	}

}