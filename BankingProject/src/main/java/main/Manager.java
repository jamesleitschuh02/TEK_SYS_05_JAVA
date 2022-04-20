package main;

public class Manager extends Employee {
	
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

} //
