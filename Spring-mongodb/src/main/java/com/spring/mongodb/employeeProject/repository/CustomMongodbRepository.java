package com.spring.mongodb.employeeProject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.spring.mongodb.employeeProject.model.Employee;

public interface CustomMongodbRepository extends MongoRepository<Employee, Integer> {

	public Employee findById(int empid);
	
}
