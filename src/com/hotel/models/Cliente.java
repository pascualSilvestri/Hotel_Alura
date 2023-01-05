package com.hotel.models;

public class Cliente {
	
	private int id;
	private String nombre;
	private String apellido;
	private String nacionalidad;
	private String telefono;
	private String fechaNac; 
	private String numeroReserva;
	

	public Cliente(
			int id,
			String nombre,
			String apellido,
			String nacionalidad,
			String telefono,
			String fechaNac,
			String numReserva
			) {
		this.id = id;
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.numeroReserva = numReserva;
		this.fechaNac = fechaNac;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		
	}


	public Cliente(
			String nombre,
			String apellido,
			String nacionalidad,
			String telefono,
			String fechaNacimiento,
			String numReserva
			) {
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.numeroReserva = numReserva;
		this.fechaNac = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNacionalidad() {
		return nacionalidad;
	}


	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getFechaNac() {
		return fechaNac;
	}


	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}


	public String getNumeroReserva() {
		return numeroReserva;
	}


	public void setNumeroReserva(String numeroReserva) {
		this.numeroReserva = numeroReserva;
	}


	public String getNumeroCliente() {
		return numeroReserva;
	}


	public void setNumeroCliente(String numeroCliente) {
		this.numeroReserva = numeroCliente;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
