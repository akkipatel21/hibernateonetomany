package com.spring.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.rmi.CORBA.Stub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.model.Student;
import com.spring.model.University;
import com.spring.services.UniversityService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private UniversityService univerService;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		return "student";
	}
	@RequestMapping(value = "insertData", method = RequestMethod.POST)
	public String insertData(@RequestParam("universityName")String universityName,
			@RequestParam("country")String country,
			@RequestParam("firstname")String firstname,
			@RequestParam("lastname")String lastname,
			@RequestParam("section")String section, Model model) {
		logger.info("universityName"+universityName);
		logger.info("country"+country);
		logger.info("firstname"+firstname);
		logger.info("lastname"+lastname);
		logger.info("section"+section);
		
		University uni =new University();
		uni.setUniversityName(universityName);
		uni.setCountry(country);
		
		Student stu1 = new Student();
		stu1.setFirstname(firstname);
		stu1.setLastname(lastname);
		stu1.setSection(section);
		
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(stu1);
		uni.setStudents(studentList);
		stu1.setUniversity(uni);
		/*University i =*/ univerService.addData(uni);
		/*String result ="";
		if(i.getUid()>0){
			logger.info("Data inserted Successfully....!!!!! ");
			result = "redirect:showAll";
		}else{
			logger.info("Datas donot inserted  Successfully....!!!!! ");
			result = "redirect:student";
		}
		*/
		return "redirect:showAll";
	}
	@RequestMapping(value = "showAll", method = RequestMethod.GET)
	public String showAll(Locale locale, Model model) {
		logger.info("Welcome showAll()");
		model.addAttribute("show", univerService.getAll());
		return "showStudent";
	}
	
}
