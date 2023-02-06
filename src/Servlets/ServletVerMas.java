package Servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.articuloDAO;
import modelo.articuloVO;
import utils.ConexionBD;

@WebServlet("/ServletVerMas")
public class ServletVerMas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletVerMas() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String codigo;

		codigo = request.getParameter("codigo");

		articuloDAO articulodao = new articuloDAO();

		Object[] articulosArray = articulodao.cargarArticuloVerMas(codigo);

		request.setAttribute("articulosArray", articulosArray);

		request.getRequestDispatcher("/WEB-INF/VerMas.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
