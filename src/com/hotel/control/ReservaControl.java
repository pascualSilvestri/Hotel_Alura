package com.hotel.control;

import com.hotel.connect.ConnectFactory;
import com.hotel.dao.ReservaDAO;
import com.hotel.models.Cliente;
import com.hotel.models.Reserva;

public class ReservaControl {
	
	ReservaDAO reservaDAO;
	
	int id;
	
	public ReservaControl() {
		var con = new ConnectFactory();
        this.reservaDAO = new ReservaDAO(con.recuperaConexion());
	}
	
	public void guardar(Reserva reserva) {
		reservaDAO.reservar(reserva);
		this.id = reserva.getId();
	}
	
	public void guardarCliente(Cliente cliente) {
		reservaDAO.reservaCliente(cliente, id);
	}

}
