package com.hotel.control;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hotel.connect.ConnectFactory;
import com.hotel.models.Reserva;

public class ReservaControl {
	
	
	
	Connection con;
	
	public ReservaControl() {
		this.con = (Connection) new ConnectFactory();
	}
	
	public void reservar(Reserva reserva) {
		 try {
	            PreparedStatement statement;
	                statement = con.prepareStatement(
	                        "INSERT INTO PRODUCTO "
	                        + "(fecha_de_entrada, fecha_de_salida, valor,forma_de_pago)"
	                        + " VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
	    
	            try (statement) {
	                statement.setDate(1, (Date) reserva.getFechaEntrada());
	                statement.setDate(2, (Date) reserva.getFechaSalida());
	                statement.setInt(3, reserva.getValor());
	                statement.setString(4, reserva.getFormaPago());
	    
	                statement.execute();
	    
	                final ResultSet resultSet = statement.getGeneratedKeys();
	    
	                try (resultSet) {
	                    while (resultSet.next()) {
	                        reserva.setNumeroReserva(resultSet.getInt(1));
	                        
	                        System.out.println(String.format("Fue insertado el reserva: %s", reserva));
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	}

}
