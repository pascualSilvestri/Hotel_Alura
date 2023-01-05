package com.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hotel.models.Cliente;
import com.hotel.models.Reserva;

public class ReservaDAO<E> {
	
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
	
	public void reservaCliente(Cliente cliente) {
		int id = returnarUltimaReserva().get(0);
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
                statement.setString(5, cliente.getTelefono());
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
	
	public List<Integer> returnarUltimaReserva() {
		List<Integer> resultado = new ArrayList<>();
		try {
            final PreparedStatement statement;
                statement = con.prepareStatement(
                        "SELECT *\r\n"
                        + "FROM RESERVA\r\n"
                        + "ORDER by ID DESC\r\n"
                        + "LIMIT 1; ", Statement.RETURN_GENERATED_KEYS);
    
            try (statement) {
                
                statement.execute();
                ResultSet resultSet = statement.getResultSet();
                while(resultSet.next()) {
                	resultado.add(resultSet.getInt(1));
                }
		        
            }
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
		return resultado;
	}

	public List<Reserva> listaReserva(){
		List<Reserva> resultado = new ArrayList<>();
		
		try {
            final PreparedStatement statement;
                statement = con.prepareStatement(
                        "SELECT *"
                        + "FROM RESERVA", Statement.RETURN_GENERATED_KEYS);
    
            try (statement) {
                
                statement.execute();
                ResultSet resultSet = statement.getResultSet();
                while(resultSet.next()) {
                	resultado.add(new Reserva(
                			resultSet.getInt("ID"),
                			resultSet.getString("fecha_de_entrada"),
                			resultSet.getString("fecha_de_salida"),
                			resultSet.getLong("valor"),
                			resultSet.getString("forma_de_pago")));
                }
		        
            }
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
		
		return resultado;
	}

	public List<Cliente> listaCliente(){
		List<Cliente> resultado = new ArrayList<>();
		
		try {
            final PreparedStatement statement;
                statement = con.prepareStatement(
                        "SELECT *"
                        + "FROM CLIENTE", Statement.RETURN_GENERATED_KEYS);
    
            try (statement) {
                
                statement.execute();
                ResultSet resultSet = statement.getResultSet();
                while(resultSet.next()) {
                	resultado.add(new Cliente(
                			resultSet.getInt("ID"),
                			resultSet.getString("nombre"),
                			resultSet.getString("APELLIDO"),
                			resultSet.getString("FECHA_NACIMIENTO"),
                			resultSet.getString("NACIONALIDAD"),
                			resultSet.getString("TELEFONO"),
                			resultSet.getString("RESERVA_ID")));
                }
		        
            }
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
		
		return resultado;
	}

	public int eliminar(int id) {
		  try {
	            final PreparedStatement statement = con.prepareStatement("DELETE FROM RESERVA WHERE ID = ?");

	            try (statement) {
	                statement.setInt(1, id);
	                statement.execute();

	                int updateCount = statement.getUpdateCount();

	                return updateCount;
	            }
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	}
}
