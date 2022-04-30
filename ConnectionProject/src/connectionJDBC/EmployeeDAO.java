package connectionJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO {
	
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet resultSet = null;
	
	public EmployeeDAO() {
		
	}
	
	public Connection getConnection() throws SQLException {
		Connection conn;
		conn = FactoryConnection.getInstance().getConnection();
		return conn;
	}
	
	public EmployeeModel getEmployeeById(int id) {
		EmployeeModel employee = new EmployeeModel();
		try {
			String queryString = "SELECT * FROM employees";
			connection = getConnection();
			ps = connection.prepareStatement(queryString);
			
			resultSet = ps.executeQuery();
			
			while(resultSet.next()) {
					System.out.println("EmployeeNumber: " + resultSet.getInt("employeeNumber")
					+ " First name " + resultSet.getString("firstName")
					+ " Last Name " + resultSet.getString("lastName")
					+ " Job Title " + resultSet.getString("jobTitle"));
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		return employee;
	}

}