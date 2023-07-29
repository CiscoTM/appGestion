package org.tuke.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
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
		String sql = "select * from table_clients WHERE active=1";
		return jdbcTemplate.query(sql, new ClienteRowMapper());
	}
	
	
	// Create GeneratedKeyHolder object
    GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();


	@Override
	public Integer addCliente(Cliente cliente) {
		
		String query = "INSERT INTO table_clients (username, pass, data_base) values (?,?,?)";
		
		// To insert data, you need to pre-compile the SQL and set up the data yourself.
		 int rowsAffected = jdbcTemplate.update(conn -> {
            
            // Pre-compiling SQL
        	PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        	preparedStatement.setString(1, cliente.getUsername());
        	preparedStatement.setString(2, cliente.getPass());
        	preparedStatement.setString(3, cliente.getData_base());
        	preparedStatement.setInt(4, 1);

        	

        	return preparedStatement;
        	
        }, generatedKeyHolder);
        
        // Get auto-incremented ID
        Integer id = generatedKeyHolder.getKey().intValue();
        return id;
		
				 
	}


	@Override
	public void update(String username, int id) {
		String sql = "UPDATE table_clients SET username = ? WHERE id_cliente = ?";
        jdbcTemplate.update(sql, username, id);
		
	}


	@Override
	public void delete(int id) {
		String sql = "UPDATE table_clients SET active = 0 WHERE id_cliente = ?";
        jdbcTemplate.update(sql,id);
		
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
		cliente.setActive(rs.getInt("active"));
		
		return cliente;
	}

	
	
	
	
}



































