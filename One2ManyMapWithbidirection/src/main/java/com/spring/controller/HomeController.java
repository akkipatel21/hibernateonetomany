package com.spring.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.model.Department;
import com.spring.model.Employee;
import com.spring.services.EmployeeServices;
import com.spring.services.UniversityService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private UniversityService univerService;
	
	/*@Autowired
	private EmployeeServices empServ;*/
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		return "student";
	}
	@RequestMapping(value = "insertData", method = RequestMethod.POST,produces="application/json")
	@ResponseBody
	public String insertData(/*@RequestParam("departmentId") int departmentId,*/
			@RequestParam("departmentName")String departmentName,
			@RequestParam("firstname")String firstname,
			@RequestParam("lastname")String lastname,
			@RequestParam("section")String section, Model model) {
		logger.info("departmentName"+departmentName);
		logger.info("universityName"+departmentName);
		logger.info("firstname"+firstname);
		logger.info("lastname"+lastname);
		logger.info("section"+section);
		
		Department dep =new Department();
		dep.setDepartmentName(departmentName);
		//dep.setDepartmentId(departmentId);
		
		
		//List<Employee> ep=new ArrayList<Employee>();
		Employee emp = new Employee();
		emp.setFirstname(firstname);
		emp.setLastname(lastname);
		emp.setSection(section);
		emp.setDepartment(dep);
		//ep.add(emp);
		List<Employee> employees = new ArrayList<Employee>(); 
		employees.add(emp);
		dep.setEmployees(employees);
		//dep.setEmployees(ep);
		long un=0;
		System.out.println("controller id is:"+dep.getDepartmentId());
		//if(dep.getDepartmentId()==0){
		un=univerService.addData(dep);
		System.out.println("controller id is:"+dep.getDepartmentId());
		//}
		String result ="";
		if(un>0){
			logger.info("Data inserted Successfully....!!!!! ");
			result = "1";
		}else{
			logger.info("Datas donot inserted  Successfully....!!!!! ");
			result = "0";
		}
		
		return result;
	}
	@RequestMapping(value = "showAll", method = RequestMethod.GET,produces="application/json")
	@ResponseBody
	public List<Employee> showAll(Locale locale, Model model) {
		logger.info("Welcome showAll()");
		//model.addAttribute("show", univerService.getAll());
		List<Employee> employeeList = univerService.getAll();
		return employeeList;
	}
	
}
