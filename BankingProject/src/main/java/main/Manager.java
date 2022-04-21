package main;

public class Manager extends Employee implements AccountsActionsIMPL {
	
	// fields
	private String timeCards;
	
	// default constructor
	public Manager() {}

	// constructor
	public Manager(String firstname, String lastName, long emp_id, String jobTitle, String timeCards) {
		super(firstname, lastName, emp_id, jobTitle);
		this.timeCards = timeCards;
	}

	// getters and setters
	public String getTimeCards() {
		return timeCards;
	}

	public void setTimeCards(String timeCards) {
		this.timeCards = timeCards;
	}

	// other methods
	@Override
	public String toString() {
		return "Manager [timeCards=" + timeCards + "]";
	}

	@Override
	public void withdraw(float amount, float withdrawAmount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deposit(float amount, float depositAmount) {
		// TODO Auto-generated method stub
		
	}
	
	public void PrintThis(int ...val) {
		for(int i : val) {
			System.out.println(i);
		}
	}

} //
