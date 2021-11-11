package com.spring.mongodb.employeeProject.controller;

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

import com.spring.mongodb.employeeProject.model.Employee;
import com.spring.mongodb.employeeProject.repository.CustomMongodbRepository;
import com.spring.mongodb.employeeProject.service.NextSequenceService;

@RestController
public class EmpController {
	@Autowired CustomMongodbRepository repo;
	@Autowired NextSequenceService nextSequenceService;
	
	@PostMapping("/addDetails")
	public String addDetails(@RequestBody Employee employee) {
		int tempid;
		tempid=employee.getEmpid();
		
		if(tempid==0) {
			employee.setEmpid(nextSequenceService.getNextSequence("customSequences"));
		repo.save(employee);
		
		}
		
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
		return repo.findAll();
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteEmp(@PathVariable int id) {
		repo.deleteById(id);
		return "Employee delete Successfully";
	}
	
	@PutMapping("/change/{id}")
	public String change(@PathVariable int id,@RequestBody Employee employee) {
		Employee emp=repo.findById(id);
		emp.setEmpname(employee.getEmpname());
		emp.setLocation(employee.getLocation());
		repo.save(emp);
		return "Change successfully";


}
}
