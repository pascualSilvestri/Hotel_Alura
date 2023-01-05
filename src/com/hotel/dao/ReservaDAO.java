package com.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hotel.models.Cliente;
import com.hotel.models.Reserva;

public class ReservaDAO {
	
	private Connection con;
	
	public ReservaDAO(Connection con) {
		this.con =  con;
	}
	
	public void reservar(Reserva reserva) {
		 try {
	            final PreparedStatement statement;
	                statement = con.prepareStatement(
	                        "INSERT INTO RESERVA "
	                        + "(fecha_de_entrada, fecha_de_salida, valor,forma_de_pago)"
	                        + " VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
	    
	            try (statement) {
	                statement.setString(1, reserva.getFechaEntrada());
	                statement.setString(2, reserva.getFechaSalida());
	                statement.setLong(3, reserva.getValor());
	                statement.setString(4, reserva.getFormaPago());
	    
	                statement.execute();
	                ResultSet resultSet = statement.getGeneratedKeys();
		            try (resultSet) {
			            while(resultSet.next()) {
			            	reserva.setId(resultSet.getInt(1));
			            	
			            }
		            }
	    
	            }
	            
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	}
	

	public void reservaCliente(Cliente cliente, int id) {
		try {
            final PreparedStatement statement;
                statement = con.prepareStatement(
                        "INSERT INTO CLIENTE "
                        + "(nombre, apellido, fecha_nacimiento,nacionalidad,telefono,reserva_id)"
                        + " VALUES (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
    
            try (statement) {
                statement.setString(1, cliente.getNombre());
                statement.setString(2, cliente.getApellido());
                statement.setString(3, cliente.getFechaNac());
                statement.setString(4, cliente.getNacionalidad());
                statement.setInt(5, cliente.getTelefono());
                statement.setInt(6, id);
                
                statement.execute();
                ResultSet resultSet = statement.getGeneratedKeys();
	            try (resultSet) {
		            while(resultSet.next()) {
		            	cliente.setId(resultSet.getInt(1));
		            	
		            }
	            }
    
            }
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}

}
