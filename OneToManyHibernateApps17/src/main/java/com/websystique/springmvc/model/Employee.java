package com.websystique.springmvc.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="EMP10")
public class Employee {
	
	@Id
	@Column(name="EMPLOYEE_ID")
	@GeneratedValue
	private Long employeeId;
	
	@Column(name="manager_id" ,insertable= false, updatable= false )
	private Long manager_id;
	
	public Long getManager_id() {
		return manager_id;
	}

	public void setManager_id(Long manager_id) {
		this.manager_id = manager_id;
	}

	@Column(name="FIRSTNAME")
	private String firstname;
	
	@Column(name="LASTNAME")
	private String lastname;
	
	
	
	

	@ManyToOne(cascade={CascadeType.ALL},fetch=FetchType.LAZY)
	@JoinColumn(name="manager_id" )
	//private Employee employee;
	private Employee manager;

	@OneToMany(mappedBy="manager" ,fetch=FetchType.LAZY)
	private Set<Employee> subordinates = new HashSet<Employee>();

	public Employee() {
	}

	public Employee(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	/*public Employee(String firstname, String lastname,String mangername) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.mangername = mangername;
	}*/
	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	/*public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}*/
	
	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public Set<Employee> getSubordinates() {
		return subordinates;
	}

	

	public void setSubordinates(Set<Employee> subordinates) {
		this.subordinates = subordinates;
	}
	
	

	/*@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", manager_id="
				+ manager_id + ", firstname=" + firstname + ", lastname="
				+ lastname + ", manager=" + manager + ", subordinates="
				+ subordinates + "]";
	}*/
	/*@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", manager_id="
				+ manager_id + ", firstname=" + firstname + ", lastname="
				+ lastname + ", manager=" + manager +  "]";
	}
	*/
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", manager_id="
				+ manager_id + ", firstname=" + firstname + ", lastname="
				+ lastname +  "]";
	}
	
		
	
}