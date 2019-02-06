package com.spring.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;



@Entity
@Table(name="employee")
public class Employee implements Serializable {

	public Employee() {
		
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="empId")
	private int id;
	
	@Column(name="fname")
	private String firstname;
	
	@Column(name="lname")
	private String lastname;
	
	@Column(name="salary")
	private double salary;
	
	//@LazyCollection(fetch=FetchType.LAZY)
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

	/*@Override
	public String toString() {
		return "Employee [id=" + id + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", salary=" + salary
				+ ", address=" + address + "]";
	}*/
	
}
