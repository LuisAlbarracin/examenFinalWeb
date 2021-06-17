package co.edu.ufps.examen.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import co.edu.ufps.examen.dao.RolDao;
import co.edu.ufps.examen.dao.RolDaoJPA;
import co.edu.ufps.examen.entities.Rol;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/rol")
public class RolServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RolDao rolDao;

    /**
     * Default constructor. 
     */
    public RolServlet() {
        // TODO Auto-generated constructor stub
    }

    
	public void init() throws ServletException {
		this.rolDao = new RolDaoJPA();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertarRol(request, response);
				break;
			case "/delete":
				eliminarRol(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				actualizarRol(request, response);
				break;
			default:
				listRoles(request, response);
				break;

			}
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer id = Integer.parseInt(request.getParameter("id"));

		Rol rolActual = this.rolDao.buscar(id);
		
		request.setAttribute("rol", rolActual);
		RequestDispatcher dispatcher = request.getRequestDispatcher("rol.jsp");
		dispatcher.forward(request, response);
	}

	private void listRoles(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		List<Rol> roles = this.rolDao.mostrarTodos();
		request.setAttribute("roles", roles);

		RequestDispatcher dispatcher = request.getRequestDispatcher("mostrarroles.jsp");
		dispatcher.forward(request, response);
	}

	private void actualizarRol(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {

		Integer id = Integer.parseInt(request.getParameter("id"));
		String descripcion = request.getParameter("descripcion");
		
		Rol rol = new Rol( id, descripcion);
		this.rolDao.actualizar(rol);
		
		response.sendRedirect("list");
	}

	private void eliminarRol(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		Integer id = Integer.parseInt(request.getParameter("id"));

		this.rolDao.eliminar(id);

		response.sendRedirect("list");
	}

	private void insertarRol(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		String descripcion = request.getParameter("descripcion");
		
		Rol rol = new Rol(descripcion);
		this.rolDao.insertar(rol);

		response.sendRedirect("list");
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("usuario.jsp");
		dispatcher.forward(request, response);
	}


}
