package connectionJDBC;

public class Main {

	public static void main(String[] args) {
		
		EmployeeDAO employeeOne = new EmployeeDAO();
		EmployeeModel employeeModelOne = new EmployeeModel();
		
		System.out.println(employeeOne.getEmployeeById(1));

	}

}
