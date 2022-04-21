package main;

enum AccountTypes{
	CHECKING, SAVINGS, CREDIT
}

public class Accounts {
	
	// reference of the enum
	AccountTypes accountTypes;

	// class constructor
	public Accounts(AccountTypes accountTypes) {
		super();
		this.accountTypes = accountTypes;
	}
	
	// method of choosing account types
	public void chooseAccount() {
		switch(accountTypes) {
		case CHECKING:
			System.out.println("You chose checking");
			break;
		case SAVINGS:
			System.out.println("You chose savings");
			break;
		case CREDIT:
			System.out.println("You chose savings");
			break;
		}
	}
	
	

}
