package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ServletCerrarSesion")
public class ServletCerrarSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Ya sea que el método sea por GET o POST, cerraremos la sesion.
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");

		@SuppressWarnings("unused")
		PrintWriter out = response.getWriter();

		HttpSession sesion = request.getSession(true);

		// Cerrar sesion
		sesion.invalidate();

		// Redirecciono a index.jsp
		response.sendRedirect("ServletLogin");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

}
