package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.categoriaDAO;
import modelo.cilindradaDAO;
import modelo.cilindradaVO;

@WebServlet("/ServletInsertarCilindrada")
public class ServletInsertarCilindrada extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nombre;

		nombre = request.getParameter("nombre");

		cilindradaDAO cilindradaGestion = new cilindradaDAO();
		cilindradaVO cilindrada = new cilindradaVO(nombre);

		cilindradaGestion.insertarCilindrada(cilindrada);

		System.out.println(cilindrada);

		request.getRequestDispatcher("/WEB-INF/Gestion.jsp").forward(request, response);

	}

}
