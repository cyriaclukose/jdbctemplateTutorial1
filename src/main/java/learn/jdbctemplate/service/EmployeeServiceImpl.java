package learn.jdbctemplate.service;

import java.util.List;

import learn.jdbctemplate.dao.EmployeeDao;
import learn.jdbctemplate.model.Employee;
/**
 * 
 * @author CyriacLukose
 * we have to inject the EmployeeDaoImpl class 
 */
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDao   employeeDao;
	

	

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public void createEmployee(Employee emp) {
		employeeDao.createEmployee(emp);
		
	}

	public Employee getEmployeeById(int id) {
		
		return employeeDao.getEmployeeById(id);
	}

	public void deleteEmployeeById(int id) {
		employeeDao.deleteEmployeeById(id);
		
	}

	public void updateEmployee(int id, String department) {
		
		employeeDao.updateEmpDepartMent(id, department);
	}

	public List<Employee> fetchEmployees() {
		
		return employeeDao.retrieveAllEmployees();
	}

}
