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

	public List<Reserva> ListaId(int id) {
		return reservaDAO.listaId(id);
		
	}

	public List<Cliente> ListaApellido(String busqueda) {
		
		return reservaDAO.listaApellido(busqueda);
	}

	public int modificarReserva(Integer id, String fechaEntrada, String fechaSalidad, Integer valor, String formaPago) {
		
		return reservaDAO.modificarReserva(id,fechaEntrada,fechaSalidad,valor,formaPago);
	}

	public int modificarCliente(Integer id, String nombre, String apellido, String fechaNac, String nacionalidad,
			String telefono, Integer reservaId) {
		
		return reservaDAO.modificarCliente(id,nombre, apellido, fechaNac, nacionalidad,
			telefono, reservaId);
	}
	
	

}
