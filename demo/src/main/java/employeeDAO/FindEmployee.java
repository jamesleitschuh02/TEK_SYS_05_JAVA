package employeeDAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import entity.EmployeeEntity;

public class FindEmployee {

	public void findEmp() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		String findUserString = "FROM employee";

		Query q = session.createQuery(findUserString);

		List<EmployeeEntity> results = q.getResultList();

		for (EmployeeEntity e : results) {
			System.out.println("user id: " + e.getEmp_id() + " first name " + e.getFirstName());
		}
	}

}
