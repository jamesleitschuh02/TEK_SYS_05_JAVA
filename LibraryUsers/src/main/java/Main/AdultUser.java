package Main;

public class AdultUser implements LibraryUserIMPL {
	
	//Fields	
	int age;
	String bookType;
	
	// Constructor
	public AdultUser(int age, String bookType) {
		super();
		this.age = age;
		this.bookType = bookType;
	}

	// Methods
	
	public String registerAccount() {
		
		String message;
		
		if (this.age > 12) {
			 message = "You have succesfully registered under a Adult Account";
		}
		else {
			message = "Sorry, Age must be greater than 12 to register as an adult";
		}
		
		return message;		
	}

	
	public String requestBook() {
		
		String message;
		
		if (this.bookType == "Fiction") {
			message = "Book issues succesfully, please return the book within 7 days";
		}
		else {
			message = "Oops, you are allowed to take only adult fiction books";
		}
		
		return message;		
	}



}