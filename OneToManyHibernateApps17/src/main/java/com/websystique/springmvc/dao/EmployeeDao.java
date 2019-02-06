package com.websystique.springmvc.dao;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.Transaction;
import org.hibernate.hql.internal.ast.tree.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.websystique.springmvc.model.Employee;
@Repository
public class EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(Employee employee) {
		Session session=sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(employee);
		tx.commit();
		session.close();
		System.out.println("the data inserted");
	}

	public Object show() {
		Session session=sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query =session.createQuery("from Employee");
		ArrayList<Employee> rows = (ArrayList<Employee>) query.list();
		for (Employee ug : rows) {
			System.out.println(rows);
		}
		
		return rows;
		//return null;
	}
	
	/*public Object show3() {
		Session session=sessionFactory.openSession();
		
		Query q = session.createQuery("from Employee ");
		Node cNode = (Node)q.uniqueResult(); // assuming Node with name C is unique...
		String cNodeParent = cNode.getFilename();
		System.out.println("Node: " + cNode.getName() + " Parent: " + cNodeParent.getName());l;
		}*/
	

	public Employee employee(String firstname) {
		System.out.println("hie1");
		Session session = sessionFactory.openSession();
		//user = (User) session.get(User.class, user.getUsername());
		String hql = "FROM Employee WHERE firstname = '"+firstname+"'";/* AND lastname='"+emp.getLastname()+"'";*/		
		Query query = session.createQuery(hql);
		List results = query.list();
		Employee obj = null;
		if(results.size()==0){
			return new Employee();
		}else{
			obj = (Employee) results.get(0);
		}
		session.close();
		return obj;
		
		// TODO Auto-generated method stub
		
	}
	
	public Employee employee1(String manager) {
		System.out.println("hie1");
		Session session = sessionFactory.openSession();
		//user = (User) session.get(User.class, user.getUsername());
		String hql = "FROM Employee WHERE manager = '"+manager+"'";/* AND lastname='"+emp.getLastname()+"'";*/		
		Query query = session.createQuery(hql);
		List results = query.list();
		Employee obj = null;
		if(results.size()==0){
			return new Employee();
		}else{
			obj = (Employee) results.get(0);
		}
		session.close();
		return obj;
		
		// TODO Auto-generated method stub
		
	}
	public Object show1() {
		Session session=sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query =session.createQuery("from Employee");
		ArrayList<Employee> rows = (ArrayList<Employee>) query.list();
		for (Employee ug : rows) {
			System.out.println(rows);
		}
		
		return rows;
		//return null;
	}

	public List<Employee> getEmployees() {
		System.out.println("hi in topic");
		Session session=sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query =session.createQuery("from Employee where manager_id is null");
		ArrayList<Employee> rows = (ArrayList<Employee>) query.list();
		for (Employee ug : rows) {
			System.out.println("if employee is null"+rows.toString());
		}
		
		return rows;
	}

	public List<Employee> getEmpData(long id) {
		System.out.println("hi in sub topic");
		Session session=sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query =session.createQuery("from Employee where manager_id "+id);
		ArrayList<Employee> rows = (ArrayList<Employee>) query.list();
		for (Employee ug : rows) {
			System.out.println("if employee is "+rows.toString());
		}
		
		return rows;
	}

	public void save1(Employee manager1) {
		Session session=sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		long i = (Long) session.save(manager1);
		tx.commit();
		session.close();
		System.out.println("the data inserted id issssss===="+i);
		
	}
	public void save2(Employee manager1) {
		Session session=sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		long  i2 =(Long) session.save(manager1);
		tx.commit();
		session.close();
		System.out.println("the data inserted id iss ====="+i2);
		
	}


	public Employee find(Employee employee) {
		System.out.println("hi in topic");
		Session session=sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query =session.createQuery("from Employee where manager_id is null");
		//ArrayList<Employee> rows = (ArrayList<Employee>) query.list();
		List results = query.list();
		Employee obj = null;
		if(results.size()==0){
			return  new Employee();
		}else{
			obj = (Employee) results.get(0);
		}
		session.close();
		return  obj;
		
	}

	public Employee employee6(String lastname) {
		System.out.println("hie1");
		Session session = sessionFactory.openSession();
		//user = (User) session.get(User.class, user.getUsername());
		String hql = "FROM Employee WHERE lastname = '"+lastname+"'";/* AND lastname='"+emp.getLastname()+"'";*/		
		Query query = session.createQuery(hql);
		List results = query.list();
		Employee obj = null;
		if(results.size()==0){
			return new Employee();
		}else{
			obj = (Employee) results.get(0);
		}
		session.close();
		return obj;
	}

	public void save3(Employee employee) {
		Session session=sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		long  i3 =(Long) session.save(employee);
		tx.commit();
		session.close();
		System.out.println("the data inserted id iss ====="+i3);
		
	}

	public Employee findemployee(Employee employee, Long employeeId) {
		System.out.println("findemployee hie1");
		System.out.println("in daooo#######"+""+employeeId);
		Session session = sessionFactory.openSession();
		//user = (User) session.get(User.class, user.getUsername());
		String hql = "FROM Employee WHERE manger_id = '"+employeeId+"'";/* AND lastname='"+emp.getLastname()+"'";*/		
		Query query = session.createQuery(hql);
		List results = query.list();
		Employee obj = null;
		if(results.size()==0){
			System.out.println("findemployee hie1");
			return new Employee();
		}else{
			System.out.println("findemployee hie3");
			obj = (Employee) results.get(0);
		}
		session.close();
		return obj;
	
		
		//return employee;
		
	}

	public List<Employee> showall() {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query query =session.createQuery("from Employee where manager_id is null");
		ArrayList<Employee> rows = (ArrayList<Employee>) query.list();
		session.close();
		for (Employee ug : rows) {
			System.out.println(rows);
		}
		
		return rows;
		
	}

	
	
	
	
}
