package org.tuke.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.tuke.entity.Cliente;

public class ClienteDAOImpl implements ClienteDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	SimpleJdbcInsert simpleJdbcInsert;
	
	@Autowired
	SimpleJdbcInsert simpleJdbcInsert2;
	

	@Override
	public List<Cliente> findAll() {
		// SQL SERVER
//		String sql = "select * from tk3consulting.table_clients";
		// MYSQL
		String sql = "select * from table_clients";
		return jdbcTemplate.query(sql, new ClienteRowMapper());
	}


	@Override
	public void addCliente(Cliente cliente) {
		
		String query = "INSERT INTO table_clients (username, pass, data_base) values (?,?,?)";
		
		jdbcTemplate.update(query, 
				cliente.getUsername(),
				cliente.getPass(),
				cliente.getData_base());	
		 
	}
	

}

class ClienteRowMapper implements RowMapper<Cliente>{

	@Override
	public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Cliente cliente = new Cliente();
		
		cliente.setId_cliente(rs.getInt("id_cliente"));
		cliente.setUsername(rs.getString("username"));
		cliente.setPass(rs.getString("pass"));
		cliente.setData_base(rs.getString("data_base"));
		
		return cliente;
	}

	
	
	
	
}



































