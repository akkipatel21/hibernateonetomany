package com.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="emp25")
//@IdClass(Employee.class)
public class Employee implements Serializable {
 
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    @Column(name="employee_id")
    private Long employeeId;
     
    @Column(name="firstname")
    private String firstname;
     
    @Column(name="lastname")
    private String lastname;
     
    @Column(name="section")
    private String section;
 
    @ManyToOne/*(fetch=FetchType.EAGER,cascade=CascadeType.PERSIST)*/
    @JoinColumn(name="department_id")
   /* @JoinTable(
            name = "employee_list",
            joinColumns = @JoinColumn(name = "DEPARTMENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")
    )*/
    private Department department;
     

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

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
     
   
    
}  