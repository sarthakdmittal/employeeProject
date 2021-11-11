package com.spring.postgress.employeeProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.postgress.employeeProject.model.Employee;

@Repository
public interface CustomPostgressRepository extends JpaRepository<Employee, Integer> {
	public Employee findById(int empid);
}
