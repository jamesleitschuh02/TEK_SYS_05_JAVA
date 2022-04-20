package Main;

public class Trainee extends Employee {
	
	// Default Constructor
	
	public Trainee() {}

	// Constructor
	
	public Trainee(
			long employeeId, 
			String employeeName, 
			String employeeAddress, 
			long employeePhone, 
			double basicSalary 
			) {
		super(
				employeeId,
				employeeName,
				employeeAddress,
				employeePhone,
				basicSalary
				);
		
	}

}
