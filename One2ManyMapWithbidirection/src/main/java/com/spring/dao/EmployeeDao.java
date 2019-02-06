package com.spring.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;
}
