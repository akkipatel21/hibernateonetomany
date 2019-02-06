package com.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="Student3")
public class Student implements Serializable {
	
	@Id
	//@GeneratedValue(generator="gen")
	//@GenericGenerator(name="gen", strategy="foreign",parameters=@Parameter(name="property", value="university"))
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name="stuId")
	private long stuId;
	
	@Column(name="fname")
	private String firstname;
	
	@Column(name="lname")
	private String lastname;
	
	@Column(name="section")
	private String section;
	
	@ManyToOne(optional= false)
	@JoinColumn(name="universityId")
	private University university;

	public long getStuId() {
		return stuId;
	}

	public void setStuId(long stuId) {
		this.stuId = stuId;
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

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}
	
	
	  @Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + (int) (stuId ^ (stuId >>> 32));
	        return result;
	    }
	 
	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (!(obj instanceof Student))
	            return false;
	        Student other = (Student) obj;
	        if (stuId != other.stuId)
	            return false;
	        return true;
	    }
	 
	
	/*@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", section=" + section
				+ ", university=" + university + "]";
	}*/
	
	
	

}
