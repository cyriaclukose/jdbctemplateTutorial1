package learn.jdbctemplate.dao;

import java.util.List;

import learn.jdbctemplate.model.Employee;

/**
 * 
 * @author CyriacLukose
 *
 *this interface defines the crud operation that can be 
 *performed on the employee table
 */
public interface EmployeeDao {
	
	public void createEmployee(Employee emp);
	
	public Employee getEmployeeById(int id);
	
	public void deleteEmployeeById(int id);
	
	public void updateEmpDepartMent(int id,String department);
	
	public List<Employee> retrieveAllEmployees();

}
