package co.edu.ufps.examen.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import co.edu.ufps.examen.dao.RolDao;
import co.edu.ufps.examen.dao.RolDaoJPA;
import co.edu.ufps.examen.dao.UsuarioDao;
import co.edu.ufps.examen.dao.UsuarioDaoJPA;
import co.edu.ufps.examen.entities.Rol;
import co.edu.ufps.examen.entities.Usuario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDao usuarioDao;
	private RolDao rolDao;

	/**
	 * Default constructor.
	 */
	public UsuarioServlet() {
		// TODO Auto-generated constructor stub
	}

	public void init() throws ServletException {
		this.usuarioDao = new UsuarioDaoJPA();
		this.rolDao = new RolDaoJPA();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertarUsuario(request, response);
				break;
			case "/delete":
				eliminarUsuario(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				actualizarUsuario(request, response);
				break;
			case "/login":
				loginUsuario(request, response);
				break;
			default:
				listUsuarios(request, response);
				break;

			}
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));

		Usuario usuarioActual = (Usuario) this.usuarioDao.buscar(id);
		List<Rol> roles = this.rolDao.mostrarTodos();
		
		request.setAttribute("roles", roles);
		request.setAttribute("usuario", usuarioActual);
		RequestDispatcher dispatcher = request.getRequestDispatcher("usuario.jsp");
		dispatcher.forward(request, response);
	}

	private void listUsuarios(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		List<Usuario> usuarios = this.usuarioDao.mostrarTodos();
		request.setAttribute("usuarios", usuarios);

		RequestDispatcher dispatcher = request.getRequestDispatcher("mostrarusuarios.jsp");
		dispatcher.forward(request, response);
	}

	private void actualizarUsuario(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));
		String usuarioN = request.getParameter("usuario");
		String email = request.getParameter("email");
		String pass = request.getParameter("contrasenia");
		Integer rolId = Integer.parseInt(request.getParameter("rol"));
		Short state = Short.parseShort(request.getParameter("estado"));
		
		Rol rol = rolDao.buscar(rolId);
		
		Usuario usuario = new Usuario( id, email,  pass,  state,  usuarioN,  rol);
		this.usuarioDao.actualizar(usuario);
		
		response.sendRedirect("list");
	}

	private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));

		this.usuarioDao.eliminar(id);

		response.sendRedirect("list");
	}

	private void insertarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub

		String usuarioN = request.getParameter("usuario");
		String email = request.getParameter("email");
		String pass = request.getParameter("contrasenia");
		Integer rolId = Integer.parseInt(request.getParameter("rol"));
		Short state = Short.parseShort(request.getParameter("estado"));
		
		Rol rol = rolDao.buscar(rolId);
		
		Usuario usuario = new Usuario(  email,  pass,  state,  usuarioN,  rol);
		this.usuarioDao.insertar(usuario);

		response.sendRedirect("list");
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Rol> roles = this.rolDao.mostrarTodos();
		request.setAttribute("roles", roles);

		
		RequestDispatcher dispatcher = request.getRequestDispatcher("usuario.jsp");
		dispatcher.forward(request, response);
	}
	
	private void loginUsuario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub

		String usuarioN = request.getParameter("usuario");
		String email = request.getParameter("email");
		Integer rolId = Integer.parseInt(request.getParameter("rol"));
		
		Rol rol = rolDao.buscar(rolId);
		
		//Buscar al usuario
		this.usuarioDao.buscar(rolId);


		response.sendRedirect("list");
	}

}
