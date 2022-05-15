package jpa.mainrunner;

import java.util.ArrayList;
import java.util.Scanner;

import antlr.collections.List;
import jpa.entitymodels.Course;
import jpa.service.CourseService;
import jpa.service.StudentService;

public class SMSRunner {
	public static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		
		// Talked to Kevin about manyTomany relationship and program functionality only to what is shown on SBA page

		StudentService student = new StudentService();
		CourseService course = new CourseService();
		
		
		Integer choice = 0;
		while ( choice != 2) {
			System.out.println("Select an action: "
					+ "\n1. Login to student account"
					+ "\n2. Quit");
			choice = reader.nextInt();
			switch(choice){
				case 1: 
					reader.nextLine();
					
					System.out.println("Enter your email:\n");
					String email = reader.nextLine();
					
					System.out.println("Enter your password:\n");
					String password = reader.nextLine();
					
					if(student.validateStudent(email, password)) {
						Integer cNum = 0;
						
						while(cNum != 3) {	
							
							System.out.println("Select a new action:"
									+ "\n1. Register to course"
									+ "\n2. View current registered courses"
									+ "\n3. Logout");
							cNum = reader.nextInt();
							switch(cNum) {
								case 1:
									ArrayList<Course> courseList = (ArrayList<Course>) course.getAllCourses();
									System.out.println("\nSelect a course");
									for (int i = 0; i < courseList.size(); i++) {
										System.out.println((i+1) + ". " + courseList.get(i).getcName());
									}
									int courseNum = reader.nextInt();
									student.registerStudentToCourse(email, courseNum);
									break;
								case 2:
									int size = student.getStudentCourses(email).size();
									ArrayList<String> studentCourseList = new ArrayList<String>(size);
									for (int i = 0; i < size; i++ ) {
										studentCourseList.add(student.getStudentCourses(email).get(i).getcName());
									}
									System.out.println("Current registered courses:\n");
									for (int i = 0; i < studentCourseList.size(); i++) {
										System.out.println(studentCourseList.get(i));
									}
									System.out.println("\n");
									break;
								case 3:
									System.out.println("Logged out\n");
									break;
								default:
									break;
							}
							}						
					}else {
						System.out.println("get outta here\n");
					}
					break;
				case 2: 
					System.out.println("Have a nice day");
					break;
				default:
					break;
			}
		}
		
		reader.close();		

	}

}
