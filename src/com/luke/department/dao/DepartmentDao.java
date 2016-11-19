package com.luke.department.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.luke.employee.model.Department;

@Component("departmentDao")
public class DepartmentDao {
	private HibernateTemplate hibernateTemplate;

	public List<Department> loadAllDep() {
		return hibernateTemplate.find("from Department");
	}
	
	//--------All Get and Set-----------
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource(name="hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	
}
