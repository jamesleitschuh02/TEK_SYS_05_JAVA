package main;

public class Employee {
	// java oop slides 14

		// fields
		// encapsulation slide 3
		// inheritance 27
		private String firstname;
		private String lastName;
		private long emp_id;
		private String jobTitle;
		
		// default constructor
		public Employee() {}
		
		// Constructor
		public Employee(String firstname, String lastName, long emp_id, String jobTitle) {
			super();
			this.firstname = firstname;
			this.lastName = lastName;
			this.emp_id = emp_id;
			this.jobTitle = jobTitle;
		}

		// Getters and Setters
		public String getFirstname() {
			return firstname; 
		}

		// void means we're not returning anything
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public long getEmp_id() {
			return emp_id;
		}

		public void setEmp_id(long emp_id) {
			this.emp_id = emp_id;
		}

		public String getJobTitle() {
			return jobTitle;
		}

		public void setJobTitle(String jobTitle) {
			this.jobTitle = jobTitle;
		}

		
		// other methods
		@Override
		public String toString() {
			return "employee [firstname="
					+ firstname + ","
					+ " lastName=" + lastName + ", emp_id="
					+ emp_id + ", jobTitle="
					+ jobTitle + "]";
		}
}
