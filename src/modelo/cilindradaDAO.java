package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utils.ConexionBD;

public class cilindradaDAO {

	public int insertarCilindrada(cilindradaVO cilindrada) {

		// VARIABLES
		String query = "";
		PreparedStatement pStmt;

		// POR DEFECTO PONEMOS EL VALOR DE FALLO
		int resultado = -1;

		// CONECTAMOS A LA BASE DE DATOS
		Connection con = ConexionBD.conectar();

		try {

			query = "INSERT INTO \"TFG\".cilindrada(id,nombre) VALUES (?,?)";

			// AÑADIMOS ELEMENTOS AL PREPAREDSTATEMENT
			pStmt = con.prepareStatement(query);

			// CARGAMOS LOS DATOS A LA QUERY
			pStmt.setInt(1, cilindrada.getId());
			pStmt.setString(2, cilindrada.getNombre());

			// EJECUTAMOS LA QUERY
			resultado = pStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			resultado = -1;
			return resultado;
		}
		// CERRAMOS LAS CONEXIONES ACTIVAS
		try {
			pStmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}

	public boolean modificarCilindrada(cilindradaVO cilindrada)

	{
		// VARIABLES
		int numMod = -1;
		String query = "";
		PreparedStatement pStmt;
		boolean modCorrecto = false;
		boolean anterior = false;

		// CONECTAMOS A LA BASE DE DATOS
		Connection con = ConexionBD.conectar();

		try {

			query = "UPDATE \"TFG\".cilindrada SET";

			// AÑADIMOS AL UPDATE LOS CAMPOS A MODIFICAR
			if (cilindrada.getId() != 0) {
				query = query + " id='" + cilindrada.getId() + "'";
				anterior = true;
			}

			if (cilindrada.getNombre() != null) {
				if (anterior)
					query = query + " , ";
				else
					anterior = true;
				query = query + " nombre=" + cilindrada.getNombre();

			}

			query = query + " WHERE id=? ";

			// AÑADIMOS LA QUERY AL PREPAREDSTATEMENT
			pStmt = con.prepareStatement(query);

			// AÑADIMOS EL ID
			pStmt.setInt(1, cilindrada.getId());

			// EJECUTAMOS LA QUERY
			numMod = pStmt.executeUpdate();

			// SI NOS DEVUELVE 1 cilindrada MODIFICADO
			// HA IDO BIEN
			if (numMod == 1)
				modCorrecto = true;

			pStmt.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}

		// CERRAMOS LAS CONEXIONES ACTIVAS
		try {

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return modCorrecto;
	}

	public int eliminarCilindrada(cilindradaVO cilindrada) {

		// Variables
		String query = "";
		// Por defecto ponemos el valor de fallo
		int resultado = -1;
		PreparedStatement pStmt;

		// Conectamos a la base de datos
		Connection con = ConexionBD.conectar();

		try {

			query = "DELETE FROM \"TFG\".cilindrada WHERE nombre = ?";

			pStmt = con.prepareStatement(query);

			pStmt.setString(1, cilindrada.getNombre());

			resultado = pStmt.executeUpdate();

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

	public ArrayList<cilindradaVO> cargarCilindrada()

	{
		// Variables
		ResultSet res;
		String query = "";
		Statement stmt;
		cilindradaVO cilindrada = null;

		// Arraylist para guardar la cilindrada con el nombre recibido
		ArrayList<cilindradaVO> cilindradas = new ArrayList<cilindradaVO>();

		// Concetamos a la base de datos
		Connection con = ConexionBD.conectar();

		try {

			stmt = con.createStatement();

			// Creamos la consulta
			query = "SELECT * FROM \"TFG\".cilindrada";

			// Ejecutamos la query
			res = stmt.executeQuery(query);

			// Si el resulset no esta vacio creamos el cilindradaVO
			while (res.next()) {

				// Creamos un cilindradaVO con los datos de la query
				cilindrada = new cilindradaVO(res.getInt("id"), res.getString("nombre"));

				// Añado al array
				cilindradas.add(cilindrada);

			}

		} catch (SQLException e) {
			e.printStackTrace();
			return cilindradas;
		}
		// Cerramos las conexiones activas
		try {
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cilindradas;
	}

}
