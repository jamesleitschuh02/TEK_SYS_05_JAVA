package Main;

public class Monster {

	// Fields
	private String name;
	
	// Default Constructor
	public Monster() {}

	// Constructor
	public Monster(String name) {
		super();
		this.name = name;
	}

	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// Other Methods
	public String attack() {
		return "$%!#$ I don't know how to attack!";
	}
}