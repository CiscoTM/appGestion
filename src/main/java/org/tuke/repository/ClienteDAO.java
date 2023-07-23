package org.tuke.repository;

import java.util.List;

import org.tuke.entity.Cliente;

public interface ClienteDAO {
	
	List<Cliente> findAll();
	
	int addClienteWithSimpleJdbcInsert(Cliente cliente);

}
