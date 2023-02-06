package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class actualizarAlta {

	public static int actAlta(String correo) {
		// Definimos la variable que guardara los datos de la BD
		int resultado = -1;
		PreparedStatement pstmt;
		// Conectamos con la BD
		Connection con = ConexionBD.conectar();

		try {

			String query = "UPDATE \"TFG\".cliente SET alta = 'true' WHERE correo = ?";

			// Creamos el PreparedStatement
			pstmt = con.prepareStatement(query);

			// Añadimos el parametro al preparedstatement
			pstmt.setString(1, correo);

			// Recuperamos de la BD el cliente
			resultado = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			resultado = -1;
			return resultado;
		}
		// Cerramos las conexiones activas
		try {
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;

	}

}
