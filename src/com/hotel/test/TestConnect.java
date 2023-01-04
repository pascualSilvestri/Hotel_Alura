package com.hotel.test;
import com.hotel.connect.ConnectFactory;

public class TestConnect {
	
	ConnectFactory con;
	
	public TestConnect() {
		this.con = new ConnectFactory();
	}
	
	
	public void datos() {
		con.recuperaConexion();
	}
	
	public static void main(String[] args) {
		 ConnectFactory con = new ConnectFactory();
		System.out.println(con.recuperaConexion());
		
		
		
	}
}
