package com.hotel.models;

public class Empleado extends Persona {
	
	private String password;
	
	private String usuario;
	
	public Empleado(String nombre, Integer dni, String password, String usuario) {
		super(nombre, dni);
		this.password = password;
		this.usuario = usuario;
		// TODO Auto-generated constructor stub
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	

}
