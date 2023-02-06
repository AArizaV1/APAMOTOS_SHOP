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
import utils.crearCodigo;
import utils.encriptarContrasena;
import utils.enviarCorreo;

@WebServlet("/ServletRegistrarCliente")
public class ServletRegistrarCliente extends HttpServlet {

	private static final long serialVersionUID = 1L;

	HttpSession sesion;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/AutoregistroV2.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nombre;
		int edad;
		String correo;
		String telefono;
		String contrasena;
		String contrasena2;
		int codigo;
		boolean alta;
		int tipo;
		String ciudad;
		String documento;

		nombre = request.getParameter("nombre");
		edad = Integer.parseInt(request.getParameter("edad"));
		correo = request.getParameter("correo");
		telefono = request.getParameter("telefono");
		ciudad = request.getParameter("ciudad");
		documento = request.getParameter("documento");

		contrasena = request.getParameter("contrasena");
		contrasena = encriptarContrasena.convertirSHA256(contrasena);

		contrasena2 = request.getParameter("contrasena2");
		contrasena2 = encriptarContrasena.convertirSHA256(contrasena2);

		codigo = crearCodigo.codigoVerificar();
		alta = false;
		tipo = 1;

		sesion = request.getSession();

		clienteDAO administrarCliente = new clienteDAO();

		clienteVO cliente = new clienteVO(nombre, edad, correo, telefono, contrasena, codigo, alta, tipo, ciudad,
				documento);

		if (contrasena.equals(contrasena2)) {

			administrarCliente.insertarCliente(cliente);

			try {

				enviarCorreo.EnviarEmail(correo, codigo);

				sesion.setAttribute("correo", cliente.getCorreo());

			} catch (Exception e) {

			}

			response.sendRedirect("ServletVerificarCodigo");
			request.getRequestDispatcher("ServletVerificarCodigo").forward(request, response);

		} else {

			request.setAttribute("errorPassword", "Las contraseñas no coinciden.");
			request.getRequestDispatcher("/WEB-INF/AutoregistroV2.jsp").forward(request, response);

		}

	}

}
