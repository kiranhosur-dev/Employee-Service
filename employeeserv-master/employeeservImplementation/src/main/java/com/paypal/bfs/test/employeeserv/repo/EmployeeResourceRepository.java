package com.paypal.bfs.test.employeeserv.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employee;


@Repository
public class EmployeeResourceRepository{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Employee findById(Integer id) {
		 Employee employee = jdbcTemplate.queryForObject("SELECT * FROM employee where id=?", new Object[]{id},new BeanPropertyRowMapper<Employee>(Employee.class));
		 if(employee.getId() >0 ) {
			 Address address = jdbcTemplate.queryForObject("SELECT * FROM address where id=?", new Object[]{employee.getAddressId()},new BeanPropertyRowMapper<Address>(Address.class));
			 employee.setAddressId(address.getId());
		 }
		 return employee;
	}

	public int createEmployee(Employee employee) {
		
		Address address = null;
		int update = jdbcTemplate.update("INSERT INTO address(line1, line2, city, state, country, zipCode) values (?, ?, ?, ?, ?, ?)", new Object[]{address.getLine1()
				 , address.getLine2(), address.getCity(), address.getState(), address.getCountry(), address.getZipcode()});
		System.err.println(update);
		int update2 = jdbcTemplate.update("INSERT INTO employee(firstName, lastName, dateOfBirth, addressId) values (?, ?, ?, ?)", new Object[]{employee.getFirstName()
				 , employee.getLastName(), employee.getBirthDate(), update});
		
		return update2;
	}
}
