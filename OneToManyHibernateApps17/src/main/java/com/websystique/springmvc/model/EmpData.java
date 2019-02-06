package com.websystique.springmvc.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

//import com.spring.bean.EmpData;

//import com.spring.bean.EmpData;
@Entity
@Table(name="EmpData")
public class EmpData {
	private long EMPLOYEE_ID;
	private String FIRSTNAME;
	private String LASTNAME;
	private List<EmpData> empDataList;
	//private String MANAGERNAME;
	private long manager_id;
	private String subid;
	
	private int no;
	
	
	
	public String getFIRSTNAME() {
		return FIRSTNAME;
	}
	public long getEMPLOYEE_ID() {
		return EMPLOYEE_ID;
	}
	public void setEMPLOYEE_ID(long eMPLOYEE_ID) {
		EMPLOYEE_ID = eMPLOYEE_ID;
	}
	public void setFIRSTNAME(String fIRSTNAME) {
		FIRSTNAME = fIRSTNAME;
	}
	public String getLASTNAME() {
		return LASTNAME;
	}
	public void setLASTNAME(String lASTNAME) {
		LASTNAME = lASTNAME;
	}
	public List<EmpData> getEmpDataList() {
		return empDataList;
	}
	public void setEmpDataList(List<EmpData> empDataList) {
		this.empDataList = empDataList;
	}
	
	
	
	public long getManager_id() {
		return manager_id;
	}
	public void setManager_id(long manager_id) {
		this.manager_id = manager_id;
	}
	
	
	public String getSubid() {
		return subid;
	}
	public void setSubid(String subid) {
		this.subid = subid;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	@Override
	public String toString() {
		return "EmpData [EMPLOYEE_ID=" + EMPLOYEE_ID + ", FIRSTNAME="
				+ FIRSTNAME + ", LASTNAME=" + LASTNAME + ", empDataList="
				+ empDataList + ", manager_id=" + manager_id + ", subid="
				+ subid + ", no=" + no + "]";
	}
	

}
