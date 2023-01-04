package com.hotel.models;

import java.util.Date;

public class Reserva {
	
	private int numeroReserva;
	private String fechaEntrada;
	private String fechaSalida;
	private long valor;
	private String formaPago;
	
	public Reserva(
			int numeroReserva,
			 String fechaEntrada,
			 String fechaSalida,
			long valor,
			String formaPago
			) {
		this.numeroReserva = numeroReserva;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valor = valor;
		this.formaPago = formaPago;
	}

	public Reserva(
			 String fechaEntrada,
			 String fechaSalida,
			long valor,
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

	public String getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada( String fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public  String getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida( String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public long getValor() {
		return valor;
	}

	public void setValor(long valor) {
		this.valor = valor;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	
	
	
	
	
}
