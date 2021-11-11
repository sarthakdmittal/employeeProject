package com.spring.postgress.employeeProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.postgress.employeeProject.model.Employee;
import com.spring.postgress.employeeProject.repository.CustomPostgressRepository;

@Service
public class EmpService {

	@Autowired 
	public CustomPostgressRepository repo;
	
	public Employee addDetailsService(Employee employee) {
	return repo.save(employee);
	}
	
	public  List<Employee> getEmpService(){
		List<Employee> emp= repo.findAll();
		return emp;
	}
	
	public String deleteEmpService(int id) {
		repo.deleteById(id);
		return "Employee with id :"+id+ " is deleted successfully";
	}
	
	public String changeEmpService(int id, Employee employee) {
		Employee emp=repo.findById(id);
		emp.setEmpname(employee.getEmpname());
		emp.setLocation(employee.getLocation());
		repo.save(emp);
		return "Employee details changed successfully";
	}
}
