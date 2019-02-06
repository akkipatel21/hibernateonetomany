package com.spring.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;





@Entity
@Table(name="employee1")
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public Employee() {
		
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="emp_Id")
	private int id;
	
	@Column(name="fname")
	private String firstname;
	
	@Column(name="lname")
	private String lastname;
	
	@Column(name="salary")
	private double salary;
	
	@OneToOne(mappedBy="employee",cascade = CascadeType.ALL)
	private Address address;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	
	
}
