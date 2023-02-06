package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import modelo.articuloDAO;
import modelo.articuloVO;
import modelo.categoriaDAO;
import modelo.categoriaVO;
import modelo.cilindradaDAO;
import modelo.cilindradaVO;

@WebServlet("/ServletVerCatalogo")
public class ServletVerCatalogo extends HttpServlet {

	public static ArrayList<Session> socket;

	private static final long serialVersionUID = 1L;

	private int totalPaginas = 1;
	private static final int tamanioPagina = 6;

	private int numPagina = 1;

	private boolean siguiente = true;
	private boolean anterior = true;

	public int filtroArticulo = 1;
	public int filtroFamilia = 0;
	public int filtroCilindrada = 0;

	public articuloVO articulovo;
	public articuloDAO articulodao;
	public categoriaVO categoriavo;
	public categoriaDAO categoriadao;
	public cilindradaVO cilindradavo;
	public cilindradaDAO cilindradadao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (socket == null) {
			socket = new ArrayList<Session>();
		}

		articulovo = new articuloVO();
		articulodao = new articuloDAO();
		categoriavo = new categoriaVO();
		categoriadao = new categoriaDAO();
		cilindradavo = new cilindradaVO();
		cilindradadao = new cilindradaDAO();

		if (request.getParameter("numPagina") != null) {
			numPagina = Integer.parseInt(request.getParameter("numPagina"));
		}

		if (request.getParameter("filtroArticulo") != null) {
			filtroArticulo = Integer.parseInt(request.getParameter("filtroArticulo"));
		}

		if (request.getParameter("filtroFamilia") != null) {
			filtroFamilia = Integer.parseInt(request.getParameter("filtroFamilia"));
		}

		if (request.getParameter("filtroCilindrada") != null) {
			filtroCilindrada = Integer.parseInt(request.getParameter("filtroCilindrada"));
		}

		articulodao.setFiltroFamilia(filtroFamilia);
		articulodao.setFiltroArticulo(filtroArticulo);
		articulodao.setFiltroCilindrada(filtroCilindrada);

		ArrayList<articuloVO> articulos = resultado(filtroFamilia, filtroCilindrada, articulodao);
		ArrayList<categoriaVO> categorias = categoriadao.cargarCategoria();
		ArrayList<cilindradaVO> cilindradas = cilindradadao.cargarCilindrada();

		request.setAttribute("articulo", articulos);
		request.setAttribute("categoria", categorias);
		request.setAttribute("cilindrada", cilindradas);
		request.setAttribute("filtroArticulo", filtroArticulo);
		request.setAttribute("filtroFamilia", filtroFamilia);
		request.setAttribute("filtroCilindrada", filtroCilindrada);

		request.setAttribute("totalPaginas", totalPaginas);
		request.setAttribute("numPagina", numPagina);
		request.setAttribute("siguiente", siguiente);
		request.setAttribute("anterior", anterior);

		request.getRequestDispatcher("WEB-INF/CatalogoV3.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		articulovo = new articuloVO();
		articulodao = new articuloDAO();
		categoriavo = new categoriaVO();
		categoriadao = new categoriaDAO();
		cilindradavo = new cilindradaVO();
		cilindradadao = new cilindradaDAO();

		if (request.getParameter("filtroArticulo") != null) {
			filtroArticulo = Integer.parseInt(request.getParameter("filtroArticulo"));
		}

		if (request.getParameter("filtroFamilia") != null) {
			filtroFamilia = Integer.parseInt(request.getParameter("filtroFamilia"));
		}

		if (request.getParameter("filtroCilindrada") != null) {
			filtroCilindrada = Integer.parseInt(request.getParameter("filtroCilindrada"));
		}

		if (request.getParameter("numPagina") != null) {
			numPagina = Integer.parseInt(request.getParameter("numPagina"));
		}

		articulodao.setFiltroFamilia(filtroFamilia);
		articulodao.setFiltroArticulo(filtroArticulo);
		articulodao.setFiltroCilindrada(filtroCilindrada);

		ArrayList<articuloVO> articulos = resultado(filtroFamilia, filtroCilindrada, articulodao);
		ArrayList<categoriaVO> categorias = categoriadao.cargarCategoria();
		ArrayList<cilindradaVO> cilindradas = cilindradadao.cargarCilindrada();

		request.setAttribute("articulo", articulos);
		request.setAttribute("categoria", categorias);
		request.setAttribute("cilindrada", cilindradas);
		request.setAttribute("filtroArticulo", filtroArticulo);
		request.setAttribute("filtroFamilia", filtroFamilia);
		request.setAttribute("filtroCilindrada", filtroCilindrada);

		request.setAttribute("totalPaginas", totalPaginas);
		request.setAttribute("numPagina", numPagina);
		request.setAttribute("siguiente", siguiente);
		request.setAttribute("anterior", anterior);

		request.getRequestDispatcher("WEB-INF/CatalogoV3.jsp").forward(request, response);

	}

	public ArrayList<articuloVO> resultado(int filtroFamilia, int filtroCilindrada, articuloDAO artiDAO) {

		ArrayList<articuloVO> artiVO = null;

		if (filtroFamilia != 0 && filtroCilindrada != 0) {

			totalPaginas = artiDAO.CatCilTodo();
			artiVO = artiDAO.cargarCatCil(numPagina, tamanioPagina);
		}

		if (filtroFamilia != 0 && filtroCilindrada == 0) {
			totalPaginas = artiDAO.CatTodo();
			artiVO = artiDAO.cargarCat(numPagina, tamanioPagina);
		}

		if (filtroFamilia == 0 && filtroCilindrada != 0) {
			totalPaginas = artiDAO.CilTodo();
			artiVO = artiDAO.cargarCil(numPagina, tamanioPagina);
		}

		if (filtroFamilia == 0 && filtroCilindrada == 0) {

			totalPaginas = artiDAO.totalTodo();
			artiVO = artiDAO.cargarTodo(numPagina, tamanioPagina);
		}

		getAnteriorAndSiguiente(artiVO);
		checkTotalPaginas();

		return artiVO;

	}

	public void getAnteriorAndSiguiente(ArrayList<articuloVO> articulos) {

		if (numPagina <= 1) {

			numPagina = 1;
			anterior = false;

		} else {
			anterior = true;
		}

		if (articulos.size() != tamanioPagina) {
			siguiente = false;
		} else {
			siguiente = true;

		}

	}

	private void checkTotalPaginas() {

		if (totalPaginas % tamanioPagina != 0) {
			totalPaginas = (totalPaginas / tamanioPagina) + 1;
		} else {
			totalPaginas = totalPaginas / tamanioPagina;
		}
	}

}
