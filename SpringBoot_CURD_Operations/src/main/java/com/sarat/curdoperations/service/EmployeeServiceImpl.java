package com.sarat.curdoperations.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarat.curdoperations.customexception.BusinessException;
import com.sarat.curdoperations.customexception.EmptyInputException;
import com.sarat.curdoperations.entity.Employee;
import com.sarat.curdoperations.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {

		if (employee.getName().isEmpty() || employee.getName().length() == 0) {
			throw new EmptyInputException("601", "employee name is empty or it's blank");
		}
		try {
			Employee SaveEmployee = employeeRepository.save(employee);
			return SaveEmployee;
		} catch (IllegalArgumentException e) {
			throw new BusinessException("602", "given employee is null " + e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("603", "Something went wrong while saving employee data " + e.getMessage());
		}

	}

	@Override
	public List<Employee> getAllEmployees() {

		try {
			List<Employee> list = employeeRepository.findAll();
			if (list.isEmpty()) {
				throw new BusinessException("604", "Hey list is empty to return ");
			}
			return list;
		} catch (Exception e) {
			throw new BusinessException("605",
					"Something went wrong in service layer while fetching all employees " + e.getMessage());
		}

	}

	@Override
	public Employee getEmployeeById(Long empId) {
		/* try { */
			return employeeRepository.findById(empId).get();
			/*
			 * } catch (IllegalArgumentException e) { throw new BusinessException("606",
			 * "employee id is null, please search with different id " + e.getMessage()); }
			 * catch (NoSuchElementException e) { throw new BusinessException("607",
			 * "employee id is doesn't exits in DB, please search with different id " +
			 * e.getMessage()); }
			 */

	}

	@Override
	public void delEmployeeById(Long empId) {
		try {
			employeeRepository.deleteById(empId);
		} catch (IllegalArgumentException e) {
			throw new BusinessException("608",
					"employee id is null, please search with different id " + e.getMessage());
		} catch (NoSuchElementException e) {
			throw new BusinessException("609",
					"employee id is doesn't exits in DB, please search with different id " + e.getMessage());
		}

	}

}
