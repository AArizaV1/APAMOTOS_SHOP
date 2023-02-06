package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ServletPerfil")
public class ServletPerfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	HttpSession sesion;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		sesion = request.getSession();

		request.getRequestDispatcher("/WEB-INF/Perfil.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recuperamos la sesion
		sesion = request.getSession();

	}

}
