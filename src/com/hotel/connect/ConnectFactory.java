package com.hotel.connect;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectFactory {
	
private DataSource dataSource;
    
    public ConnectFactory() {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/hotel_alura?useTimeZone=true&serverTimeZone=UTC");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("0716");
        comboPooledDataSource.setMaxPoolSize(10);
        
        this.dataSource = comboPooledDataSource;
    }

    public Connection recuperaConexion() {
        try {
        	System.out.println("se Conecto");
            return this.dataSource.getConnection();
           
        } catch (SQLException e) {
            System.out.println("No se conecto");
            throw new RuntimeException(e);
        }
    }


}
