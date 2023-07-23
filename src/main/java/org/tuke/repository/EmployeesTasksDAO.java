package org.tuke.repository;

import java.util.List;

import org.tuke.entity.EmployeesTasks;


public interface EmployeesTasksDAO {
	
	List<EmployeesTasks> findAll();

}
