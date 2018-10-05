package br.com.senac.pi4.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {

	private static Database instance = null;
	
	private Database () {};
	
	public static Database get () {
		if (instance == null)
			instance = new Database();
		return instance;
	}
	
	public Connection conn () throws Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
		String connectionUrl = "jdbc:sqlserver://192.168.1.228\\SQLEXPRESS;user=sa;password=@admin;database=facenac";
//		String connectionUrl = "jdbc:sqlserver://josiasveras.database.windows.net;user=jorzias;password=my0wn4zur3;database=PI4";
		Connection conn = DriverManager.getConnection(connectionUrl);

		return conn;
	}
	
}
