package learn.jdbctemplate.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import learn.jdbctemplate.model.Employee;
/**
 * the mapRow method will called by the jJdbcTemplate whenever 
 * it wants to convert the result set into custom objects
 * @author CyriacLukose
 *
 */
public class EmployeeRowMapper implements RowMapper<Employee>  {

	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee emp=new Employee();
		emp.setId(rs.getInt("id"));
		emp.setAge(rs.getInt("age"));
		emp.setDepartment(rs.getString("department"));
		emp.setName(rs.getString("name"));
		return emp;
	}

}
