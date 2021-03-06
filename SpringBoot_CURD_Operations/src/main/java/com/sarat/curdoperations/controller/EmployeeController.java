package com.sarat.curdoperations.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sarat.curdoperations.customexception.BusinessException;
import com.sarat.curdoperations.customexception.ControllerException;
import com.sarat.curdoperations.entity.Employee;
import com.sarat.curdoperations.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/save")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {

		Employee savedEmployee = employeeService.addEmployee(employee);
		return new ResponseEntity<Employee>(savedEmployee, HttpStatus.CREATED);

	}

	/*
	 * @PostMapping("/save") public ResponseEntity<?> addEmployee(@RequestBody
	 * Employee employee) { try { Employee savedEmployee =
	 * employeeService.addEmployee(employee); return new
	 * ResponseEntity<Employee>(savedEmployee, HttpStatus.CREATED); } catch
	 * (BusinessException e) { ControllerException ce = new
	 * ControllerException(e.getErrorCode(), e.getErrorMessage()); return new
	 * ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST); } catch
	 * (Exception e) { ControllerException ce = new ControllerException("611",
	 * "Something went wrong"); return new ResponseEntity<ControllerException>(ce,
	 * HttpStatus.BAD_REQUEST); }
	 * 
	 * }
	 */

	@GetMapping("/allEmployees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> listOfEmployees = employeeService.getAllEmployees();
		return new ResponseEntity<List<Employee>>(listOfEmployees, HttpStatus.OK);
	}

	@GetMapping("/emp/{empId}")
	public ResponseEntity<?> getEmployeeById(@PathVariable("empId") Long empId) {

		/* try { */
			Employee emp = employeeService.getEmployeeById(empId);
			return new ResponseEntity<Employee>(emp, HttpStatus.OK);
			/*
			 * } catch (BusinessException e) { ControllerException ce = new
			 * ControllerException(e.getErrorCode(), e.getErrorMessage()); return new
			 * ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST); } catch
			 * (Exception e) { ControllerException ce = new ControllerException("612",
			 * "Something went wrong"); return new ResponseEntity<ControllerException>(ce,
			 * HttpStatus.BAD_REQUEST); }
			 */
	}

	@DeleteMapping("/emp/{empId}")
	public ResponseEntity<Void> deltEmployeeById(@PathVariable("empId") Long empId) {
		employeeService.delEmployeeById(empId);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		Employee savedEmployee = employeeService.addEmployee(employee);
		return new ResponseEntity<Employee>(savedEmployee, HttpStatus.CREATED);
	}

}
