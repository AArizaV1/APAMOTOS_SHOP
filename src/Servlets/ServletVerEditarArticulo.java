package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.articuloDAO;
import modelo.articuloVO;

@WebServlet("/ServletVerEditarArticulo")
public class ServletVerEditarArticulo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String codigo = null;

		if (request.getParameter("codigo") != null) {
			codigo = request.getParameter("codigo");
		}

		articuloVO articulo = articuloDAO.cargarArticulo(codigo);

		request.setAttribute("articulo", articulo);

		request.getRequestDispatcher("/WEB-INF/EditarArticulo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
