package com.luke.employee.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.luke.employee.model.Department;
import com.luke.employee.model.Employee;

public class EmpTest {

	@Test
	public void testAddEmp() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		EmployeeService uis = (EmployeeService) ac.getBean("employeeService");
		
		Employee e = new Employee();
		e.setLastname("Xiao Mao");
		e.setEmail("mao@123.com");
		
		Department d =new Department();
		d.setId(1);
		
		e.setDepartment(d);
		uis.add(e);
	}
	
	@Test
	public void testSearchById(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		EmployeeService uis = (EmployeeService) ac.getBean("employeeService");
		
		Employee e =uis.getEmployeebyId(2);
		System.out.println("*****"+e.getLastname());
	}

	@Test
	public void testValidateByName(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		EmployeeService uis = (EmployeeService) ac.getBean("employeeService");
		
		System.out.println(uis.validateLastname("AA"));
	}
}
