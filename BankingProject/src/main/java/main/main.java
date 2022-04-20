package main;

public class main {

	public static void main(String[] args) {
		// In class - Banking
		
		//OBJECT AND MEMORY SLIDE 15, 10, 8,  IMPORTANT
		
		Employee emp_one = new Employee("John", "Smith", 12345, "Sales");
		Employee emp_two = new Employee("Mark", "Smith", 12346, "Sales");
		Manager manager_one = new Manager("Bob", "Doe", 125352, "Manager", "Sales Timecards");
		Manager manager_two = new Manager();
				
		System.out.println(emp_one);
		System.out.println(emp_two);
		System.out.println(manager_one);
		System.out.println(manager_two);
		System.out.println(manager_one.getFirstname());
		manager_one.setFirstname("Johnny");
		System.out.println(manager_one.getFirstname());

	}

}
