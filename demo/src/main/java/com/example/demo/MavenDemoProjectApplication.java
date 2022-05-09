package com.example.demo;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import entity.EmployeeEntity;

// @SpringBootApplication
public class MavenDemoProjectApplication {

	public static void main(String[] args) {
//		SpringApplication.run(MavenDemoProjectApplication.class, args);
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session  = factory.openSession();
		Transaction t = session.beginTransaction();
		
//		String findUser = "FROM employee";
		
//		Query q = session.createQuery(findUser);
//		
//		List<EmployeeEntity> results = q.getResultList();
//		
//		for(EmployeeEntity e : results) {
//			System.out.println(e);
//		}
		
		EmployeeEntity employeeEntity = new EmployeeEntity();		
		t.commit();
		
		System.out.println("Succesfully created table");
		
		// Create User
		employeeEntity.setFirstName("James");
		employeeEntity.setCity("Minnetonka");
		employeeEntity.setEmail("email");
		employeeEntity.setSalary(400);
		session.save(employeeEntity);
		
		// employeeEntity.setEmp_id();
		// session.merge(employeeEntity) - UPDATES including the employee ID
		
		int emp_id = 1;
		EmployeeEntity e = session.load(employeeEntity.getClass(), emp_id);
		session.delete(e);
		System.out.println("user first name: " + e.getFirstName());
		
		
		factory.close();
		session.close();
	}

}
