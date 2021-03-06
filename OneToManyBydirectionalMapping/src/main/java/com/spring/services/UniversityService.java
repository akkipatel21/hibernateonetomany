package com.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.UniversityDao;
import com.spring.model.Student;
import com.spring.model.University;

@Service
public class UniversityService {
	@Autowired
	private UniversityDao universityDao;
	
	public void addData(University uni){
		universityDao.insertedData(uni);
		//return universityDao.insertedData(uni);
		
	}
	public List<Student> getAll(){
		return universityDao.showAll();
		
	}
}
