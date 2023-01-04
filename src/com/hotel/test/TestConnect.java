package com.hotel.test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hotel.connect.ConnectFactory;
import java.sql.Statement;

public class TestConnect {
	

	Connection con;
	
	public TestConnect() {
		this.con = (Connection) new ConnectFactory();
	}
	
	public void datos() {
		try {
            PreparedStatement statement;
                statement = con.prepareStatement(
                        "INSERT INTO RESERVA "
                        + "(fecha_de_entrada, fecha_de_salida, valor,forma_de_pago)"
                        + " VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
    
            try (statement) {
                statement.setString(1, "fecha_de_entrada");
                statement.setString(2, "fecha_de_salida");
                statement.setNString(3, "valor");
                statement.setString(4, "forma_de_pago");
    
                statement.execute();
    
                final ResultSet resultSet = statement.getGeneratedKeys();
    
                try (resultSet) {
                    while (resultSet.next()) {
                       System.out.println(resultSet.getInt(1)); 
                       
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	
	public static void main(String[] args) {
		
	}
	
	
}
