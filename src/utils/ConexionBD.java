package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

	public Connection con;

	// FUNCION PARA CONECTAR LA BBDD
	public static Connection conectar() {

		// VARIABLES
		Connection con = null;

		String JDBC_URL = "jdbc:postgresql://ns3034756.ip-91-121-81.eu:5432/a21_aaripat";
		String user = "a21_aaripat";
		String passwd = "a21_aaripat";

		// INTENTAMOS CONECTAR LA BBDD
		try {
			Class.forName("org.postgresql.Driver");

			con = DriverManager.getConnection(JDBC_URL, user, passwd);

			System.out.println("\nSe ha establecido conexion correctamente.");

			// CAPTURAMOS LAS EXCEPCIONES
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("El proyecto no tiene un conector");

			// CAPTURAMOS LAS EXCEPCIONES
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("¡Error al conectarse a la Base de Datos!");
		}

		// DEVOLVEMOS CON
		return con;
	}

}