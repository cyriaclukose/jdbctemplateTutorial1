package learn.jdbctemplate.client;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import learn.jdbctemplate.model.Employee;
import learn.jdbctemplate.service.EmployeeService;
import learn.jdbctemplate.service.EmployeeServiceImpl;

public class JdbcTemplateExample {
	
	/**
	 * we have to initialize the Application context 
	 * using the meta data supplied from spring-bean.xml
	 * then we get the EmployeeServiceBean and perform the 
	 * crud operations
	 * @param args
	 */
	public static void main(String [] args)
	{
		
		AbstractApplicationContext applicationcontext=new ClassPathXmlApplicationContext("spring-bean.xml");
		
		EmployeeService employeeService=applicationcontext.getBean("employeeserviceimpl", learn.jdbctemplate.service.EmployeeServiceImpl.class);
	
		
		
	
	//createEmployee(employeeService);
		//updateEmployee(employeeService);
		//getEmployDetails(employeeService);
		//getAllEmployess(employeeService);
	    deleteEmployee(employeeService);
		
	applicationcontext.close();
	
	}

	private static void deleteEmployee(EmployeeService employeeService) {
		
		employeeService.deleteEmployeeById(4);
	}

	private static void getAllEmployess(EmployeeService employeeService) {
		List<Employee> employees=employeeService.fetchEmployees();
		
		for(Employee emp:employees)
		{
			System.out.print(""+emp+"\n");
		}
		
	}

	private static void getEmployDetails(EmployeeService employeeService) {
		
		
		Employee emp=employeeService.getEmployeeById(3);
		System.out.println("the employee details for the requeted id is : "+emp);
	}

	/**
	 * 
	 * @param employeeService
	 */
	private static void updateEmployee(EmployeeService employeeService) {
		
		int id=2;
		String department="BuisnessManagement";
		
		employeeService.updateEmployee(id, department);
	}

	/**
	 * 
	 * @param employeeService
	 */
	private static void createEmployee(EmployeeService employeeService) {
		Employee emp=new  Employee();
		emp.setName("Albert Einstein");
		emp.setAge(99);
		emp.setDepartment("Qunatum Physics");
		
		employeeService.createEmployee(emp);
	}

}
