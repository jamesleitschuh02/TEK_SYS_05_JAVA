package Main;

public class Employee {
	
	// Fields
	
	long employeeId;
	String employeeName;
	String employeeAddress;
	long employeePhone;
	double basicSalary;
	double specialAllowance;
	double hra;
	
	// Default Constructor
	
	public Employee() {}
	
	// Constructor

	public Employee(
			long employeeId,
			String employeeName,
			String employeeAddress,
			long employeePhone,
			double basicSalary,
			double specialAllowance,
			double hra
			) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
		this.employeePhone = employeePhone;
		this.basicSalary = basicSalary;
		this.specialAllowance = specialAllowance;
		this.hra = hra;
	}
	
	public Employee(
			long employeeId,
			String employeeName,
			String employeeAddress,
			long employeePhone,
			double basicSalary
			) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
		this.employeePhone = employeePhone;
		this.basicSalary = basicSalary;
		this.specialAllowance = 250.80;
		this.hra = 1000.50;
	}
	
	// Getters and Setters

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public long getEmployeePhone() {
		return employeePhone;
	}

	public void setEmployeePhone(long employeePhone) {
		this.employeePhone = employeePhone;
	}

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}

	public double getSpecialAllowance() {
		return specialAllowance;
	}

	public void setSpecialAllowance(double specialAllowance) {
		this.specialAllowance = specialAllowance;
	}

	public double getHra() {
		return hra;
	}

	public void setHra(double hra) {
		this.hra = hra;
	}
	
	// Other Methods
	
	public double calculateSalary() {
		double salary = 
				this.basicSalary 
				+ (this.basicSalary * (this.specialAllowance/100))
				+ (this.basicSalary * (this.hra/100));
		
		return salary;
	}
	
	public double calculateTransportAllowance() {
		double transportAllowance = 
				(.10 * this.basicSalary);
		
		return transportAllowance;
	}
	
	}