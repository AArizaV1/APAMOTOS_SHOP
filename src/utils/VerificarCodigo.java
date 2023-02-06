package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VerificarCodigo {

	public static int verificarCodigo(int codigo) {

		// Variables
		String query = "";
		PreparedStatement pStmt;
		ResultSet rs;

		// Por defecto ponemos el valor de fallo
		int resultado = -1;

		// Conectamos a la base de datos
		Connection con = ConexionBD.conectar();

		try {

			query = "SELECT codigo from \"TFG\".cliente WHERE codigo = ?";

			// Añadimos la query al preparedStatement
			pStmt = con.prepareStatement(query);

			pStmt.setInt(1, codigo);

			// Ejecutamos la query
			rs = pStmt.executeQuery();

			while (rs.next()) {
				resultado = rs.getInt("codigo");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			resultado = -1;
			return resultado;
		}
		// Cerramos las conexiones activas
		try {
			pStmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}

}
