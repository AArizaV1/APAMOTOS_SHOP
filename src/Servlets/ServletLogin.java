package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.clienteDAO;
import modelo.clienteVO;
import utils.Validaciones;
import utils.encriptarContrasena;

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final int NUM_INTENTOS = 3;

	HttpSession sesion;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/InicioSesion.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Recuperamos la sesion
		sesion = request.getSession();

		// Recuperamos los parametros que nos pasa el jsp
		String correo = request.getParameter("correo");
		String contrasena = request.getParameter("contrasena");
		String snumIntentos = request.getParameter("numIntentos");
		PrintWriter out = response.getWriter();

		contrasena = encriptarContrasena.convertirSHA256(contrasena);

		// Cargamos el numero de intentos
		int numIntentos = 0;
		if (Validaciones.isNumeric(snumIntentos))
			numIntentos = Integer.parseInt(snumIntentos);

		// Cargarmos el usuario desde BD asociado a dicho email
		clienteVO cliente = clienteDAO.cargarUsuario(correo);

		if (cliente == null || !cliente.getContrasena().equals(contrasena)) {
			// Si ha fallado volvemos al login mostrando el error
			// Decrementamos el numero de intentos
			numIntentos--;
			if (numIntentos == 0) {
				out.println("Ha fallado tres veces en el login, espere 3 minutos");

				// Reiniciamos el numero de intentos
				numIntentos = NUM_INTENTOS;

			}
			request.setAttribute("numIntentos", numIntentos);
			request.getRequestDispatcher("/WEB-INF/InicioSesion.jsp").forward(request, response);

		} else {
			// Si entra aqui es que ha introducido un usuario y una contraseña
			// Correctas

			// Guardamos en la sesion el nombre del usuario y el tipo

			sesion.setAttribute("cliente", cliente);
			sesion.setAttribute("documento", cliente.getDocumento());
			sesion.setAttribute("email", correo);

			// Dependiendo del tipo de usuario
			// Lo redireccionamos a distintas partes del nuestra webapp
			switch (cliente.getTipo()) {
			case clienteDAO.TIPO_ADMIN:
				// Reenviamos a la lista del administrador
				request.getRequestDispatcher("/WEB-INF/Gestion.jsp").forward(request, response);
				break;

			case clienteDAO.TIPO_CLIENTE:
				// Reenviamos a la lista del cliente
				request.getRequestDispatcher("/WEB-INF/Perfil.jsp").forward(request, response);
				break;

			default:
				// Reenviamos a la lista de montaditos del cliente
				request.getRequestDispatcher("WEB-INF/Catalogo.jsp").forward(request, response);
				break;

			}

		}

		// Cerramos el writer
		out.close();
	}

}