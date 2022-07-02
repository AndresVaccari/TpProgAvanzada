package entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	public static Connection getConexion()
	{
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/tpfinal", "root", "");
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}
}