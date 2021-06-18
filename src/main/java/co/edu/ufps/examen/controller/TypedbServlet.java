package co.edu.ufps.examen.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import co.edu.ufps.examen.dao.TypedbDao;
import co.edu.ufps.examen.dao.TypedbDaoJPA;
import co.edu.ufps.examen.entities.Typedb;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/typedb")
public class TypedbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TypedbDao typedbDao;
    /**
     * Default constructor. 
     */
    public TypedbServlet() {
        // TODO Auto-generated constructor stub
    }

    
    public void init() throws ServletException {
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
				insertarTypedb(request, response);
				break;
			case "/delete":
				eliminarTypedb(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				actualizarTypedb(request, response);
				break;
			default:
				listTypesdb(request, response);
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
		
		String id = request.getParameter("id");

		Typedb typedbActual = this.typedbDao.buscar(id);
		
		request.setAttribute("rol", typedbActual);
		RequestDispatcher dispatcher = request.getRequestDispatcher("typedb.jsp");
		dispatcher.forward(request, response);
	}

	private void listTypesdb(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		List<Typedb> typesdb = this.typedbDao.mostrarTodos();
		request.setAttribute("roles", typesdb);

		RequestDispatcher dispatcher = request.getRequestDispatcher("mostrartypesdb.jsp");
		dispatcher.forward(request, response);
	}

	private void actualizarTypedb(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {

		String id = request.getParameter("id");
		String descripcion = request.getParameter("descripcion");
		String driver = request.getParameter("driver");
		String aditional = request.getParameter("aditional");
		
		Typedb typedb = new Typedb(id, descripcion, driver, aditional);
		
		this.typedbDao.actualizar(typedb);
		
		response.sendRedirect("list");
	}

	private void eliminarTypedb(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		String id = request.getParameter("id");

		this.typedbDao.eliminar(id);

		response.sendRedirect("list");
	}

	private void insertarTypedb(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		String id = request.getParameter("id");
		String descripcion = request.getParameter("descripcion");
		String driver = request.getParameter("driver");
		String aditional = request.getParameter("aditional");
		
		Typedb typedb = new Typedb(id, descripcion, driver, aditional);
		this.typedbDao.insertar(typedb);

		response.sendRedirect("list");
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("typedb.jsp");
		dispatcher.forward(request, response);
	}



}
