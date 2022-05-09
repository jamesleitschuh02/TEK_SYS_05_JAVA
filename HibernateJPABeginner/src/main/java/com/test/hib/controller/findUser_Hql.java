package com.test.hib.controller;

import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.test.hib.model.User;

public class findUser_Hql {
	public void findUser() {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

	    String hql = "FROM User";
 	    Query query = session.createQuery(hql);
	    List<User> results = query.getResultList();
	    for (User u : results) {
	    	 System.out.println("User Id: " +u.getId() + "|" + " Full name:" + u.getFullname() +"|"+ "Email: " + u.getEmail() +"|"+ 
	    			 "password" + u.getPassword());
	    }
	}
}
