package com.spring.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.w3c.dom.ls.LSInput;

import com.spring.model.Department;
import com.spring.model.Employee;

@Repository
public class UniversityDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public long insertedData(Department dep){
		//System.out.println("");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("Before inserted id "+dep.getDepartmentId());
		long i =  (Long) session.save(dep);
		System.out.println("After inserted id "+dep.getDepartmentId());
		tx.commit();
		session.close();
		return i;
		
	}
	@SuppressWarnings("unchecked")
	public List<Employee> showAll(){
		
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Employee");
		
		List<Employee> employeeList =   query.list();
		for (Employee employee : employeeList) {
			System.out.println("University_list is:"+employee.getDepartment().getDepartmentId());
			System.out.println("University_list is:"+employeeList);
		}
		
		return employeeList;
		
	}

}
