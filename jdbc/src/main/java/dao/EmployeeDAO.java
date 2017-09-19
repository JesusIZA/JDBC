package dao;

import java.util.List;

import entity.Employee;

public interface EmployeeDAO {

	//create
	void add(Employee employee);
	
	//read
	List<Employee> getAll();
	
	Employee getById(Long id);
	
	//update
	void update(Employee employee);
	
	//delete
	void delete(Employee employee);
	
}
