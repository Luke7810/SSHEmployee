package com.luke.department.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.luke.department.dao.DepartmentDao;
import com.luke.employee.model.Department;

@Component("departmentService")
public class DepartmentService {
	private DepartmentDao departmentDao;

	public List<Department> getAllDep() {
		return departmentDao.loadAllDep();
	}
	
	//-------All Set and Get-----------
	public DepartmentDao getDepartmentDao() {
		return departmentDao;
	}

	@Resource(name="departmentDao")
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	
	
}
