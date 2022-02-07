package com.sarat.curdoperations.service;

import java.util.List;

import com.sarat.curdoperations.entity.Employee;

public interface EmployeeService {

	public Employee addEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public Employee getEmployeeById(Long empId);

	public void delEmployeeById(Long empId);

}
