package com.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.Stock;
import com.spring.model.StockDailyRecord;
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
	public List<StockDailyRecord> showAll(){
		
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from StockDailyRecord");
		
		List<StockDailyRecord> studentList = (List<StockDailyRecord>) query.list();
		for (StockDailyRecord student : studentList) {
			System.out.println("University_list is:"+student.getStock());
			System.out.println("University_list is:"+studentList);
		}
		
		return studentList;
		
	}
	public Stock mergestock(Stock stock) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Stock i =  (Stock) session.merge(stock);
		
		tx.commit();
		session.close();
		
		
		return i;
		
		
	}
	public Stock readStock(String stockname) {
		
		
		Session session = sessionFactory.openSession();
		String hql = "FROM Stock WHERE name = '"+stockname+"'";
		Query query = session.createQuery(hql);
		List results = query.list();
		Stock obj = null;
		if(results.size()==0){
			return new Stock();
		}else{
			obj = (Stock) results.get(0);
		}
		session.close();
		return obj;
	
		
	}
	public int saveStock(Stock stock) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		int i =  (Integer) session.save(stock);
		
		tx.commit();
		session.close();
		return i;
		
		
	}
	public int savestockDailyRecords(StockDailyRecord stockDailyRecords) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		int i =  (Integer) session.save(stockDailyRecords);
		
		tx.commit();
		session.close();
		return i;
	}

}
