package com.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
@Entity
@Table(name="Address")
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@Column(name="empId")
	@GeneratedValue(generator="gen")
	@GenericGenerator(name="gen",strategy="foreign",parameters=@Parameter(name="property",value="employee"))
	private int id;
	
	@Column(name="state")
	private String state;
	
	@Column(name="city")
	private String city;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	//@JoinColumn(name="empId")
	private Employee employee;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/*@Override
	public String toString() {
		return "Address [id=" + id + ", state=" + state + ", city=" + city
				+ ", employee=" + employee + "]";
	}*/
	
	
	
}
