package connectionJDBC;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FactoryConnection {
	
	private String driverClassName = "org.mariadb.jdbc.Driver";
	private final String url = "jdbc:mariadb://localhost/classicmodels";
	private final String user = "root";
	private final String pass = "password";
	
	private static FactoryConnection factoryConnection = null;

//	Connection conn = DriverManager.getConnection(url, user, pass);
//	Driver driver = new org.mariadb.jdbc.Driver();
	
	private FactoryConnection() {
		try {
			Class.forName(driverClassName);
		}catch(ClassNotFoundException e) {
			System.out.println("Exception in Factory Connection class");
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection(url, user, pass);
		return conn;
	}
	
	public static FactoryConnection getInstance() {
		if(factoryConnection == null) {
			factoryConnection = new FactoryConnection();
		}
		return factoryConnection;
	}

}
