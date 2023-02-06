package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.clienteDAO;
import modelo.clienteVO;
import utils.actualizarAlta;

@WebServlet("/ServletVerificarCodigo")
public class ServletVerificarCodigo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	HttpSession sesion;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/Verificacion.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		sesion = request.getSession();

		int codigo;
		String correo;

		clienteVO usuario;

		codigo = Integer.parseInt(request.getParameter("codigo"));
		correo = request.getParameter("emailVerificar");

		usuario = clienteDAO.cargarUsuario(correo);

		System.out.println(usuario);

		System.out.println(codigo + correo);

		if (codigo == usuario.getCodigo() && correo.equals(usuario.getCorreo())) {

			actualizarAlta.actAlta(correo);
			// CAMBIAR AL PERFIL.JSP (ESTO ES SOLO COMPROBACION)
			response.sendRedirect("ServletLogin");

		} else {

			response.sendRedirect("ServletRegistrarCliente");

		}

	}

}
