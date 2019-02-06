package com.spring.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.rmi.CORBA.Stub;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.model.Stock;
import com.spring.model.StockDailyRecord;

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
	@RequestMapping(value = "insertData", method = RequestMethod.POST,produces="application/json")
	@ResponseBody
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
		
	/*	System.out.println("START");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Stock stock = null;
		
        stock.setName("tata");
        session.merge(stock);
		
		stock = readStock("l&t");
		if(stock.getId() == null || stock.getId()==0){
			stock.setName("l&t");
	        session.save(stock);
	        
	        StockDailyRecord stockDailyRecords = new StockDailyRecord();
	        stockDailyRecords.setName("l&t pipe..new");
	        
	        stockDailyRecords.setStock(stock);
	        stock.getStockDailyRecords().add(stockDailyRecords);
	        session.save(stockDailyRecords);
		}else{
			StockDailyRecord stockDailyRecords = new StockDailyRecord();
	        stockDailyRecords.setName("l&t pipe..old");
	        
	        stockDailyRecords.setStock(stock);
	        session.save(stockDailyRecords);
		}
		session.getTransaction().commit();
		System.out.println("END OK");
	}
	
	private static Stock readStock(String nm) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		String hql = "FROM Stock WHERE name = '"+nm+"'";
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
	}*/
		
		University uni =new University();
		uni.setUniversityName(universityName);
		uni.setCountry(country);
		
		List<Student> st=new ArrayList<Student>();
		Student stu1 = new Student();
		stu1.setFirstname(firstname);
		stu1.setLastname(lastname);
		stu1.setSection(section);
		stu1.setUniversity(uni);
		st.add(stu1);
		uni.setStudents(st);
		University un=univerService.addData(uni);
		String result ="";
		if(un.getUid()>0){
			logger.info("Data inserted Successfully....!!!!! ");
			result = "1";
		}else{
			logger.info("Datas donot inserted  Successfully....!!!!! ");
			result = "0";
		}
		
		return result;
	}
	/*@RequestMapping(value = "showAll", method = RequestMethod.GET,produces="application/json")
	@ResponseBody
	public List<Student> showAll(Locale locale, Model model) {
		logger.info("Welcome showAll()");
		//model.addAttribute("show", univerService.getAll());
		//List<Student> studentlist = univerService.getAll();
		//return studentlist;
	}*/
	
	@RequestMapping(value = "addData", method = RequestMethod.POST)
	public String addData(@RequestParam("stockname")String stockname,
			@RequestParam("name")String name, Model model) {
		logger.info("Welcome addData()");
		
		Stock stock = null;
			System.out.println("START");
	
		stock = univerService.readStock(stockname);
		if(stock.getId() == null || stock.getId()==0){
			stock.setStockName(stockname);
	        int  id = univerService.saveStock(stock);
	        
	        StockDailyRecord stockDailyRecords = new StockDailyRecord();
	        stockDailyRecords.setName(name);
	        
	        stockDailyRecords.setStock(stock);
	        stock.getStockDailyRecords().add(stockDailyRecords);
	       int id1= univerService.savestockDailyRecords(stockDailyRecords);
		}else{
			StockDailyRecord stockDailyRecords = new StockDailyRecord();
	        stockDailyRecords.setName(name);
	        
	        stockDailyRecords.setStock(stock);
	       int id= univerService.savestockDailyRecords(stockDailyRecords);
		}
		stock.setStockName(stockname);
        stock = univerService.mergestock(stock);
		
		System.out.println("END OK");
	
	
	
		return "redirect:showStudent";
	}
	@RequestMapping(value = "showAll2", method = RequestMethod.GET,produces="application/json")
	@ResponseBody
	public String showAll2(Locale locale, Model model) {
		logger.info("Welcome showAll()");
		//model.addAttribute("show", univerService.getAll());
		//List<Student> studentlist = univerService.getAll();
		model.addAttribute("show", univerService.getAll());
		return "showStudent";
	}
	
}
