package org.tuke.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.tuke.entity.Cliente;
import org.tuke.entity.EmployeesTasks;
import org.tuke.entity.Task;
import org.tuke.repository.ClienteDAO;
import org.tuke.repository.ClienteDAOImpl;
import org.tuke.repository.EmployeesTasksDAO;
import org.tuke.repository.TaskDAO;



@RestController
@RequestMapping("/api")
public class HomeController {
	
	@Autowired
	private ClienteDAO repository;

	
	
	
	@GetMapping()
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
	
	@PostMapping("/edit")
	public void create(@RequestBody Cliente cliente){ 
		repository.addCliente(cliente);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
