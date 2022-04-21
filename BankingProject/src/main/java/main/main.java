package main;

public class main {

	public static void main(String[] args) {
		// In class - Banking
		
		//OBJECT AND MEMORY SLIDE 15, 10, 8,  IMPORTANT
		
		Employee emp_one = new Employee("John", "Smith", 12345, "Sales");
		Employee emp_two = new Employee("Mark", "Smith", 12346, "Sales");
		Manager manager_one = new Manager("Bob", "Doe", 125352, "Manager", "Sales Timecards");
		Manager manager_two = new Manager();
		manager_one.PrintThis(1,2,3,4,5,6,7537,5);
				
//		System.out.println(emp_one);
//		System.out.println(emp_two);
//		System.out.println(manager_one);
//		System.out.println(manager_two);
//		System.out.println(manager_one.getFirstname());
//		manager_one.setFirstname("Johnny");
//		System.out.println(manager_one.getFirstname());
		
		Box<Integer> intBox = new Box<Integer>();
		intBox.add(234);
		intBox.add(34);
		intBox.add(878734);
		intBox.add(874);
		
		System.out.println(intBox.get());
		
		Box<String> strBox = new Box<String>();
		strBox.add("hi");
		strBox.add("james");
		strBox.add("wers");
		strBox.add("words");
		
		System.out.println(strBox.get());
		

	}

}
