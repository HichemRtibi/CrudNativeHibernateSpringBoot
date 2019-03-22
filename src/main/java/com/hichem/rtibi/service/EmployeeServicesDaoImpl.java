package com.hichem.rtibi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hichem.rtibi.dao.EmployeeDao;
import com.hichem.rtibi.entity.Employee;
@Service
public class EmployeeServicesDaoImpl implements EmployeeServiceDao{
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	@Transactional
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeDao.findAll();
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		employeeDao.save(employee);
	}

	@Override
	@Transactional
	public void deleteById(int theid) {
		employeeDao.deleteById(theid);
		
	}

	@Override
	@Transactional
	public Employee findabyId(int theid) {
		// TODO Auto-generated method stub
		return employeeDao.findabyId(theid);
	}

}
