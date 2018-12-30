package learn.jdbctemplate.service;

import java.util.List;

import learn.jdbctemplate.model.Employee;

public interface EmployeeService {
	
public void createEmployee(Employee emp);
	
	public Employee getEmployeeById(int id);
	
	public void deleteEmployeeById(int id);
	
	public void updateEmployee(int id,String department);
	
	public List<Employee> fetchEmployees();


}
