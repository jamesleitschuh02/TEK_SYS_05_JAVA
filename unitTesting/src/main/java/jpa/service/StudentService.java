package jpa.service;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jpa.dao.StudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public class StudentService implements StudentDAO {

	public List<Student> getAllStudents() {
		
		List<Student> results = null;
		
		SessionFactory factory = null;
		Session session = null;
		
		try {
			factory = new Configuration().configure().buildSessionFactory();	
			session  = factory.openSession();
			
			String findUsers = "FROM Student";
		
			Query q = session.createQuery(findUsers);
				
			results = q.getResultList();
			for(Student e : results) {
				System.out.println(e);							
			}
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			session.close();
			factory.close();			
		}
		
		return results;
}

	public Student getStudentByEmail(String email) {
		
		Student student = null;
		
		SessionFactory factory = null;		
		Session session  = null;
		
		try {
			factory = new Configuration().configure().buildSessionFactory();		
			session  = factory.openSession();
			
			String findUsers = "FROM Student s WHERE s.sEmail = :email";
		
			Query q = session.createQuery(findUsers);
			q.setParameter("email", email);
		
			List<Student> result = q.getResultList();
		
			student = result.get(0);
		}catch(IndexOutOfBoundsException e) {
			System.out.println("Student not found");
		}finally {
			System.out.println(student);
			session.close();
			factory.close();
		}
		
		return student;
	}

	public boolean validateStudent(String email, String password) {
		
		boolean verification = false;
		
		SessionFactory factory = null;	
		Session session  = null;
		
		try {
			factory = new Configuration().configure().buildSessionFactory();		
			session  = factory.openSession();
			
			Student student = getStudentByEmail(email);
			
			if (student.getsEmail().equals(email) && student.getsPass().equals(password)) {
				verification = true;
			}		
		}catch (IndexOutOfBoundsException e) {
			System.out.println("Student not verified");
		}catch(NullPointerException e){
			System.out.println("this error reads");
			System.out.println(e);
		}finally {
			System.out.println(verification);
			session.close();
			factory.close();			
		}			
		
		return verification;
	}

	public void registerStudentToCourse(String email, int cId) {
		
		SessionFactory factory = null;	
		Session session  = null;
		Transaction t = null;
		
		try {
			factory = new Configuration().configure().buildSessionFactory();		
			session  = factory.openSession();
			t = session.beginTransaction();
		
			String getStudent = "FROM Student s WHERE s.sEmail = :email";
			Query q = session.createQuery(getStudent);
			q.setParameter("email", email);		
			List<Student> result = q.getResultList();
			Student student = result.get(0);		
			
			String getCourse = "FROM Course c WHERE c.cId = :cId";
			Query q2 = session.createQuery(getCourse);
			q2.setParameter("cId", cId);
			List<Course> result2 = q2.getResultList();
			Course course = result2.get(0);
			
			List<Course> temp = student.getsCourse();
		
			if(!student.getsCourse().contains(course)) {
				temp.add(course);
				student.setsCourse(temp);
			}
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			t.commit();
			session.close();
			factory.close();			
		}	
		
	}
	
	public List<Course> getStudentCourses(String email) {
		
		Student student = null;
		
		SessionFactory factory = null;
		Session session  = null;
		
		try {
			factory = new Configuration().configure().buildSessionFactory();		
			session  = factory.openSession();
			
			student = getStudentByEmail(email);
		
			System.out.println(student.getsCourse());
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			session.close();
			factory.close();			
		}
		
		return student.getsCourse();
	}
	

}
