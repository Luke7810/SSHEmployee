package com.luke.employee.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.luke.employee.dao.EmployeeDao;
import com.luke.employee.model.Employee;

@Component("employeeService")
public class EmployeeService {
	
	private EmployeeDao employeeDao;

	public void add(Employee e){
		employeeDao.save(e);
	}
	
	public void update(Employee e){
		employeeDao.update(e);
	}
	
	public List<Employee> listAllEmployee() {
		return employeeDao.loadAllEmployee();
	}
	
	public Employee getEmployeebyId(int id){
		return employeeDao.loadEmployeebyId(id);
	}
	
	public void deleteEmployee(int id){
		Employee e = new Employee();
		e.setId(id);
		employeeDao.deleteEmployee(e);
	}
	
	public boolean validateLastname(String lastname){
		if(employeeDao.loadEmployeebyName(lastname) == null){
			return true;
		}
		return false;
	}
	
	//-------All Get and Set------
	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	@Resource(name="employeeDao")
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
}
