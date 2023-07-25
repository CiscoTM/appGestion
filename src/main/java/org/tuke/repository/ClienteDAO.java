package org.tuke.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.tuke.entity.Cliente;

@Repository
public interface ClienteDAO {
	
	List<Cliente> findAll();
	
	int addClienteWithSimpleJdbcInsert(Cliente cliente);

}
