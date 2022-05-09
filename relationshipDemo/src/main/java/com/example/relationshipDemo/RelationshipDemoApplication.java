package com.example.relationshipDemo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.Set;

import entity.CohortEntity;
import entity.DepartmentEntity;
import entity.TeacherEntity;

//@SpringBootApplication
public class RelationshipDemoApplication {

	public static void main(String[] args) {
//		SpringApplication.run(RelationshipDemoApplication.class, args);
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction t = session.beginTransaction();
		
//		DepartmentEntity it_dept = new DepartmentEntity();
//		it_dept.setDeptName("IT");
//		
//		DepartmentEntity hr_dept = new DepartmentEntity();
//		hr_dept.setDeptName("HR");
		
//		TeacherEntity t4 = new TeacherEntity();
//		t4.setTeacherName("Dave");
//		t4.setSalary("70k");
////		t1.setDepartment(it_dept);
//		
//		TeacherEntity t5 = new TeacherEntity();
//		t5.setTeacherName("charles");
//		t5.setSalary("80k");
////		t2.setDepartment(hr_dept);
//		
//		TeacherEntity t6 = new TeacherEntity();
//		t6.setTeacherName("suzanne");
//		t6.setSalary("34k");
////		t3.setDepartment(hr_dept);
//		
////		session.save(hr_dept);
////		session.save(it_dept);
//		
//		List<TeacherEntity> teacherList = new ArrayList<>();
//		teacherList.add(t4);
//		teacherList.add(t5);
//		teacherList.add(t6);
//		session.save(t4);
//		session.save(t5);
//		session.save(t6);
//		
//		DepartmentEntity dept = new DepartmentEntity();
//		dept.setDeptName("Development");
//		dept.setTeacherList(teacherList);
		
		CohortEntity c1 = new CohortEntity();
		c1.setCohortName("TekSystems 05");
		c1.setDuration("12 weeks");
		
		CohortEntity c2 = new CohortEntity();
		c2.setCohortName("TekSystems 02");
		c2.setDuration("14 weeks");
		
		CohortEntity c3 = new CohortEntity();
		c3.setCohortName("TekSystems 03");
		c3.setDuration("16 weeks");
		
		session.save(c1);
		session.save(c2);
		session.save(c3);
		
		Set<CohortEntity> classSetOne = new HashSet<>();
		classSetOne.add(c1);
		classSetOne.add(c2);
		classSetOne.add(c3);
		
		Set<CohortEntity> classSetTwo = new HashSet<>();
		classSetOne.add(c2);
		classSetOne.add(c1);
		classSetOne.add(c3);
		
		TeacherEntity t1000 = new TeacherEntity();
		t1000.setTeacherName("James");
		
		t.commit();
		session.close();
		

	}

}
