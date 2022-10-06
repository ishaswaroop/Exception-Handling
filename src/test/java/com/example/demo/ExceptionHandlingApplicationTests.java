package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Entity.Employee;
import com.example.demo.repo.EmployeeCrudRepo;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)

class ExceptionHandlingApplicationTests {
     
	@Autowired
	EmployeeCrudRepo employeerepo;
	
	@Test
	@Order(1)
	public void testCreate() {
		Employee emp=new Employee();
		emp.setId(1L);
		emp.setName("Yash Srivastava");
		emp.setAddress("5/25 vikas Nagar,Lucknow");
		emp.setContact("9335998101");
		employeerepo.save(emp);
		assertNotNull(employeerepo.findById(1L).get());
	}
	@Test
	@Order(2)
	public void testReadAll() {
		List<Employee>list=employeerepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	@Test
	@Order(3)
    public void testSingleEmployee() {
		Employee emp=employeerepo.findById(1L).get();
		assertEquals("9335998101",emp.getContact());
	}
	@Test
	@Order(4)
    public void testUpdate() {
		Employee e=employeerepo.findById(1L).get();
		e.setName("Manas Srivastava");
		employeerepo.save(e);
		assertNotEquals("Yash Srivastava",employeerepo.findById(1L).get().getName());
	}
	@Test
	@Order(5)
	public void testDelete() {
		employeerepo.deleteById(1L);
		assertThat(employeerepo.existsById(1L)).isFalse();
	}
}
