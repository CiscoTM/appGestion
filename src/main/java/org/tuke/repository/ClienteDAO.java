package org.tuke.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.tuke.entity.Cliente;

@Repository
public interface ClienteDAO {
	
	List<Cliente> findAll();
	Integer addCliente(Cliente cliente);
	void update(String username, int id);
	void delete(int id);
	
	

}
