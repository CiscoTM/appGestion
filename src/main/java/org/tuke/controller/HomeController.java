package org.tuke.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.tuke.entity.Cliente;
import org.tuke.entity.EmployeesTasks;
import org.tuke.entity.Task;
import org.tuke.repository.ClienteDAO;
import org.tuke.repository.EmployeesTasksDAO;
import org.tuke.repository.TaskDAO;

@Controller
public class HomeController {
	
	@Autowired
	ClienteDAO dao;
	
	@Autowired
	TaskDAO Taskdao;
	
	@Autowired
	EmployeesTasksDAO employeesTasksDAO;
	
	@RequestMapping("/")
	public ModelAndView getClientes(ModelAndView model) {
		
		List<Cliente> clientes = dao.findAll();
		
		model.addObject("clientes", clientes);
		model.setViewName("inicio");

		return model;
	}
	
	@RequestMapping("/task")
	public ModelAndView getTasks(ModelAndView model) {
		
		List<Task> tasks = Taskdao.findAll();
		
		model.addObject("tasks", tasks);
		model.setViewName("task");

		return model;
	}
	
	@RequestMapping("/horario")
	public ModelAndView getHorario(ModelAndView model) {
		
		List<EmployeesTasks> listado = employeesTasksDAO.findAll();
		
		model.addObject("listado",listado);
		model.setViewName("horario");
		
		return model;
		
	}
	
	
	public List<String> getDays(){
		
		List<String>dias=new ArrayList<String>();
		List<EmployeesTasks> listado = employeesTasksDAO.findAll();
		for (EmployeesTasks e : listado) {
			
			Date fecha = e.getDate_at();
			dias.add(String.valueOf(fecha.getDay()));
			
		}
		
		return dias;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
