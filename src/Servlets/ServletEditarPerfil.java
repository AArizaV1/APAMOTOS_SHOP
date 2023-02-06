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
import utils.encriptarContrasena;

@WebServlet("/ServletEditarPerfil")
public class ServletEditarPerfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	HttpSession sesion;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		sesion = request.getSession();

		request.getRequestDispatcher("/WEB-INF/EditarPerfil.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		sesion = request.getSession();

		int id;
		String documento;
		String nombre;
		int edad;
		String ciudad;
		String correo;
		String telefono;
		String contrasena = request.getParameter("contrasena");
		;

		id = Integer.parseInt(request.getParameter("id"));
		documento = request.getParameter("documento");
		nombre = request.getParameter("nombre");
		edad = Integer.parseInt(request.getParameter("edad"));
		ciudad = request.getParameter("ciudad");
		correo = request.getParameter("correo");
		telefono = request.getParameter("telefono");
		contrasena = request.getParameter("contrasena");
		contrasena = encriptarContrasena.convertirSHA256(contrasena);

		clienteDAO actualizarCliente = new clienteDAO();
		clienteVO cliente = new clienteVO(id, documento, nombre, edad, ciudad, correo, telefono, contrasena);

		sesion.setAttribute("cliente", cliente);

		actualizarCliente.actualizarCliente(cliente);

		request.getRequestDispatcher("/WEB-INF/Perfil.jsp").forward(request, response);

	}

}
