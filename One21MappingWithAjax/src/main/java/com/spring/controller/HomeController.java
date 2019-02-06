package com.spring.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.model.Address;
import com.spring.model.Employee;
import com.spring.services.EmployeeService;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private EmployeeService empServ;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.");
		return "employee";
	}
	@RequestMapping(value = "insertData", method = RequestMethod.POST ,produces="application/json")
	@ResponseBody
	public String addEmp(@RequestParam("fname")String fname,
			@RequestParam("lname")String lname,
			@RequestParam("salary")double salary,
			@RequestParam("state")String state,
			@RequestParam("city")String city, Model model) {
		logger.info("Welcome addEmp()");
		logger.info("fname"+fname);
		logger.info("lname"+lname);
		logger.info("salary"+salary);
		logger.info("state"+state);
		logger.info("city"+city);
		Employee empModel = new Employee();
		empModel.setFirstname(fname);
		empModel.setLastname(lname);
		empModel.setSalary(salary);
		Address empAdd = new Address();
		//empAdd.setId(empModel);
		empAdd.setState(state);
		empAdd.setCity(city);
		empModel.setAddress(empAdd);
		empAdd.setEmployee(empModel);
		String result="";
		int i = empServ.insertData(empModel);
		if(i != 0){
			logger.info("InsertData successFully......!!!!!!!!");
			result = "1";
		}else{
			logger.info("Inserdata Not SuccessFully.....!!!!!");
			result = "0";
		}
		
		return result;
	}
	@RequestMapping(value = "showAll", method = RequestMethod.GET,produces="application/json")
	@ResponseBody
	public ArrayList<Employee> showAll(Locale locale, Model model) {
		logger.info("Welcome showAll()");
		//model.addAttribute("show",empServ.getAll());
		ArrayList<Employee> employeeList = empServ.getAll();
		return employeeList;
	}
	
}
