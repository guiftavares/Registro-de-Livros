package RegistroLivros;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class BaseConnection {
	String serverName = "localhost";
	String mydatabase = "book";
	String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
	String username = "root"; 
	String password = "#######"; //Inserir senha
	Connection connection;
	
	BaseConnection() throws SQLException{
		connection = DriverManager.getConnection(url, username, password);
	}

}
