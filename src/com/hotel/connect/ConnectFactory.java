package com.hotel.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.cj.jdbc.Driver;

public class ConnectFactory {
	
	
	   
     private DataSource dataSource;
    public ConnectFactory() {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/hotel_alura?serverTimezone=UTC ");
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



//creacion de manera comun
/*	
public Connection recuperaConexion() {
    try {	
        return DriverManager.getConnection("jdbc:mysql://localhost/hotel_alura?useTimeZone=true&serverTimeZone=UTC","root","0716");
       
    } catch (SQLException e) {
        System.out.println("No se conecto");
        throw new RuntimeException(e);
    }
}
*/

//Creacion con pool De Ejecicion
 



}
