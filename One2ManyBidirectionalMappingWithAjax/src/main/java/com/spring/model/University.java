package com.spring.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.IndexColumn;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="University2")
public class University implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="universityId")
	private long uid;
	
	@Column(name="universityName")
	private String universityName;
	
	@Column(name="country")
	private String country;
	
	@JsonIgnore
	//@JoinColumn(name="universityId")
    //@IndexColumn(name="idx")
	@OneToMany(mappedBy="university",cascade=CascadeType.ALL,fetch =FetchType.LAZY)
	private List<Student> students;

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	/*@Override
	public String toString() {
		return "University [uid=" + uid + ", universityName=" + universityName
				+ ", country=" + country + ", students=" + students + "]";
	}*/
	
	

}
