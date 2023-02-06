package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.articuloDAO;

@WebServlet("/ServletEliminarArticulo")
public class ServletEliminarArticulo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String codigo;

		codigo = request.getParameter("codigo");

		articuloDAO articuloGestion = new articuloDAO();

		articuloGestion.eliminarArticulo(codigo);

		request.getRequestDispatcher("/WEB-INF/Gestion.jsp").forward(request, response);

	}

}
