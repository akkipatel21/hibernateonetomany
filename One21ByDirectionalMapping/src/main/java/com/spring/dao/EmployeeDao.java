package com.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.Employee;


@Repository
public class EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public int addEmployee(Employee empModel){
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		int i = (Integer) session.save(empModel);
		tx.commit();
		session.close();
		
		
		return i;
		
	}

    @SuppressWarnings("unchecked")
	public ArrayList<Employee> showAll(){
		Session session= sessionFactory.openSession();
		Query query =session.createQuery("from Employee");
		ArrayList<Employee> rows = (ArrayList<Employee>) query.list();
		
	/*	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jcg-JPA");
		EntityManager em = emf.createEntityManager();
		Query q = (Query) em.createNativeQuery("SELECT * from Student");
		@SuppressWarnings("unchecked")
		ArrayList<Student> list = (ArrayList<Student>) ((javax.persistence.Query) query).getResultList();
		System.out.println("native>>>");*/
		for (Employee emp : rows) {
			System.out.println(rows);
		}
		return rows;

	}

}
