package com.hichem.rtibi.dao;

import java.util.List;

import com.hichem.rtibi.entity.Employee;

public interface EmployeeDao {

	public List<Employee> findAll();

	public void save(Employee employee);

	public void deleteById(int theid);

	public Employee findabyId(int theid);

}
