package com.luke.employee.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.luke.employee.model.Employee;

@Component("employeeDao")
public class EmployeeDao {
	
	private HibernateTemplate hibernateTemplate;
	
	public void save(Employee e){
		hibernateTemplate.save(e);
	}
	
	public void update(Employee e){
		hibernateTemplate.clear();
		hibernateTemplate.update(e);
	}
	
	public List<Employee> loadAllEmployee(){
		return hibernateTemplate.find("from Employee e LEFT OUTER JOIN FETCH e.department");
	}
	
	public Employee loadEmployeebyId(int id) {
		Employee e = (Employee) hibernateTemplate.get(Employee.class, id);
		return e;
	}
	
	public Employee loadEmployeebyName(String lastname){
		List<Employee> emps = hibernateTemplate.find("From Employee e WHERE e.lastname='"+lastname+"'");
		if(emps != null && emps.size()>0){
			return emps.get(0);
		}else{
			return null;
		}
	}
	
	public void deleteEmployee(Employee e){
		hibernateTemplate.delete(e);
	}

	//--------All Set and Get---------
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
}
