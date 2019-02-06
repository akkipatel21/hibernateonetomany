package com.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.Student;
import com.spring.model.University;

@Repository
public class UniversityDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void insertedData(University uni){
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		//University i =  (University) session.merge(uni);
		session.persist(uni);
		System.out.println("inerted"+session);
		tx.commit();
		session.close();
		//return i;
		
	}
	@SuppressWarnings("unchecked")
	public List<Student> showAll(){
		
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Student");
		
		List<Student> studentList = query.list();
		for (Student student : studentList) {
			System.out.println("University_list is:"+student.getUniversity().getUniversityName());
			System.out.println("University_list is:"+student);
		}
		
		return studentList;
		
	}

}
