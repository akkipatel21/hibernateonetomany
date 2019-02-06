package com.spring.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="DEPARTMENT25")
//@IdClass(Department.class)
public class Department implements Serializable {
 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="DEPARTMENT_ID")
    private Long departmentId;
     
    @Column(name="DEPT_NAME")
    private String departmentName;
    
    @JsonIgnore
    @OneToMany(mappedBy="department",cascade={CascadeType.ALL},fetch = FetchType.EAGER)
    //@JoinColumn(name="department_id")
    //@JoinColumn(name="employee_id")
    //@IndexColumn(name="idx")
    private List<Employee> employees;

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
 
   
}
