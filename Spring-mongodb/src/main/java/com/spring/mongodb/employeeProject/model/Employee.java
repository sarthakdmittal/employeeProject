package com.spring.mongodb.employeeProject.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="employeeDetails")
public class Employee {
	@Id  public int empid;
	public String empname;
	public String location;
	
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Employee() {}
	public Employee(int empid, String empname, String location) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.location = location;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", location=" + location + "]";
	}
	
}
