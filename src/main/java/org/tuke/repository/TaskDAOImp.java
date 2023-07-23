package org.tuke.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.tuke.entity.Task;

public class TaskDAOImp implements TaskDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	SimpleJdbcInsert simpleJdbcInsert;
	
	@Autowired
	SimpleJdbcInsert simpleJdbcInsert2;

	@Override
	public List<Task> findAll() {
		// SQL SERVER
//		String sql = "select * from tk3consulting.table_tasks";
		// MYSQL
		String sql = "select * from table_tasks";
		return jdbcTemplate.query(sql, new TaskRowMapper());
	}

}

class TaskRowMapper implements RowMapper<Task>{

	@Override
	public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
		Task task = new Task();
		task.setTask_id(rs.getInt("task_id"));
		task.setTask_name(rs.getString("task_name"));
		task.setSection_id(rs.getInt("section_id"));
		return task;
	}
	
	
	
}

















