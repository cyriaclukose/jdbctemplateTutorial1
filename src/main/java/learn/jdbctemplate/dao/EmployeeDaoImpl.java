package learn.jdbctemplate.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import learn.jdbctemplate.model.Employee;

/**
 * 
 * @author CyriacLukose here we need to inject the data source to the Employee
 *         Dao impl and also we need to initialise the jdbc template differnt
 *         methods of the JdbcTemplate will be used to perform the crud
 *         operations based on the requirement
 *
 *         1.create employee create the sql statement and pass the argument
 *         array for the fields of the employee
 *
 *
 */
public class EmployeeDaoImpl implements EmployeeDao {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	/**
	 * initialize the dataSource and the JdbcTemplate
	 * 
	 * @param dataSource
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * create and employee record in date base
	 */
	public void createEmployee(Employee emp) {
		String sql = "INSERT INTO employee (name,age,department) VALUES(?,?,?) ";
		Object[] inputList = new Object[] { emp.getName(), emp.getAge(), emp.getDepartment() };
		int sqlUpdate = jdbcTemplate.update(sql, inputList);

		if (sqlUpdate > 0) {
			System.out.println("the employee record is sucessFully updated");
		}

	}

	/**
	 * retrun the employee corresponding to the id supplied
	 */
	public Employee getEmployeeById(int id) {
		String sql ="SELECT * FROM employee where id=?";
			
		return jdbcTemplate.queryForObject(sql, new Object [] {id}, new EmployeeRowMapper());
	}

	public void deleteEmployeeById(int id) {
		String sql="DELETE FROM employee WHERE id = ?";
		
		int sqlUpdate = jdbcTemplate.update(sql,id);

		if (sqlUpdate > 0) {

			System.out.println("employee record is deleted");
		}
	}

	public void updateEmpDepartMent(int id, String department) {
		String sql = "UPDATE employee SET department=? WHERE id=?";

		int sqlUpdate = jdbcTemplate.update(sql, department, id);

		if (sqlUpdate > 0) {

			System.out.println("employee record is updated");
		}

	}

	public List<Employee> retrieveAllEmployees() {
		String sql ="SELECT * FROM employee ";
		return jdbcTemplate.query(sql, new EmployeeRowMapper());
	}

}
