package com.hichem.rtibi.service;

import java.util.List;

import com.hichem.rtibi.entity.Employee;

public interface EmployeeServiceDao {
	public List<Employee> findAll();

	public void save(Employee employee);

	public void deleteById(int theid);

	public Employee findabyId(int theid);

}
