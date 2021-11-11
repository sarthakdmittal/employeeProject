package com.spring.postgress.employeeProject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.postgress.employeeProject.model.Employee;
import com.spring.postgress.employeeProject.repository.CustomPostgressRepository;
import com.spring.postgress.employeeProject.service.EmpService;


@RestController
public class EmpController {
	
	@Autowired 
	public EmpService service;
	
	@PostMapping("/addDetails")
	public String addDetails(@RequestBody Employee employee) {
		
		service.addDetailsService(employee);
		
//		else {
//		String checkid=repo.findById(employee.getEmpid());
//		if(checkid==null) {
//			repo.save(employee);
//		}
//		else {
//			return "Employee with this id already exists";
//		}
		//}
		return "Added Successfully with id: "+ employee.getEmpid();
}
	
	@GetMapping("/getEmployees")
	public List<Employee> getEmp(){
		return service.getEmpService();
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteEmp(@PathVariable int id) {
		return service.deleteEmpService(id);
	}
	
	@PutMapping("/change/{id}")
	public String changeEmp(@PathVariable int id,@RequestBody Employee employee) {
		return service.changeEmpService(id, employee);
	}
}
