package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.articuloDAO;
import modelo.articuloVO;

@WebServlet("/ServletEditarArticulo")
public class ServletEditarArticulo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nombre;
		String descripcion;
		float precio;
		String codigo;
		int categoria;
		int cilindrada;

		nombre = request.getParameter("nombre");
		descripcion = request.getParameter("descripcion");
		precio = Float.parseFloat(request.getParameter("precio"));
		codigo = request.getParameter("codigo");
		categoria = Integer.parseInt(request.getParameter("categoria"));
		cilindrada = Integer.parseInt(request.getParameter("cilindrada"));

		// Definimos el printwriter para escribir en el navegador
		@SuppressWarnings("unused")
		PrintWriter out = response.getWriter();

		// Modificamos el articulo en la BD
		articuloDAO articuloGestion = new articuloDAO();
		articuloVO articulo = new articuloVO(nombre, descripcion, precio, codigo, categoria, cilindrada);

		articuloGestion.actualizarArticulo(articulo);

		// Redirecciono al listado
		request.getRequestDispatcher("/WEB-INF/Gestion.jsp").forward(request, response);

	}
}
