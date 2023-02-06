package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.text.AbstractDocument.BranchElement;

import utils.ConexionBD;

public class articuloDAO {

	static Connection con = ConexionBD.conectar();

	public int filtroArticulo = 0;
	public int filtroFamilia = 0;
	public int filtroCilindrada = 0;

	public static final int NOMBREASC = 1;
	public static final int NOMBREDESC = 2;
	public static final int PRECIOASC = 3;
	public static final int PRECIODESC = 4;

	public void setFiltroArticulo(int filtroArticulo) {
		this.filtroArticulo = filtroArticulo;
	}

	public void setFiltroFamilia(int filtroFamilia) {
		this.filtroFamilia = filtroFamilia;
	}

	public void setFiltroCilindrada(int filtroCilindrada) {
		this.filtroCilindrada = filtroCilindrada;
	}

	public int insertarArticulo(articuloVO articulo) {

		// VARIABLES
		String query = "";
		PreparedStatement pStmt;

		File archivo;
		FileInputStream fis;

		// POR DEFECTO PONEMOS EL VALOR DE FALLO
		int resultado = -1;

		archivo = new File("/home/usuario/Imágenes/defecto.png");

		// CONECTAMOS A LA BASE DE DATOS
		Connection con = ConexionBD.conectar();

		try {

			fis = new FileInputStream(archivo);

			query = "INSERT INTO \"TFG\".articulo(nombre, descripcion, precio, codigo, categoria, imagen, idcliente, cilindrada) VALUES (?,?,?,?,?,?,?,?)";

			// AÑADIMOS ELEMENTOS AL PREPAREDSTATEMENT
			pStmt = con.prepareStatement(query);

			// CARGAMOS LOS DATOS A LA QUERY
			pStmt.setString(1, articulo.getNombre());
			pStmt.setString(2, articulo.getDescripcion());
			pStmt.setFloat(3, articulo.getPrecio());
			pStmt.setString(4, articulo.getCodigo());
			pStmt.setInt(5, articulo.getCategoria());
			pStmt.setBinaryStream(6, fis, archivo.length());
			pStmt.setString(7, articulo.getIdCliente());
			pStmt.setInt(8, articulo.getCilindrada());

			// EJECUTAMOS LA QUERY
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

	public int eliminarArticulo(String codigo) {

		// Variables
		String query = "";

		// Por defecto ponemos el valor de fallo
		int resultado = -1;
		PreparedStatement pStmt;

		// Conectamos a la base de datos
		Connection con = ConexionBD.conectar();

		try {

			query = "DELETE FROM \"TFG\".articulo WHERE codigo = ?";

			pStmt = con.prepareStatement(query);

			pStmt.setString(1, codigo);

			resultado = pStmt.executeUpdate();

			// Si se ha borrado 1 registro devolvemos 0 ha ido bien
			if (resultado == 1)
				return 0;

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

	public int actualizarArticulo(articuloVO articulo) {

		// Conectamos con la BD
		Connection con = ConexionBD.conectar();

		PreparedStatement pStmt;

		// Definimos un ResulSet para recoger los datos de la BD
		@SuppressWarnings("unused")
		ResultSet res = null;

		try {

			pStmt = con.prepareStatement(
					"UPDATE \"TFG\".articulo SET nombre = ?, descripcion = ?, precio = ?, categoria = ?, cilindrada = ? WHERE codigo = ? ");

			pStmt.setString(1, articulo.getNombre());
			pStmt.setString(2, articulo.getDescripcion());
			pStmt.setFloat(3, articulo.getPrecio());
			pStmt.setInt(4, articulo.getCategoria());
			pStmt.setInt(5, articulo.getCilindrada());
			pStmt.setString(6, articulo.getCodigo());

			int filasAfectadas = pStmt.executeUpdate();

			// Si no se ha actualizado ningun registro
			// devolvemos fallo
			if (filasAfectadas == 0)
				return -1;

			// Cerramos la conexion con la BD

			pStmt.close();
			con.close();

		} catch (SQLException sqe) {
			sqe.printStackTrace();
			return -1;
		}

		return 0;
	}

	public static ArrayList<articuloVO> cargarArticulos(String documento, int numPagina, int tamanoPagina) {

		// Definimos el arrayList que guardara todos los articulos de la BD
		ArrayList<articuloVO> articulos = new ArrayList<articuloVO>();

		// Conectamos con la BD
		Connection con = ConexionBD.conectar();

		// Definimos un ResulSet para recoger los datos de la BD
		ResultSet res = null;

		try {

			// Creamos el PreparedStatement
			PreparedStatement pstmt = con.prepareStatement(
					"SELECT * FROM \"TFG\".articulo, \"TFG\".cliente WHERE articulo.idcliente = cliente.documento AND cliente.documento=? LIMIT "
							+ tamanoPagina + " OFFSET " + numPagina * (numPagina - 1));

			pstmt.setString(1, documento);

			res = pstmt.executeQuery();

			while (res.next()) {
				// Creamos un articulo y lo cargamos con los datos del resulset
				articuloVO articulo = new articuloVO(res.getString("nombre"), res.getString("descripcion"),
						res.getFloat("precio"), res.getString("codigo"), res.getInt("categoria"),
						res.getInt("cilindrada"));

				// Añadimos
				articulos.add(articulo);

			}

			pstmt.close();
			con.close();
			res.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		// Devolvemos el array cargado con los articulos
		return articulos;

	}

	public ArrayList<articuloVO> cargarArticulosGeneral(int numPagina, int tamanioPagina) {

		// Definimos el arrayList que guardara todos los articulos de la BD
		ArrayList<articuloVO> articulos = new ArrayList<articuloVO>();

		// Conectamos con la BD
		Connection con = ConexionBD.conectar();

		// Definimos un ResulSet para recoger los datos de la BD
		ResultSet res = null;

		try {

			// Creamos el Statement
			Statement stmt = con.createStatement();

			// Recuperamos de la BD el articulo
			res = stmt.executeQuery(
					"SELECT * FROM \"TFG\".articulo LIMIT " + tamanioPagina + " OFFSET " + numPagina * (numPagina - 1));

			while (res.next()) {
				// Creamos un articulo y lo cargamos con los datos del resulset
				articuloVO articulo = new articuloVO(res.getString("nombre"), res.getString("descripcion"),
						res.getFloat("precio"), res.getString("codigo"), res.getInt("categoria"),
						res.getInt("cilindrada"));

				// Añadimos
				articulos.add(articulo);

			}

			stmt.close();
			con.close();
			res.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		// Devolvemos el array cargado con los articulos
		return articulos;

	}

	public ArrayList<articuloVO> cargarArticulosGeneralNOFILTROS() {

		// Definimos el arrayList que guardara todos los articulos de la BD
		ArrayList<articuloVO> articulos = new ArrayList<articuloVO>();

		// Conectamos con la BD
		Connection con = ConexionBD.conectar();

		// Definimos un ResulSet para recoger los datos de la BD
		ResultSet res = null;

		try {

			// Creamos el Statement
			Statement stmt = con.createStatement();

			// Recuperamos de la BD el articulo
			res = stmt.executeQuery("SELECT * FROM \"TFG\".articulo");

			while (res.next()) {
				// Creamos un articulo y lo cargamos con los datos del resulset
				articuloVO articulo = new articuloVO(res.getString("nombre"), res.getString("descripcion"),
						res.getFloat("precio"), res.getString("codigo"), res.getInt("categoria"),
						res.getInt("cilindrada"));

				// Añadimos
				articulos.add(articulo);

			}

			stmt.close();
			con.close();
			res.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		// Devolvemos el array cargado con los articulos
		return articulos;

	}

	public Object[] cargarArticuloVerMas(String codigo) {

		// Definimos el arrayList que guardara todos los articulos de la BD
		articuloVO articulos = null;

		Object[] articulosArray = new Object[24];

		// Conectamos con la BD
		Connection con = ConexionBD.conectar();

		// Definimos un ResulSet para recoger los datos de la BD
		ResultSet res = null;

		try {

			// Creamos el PreparedStatement
			PreparedStatement pstmt = con.prepareStatement(
					"SELECT * FROM \"TFG\".articulo FULL OUTER JOIN  \"TFG\".cliente ON articulo.idcliente = cliente.documento FULL OUTER JOIN \"TFG\".categoria ON articulo.categoria = categoria.id FULL OUTER JOIN \"TFG\".cilindrada ON articulo.cilindrada = cilindrada.id WHERE articulo.codigo = ?");

			pstmt.setString(1, codigo);

			res = pstmt.executeQuery();

			if (res.next()) {

				// Creamos un articulo y lo cargamos con los datos del array

				// ARTICULO
				articulosArray[0] = res.getString(2);
				articulosArray[1] = res.getString(3);
				articulosArray[2] = res.getString(4);
				articulosArray[3] = res.getString(5);
				articulosArray[4] = res.getString(23);
				articulosArray[5] = res.getString(25);

				// USUARIO
				articulosArray[6] = res.getString(11);
				articulosArray[7] = res.getString(12);
				articulosArray[8] = res.getString(13);
				articulosArray[9] = res.getString(18);
				articulosArray[10] = res.getString(20);

			}

			pstmt.close();
			con.close();
			res.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		// Devolvemos el array cargado con los articulos
		return articulosArray;

	}

	public static articuloVO cargarArticulo(String codigo) {

		// Definimos el arrayList que guardara todos los articulos de la BD
		articuloVO articulos = null;

		// Conectamos con la BD
		Connection con = ConexionBD.conectar();

		// Definimos un ResulSet para recoger los datos de la BD
		ResultSet res = null;

		try {

			// Creamos el PreparedStatement
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM \"TFG\".articulo WHERE codigo = ?");

			pstmt.setString(1, codigo);

			res = pstmt.executeQuery();

			if (res.next()) {
				// Creamos un articulo y lo cargamos con los datos del resulset
				articulos = new articuloVO(res.getString("nombre"), res.getString("descripcion"),
						res.getFloat("precio"), res.getString("codigo"), res.getInt("categoria"),
						res.getInt("cilindrada"));

			}

			pstmt.close();
			con.close();
			res.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		// Devolvemos el array cargado con los articulos
		return articulos;

	}

	public ArrayList<articuloVO> cargarCatCil(int numPagina, int tamanoPagina) {

		String filtro = null;

		switch (filtroArticulo) {

		case NOMBREASC:
			filtro = "nombre ASC";
			break;

		case NOMBREDESC:
			filtro = "nombre DESC";
			break;

		case PRECIOASC:
			filtro = "precio ASC";
			break;

		case PRECIODESC:
			filtro = "precio DESC";
			break;

		}

		// Definimos el arrayList que guardara todos los articulos de la BD
		ArrayList<articuloVO> articulos = new ArrayList<articuloVO>();

		// Conectamos con la BD
		Connection con = ConexionBD.conectar();

		// Definimos un ResulSet para recoger los datos de la BD
		ResultSet res = null;

		try {
			// Creamos el Statement
			Statement stmt = con.createStatement();

			// Recuperamos de la BD el articulo
			res = stmt.executeQuery(
					"SELECT articulo.nombre, articulo.descripcion, articulo.precio, articulo.codigo, articulo.categoria,"
							+ " cilindrada.nombre FROM  \"TFG\".articulo INNER JOIN \"TFG\".cilindrada ON articulo.cilindrada=cilindrada.id"
							+ " AND articulo.categoria=" + filtroFamilia + " AND articulo.cilindrada="
							+ filtroCilindrada + " ORDER BY articulo." + filtro + " LIMIT " + tamanoPagina + " OFFSET "
							+ tamanoPagina * (numPagina - 1) + "");

			while (res.next()) {
				// Creamos un articulo y lo cargamos con los datos del resulset
				articuloVO articulo = new articuloVO(res.getString("nombre"), res.getString("descripcion"),
						res.getFloat("precio"), res.getString("codigo"), res.getInt("categoria"));

				// Añadimos
				articulos.add(articulo);

			}

			stmt.close();
			con.close();
			res.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		// Devolvemos el array cargado con los articulos
		return articulos;

	}

	public ArrayList<articuloVO> cargarCat(int numPagina, int tamanoPagina) {

		String filtro = null;

		switch (filtroArticulo) {

		case NOMBREASC:
			filtro = "nombre ASC";
			break;

		case NOMBREDESC:
			filtro = "nombre DESC";
			break;

		case PRECIOASC:
			filtro = "precio ASC";
			break;

		case PRECIODESC:
			filtro = "precio DESC";
			break;

		}

		// Definimos el arrayList que guardara todos los articulos de la BD
		ArrayList<articuloVO> articulos = new ArrayList<articuloVO>();

		// Conectamos con la BD
		Connection con = ConexionBD.conectar();

		// Definimos un ResulSet para recoger los datos de la BD
		ResultSet res = null;

		try {
			// Creamos el Statement
			Statement stmt = con.createStatement();

			// Recuperamos de la BD el articulo
			res = stmt.executeQuery(
					"SELECT articulo.nombre, articulo.descripcion, articulo.precio, articulo.codigo, articulo.categoria,"
							+ " cilindrada.nombre FROM  \"TFG\".articulo INNER JOIN \"TFG\".cilindrada ON articulo.cilindrada=cilindrada.id"
							+ " AND articulo.categoria=" + filtroFamilia + " ORDER BY articulo." + filtro + " LIMIT "
							+ tamanoPagina + " OFFSET " + tamanoPagina * (numPagina - 1) + "");

			while (res.next()) {
				// Creamos un articulo y lo cargamos con los datos del resulset
				articuloVO articulo = new articuloVO(res.getString("nombre"), res.getString("descripcion"),
						res.getFloat("precio"), res.getString("codigo"), res.getInt("categoria"));

				// Añadimos
				articulos.add(articulo);

			}

			stmt.close();
			con.close();
			res.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		// Devolvemos el array cargado con los articulos
		return articulos;

	}

	public ArrayList<articuloVO> cargarCil(int numPagina, int tamanoPagina) {

		String filtro = null;

		switch (filtroArticulo) {

		case NOMBREASC:
			filtro = "nombre ASC";
			break;

		case NOMBREDESC:
			filtro = "nombre DESC";
			break;

		case PRECIOASC:
			filtro = "precio ASC";
			break;

		case PRECIODESC:
			filtro = "precio DESC";
			break;

		}

		// Definimos el arrayList que guardara todos los articulos de la BD
		ArrayList<articuloVO> articulos = new ArrayList<articuloVO>();

		// Conectamos con la BD
		Connection con = ConexionBD.conectar();

		// Definimos un ResulSet para recoger los datos de la BD
		ResultSet res = null;

		try {
			// Creamos el Statement
			Statement stmt = con.createStatement();

			// Recuperamos de la BD el articulo
			res = stmt.executeQuery(
					"SELECT articulo.nombre, articulo.descripcion, articulo.precio, articulo.codigo, articulo.categoria,"
							+ " cilindrada.nombre FROM  \"TFG\".articulo INNER JOIN \"TFG\".cilindrada ON articulo.cilindrada=cilindrada.id"
							+ " AND articulo.cilindrada=" + filtroCilindrada + " ORDER BY articulo." + filtro
							+ " LIMIT " + tamanoPagina + " OFFSET " + tamanoPagina * (numPagina - 1) + "");

			while (res.next()) {
				// Creamos un articulo y lo cargamos con los datos del resulset
				articuloVO articulo = new articuloVO(res.getString("nombre"), res.getString("descripcion"),
						res.getFloat("precio"), res.getString("codigo"), res.getInt("categoria"));

				// Añadimos
				articulos.add(articulo);

			}

			stmt.close();
			con.close();
			res.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		// Devolvemos el array cargado con los articulos
		return articulos;

	}

	public ArrayList<articuloVO> cargarTodo(int numPagina, int tamanoPagina) {

		String filtro = null;

		switch (filtroArticulo) {

		case NOMBREASC:
			filtro = "nombre ASC";
			break;

		case NOMBREDESC:
			filtro = "nombre DESC";
			break;

		case PRECIOASC:
			filtro = "precio ASC";
			break;

		case PRECIODESC:
			filtro = "precio DESC";
			break;

		}

		// Definimos el arrayList que guardara todos los articulos de la BD
		ArrayList<articuloVO> articulos = new ArrayList<articuloVO>();

		// Conectamos con la BD
		Connection con = ConexionBD.conectar();

		// Definimos un ResulSet para recoger los datos de la BD
		ResultSet res = null;

		try {
			// Creamos el Statement
			Statement stmt = con.createStatement();

			// Recuperamos de la BD el articulo
			res = stmt.executeQuery(
					"SELECT articulo.nombre, articulo.descripcion, articulo.precio, articulo.codigo, articulo.categoria,"
							+ " cilindrada.nombre FROM  \"TFG\".articulo INNER JOIN \"TFG\".cilindrada ON articulo.cilindrada=cilindrada.id"
							+ " ORDER BY articulo." + filtro + " LIMIT " + tamanoPagina + " OFFSET "
							+ tamanoPagina * (numPagina - 1) + "");

			while (res.next()) {
				// Creamos un articulo y lo cargamos con los datos del resulset
				articuloVO articulo = new articuloVO(res.getString("nombre"), res.getString("descripcion"),
						res.getFloat("precio"), res.getString("codigo"), res.getInt("categoria"));

				// Añadimos
				articulos.add(articulo);

			}

			stmt.close();
			con.close();
			res.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		// Devolvemos el array cargado con los articulos
		return articulos;

	}

	public int totalTodo() {

		int resultado = 0;

		String filtro = null;

		switch (filtroArticulo) {

		case NOMBREASC:
			filtro = "nombre ASC";
			break;

		case NOMBREDESC:
			filtro = "nombre DESC";
			break;

		case PRECIOASC:
			filtro = "precio ASC";
			break;

		case PRECIODESC:
			filtro = "precio DESC";
			break;

		}

		// Conectamos con la BD
		Connection con = ConexionBD.conectar();

		// Definimos un ResulSet para recoger los datos de la BD
		ResultSet res = null;

		try {
			// Creamos el Statement
			Statement stmt = con.createStatement();

			// Recuperamos de la BD el articulo
			res = stmt.executeQuery(
					"SELECT articulo.nombre, articulo.descripcion, articulo.precio, articulo.codigo, articulo.categoria,"
							+ " cilindrada.nombre FROM  \"TFG\".articulo INNER JOIN \"TFG\".cilindrada ON articulo.cilindrada=cilindrada.id"
							+ " ORDER BY articulo." + filtro);

			while (res.next()) {
				resultado++;
			}

			stmt.close();
			con.close();
			res.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		// Devolvemos el array cargado con los articulos
		return resultado;

	}

	public int CatTodo() {

		int resultado = 0;

		String filtro = null;

		switch (filtroArticulo) {

		case NOMBREASC:
			filtro = "nombre ASC";
			break;

		case NOMBREDESC:
			filtro = "nombre DESC";
			break;

		case PRECIOASC:
			filtro = "precio ASC";
			break;

		case PRECIODESC:
			filtro = "precio DESC";
			break;

		}

		// Conectamos con la BD
		Connection con = ConexionBD.conectar();

		// Definimos un ResulSet para recoger los datos de la BD
		ResultSet res = null;

		try {
			// Creamos el Statement
			Statement stmt = con.createStatement();

			// Recuperamos de la BD el articulo
			res = stmt.executeQuery(
					"SELECT articulo.nombre, articulo.descripcion, articulo.precio, articulo.codigo, articulo.categoria,"
							+ " cilindrada.nombre FROM  \"TFG\".articulo INNER JOIN \"TFG\".cilindrada ON articulo.cilindrada=cilindrada.id"
							+ " AND articulo.categoria=" + filtroFamilia + " ORDER BY articulo." + filtro);

			while (res.next()) {
				resultado++;
			}

			stmt.close();
			con.close();
			res.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		// Devolvemos el array cargado con los articulos
		return resultado;

	}

	public int CilTodo() {

		int resultado = 0;

		String filtro = null;

		switch (filtroArticulo) {

		case NOMBREASC:
			filtro = "nombre ASC";
			break;

		case NOMBREDESC:
			filtro = "nombre DESC";
			break;

		case PRECIOASC:
			filtro = "precio ASC";
			break;

		case PRECIODESC:
			filtro = "precio DESC";
			break;

		}

		// Conectamos con la BD
		Connection con = ConexionBD.conectar();

		// Definimos un ResulSet para recoger los datos de la BD
		ResultSet res = null;

		try {
			// Creamos el Statement
			Statement stmt = con.createStatement();

			// Recuperamos de la BD el articulo
			res = stmt.executeQuery(
					"SELECT articulo.nombre, articulo.descripcion, articulo.precio, articulo.codigo, articulo.categoria,"
							+ " cilindrada.nombre FROM  \"TFG\".articulo INNER JOIN \"TFG\".cilindrada ON articulo.cilindrada=cilindrada.id"
							+ " AND articulo.cilindrada=" + filtroCilindrada + " ORDER BY articulo." + filtro);

			while (res.next()) {
				resultado++;
			}

			stmt.close();
			con.close();
			res.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		// Devolvemos el array cargado con los articulos
		return resultado;

	}

	public int CatCilTodo() {

		int resultado = 0;

		String filtro = null;

		switch (filtroArticulo) {

		case NOMBREASC:
			filtro = "nombre ASC";
			break;

		case NOMBREDESC:
			filtro = "nombre DESC";
			break;

		case PRECIOASC:
			filtro = "precio ASC";
			break;

		case PRECIODESC:
			filtro = "precio DESC";
			break;

		}

		// Conectamos con la BD
		Connection con = ConexionBD.conectar();

		// Definimos un ResulSet para recoger los datos de la BD
		ResultSet res = null;

		try {
			// Creamos el Statement
			Statement stmt = con.createStatement();

			// Recuperamos de la BD el articulo
			res = stmt.executeQuery(
					"SELECT articulo.nombre, articulo.descripcion, articulo.precio, articulo.codigo, articulo.categoria,"
							+ " cilindrada.nombre FROM  \"TFG\".articulo INNER JOIN \"TFG\".cilindrada ON articulo.cilindrada=cilindrada.id"
							+ " AND articulo.categoria=" + filtroFamilia + " AND articulo.cilindrada="
							+ filtroCilindrada + " ORDER BY articulo." + filtro);

			while (res.next()) {
				resultado++;
			}

			stmt.close();
			con.close();
			res.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		// Devolvemos el array cargado con los articulos
		return resultado;

	}

}
