package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class EmployeeEntity {
	// column id, generated value
	@Column(name="emp_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer emp_id;
	private String firstName;
	private String email;
	private int age;
	private double salary;
	private String city;
	
	public EmployeeEntity() {}

	public EmployeeEntity(Integer emp_id, String firstName, String email, int age, double salary, String city) {
		this.emp_id = emp_id;
		this.firstName = firstName;
		this.email = email;
		this.age = age;
		this.salary = salary;
		this.city = city;
	}

	public Integer getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "EmployeeEntity [emp_id=" + emp_id + ", firstName=" + firstName + ", email=" + email + ", age=" + age
				+ ", salary=" + salary + ", city=" + city + "]";
	}

}