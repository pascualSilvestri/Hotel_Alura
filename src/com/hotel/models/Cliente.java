package com.hotel.models;

import com.toedter.calendar.JCalendar;

public class Cliente extends Persona{
	
	private String nacionalidad;
	private Integer telefono;
	private JCalendar fechaNac; 
	private String numeroReserva;
	

	public Cliente(String nombre, Integer dni,String nacionalidad,Integer telefono,JCalendar fechaNac, String numeroCliente) {
		super(nombre, dni);
		this.numeroReserva = numeroCliente;
		this.fechaNac = fechaNac;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		
	}


	public String getNacionalidad() {
		return nacionalidad;
	}


	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}


	public Integer getTelefono() {
		return telefono;
	}


	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}


	public JCalendar getFechaNac() {
		return fechaNac;
	}


	public void setFechaNac(JCalendar fechaNac) {
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
	
	

}
