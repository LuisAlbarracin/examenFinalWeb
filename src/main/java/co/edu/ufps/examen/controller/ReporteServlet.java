package co.edu.ufps.examen.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import co.edu.ufps.examen.dao.ConnectiontokenDao;
import co.edu.ufps.examen.dao.ConnectiontokenDaoJPA;
import co.edu.ufps.examen.dao.ReporteDao;
import co.edu.ufps.examen.dao.ReporteDaoJPA;
import co.edu.ufps.examen.dao.RolDaoJPA;
import co.edu.ufps.examen.dao.UsuarioDaoJPA;
import co.edu.ufps.examen.entities.Connectiontoken;
import co.edu.ufps.examen.entities.Reporte;
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
@WebServlet("/reporte")
public class ReporteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReporteDao reporteDao;
	private ConnectiontokenDao connectiontokenDao;
    /**
     * Default constructor. 
     */
    public ReporteServlet() {
        // TODO Auto-generated constructor stub
    }

    public void init() throws ServletException {
    	this.reporteDao = new ReporteDaoJPA();
    	this.connectiontokenDao = new ConnectiontokenDaoJPA();
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
				insertarReporte(request, response);
				break;
			case "/delete":
				eliminarReporte(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				actualizarReporte(request, response);
				break;
			default:
				listReportes(request, response);
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

		Reporte reporteActual = (Reporte) this.reporteDao.buscar(id);
		List<Connectiontoken> connectiontokens = this.connectiontokenDao.mostrarTodos();
		request.setAttribute("reporte", reporteActual);
		request.setAttribute("conexiones", connectiontokens);
		RequestDispatcher dispatcher = request.getRequestDispatcher("reporte.jsp");
		dispatcher.forward(request, response);
	}

	private void listReportes(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		List<Reporte> reportes = this.reporteDao.mostrarTodos();
		request.setAttribute("reportes", reportes);

		RequestDispatcher dispatcher = request.getRequestDispatcher("mostrarreportes.jsp");
		dispatcher.forward(request, response);
	}

	private void actualizarReporte(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));
		String file = request.getParameter("file");
		String datecreate = request.getParameter("datecreate");
		Integer conexionId = Integer.parseInt(request.getParameter("conexion"));
		String state = request.getParameter("state");
		String descripcion = request.getParameter("descripcion");
		String name = request.getParameter("nombre");
		
		Connectiontoken conexion = this.connectiontokenDao.buscar(conexionId);
		@SuppressWarnings("deprecation")
		Timestamp fechacreacion = new Timestamp(1990, 11, 2, 0, 0, 0, 0);
		
		Reporte reporte = new Reporte( id, fechacreacion, descripcion, file,  name, state, conexion);
		this.reporteDao.actualizar(reporte);
		
		response.sendRedirect("list");
	}

	private void eliminarReporte(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));

		this.reporteDao.eliminar(id);

		response.sendRedirect("list");
	}

	private void insertarReporte(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub

		String file = request.getParameter("file");
		String datecreate = request.getParameter("datecreate");
		Integer conexionId = Integer.parseInt(request.getParameter("conexion"));
		String state = request.getParameter("state");
		String descripcion = request.getParameter("descripcion");
		String name = request.getParameter("nombre");
		
		Connectiontoken conexion = this.connectiontokenDao.buscar(conexionId);
		@SuppressWarnings("deprecation")
		Timestamp fechacreacion = new Timestamp(1990, 11, 2, 0, 0, 0, 0);
		
		Reporte reporte = new Reporte( fechacreacion, descripcion, file,  name, state, conexion);
		this.reporteDao.insertar(reporte);

		response.sendRedirect("list");
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Connectiontoken> connectiontokens = this.connectiontokenDao.mostrarTodos();
		request.setAttribute("conexiones", connectiontokens);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("reporte.jsp");
		dispatcher.forward(request, response);
	}


}
