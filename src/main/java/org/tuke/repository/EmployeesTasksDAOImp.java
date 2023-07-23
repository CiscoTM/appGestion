package org.tuke.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.tuke.entity.EmployeesTasks;

public class EmployeesTasksDAOImp implements EmployeesTasksDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	SimpleJdbcInsert simpleJdbcInsert;
	
	@Autowired
	SimpleJdbcInsert simpleJdbcInsert2;

	@Override
	public List<EmployeesTasks> findAll() {
		
		//SQL SERVER
//		String sql = "SELECT e.employee_id, et.date_at, t.task_name FROM tk3consulting.table_tasks t INNER JOIN table_employees_tasks et ON et.task_id=t.task_id INNER JOIN table_employees e ON e.employee_id=et.employee_id\r\n"
//				+ "WHERE e.employee_id=1 AND month(et.date_at)=11 ORDER BY day(et.date_at),month(et.date_at) ASC";
		//MYSQL
		String sql = "SELECT e.employee_id, et.date_at, t.task_name FROM tk3consulting.table_tasks t INNER JOIN table_employees_tasks et ON et.task_id=t.task_id INNER JOIN table_employees e ON e.employee_id=et.employee_id\r\n"
				+ "WHERE e.employee_id=1 AND month(et.date_at)=11 ORDER BY day(et.date_at),month(et.date_at) ASC";
		return jdbcTemplate.query(sql, new EmployeesTasksRowMapper());
	}
		

}



class EmployeesTasksRowMapper implements RowMapper<EmployeesTasks>{

	@Override
	public EmployeesTasks mapRow(ResultSet rs, int rowNum) throws SQLException {

		EmployeesTasks employeesTasks = new EmployeesTasks();
		employeesTasks.setEmployee_id(rs.getInt("employee_id"));
		employeesTasks.setTask_name(rs.getString("task_name"));
		employeesTasks.setDate_at(rs.getTimestamp("date_at"));
		
		return employeesTasks;
	}
	
	
	
}






























