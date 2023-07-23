package org.tuke.entity;

public class Cliente {

	private int id_cliente;
	private String username;
	private String pass;
	private String data_base;
	
	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getData_base() {
		return data_base;
	}
	public void setData_base(String data_base) {
		this.data_base = data_base;
	}
	@Override
	public String toString() {
		return "Clientes [id_cliente=" + id_cliente + ", username=" + username + ", pass=" + pass + ", data_base="
				+ data_base + "]";
	}
	
	
}
