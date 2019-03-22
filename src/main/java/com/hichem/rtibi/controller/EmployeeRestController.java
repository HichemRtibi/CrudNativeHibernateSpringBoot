package com.hichem.rtibi.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hichem.rtibi.entity.Employee;
import com.hichem.rtibi.service.EmployeeServiceDao;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	@Autowired
	private EmployeeServiceDao employeeServiceDao;

	@PostMapping("/employees")
	public void save(@RequestBody Employee employee) {
		employeeServiceDao.save(employee);
	}

	@DeleteMapping("/employees/{theid}")
	public String deleteById(@PathVariable int theid) {
		Employee employee = employeeServiceDao.findabyId(theid);
		if (employee == null) {
			throw new RuntimeException("Employee not found");
		}
		employeeServiceDao.deleteById(theid);
		return "employee deleted ";
	}

	@GetMapping("/employees/{theid}")

	public Employee findabyId(@PathVariable int theid) {
		Employee theemployee = employeeServiceDao.findabyId(theid);
		if (theemployee == null) {
			throw new RuntimeException("not found employee with id :" + theid);
		}
		return theemployee;
	}

	@GetMapping("/employees")
	public List<Employee> getAllEmployee() {
		return employeeServiceDao.findAll();
	}

	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theemployee) {
		employeeServiceDao.save(theemployee);
		return theemployee;

	}
}
