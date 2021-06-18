package co.edu.ufps.examen.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import co.edu.ufps.examen.dao.ConnectiontokenDao;
import co.edu.ufps.examen.dao.ConnectiontokenDaoJPA;
import co.edu.ufps.examen.dao.TypedbDao;
import co.edu.ufps.examen.dao.TypedbDaoJPA;
import co.edu.ufps.examen.dao.UsuarioDao;
import co.edu.ufps.examen.dao.UsuarioDaoJPA;
import co.edu.ufps.examen.entities.Connectiontoken;
import co.edu.ufps.examen.entities.Typedb;
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
@WebServlet("/connectiontoken")
public class ConnectiontokenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConnectiontokenDao connectiontokenDao;
	private UsuarioDao usuarioDao;
	private TypedbDao typedbDao;

    /**
     * Default constructor. 
     */
    public ConnectiontokenServlet() {
        // TODO Auto-generated constructor stub
    }

    
	public void init() throws ServletException {
		this.usuarioDao = new UsuarioDaoJPA();
		this.connectiontokenDao = new ConnectiontokenDaoJPA();
		this.typedbDao = new TypedbDaoJPA();
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
				insertarConexion(request, response);
				break;
			case "/delete":
				eliminarConexion(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				actualizarConexion(request, response);
				break;
			default:
				listConexiones(request, response);
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));

		Connectiontoken connectiontokenActual = (Connectiontoken) this.connectiontokenDao.buscar(id);
		
		List<Typedb> typesdb = this.typedbDao.mostrarTodos();
		List<Usuario> usuarios = this.usuarioDao.mostrarTodos();

		request.setAttribute("typesdb", typesdb);
		request.setAttribute("usuarios", usuarios);
		request.setAttribute("connectiontoken", connectiontokenActual);
		RequestDispatcher dispatcher = request.getRequestDispatcher("connectiontoken.jsp");
		dispatcher.forward(request, response);
	}

	private void listConexiones(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		List<Connectiontoken> connectiontokens = this.connectiontokenDao.mostrarTodos();
		request.setAttribute("connectiontokens", connectiontokens);

		RequestDispatcher dispatcher = request.getRequestDispatcher("mostrarconnectiontokens.jsp");
		dispatcher.forward(request, response);
	}

	private void actualizarConexion(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));
		String host = request.getParameter("host");
		String userdb = request.getParameter("userdb");
		String pass = request.getParameter("pass");
		String db = request.getParameter("db");
		String token = request.getParameter("token");
		Short port = Short.parseShort(request.getParameter("estado"));
		Integer usuarioId = Integer.parseInt(request.getParameter("usuario"));
		Short state = Short.parseShort(request.getParameter("estado"));
		String typeId = request.getParameter("type");
		
		Usuario usuario = this.usuarioDao.buscar(usuarioId);
		Typedb typedb = this.typedbDao.buscar(typeId);
		
		Connectiontoken connectiontoken = new Connectiontoken( id,  db, host, pass, port, state, token, userdb, typedb, usuario);
		this.connectiontokenDao.actualizar(connectiontoken);
		
		response.sendRedirect("list");
	}

	private void eliminarConexion(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));

		this.connectiontokenDao.eliminar(id);

		response.sendRedirect("list");
	}

	private void insertarConexion(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		String host = request.getParameter("host");
		String userdb = request.getParameter("userdb");
		String pass = request.getParameter("pass");
		String db = request.getParameter("db");
		String token = request.getParameter("token");
		Short port = Short.parseShort(request.getParameter("estado"));
		Integer usuarioId = Integer.parseInt(request.getParameter("usuario"));
		Short state = Short.parseShort(request.getParameter("estado"));
		String typeId = request.getParameter("type");
		
		Usuario usuario = this.usuarioDao.buscar(usuarioId);
		Typedb typedb = this.typedbDao.buscar(typeId);
		
		Connectiontoken connectiontoken = new Connectiontoken( db, host, pass, port, state, token, userdb, typedb, usuario);
		
		this.connectiontokenDao.insertar(connectiontoken);

		response.sendRedirect("list");
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<Typedb> typesdb = this.typedbDao.mostrarTodos();
		List<Usuario> usuarios = this.usuarioDao.mostrarTodos();

		request.setAttribute("typesdb", typesdb);
		request.setAttribute("usuarios", usuarios);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("connectiontoken.jsp");
		dispatcher.forward(request, response);
	}

}
