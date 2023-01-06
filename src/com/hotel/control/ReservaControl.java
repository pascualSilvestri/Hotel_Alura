package com.hotel.control;

import java.util.List;

import com.hotel.connect.ConnectFactory;
import com.hotel.dao.ReservaDAO;
import com.hotel.models.Cliente;
import com.hotel.models.Reserva;

public class ReservaControl {
	
	ReservaDAO<?> reservaDAO;
	
	private int id;
	
	
	
	public ReservaControl() {
		var con = new ConnectFactory();
        this.reservaDAO = new ReservaDAO(con.recuperaConexion());
	}
	
	public String returnNumReserva() {
		return String.valueOf(reservaDAO.returnarUltimaReserva().get(0));
	}
	
	public void guardar(Reserva reserva) {
		reservaDAO.reservar(reserva);
		this.id = reserva.getId();
	}
	
	public void guardarCliente(Cliente cliente) {
		System.out.println(id);
		reservaDAO.reservaCliente(cliente);
	}
	
	public List<Cliente> listaCliente() {
		return reservaDAO.listaCliente();
	}
	
	
	public List<Reserva> listaReserva(){
		return reservaDAO.listaReserva();
	}

	public int eliminarReserva(int id) {
		return reservaDAO.eliminarReserva(id);
	}
	
	public int eliminarCliente(int id) {
		return reservaDAO.eliminarCliente(id);
	}
	
	

}
