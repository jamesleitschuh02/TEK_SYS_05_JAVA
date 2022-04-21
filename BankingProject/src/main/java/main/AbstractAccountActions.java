package main;

public abstract class AbstractAccountActions {
	// fields
	private String bankAccount;
	
	// default constructor
	public AbstractAccountActions() {}	
	
	// constructor
	public AbstractAccountActions(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	// methods with no method body
	abstract float withdraw(int amount, int withdrawAmount);
	abstract float deposit(int amount, int depositAmount);
	
	// other methods
	public String getBankAccount() {
		return bankAccount;
	}

}
