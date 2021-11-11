package com.spring.postgress.employeeProject;


import java.util.stream.Stream;
import  java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
 
import java.util.ArrayList;
import java.util.List;

import com.spring.postgress.employeeProject.model.Employee;
import com.spring.postgress.employeeProject.repository.CustomPostgressRepository;
import com.spring.postgress.employeeProject.service.EmpService;

@SpringBootTest
class SpringPostgressApplicationTests {
	
	@MockBean
	public CustomPostgressRepository repo;
	@Autowired
	public EmpService service;
	@Test
	void contextLoads() {
	}

	@Test
	public void addDetailsServiceTest() {
		Employee emp=new Employee(102,"Hello","UK");
		when(repo.save(emp)).thenReturn(emp);
		System.out.println(emp);
		assertEquals(emp,service.addDetailsService(emp));
	}
	
	@Test
	public void getEmpServiceTest() {
		when(repo.findAll()).thenReturn(Stream.of(new Employee(101,"Hi","Lucknow")).toList());
		assertEquals(1,service.getEmpService().size());
	}
	
//	@Test
//	public void  deleteEmpServiceTest() {
//		Employee emp= new Employee(104,"hello","AP");
//		service.deleteEmpService(emp.getEmpid());
//		verify(repo,times(1)).delete(emp);
//	}
	
//	@Test
//	public void changeEmpServiceTest() {
//		Employee emp= new Employee(102,"Sam","US");
//		service.changeEmpService(emp.getEmpid(), emp);
//		when(repo.save(emp)).thenReturn(emp);
//		assertEquals(emp,service.getEmpService());
//	}
	
}
