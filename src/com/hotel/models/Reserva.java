package com.hotel.models;

import java.util.Date;

public class Reserva {
	
	private int numeroReserva;
	private Date fechaEntrada;
	private Date fechaSalida;
	private int valor;
	private String formaPago;
	
	public Reserva(
			int numeroReserva,
			Date fechaEntrada,
			Date fechaSalida,
			int valor,
			String formaPago
			) {
		this.numeroReserva = numeroReserva;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valor = valor;
		this.formaPago = formaPago;
	}

	public Reserva(
			Date fechaEntrada,
			Date fechaSalida,
			int valor,
			String formaPago
			) {
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valor = valor;
		this.formaPago = formaPago;
	}

	public int getNumeroReserva() {
		return numeroReserva;
	}

	public void setNumeroReserva(int numeroReserva) {
		this.numeroReserva = numeroReserva;
	}

	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	
	
	
	
	
}
