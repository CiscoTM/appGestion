package org.tuke.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tuke.entity.Cliente;
import org.tuke.repository.ClienteDAO;



@RestController
@RequestMapping("/api")
public class HomeController {
	
	@Autowired
	private ClienteDAO repository;

	
	@GetMapping
	public ResponseEntity<Object> get(){ 
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Cliente> list  = repository.findAll();
			return new ResponseEntity<Object>(list,HttpStatus.OK);
		} 
		catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
 	}
	
	@PostMapping
	public Integer create(@RequestBody Cliente cliente){ 
		return repository.addCliente(cliente);
	}
	
	@PutMapping("/update/{id}")
	public void update(@RequestBody String username, @PathVariable int id) {
		
		repository.update(username, id);
	}
	
	@PutMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		
		repository.delete(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
