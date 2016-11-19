package com.luke.employee.action;

import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.luke.department.service.DepartmentService;
import com.luke.employee.model.Department;
import com.luke.employee.model.Employee;
import com.luke.employee.service.EmployeeService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

@Component("employeeAction")
public class EmployeeAction extends ActionSupport  implements ModelDriven<Employee> , Preparable{
	private EmployeeService employeeService;
	private DepartmentService departmentService;
	private Employee epm;
	private Department department;
	private List<Employee> epms;
	private List<Department> deps;
	private int emp_id;
	private InputStream inputStream;
	private String lastname;
	
	//------Override Preparable interface------------
	@Override
	public void prepare() throws Exception {}
	
	//------Override ModelDriven interface----------
	private Employee model;
	@Override
	public Employee getModel() {
		return model;
	}
	
	//------set pirfix method-------------------------
	public void prepareSave() {
		if(emp_id == 0){
			model = new Employee();
		}else{
			model = employeeService.getEmployeebyId(emp_id);
		}
		
	}
	
	//------Save Employee---------------------------
	public String save() {
		if(emp_id == 0){
			employeeService.add(model);
		}else{
			employeeService.update(model);
		}
		//employeeService.add(model);
		return "success";
	}
	
	//------List all Employee------------------------
	public String list() {
		epms = employeeService.listAllEmployee();
		return "list";
	}
	
	//------Delete Employeee-----------------------
	public String delete() {
		try {
			employeeService.deleteEmployee(emp_id);
			inputStream = new StringBufferInputStream("1");
		} catch (Exception e) {
			inputStream = new StringBufferInputStream("0");
			e.printStackTrace();
		}
		return "ajax-success";
	}
	
	//-------Validate last name-----------------------
	public String validateLastName(){
		if(employeeService.validateLastname(lastname)==true){
			inputStream = new StringBufferInputStream("1");
		}else{
			inputStream = new StringBufferInputStream("0");
		}
		
		return "ajax-success";
	}
	
	//-------Input or Update page, get all Dep Name-----------------
	public String input() {
		deps = departmentService.getAllDep();
		return "input";
	}
	
	public void prepareInput(){
		if(emp_id != 0){
			model = employeeService.getEmployeebyId(emp_id);
		}else{
			model = new Employee();
		}
	}
	
	//-------All Get and Set----------
	public EmployeeService getEmployeeService() {
		return employeeService;
	}
	@Resource(name="employeeService")
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	public Employee getEpm() {
		return epm;
	}
	public void setEpm(Employee epm) {
		this.epm = epm;
	}
	public List<Employee> getEpms() {
		return epms;
	}
	public void setEpms(List<Employee> epms) {
		this.epms = epms;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
    public InputStream getInputStream() {
        return inputStream;
    }

	public DepartmentService getDepartmentService() {
		return departmentService;
	}
	
	@Resource(name="departmentService")
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public List<Department> getDeps() {
		return deps;
	}

	public void setDeps(List<Department> deps) {
		this.deps = deps;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
}
