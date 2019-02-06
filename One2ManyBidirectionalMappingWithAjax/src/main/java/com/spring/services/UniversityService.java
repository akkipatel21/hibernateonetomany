package com.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.UniversityDao;
import com.spring.model.Stock;
import com.spring.model.StockDailyRecord;
import com.spring.model.Student;
import com.spring.model.University;

@Service
public class UniversityService {
	@Autowired
	private UniversityDao universityDao;
	
	public University addData(University uni){
		return universityDao.insertedData(uni);
		
	}
	public List<StockDailyRecord> getAll(){
		return universityDao.showAll();
		
	}
	public Stock mergestock(Stock stock) {
		
		return universityDao.mergestock(stock);
	}
	public Stock readStock(String stockname) {
		
		return universityDao.readStock(stockname);
	}
	public int saveStock(Stock stock) {
		return universityDao.saveStock(stock);
		
	}
	public int savestockDailyRecords(StockDailyRecord stockDailyRecords) {
		return universityDao.savestockDailyRecords(stockDailyRecords) ;

	}
}
