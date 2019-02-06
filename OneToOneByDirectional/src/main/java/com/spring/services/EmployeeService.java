package com.spring.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.EmployeeDao;
import com.spring.model.Employee;

@Service
@Transactional
public class EmployeeService {
	
	@Autowired
	private EmployeeDao empDao;
	
	@Transactional
	public int insertData(Employee empModel){
		return empDao.addEmployee(empModel);
		
	}
	@Transactional
	public ArrayList<Employee> getAll(){
		return empDao.showAll();
		
	}
                                                      
}
