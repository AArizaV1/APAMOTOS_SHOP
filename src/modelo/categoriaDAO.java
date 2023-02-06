package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utils.ConexionBD;

public class categoriaDAO {

	public int insertarCategoria(categoriaVO categoria) {

		// VARIABLES
		String query = "";
		PreparedStatement pStmt;

		// POR DEFECTO PONEMOS EL VALOR DE FALLO
		int resultado = -1;

		// CONECTAMOS A LA BASE DE DATOS
		Connection con = ConexionBD.conectar();

		try {

			query = "INSERT INTO \"TFG\".categoria(id,nombre) VALUES (?,?)";

			// AÑADIMOS ELEMENTOS AL PREPAREDSTATEMENT
			pStmt = con.prepareStatement(query);

			// CARGAMOS LOS DATOS A LA QUERY
			pStmt.setInt(1, categoria.getId());
			pStmt.setString(2, categoria.getNombre());

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

	public boolean modificarCategoria(categoriaVO categoria)

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

			query = "UPDATE \"TFG\".categoria SET";

			// AÑADIMOS AL UPDATE LOS CAMPOS A MODIFICAR
			if (categoria.getId() != 0) {
				query = query + " id='" + categoria.getId() + "'";
				anterior = true;
			}

			if (categoria.getNombre() != null) {
				if (anterior)
					query = query + " , ";
				else
					anterior = true;
				query = query + " nombre=" + categoria.getNombre();

			}

			query = query + " WHERE id=? ";

			// AÑADIMOS LA QUERY AL PREPAREDSTATEMENT
			pStmt = con.prepareStatement(query);

			// AÑADIMOS EL ID
			pStmt.setInt(1, categoria.getId());

			// EJECUTAMOS LA QUERY
			numMod = pStmt.executeUpdate();

			// SI NOS DEVUELVE 1 CATEGORIA MODIFICADO
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

	public int eliminarCategoria(categoriaVO categoria) {

		// Variables
		String query = "";
		// Por defecto ponemos el valor de fallo
		int resultado = -1;
		PreparedStatement pStmt;

		// Conectamos a la base de datos
		Connection con = ConexionBD.conectar();

		try {

			query = "DELETE FROM \"TFG\".categoria WHERE nombre = ?";

			pStmt = con.prepareStatement(query);

			pStmt.setString(1, categoria.getNombre());

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

	public ArrayList<categoriaVO> cargarCategoria()

	{
		// Variables
		ResultSet res;
		String query = "";
		Statement stmt;
		categoriaVO categoria = null;

		// Arraylist para guardar la categoria con el nombre recibido
		ArrayList<categoriaVO> categorias = new ArrayList<categoriaVO>();

		// Concetamos a la base de datos
		Connection con = ConexionBD.conectar();

		try {

			stmt = con.createStatement();

			// Creamos la consulta
			query = "SELECT * FROM \"TFG\".categoria";

			// Ejecutamos la query
			res = stmt.executeQuery(query);

			// Si el resulset no esta vacio creamos el categoriaVO
			while (res.next()) {

				// Creamos un categoriaVO con los datos de la query
				categoria = new categoriaVO(res.getInt("id"), res.getString("nombre"));

				// Añado la categoria al array
				categorias.add(categoria);

			}

		} catch (SQLException e) {
			e.printStackTrace();
			return categorias;
		}
		// Cerramos las conexiones activas
		try {
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categorias;
	}

	public static int obtenerId(int categoria) {

		int id = 0;

		// Variables
		String query = "";
		// Por defecto ponemos el valor de fallo
		PreparedStatement pStmt;
		ResultSet rs;

		// Conectamos a la base de datos
		Connection con = ConexionBD.conectar();

		try {

			query = "SELECT id FROM \"TFG\".categoria WHERE nombre = ?";

			pStmt = con.prepareStatement(query);

			pStmt.setInt(1, categoria);

			rs = pStmt.executeQuery();

			while (rs.next()) {
				id = rs.getInt("id");
			}

			pStmt.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return id;

	}

}
