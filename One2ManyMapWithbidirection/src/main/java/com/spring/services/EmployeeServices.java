package com.spring.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.dao.EmployeeDao;

public class EmployeeServices {

	@Autowired
	private EmployeeDao empDao;
	
}
