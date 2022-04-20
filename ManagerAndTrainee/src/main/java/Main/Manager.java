package Main;

public class Manager extends Employee{
	
	// Default Constructor
	
	public Manager() {}

	// Constructor
	
	public Manager(
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
	
	// Other Methods
	
	@Override
	public double calculateTransportAllowance() {
		double transportAllowance = 
				(.15 * this.basicSalary);
		
		return transportAllowance;
	}
	
}
