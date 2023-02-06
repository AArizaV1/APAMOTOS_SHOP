package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.categoriaDAO;
import modelo.categoriaVO;

@WebServlet("/ServletInsertarCategoria")
public class ServletInsertarCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nombre;

		nombre = request.getParameter("nombre");

		System.out.println(nombre);

		categoriaDAO categoriaGestion = new categoriaDAO();
		categoriaVO categoria = new categoriaVO(nombre);

		categoriaGestion.insertarCategoria(categoria);

		System.out.println(categoria);

		request.getRequestDispatcher("/WEB-INF/Gestion.jsp").forward(request, response);
	}

}