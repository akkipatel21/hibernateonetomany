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
	
	public University insertedData(University uni){
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		University i =  (University) session.merge(uni);
		
		tx.commit();
		session.close();
		return i;
		
	}
	@SuppressWarnings("unchecked")
	public List<Student> showAll(){
		
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Student");
		
		List<Student> studentList = (List<Student>) query.list();
		for (Student student : studentList) {
			System.out.println("University_list is:"+student.getUniversity());
			System.out.println("University_list is:"+studentList);
		}
		
		return studentList;
		
	}
	public List<University> showUniversity() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from University");
		List<University> uniList = (List<University>) query.list();
		for (University student : uniList) {
			System.out.println("getUid is:"+student.getUid());
			System.out.println("getCountry is:"+student.getCountry());
			System.out.println("getUniversityName is:"+student.getUniversityName());
			System.out.println("University_list is:"+uniList);
		}
		return uniList;
	}

}
