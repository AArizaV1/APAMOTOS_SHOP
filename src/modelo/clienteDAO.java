package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utils.ConexionBD;

public class clienteDAO {

	public static final String ERROR_LOGIN = "ERROR";
	public static final String LOGIN_CORRECTO = "LOGINOK";

	// Constantes que definen el tipo de usuario
	public static final int TIPO_ADMIN = 0;
	public static final int TIPO_CLIENTE = 1;

	public int insertarCliente(clienteVO cliente) {

		// Variables
		String query = "";

		File archivo;
		FileInputStream fis;

		// Por defecto ponemos el valor de fallo
		int resultado = -1;
		PreparedStatement pStmt;

		archivo = new File("/home/usuario/Imágenes/perfil.jpg");

		// Conectamos a la base de datos
		Connection con = ConexionBD.conectar();

		try {

			fis = new FileInputStream(archivo);

			query = "INSERT INTO \"TFG\".cliente(id,nombre,edad,correo,telefono,contrasena,codigo,alta,tipo,ciudad,imagen,documento) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

			// Añadimos la query al preparedStatement
			pStmt = con.prepareStatement(query);

			// Cargamos los datos a la query
			pStmt.setInt(1, cliente.getId());
			pStmt.setString(2, cliente.getNombre());
			pStmt.setInt(3, cliente.getEdad());
			pStmt.setString(4, cliente.getCorreo());
			pStmt.setString(5, cliente.getTelefono());
			pStmt.setString(6, cliente.getContrasena());
			pStmt.setInt(7, cliente.getCodigo());
			pStmt.setBoolean(8, cliente.isAlta());
			pStmt.setInt(9, cliente.getTipo());
			pStmt.setString(10, cliente.getCiudad());
			pStmt.setBinaryStream(11, fis, archivo.length());
			pStmt.setString(12, cliente.getDocumento());

			// Ejecutamos la query
			resultado = pStmt.executeUpdate();

			pStmt.close();
			con.close();
			fis.close();
		} catch (SQLException e) {
			e.printStackTrace();
			resultado = -1;

		} catch (IOException e) {
			e.printStackTrace();

			return resultado;

		}

		return resultado;
	}

	public static clienteVO cargarUsuario(String correo) {
		// Definimos la variable que guardara los datos de la BD
		clienteVO usuario = null;

		// Conectamos con la BD
		Connection con = ConexionBD.conectar();

		// Definimos un ResulSet para recoger los datos de la BD
		ResultSet res = null;

		try {

			String query = "SELECT * FROM \"TFG\".cliente WHERE correo=?";

			// Creamos el PreparedStatement
			PreparedStatement pstmt = con.prepareStatement(query);

			// Añadimos el parametro al preparedstatement
			pstmt.setString(1, correo);

			// Recuperamos de la BD el montadito
			res = pstmt.executeQuery();

			// Cargamos el registro
			if (res.next()) {
				// Creamos un usuario si hay un registro en bd que coincida
				usuario = new clienteVO(res.getString("nombre"), res.getInt("edad"), res.getString("correo"),
						res.getString("telefono"), res.getString("contrasena"), res.getInt("codigo"),
						res.getBoolean("alta"), res.getInt("tipo"), res.getString("ciudad"),
						res.getString("Documento"));

			}

			con.close();
			res.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuario;
	}

	public clienteVO cargarUnCliente(int id)

	{
		// Variables
		ResultSet res;
		String query = "";
		Statement stmt;
		clienteVO cliente = null;

		// Conectamos a la base de datos
		Connection con = ConexionBD.conectar();

		try {

			stmt = con.createStatement();

			query = "SELECT * FROM \"TFG\".cliente WHERE id = " + id;

			res = stmt.executeQuery(query);
			// Si el resulset no esta vacio creamos el clienteVO
			if (res.next()) {
				cliente = new clienteVO(res.getString("nombre"), res.getInt("edad"), res.getString("correo"),
						res.getString("telefono"), res.getString("ciudad"), res.getString("documento"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return cliente;
		}

		// Cerramos las conexiones activas
		try {
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cliente;
	}

	public boolean actualizarCliente(clienteVO cliente)

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

			query = "UPDATE \"TFG\".cliente SET";

			// AÑADIMOS AL UPDATE LOS CAMPOS A MODIFICAR

			if (cliente.getNombre() != null) {
				if (anterior)
					query = query + " , ";
				else
					anterior = true;
				query = query + " nombre=" + "'" + cliente.getNombre() + "'";

			}

			if (cliente.getEdad() != 0) {
				if (anterior)
					query = query + " , ";
				else
					anterior = true;
				query = query + " edad=" + "'" + cliente.getEdad() + "'";

			}

			if (cliente.getCorreo() != null) {
				if (anterior)
					query = query + " , ";
				else
					anterior = true;
				query = query + " correo=" + "'" + cliente.getCorreo() + "'";

			}

			if (cliente.getContrasena() != null) {
				if (anterior)
					query = query + ", ";
				else
					anterior = true;
				query = query + " contrasena=" + "'" + cliente.getContrasena() + "'";

			}

			if (cliente.getCiudad() != null) {
				if (anterior)
					query = query + " , ";
				else
					anterior = true;
				query = query + " ciudad=" + "'" + cliente.getCiudad() + "'";

			}

			if (cliente.getTelefono() != null) {
				if (anterior)
					query = query + " , ";
				else
					anterior = true;
				query = query + " telefono=" + "'" + cliente.getTelefono() + "'";

			}

			query = query + " WHERE documento=" + "'" + cliente.getDocumento() + "'";

			// AÑADIMOS LA QUERY AL PREPAREDSTATEMENT
			pStmt = con.prepareStatement(query);

			// EJECUTAMOS LA QUERY
			numMod = pStmt.executeUpdate();

			// SI NOS DEVUELVE 1 CLIENTE MODIFICADO HA IDO BIEN
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

}
