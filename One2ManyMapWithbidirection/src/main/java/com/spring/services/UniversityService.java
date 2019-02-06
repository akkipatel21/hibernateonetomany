package com.spring.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.UniversityDao;
import com.spring.model.Department;
import com.spring.model.Employee;

@Service
public class UniversityService {
	@Autowired
	private UniversityDao universityDao;
	
	public long addData(Department dep){
		return universityDao.insertedData(dep);
		
	}
	public List<Employee> getAll(){
		return universityDao.showAll();
		
	}
}
