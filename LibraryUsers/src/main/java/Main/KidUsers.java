package Main;

public class KidUsers implements LibraryUserIMPL {
	
	// Fields
	int age;
	String bookType;

	// Constructor
	public KidUsers(int age, String bookType) {
		super();
		this.age = age;
		this.bookType = bookType;
	}

	// Methods
	
	public String registerAccount() {
		
		String message;
		
		if (this.age < 12) {
			 message = "You have succesfully registered under a Kids Account";
		}
		else {
			message = "Sorry, Age must be less than 12 to register as a kid";
		}
		
		return message;		
	}

	
	public String requestBook() {
		
		String message;
		
		if (this.bookType == "Kids") {
			message = "Book issues succesfully, please return the book within 10 days";
		}
		else {
			message = "Oops, you are allowed to take only kids books";
		}
		
		return message;
	}

}
