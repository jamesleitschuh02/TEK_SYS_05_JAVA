package jpa.service;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jpa.dao.CourseDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public class CourseService implements CourseDAO {

	public List<Course> getAllCourses() {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();	
		Session session  = factory.openSession();
		Transaction t = session.beginTransaction();
		
		String findCourses = "FROM Course";
		
		Query q = session.createQuery(findCourses);
		
		List<Course> results = null;
		
		try {
			results = q.getResultList();
			for(Course e : results) {
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
	
	public Course getCourseById(int cId) {
		
		Course course = null;
		
		SessionFactory factory = null;		
		Session session  = null;
		
		try {
			factory = new Configuration().configure().buildSessionFactory();		
			session  = factory.openSession();
			
			String findCourse = "FROM Course c WHERE c.cId = :cId";
		
			Query q = session.createQuery(findCourse);
			q.setParameter("cId", cId);
		
			List<Course> result = q.getResultList();
		
			course = result.get(0);
		}catch(IndexOutOfBoundsException e) {
			System.out.println("Course not found");
		}finally {
			System.out.println(course);
			session.close();
			factory.close();
		}
		
		return course;
	}

}
