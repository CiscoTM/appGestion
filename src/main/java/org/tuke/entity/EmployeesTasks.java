package org.tuke.entity;

import java.sql.Timestamp;

public class EmployeesTasks {
	
	private int employee_id;
	private Timestamp date_at;
	private String task_name;
	
	
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public Timestamp getDate_at() {
		return date_at;
	}
	public void setDate_at(Timestamp date_at) {
		this.date_at = date_at;
	}
	public String getTask_name() {
		return task_name;
	}
	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}
	@Override
	public String toString() {
		return "EmployeesTasks [employee_id=" + employee_id + ", date_at=" + date_at + ", task_name=" + task_name + "]";
	}
	
	
	
	
	

}
