package com.websystique.springmvc.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import com.spring.dao.MeetingDao;
//import com.spring.model.Employee;
//import com.spring.model.EmployeeMeeting;
//import com.spring.model.Group;
//import com.spring.model.Meeting;
//import com.spring.model.User;
//import com.spring.model.UserGroup;

import org.springframework.web.bind.annotation.RequestParam;





//import com.spring.bean.EmpData;
import com.websystique.springmvc.dao.EmployeeDao;
import com.websystique.springmvc.model.EmpData;
import com.websystique.springmvc.model.Employee;
//import com.websystique.springmvc.model.Manager;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	

	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	long startTime = System.currentTimeMillis();
	
	@Autowired
	private EmployeeDao employeeDao;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		long startTime = System.currentTimeMillis();
		logger.info("Welcome home! The client locale is {}.", locale);
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("/time"+totalTime);
		return "employee";
	}
	
	@Transactional
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(@RequestParam("firstname")String firstname,
			@RequestParam("lastname")String lastname,@RequestParam("manager")String manager
			, Model model) {
		logger.info("save");
		System.out.println("save");
		System.out.println("firstname :"+firstname);
		System.out.println("lastname :"+lastname);
		System.out.println("manager :"+manager);
		
		logger.info("firstname"+firstname);
		logger.info("lastname"+lastname);
		//logger.info("manager"+manager);
		Employee empployee =null;
		Employee empployee1 =null;
		//Employee emp1 =null;
		
		empployee = employeeDao.employee(firstname);
		empployee1 = employeeDao.employee6(lastname);
		System.out.println("if surname is same then id is"+empployee1.getEmployeeId());
		//emp = employeeDao.employee1(manager);
		if(((empployee.getEmployeeId()==null)||(empployee.getEmployeeId()==0))&&
				((empployee1.getEmployeeId()==null)||(empployee1.getEmployeeId()==0))){
		
		
		 
	        
		 Employee  employee1 = new Employee(firstname, lastname);
		// employeeDao.save(employee1);
		 //employee1.setManager(employee1);
		 Employee manager1 = new Employee(firstname,lastname);
		 manager1.setManager(employee1);
		 	//employee1.setManager(employee1);
		 employee1.getSubordinates().add(employee1);
	        employeeDao.save1(employee1);
		}
			
			//List<Employee>empdata =employeeDao.showall();
	        //Employee employee = new Employee(firstname, lastname);
	        //employee.getSubordinates().add(employee);
			// Employee emp =employeeDao.find(employee);
			else if(((empployee1.getLastname()==lastname))){
				//&& (empployee.getFirstname()==firstname) employee firstname is same and last name
				//employee1.setManager(empployee1);
				//System.out.println("(empployee1.getLastname()==lastname)======"+empployee1.getLastname()==lastname);
				for (Employee empdat : empdata) {
					
				
				System.out.println("hieeee====lastname is same then call");
				//Employee employee = new Employee(firstname,lastname);
				empdat.setFirstname(firstname);
				empdat.setLastname(lastname);
				empdat.setManager(empployee1);
				//System.out.println("hieeee====lastname is same then call manager id"+employee.getManager_id());
				//employeeDao.find
				//employee.setManager(empployee1);
				
				//System.out.println("empployee1.getid"+empployee1.getManager_id());
				//System.out.println("hieeee====lastname is same then call manager id"+employee.getManager_id());
				//employee.getSubordinates().add(employee);
				empdat.getSubordinates().add(empdat);
				
				
		        employeeDao.save3(empdat);
				}
			}else{
				for (Employee empdat2 : empdata) {
					
				
				// if(((empployee1.getLastname()!=lastname)&& (empployee.getFirstname()==firstname))) only first name is same
				System.out.println("hieeee====lastname is notttt same then call");
				//Employee employee1 = new Employee(firstname,lastname);
				empdat2.setFirstname(firstname);
				empdat2.setLastname(lastname);
				empdat2.setManager(empployee);
				//System.out.println("hieeee====lastname is same then call manager id"+employee1.getManager_id());
				//employee1.setManager(empployee);
				//System.out.println("hieeee====lastname is same then call manager id"+employee1.getManager_id());
				//System.out.println("empployee.getid"+empployee.getManager_id());
				//employee1.getSubordinates().add(employee1);
				empdat2.getSubordinates().add(empdat2);
		        employeeDao.save2(empdat2);
				}
			}
			
			
		
	
	
	
	
	
	return "redirect:showEmployee";
	}
	@RequestMapping(value = "showEmployee", method = RequestMethod.GET)
	public String showEmployee( Model model) {
		logger.info("showEmployee");
		System.out.println("showEmployee");
		model.addAttribute("emp", employeeDao.show());
		return "employeedetail";
	}
	@RequestMapping(value = "show", method = RequestMethod.GET)
	public String show(Locale locale, Model model) throws ClassNotFoundException, SQLException {
		System.out.println("show");
		//String subid ="";
		List<EmpData> empData = new ArrayList<EmpData>();
		//Employee employee = new Employee();
		/*employee.getEMPLOYEE_ID();
		employee.getFIRSTNAME();
		employee.getLASTNAME();*/
		
	
		/*employees.add(employee);
		employee.setEmployeeData(employees);*/
		
		 //model.addAttribute("item", employees);
		//model.addAttribute("show", employeelist);
		List<Employee>  employees = employeeDao.getEmployees();
		//employee.setEmployeeData(employees);
		System.out.println("employees list is 1st:"+employees.toString());
		//model.addAttribute("emp1", employees);
		//if((empData!=null)&&(empData.size()>0)){
		for (Employee em : employees) {
			EmpData ed = new EmpData();
			//System.out.println("if null then id"+em.getEMPLOYEE_ID());
			ed.setEMPLOYEE_ID(em.getEmployeeId());
			ed.setFIRSTNAME(em.getFirstname());
			ed.setManager_id(em.getManager_id());
			ed.setLASTNAME(em.getLastname());
			//ed.setNo(em.getNo());
			//String subid = em.getNo()+"";
			String subid = em.getEmployeeId()+"";
			
			System.out.println("in sublid value....."+subid);
			ed.setSubid(subid);
			//System.out.println("subid in method"+subid);
			empData.add(ed);
			getEmployee(em.getEmployeeId(),empData,subid);
			//ed.setEmpDataList(empld);
			//System.out.println(" in control sub list value"+getEmployee(em.getEMPLOYEE_ID(),empData,subid));
			//model.addAttribute("emp", empld);
			//ed.setEmpDataList(empData);
			
		}
		///Employee root = getTreeRootNode();
		//getEmployee(empData);
		model.addAttribute("show", empData);
		//System.out.println("employee data is final"+empData.toString());
		//System.out.println("list data is :"+empData.toString());
		return "employeelist";
	}
	public List<EmpData> getEmployee( long id, List<EmpData> empData, String subid) throws ClassNotFoundException, SQLException{
		//Employee employee = new Employee();
				System.out.println("IN method long id"+id);
				 List<Employee>  employees = employeeDao.getEmpData(id);
				// System.out.println("employees in method "+employees.toString());
				//System.out.println("in method subid is ====="+subid);
				 for (Employee em2 : employees) {
						EmpData ed = new EmpData();
						//System.out.println("employee id in method when id is 1"+em2.getEMPLOYEE_ID());
						ed.setEMPLOYEE_ID(em2.getEmployeeId());
						ed.setManager_id(em2.getManager_id());
						ed.setFIRSTNAME(em2.getFirstname());
						ed.setLASTNAME(em2.getLastname());
						//String sb = em2.getNo()+"";
						String sb = em2.getManager_id()+"";
						System.out.println("in method sb id iiiiiii...."+sb);
						String subid1 = subid+"."+sb;
						ed.setSubid(subid1);
						System.out.println("subid1 in method===="+subid1);
						empData.add(ed);
						//getEmployee1(em2.getEMPLOYEE_ID(),empData,subid1);
						getEmployee(em2.getEmployeeId(),empData,subid1);
						
						//ed.setEmpDataList(empld1);
					
				}
			
			 //getEmployee(empData);
		
		
		return empData;
		}
	
	/*@RequestMapping(value = "show", method = RequestMethod.GET)
	public String show(Locale locale, Model model) {
		long startTime = System.currentTimeMillis();
		logger.info("Welcome show()");
		model.addAttribute("show", metDao.showUser());
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("/time"+totalTime);
		return "showemployee";
	}
	@RequestMapping(value = "showAll", method = RequestMethod.GET,produces="application/json")
	@ResponseBody
	public ArrayList<UserGroup> showAll(Locale locale, Model model) {
		long startTime = System.currentTimeMillis();
		logger.info("Welcome show()");
		ArrayList<UserGroup> employeeList= metDao.showUser();
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("/time"+totalTime);
		return employeeList;
	}
	@RequestMapping(value = "addData", method = RequestMethod.POST)
	public String addData(@RequestParam("firstname")String firstname,
			@RequestParam("lastname")String lastname,
			@RequestParam("subject")String subject,
			@RequestParam("meetingDate")Date meetingDate, Model model) {
			logger.info("Welcome addData()");
			logger.info("firstname"+firstname);
			logger.info("lastname"+lastname);
			logger.info("subject"+subject);
			logger.info("meetingDate"+meetingDate);
			Meeting meeting = null;
			Employee emp = null;
			emp = metDao.reademployee(firstname);
			
			System.out.println("Employee name==== "+emp.getFirstname());
			
			System.out.println("employee"+emp);
			meeting = metDao.readmeeting(subject);
			
			System.out.println("Employee name==== "+meeting.getSubject());
			System.out.println("Meeting"+meeting);
				if((emp.getEmployeeId()==null || emp.getEmployeeId() == 0)&&
				(meeting.getMeetingId()==null || meeting.getMeetingId()==0)){
						System.out.println("No Data then call ");
					
							meeting = new Meeting();
						 	meeting.setSubject(subject);
						 	meeting.setMeetingDate(meetingDate);
						 	emp =new Employee();
						 	emp.setFirstname(firstname);
						 	emp.setLastname(lastname);
						 	emp.getMeetings().add(meeting);
						 	metDao.addemp(emp);
						 	System.out.println("Controller id:"+emp.getEmployeeId());
						 	System.out.println("Controller id:"+meeting.getMeetingId());
						 	
						 	
				}else if(((emp.getFirstname()!=firstname)||(emp.getFirstname()!=null))&&
				((meeting.getSubject()!=subject)||(meeting.getSubject()!=null)))
				{
					
					System.out.println("Step 1 call ");
							meeting = new Meeting();
						 	meeting.setSubject(subject);
						 	meeting.setMeetingDate(meetingDate);
						 	emp =new Employee();
						 	emp.setFirstname(firstname);
						 	emp.setLastname(lastname);
						 	emp.getMeetings().add(meeting);
						 	metDao.addemp(emp);
						 	System.out.println("Controller id:"+emp.getEmployeeId());
						 	System.out.println("Controller id:"+meeting.getMeetingId());
				}else if(((emp.getFirstname()!=firstname)||(emp.getFirstname()!=null))
				&&((meeting.getSubject()==subject)||(meeting.getSubject()!=null))){
					
					System.out.println("Step 2 call ");
					System.out.println("(meeting.getSubject()==subject)======"+(meeting.getSubject()==subject));
					System.out.println("(emp.getFirstname()!=firstname)======"+(emp.getFirstname()!=firstname));
							emp =new Employee();
						 	emp.setFirstname(firstname);
						 	emp.setLastname(lastname);
						 	emp.getMeetings().add(meeting);
						 	metDao.addemp(emp);
						 	System.out.println("Controller id:"+emp.getEmployeeId());
						 	
						 	
				}else if(((emp.getFirstname()==firstname)||(emp.getFirstname()!=null))
					&&((meeting.getSubject()!=subject)||(meeting.getSubject()!=null))){
					
					System.out.println("Step 3 call ");
							emp =new Employee();
						 	emp.setFirstname(firstname);
						 	emp.setLastname(lastname);
						 	//emp.getMeetings().add(meeting);
						 	meeting = new Meeting();
						 	meeting.setSubject(subject);
						 	meeting.setMeetingDate(meetingDate);
						 	meeting.getEmployees().add(emp);
						 	metDao.addmetting(meeting);
						 	System.out.println("Controller id:"+meeting.getMeetingId());
						 	
						 	
					}
								
								System.out.println("Step 4 call ");
								emp =new Employee();
							 	emp.setFirstname(firstname);
							 	emp.setLastname(lastname);
							 	emp.getMeetings().add(meeting);
							 	meeting = new Meeting();
							 	meeting.setSubject(subject);
							 	meeting.setMeetingDate(meetingDate);
							 	meeting.getEmployees().add(emp);
							 	metDao.addmetting(meeting);
							 	System.out.println("Controller id:"+meeting.getMeetingId());
							 	
				System.out.println("Step 1 call ");
				meeting = new Meeting();
			 	meeting.setSubject(subject);
			 	meeting.setMeetingDate(meetingDate);
			 	emp =new Employee();
			 	emp.setFirstname(firstname);
			 	emp.setLastname(lastname);
			 	emp.getMeetings().add(meeting);
			 	metDao.addemp(emp);
			 	System.out.println("Controller id:"+emp.getEmployeeId());
			 	System.out.println("Controller id:"+meeting.getMeetingId());
							 	
			
				

		return "employeeShow";
	}
	@RequestMapping(value = "addd", method = RequestMethod.POST)
	public String addd(@RequestParam("firstname")String firstname,
			@RequestParam("lastname")String lastname,
			@RequestParam("subject")String subject,
			@RequestParam("meetingDate")Date meetingDate, Model model) {
			logger.info("Welcome addData()");
			logger.info("firstname"+firstname);
			logger.info("lastname"+lastname);
			logger.info("subject"+subject);
			logger.info("meetingDate"+meetingDate);
			long startTime = 0;
			startTime = System.currentTimeMillis();	
		Meeting meeting = null;
		Employee emp = null;
		emp = metDao.reademployee(firstname);
		meeting = metDao.readmeeting(subject);
		
		if(emp.getFirstname()==null){
			System.out.println("1....if");
			emp = new Employee(firstname, lastname);
			System.out.println("\t\t\temp:::B :::"+emp.toString());
			if(emp.getFirstname()==null){
				System.out.println("hi");
				emp = metDao.add_EMP(emp);
				
			}else{
				emp = new Employee();
			}
			
		}
		else if(meeting.getSubject()==null){
			System.out.println("2....else if");
			meeting = new Meeting(subject);
			System.out.println("\t\t\tmeeting:::B :::"+meeting.toString());
			meeting = metDao.add_MEET(meeting);
		}
		
		System.out.println("3....");
		
		emp.setFirstname(firstname);
		emp.setLastname(lastname);
		meeting.setMeetingDate(meetingDate);
		meeting.setSubject(subject);
		Set<Meeting> list = new HashSet<Meeting>();
		list.add(meeting);
		emp.setMeetings( list );
		if(emp.getFirstname()==firstname){
			System.out.println("name is same");
			//EmployeeMeeting em = new EmployeeMeeting();
			 //em.setEmployee(emp.getEmployeeId());
			// em.setMeeting(meeting.getMeetingId());
			//em.setMeetingId(meeting.getMeetingId());
			//metDao.insertEmployeeMeeting(em);
		}
			
			//System.out.println("hieee");
		if(emp.getEmployeeId()==null||emp.getFirstname()==null){
				System.out.println("hieee");
				metDao.addemp(emp);
		}else{
				System.out.println("hi");
				metDao.updatemp(emp);
			}
	
		
		System.out.println("DONE "+emp.toString()+"\n\t"+meeting.toString());
		return "employeeShow";
	}
	@RequestMapping(value = "addd1", method = RequestMethod.POST)
	public String addd1(@RequestParam("username")String username,
			@RequestParam("password")String password,
			@RequestParam("email")String email,
			@RequestParam("name")String name, Model model) {
		logger.info("Welcome insertUser()");
		long startTime = System.currentTimeMillis();
		User user = null;
		Group group = null;
		UserGroup userGroup=null;
		user = metDao.readuser(username);
		
		System.out.println("Username ======"+user.getUsername());
		System.out.println("Userid ======"+user.getId());
		
		group = metDao.readgroup(name);
		
		System.out.println("name ======"+group.getName());
		System.out.println("Id ======"+group.getId());
		
		if(user.getUsername()==null){
			System.out.println("1....if");
			user = new User(username, password, email);
			userGroup = new UserGroup();
			userGroup.setGroup(group);
			userGroup.setUser(user);
			userGroup.setActivated(true);
			userGroup.setRegisteredDate(new Date());
			user.addUserGroup(userGroup);
			System.out.println("\t\t\temp:::B :::"+user.toString());
			if(user.getUsername()==null){
				System.out.println("hi");
				user = metDao.add_user(user);
				
			}else{
				user = new User();
			}
			
		}
		else if(group.getName()==null){
			System.out.println("2....else if");
			group = new Group(name);
			userGroup = new UserGroup();
			userGroup.setGroup(group);
			userGroup.setUser(user);
			userGroup.setActivated(true);
			userGroup.setRegisteredDate(new Date());
			user.addUserGroup(userGroup);
			System.out.println("\t\t\tmeeting:::B :::"+group.toString());
			if(group.getName()==null){
				System.out.println("hi");
				group = metDao.add_group(group);
				
			}else{
				group = new Group();
			}
			
		}
		
		System.out.println("3....");
		user = new User(username, password, email);
		userGroup = new UserGroup();
		group = new Group(name);
		metDao.saveGroup(group);
		userGroup.setGroup(group);
		userGroup.setUser(user);
		userGroup.setActivated(true);
		userGroup.setRegisteredDate(new Date());
		user.addUserGroup(userGroup);
		
		if(group.getName()==null){
		metDao.saveGroup(group);
		}else if(user.getUsername()==null){
			metDao.saveUser(user);
		}else{
			metDao.saveUser(user);
			
		}
		
		
		emp.setFirstname(firstname);
		emp.setLastname(lastname);
		meeting.setMeetingDate(meetingDate);
		meeting.setSubject(subject);
		Set<Meeting> list = new HashSet<Meeting>();
		list.add(meeting);
		emp.setMeetings( list );
		if(emp.getFirstname()==firstname){
			System.out.println("name is same");
			//EmployeeMeeting em = new EmployeeMeeting();
			 //em.setEmployee(emp.getEmployeeId());
			// em.setMeeting(meeting.getMeetingId());
			//em.setMeetingId(meeting.getMeetingId());
			//metDao.insertEmployeeMeeting(em);
		}
			
			//System.out.println("hieee");
		if(emp.getEmployeeId()==null||emp.getFirstname()==null){
				System.out.println("hieee");
				metDao.addemp(emp);
		}else{
				System.out.println("hi");
				metDao.updatemp(emp);
			}
	
		
		System.out.println("DONE "+user.toString()+"\n\t"+group.toString());
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(totalTime);
		return "employeeShow";
	}
	public Employee getEMP(Employee emp){
		return metDao.reademployee(emp.getFirstname());
	}
	@RequestMapping(value = "insertUser", method = RequestMethod.POST, produces="application/json")
	@ResponseBody
	public String insertUser(@RequestParam("username")String username,
			@RequestParam("password")String password,
			@RequestParam("email")String email,
			@RequestParam("name")String name, Model model) {
		logger.info("Welcome insertUser()");
		long startTime = System.currentTimeMillis();
		
		
		
		User user = null;
		Group group = null;
		UserGroup userGroup=null;
		user = metDao.readuser(username);
		
		System.out.println("Username ======"+user.getUsername());
		System.out.println("Userid ======"+user.getId());
		
		group = metDao.readgroup(name);
		
		System.out.println("name ======"+group.getName());
		System.out.println("Id ======"+group.getId());
		String result ="";
		
		if(user.getUsername()!=null  && group.getName()!=null)
		{
				System.out.println("1 Data not enty");
				userGroup = new UserGroup();
				userGroup.setGroup(group);
				userGroup.setUser(user);
				userGroup.setActivated(true);
				userGroup.setRegisteredDate(new Date());
				user.addUserGroup(userGroup);
				//metDao.saveUserGroup(userGroup);
				//result = "Data already in databse so do not entry againly";
				result= "1";
		}
		else if(user.getUsername()==null  && group.getName()!=null)
		{
				user = new User(username, password, email);
				userGroup = new UserGroup();
				userGroup.setGroup(group);
				userGroup.setUser(user);
				userGroup.setActivated(true);
				userGroup.setRegisteredDate(new Date());
				user.addUserGroup(userGroup);
				long i = metDao.saveUser(user);
				//metDao.saveUserGroup(userGroup);
				System.out.println("5 User entery");
				if(i>0){
					logger.info("Inserted user entery successfully");
					//result ="Inserted user entery successfully";
					result="1";
				}else{
					logger.info("Inserted user entery not successfully");
					//result ="Inserted user entery not successfully";
					result="0";
				}
		
		}
		else if(user.getUsername()!=null  && group.getName()==null)
		{
					group = new Group(name);
					userGroup = new UserGroup();
					userGroup.setGroup(group);
					userGroup.setUser(user);
					userGroup.setActivated(true);
					userGroup.setRegisteredDate(new Date());
					user.addUserGroup(userGroup);
					long i =metDao.saveGroup(group);
					long i1 =metDao.saveUserGroup(userGroup);
					System.out.println("7  Group entery");
					if((i>0)&&(i1>0)){
						logger.info("Inserted group and user_group entery successfully");
						//result ="Inserted group and user_group entery successfully";
						result="1";
					}else{
						logger.info("Inserted group and user_group entery not successfully");
						//result ="Inserted group and user_group entery not successfully";
						result="0";
					}
				
			
		}
		else if(user.getUsername()==null  && group.getName()==null) 
		{
			if(user.getId()==0 && group.getId()==0){
			user = new User(username, password, email);
			 
				group = new Group(name);
				
				long i =metDao.saveGroup(group);
			 
			
			if(user.getUsername()==null && group.getName()==null) {
				userGroup = new UserGroup();
				userGroup.setGroup(group);
				userGroup.setUser(user);
				userGroup.setActivated(true);
				userGroup.setRegisteredDate(new Date());
				user.addUserGroup(userGroup);
			}else{
				userGroup = new UserGroup();
				userGroup.setGroup(group);
				userGroup.setUser(user);
				userGroup.setActivated(true);
				userGroup.setRegisteredDate(new Date());
				 
				//metDao.saveUserGroup(userGroup);
			}
			 
			long i1 = metDao.saveUser(user);
			}else{
				System.out.println("hie");
			}
		 	
			System.out.println("9 Employee && Meating entery");
			
			if((i>0)&&(i1>0)){
				logger.info("Inserted user and group and user_group entery successfully");
				//result ="Inserted user and group and user_group entery successfully";
				result="1";
			}else{
				logger.info("Inserted user and group and user_group entery not successfully");
				//result ="Inserted user and group and user_group entery not successfully";
				result="0";
			}
			
		}
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("insertUser"+totalTime);
		
		return result;
	}
	long endTime   = System.currentTimeMillis();
	long totalTime = endTime - startTime;
	System.out.println(totalTime);
	public void time(){
		System.out.println("time is"+totalTime);
	}*/
	
	/*@Autowired
	UserService userService;
	
	@Autowired
	UserDocumentService userDocumentService;
	
	@Autowired
	MessageSource messageSource;

	@Autowired
	FileValidator fileValidator;
	
	@InitBinder("fileBucket")
	protected void initBinder(WebDataBinder binder) {
	   binder.setValidator(fileValidator);
	}
	
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {
    	registration.setMultipartConfig(getMultipartConfigElement());
	}

    private MultipartConfigElement getMultipartConfigElement(){
		MultipartConfigElement multipartConfigElement = new MultipartConfigElement(LOCATION, MAX_FILE_SIZE, MAX_REQUEST_SIZE, FILE_SIZE_THRESHOLD);
		return multipartConfigElement;
	}
    
    Set these variables for your project needs 
    
	private static final String LOCATION = "C:/mytemp/";

	private static final long MAX_FILE_SIZE = 1024 * 1024 * 25;//25MB
	
	private static final long MAX_REQUEST_SIZE = 1024 * 1024 * 30;//30MB

    private static final int FILE_SIZE_THRESHOLD = 0;
	
	
	*//**
	 * This method will list all existing users.
	 *//*
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listUsers(ModelMap model) {

		List<User> users = userService.findAllUsers();
		model.addAttribute("users", users);
		return "userslist";
	}

	*//**
	 * This method will provide the medium to add a new user.
	 *//*
	@RequestMapping(value = { "/newuser" }, method = RequestMethod.GET)
	public String newUser(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("edit", false);
		return "registration";
	}

	*//**
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 *//*
	@RequestMapping(value = { "/newuser" }, method = RequestMethod.POST)
	public String saveUser(@Valid User user, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "registration";
		}

		
		 * Preferred way to achieve uniqueness of field [sso] should be implementing custom @Unique annotation 
		 * and applying it on field [sso] of Model class [User].
		 * 
		 * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
		 * framework as well while still using internationalized messages.
		 * 
		 
		if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
			FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "registration";
		}
		
		userService.saveUser(user);
		
		model.addAttribute("user", user);
		model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " registered successfully");
		//return "success";
		return "registrationsuccess";
	}


	*//**
	 * This method will provide the medium to update an existing user.
	 *//*
	@RequestMapping(value = { "/edit-user-{ssoId}" }, method = RequestMethod.GET)
	public String editUser(@PathVariable String ssoId, ModelMap model) {
		User user = userService.findBySSO(ssoId);
		model.addAttribute("user", user);
		model.addAttribute("edit", true);
		return "registration";
	}
	
	*//**
	 * This method will be called on form submission, handling POST request for
	 * updating user in database. It also validates the user input
	 *//*
	@RequestMapping(value = { "/edit-user-{ssoId}" }, method = RequestMethod.POST)
	public String updateUser(@Valid User user, BindingResult result,
			ModelMap model, @PathVariable String ssoId) {

		if (result.hasErrors()) {
			return "registration";
		}

		userService.updateUser(user);

		model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " updated successfully");
		return "registrationsuccess";
	}

	
	*//**
	 * This method will delete an user by it's SSOID value.
	 *//*
	@RequestMapping(value = { "/delete-user-{ssoId}" }, method = RequestMethod.GET)
	public String deleteUser(@PathVariable String ssoId) {
		userService.deleteUserBySSO(ssoId);
		return "redirect:/list";
	}
	

	
	@RequestMapping(value = { "/add-document-{userId}" }, method = RequestMethod.GET)
	public String addDocuments(@PathVariable int userId, ModelMap model) {
		User user = userService.findById(userId);
		model.addAttribute("user", user);

		FileBucket fileModel = new FileBucket();
		model.addAttribute("fileBucket", fileModel);

		List<UserDocument> documents = userDocumentService.findAllByUserId(userId);
		model.addAttribute("documents", documents);
		
		return "managedocuments";
	}
	

	@RequestMapping(value = { "/download-document-{userId}-{docId}" }, method = RequestMethod.GET)
	public String downloadDocument(@PathVariable int userId, @PathVariable int docId, HttpServletResponse response) throws IOException {
		UserDocument document = userDocumentService.findById(docId);
		response.setContentType(document.getType());
        response.setContentLength(document.getContent().length);
        response.setHeader("Content-Disposition","attachment; filename=\"" + document.getName() +"\"");
 
        FileCopyUtils.copy(document.getContent(), response.getOutputStream());
 
 		return "redirect:/add-document-"+userId;
	}

	@RequestMapping(value = { "/delete-document-{userId}-{docId}" }, method = RequestMethod.GET)
	public String deleteDocument(@PathVariable int userId, @PathVariable int docId) {
		userDocumentService.deleteById(docId);
		return "redirect:/add-document-"+userId;
	}

	@RequestMapping(value = { "/add-document-{userId}" }, method = RequestMethod.POST)
	public String uploadDocument(@Valid FileBucket fileBucket, BindingResult result, ModelMap model, @PathVariable int userId) throws IOException{
		
		if (result.hasErrors()) {
			System.out.println("validation errors");
			User user = userService.findById(userId);
			model.addAttribute("user", user);

			List<UserDocument> documents = userDocumentService.findAllByUserId(userId);
			model.addAttribute("documents", documents);
			
			return "managedocuments";
		} else {
			
			System.out.println("Fetching file");
			
			User user = userService.findById(userId);
			model.addAttribute("user", user);

			saveDocument(fileBucket, user);

			return "redirect:/add-document-"+userId;
		}
	}
	
	private void saveDocument(FileBucket fileBucket, User user) throws IOException{
		
		UserDocument document = new UserDocument();
		
		MultipartFile multipartFile = fileBucket.getFile();
		
		document.setName(multipartFile.getOriginalFilename());
		document.setDescription(fileBucket.getDescription());
		document.setType(multipartFile.getContentType());
		document.setContent(multipartFile.getBytes());
		document.setUser(user);
		userDocumentService.saveDocument(document);
	}*/
}
