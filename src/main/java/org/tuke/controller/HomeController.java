package org.tuke.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

	
	@GetMapping("/clientes")
	public List<Cliente> getAll(){
		
		return repository.findAll();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
