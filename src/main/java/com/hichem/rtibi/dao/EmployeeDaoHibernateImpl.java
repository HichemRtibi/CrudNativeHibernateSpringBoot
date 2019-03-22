package com.hichem.rtibi.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hichem.rtibi.entity.Employee;

@Repository
public class EmployeeDaoHibernateImpl implements EmployeeDao {

	private EntityManager entityManeger;

	@Autowired
	public EmployeeDaoHibernateImpl(EntityManager entityManeger) {

		this.entityManeger = entityManeger;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		// get current hibernate session
		Session currentsession = entityManeger.unwrap(Session.class);
		// create query
		Query<Employee> thequery = currentsession.createQuery("from Employee", Employee.class);
		List<Employee> employees = thequery.getResultList();
		return employees;
	}

	@Override
	public void save(Employee employee) {
		Session currentsession = entityManeger.unwrap(Session.class);
		currentsession.saveOrUpdate(employee);

	}

	@Override
	public void deleteById(int theid) {
		// TODO Auto-generated method stub
		Session currentsession = entityManeger.unwrap(Session.class);

		Query theQuery = currentsession.createQuery("delete from Employee where id=:employeId");
		theQuery.setParameter("employeId", theid);
		theQuery.executeUpdate();

	}

	@Override
	public Employee findabyId(int theid) {
		Session currentsession = entityManeger.unwrap(Session.class);
		Employee theemployee = currentsession.get(Employee.class, theid);

		return theemployee;
	}

}
