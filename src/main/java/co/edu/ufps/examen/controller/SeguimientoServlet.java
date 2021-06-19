package co.edu.ufps.examen.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import co.edu.ufps.examen.dao.ReporteDao;
import co.edu.ufps.examen.dao.ReporteDaoJPA;
import co.edu.ufps.examen.dao.SeguimientoDao;
import co.edu.ufps.examen.dao.SeguimientoDaoJPA;
import co.edu.ufps.examen.entities.Reporte;
import co.edu.ufps.examen.entities.Seguimiento;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/seguimiento")
public class SeguimientoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SeguimientoDao seguimientoDao;
	private ReporteDao reporteDao;
    /**
     * Default constructor. 
     */
    public SeguimientoServlet() {
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException {
		this.seguimientoDao = new SeguimientoDaoJPA();
		this.reporteDao = new ReporteDaoJPA();
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
				insertarSeguimiento(request, response);
				break;
			case "/delete":
				eliminarSeguimiento(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				actualizarSeguimiento(request, response);
				break;
			default:
				listSeguimientos(request, response);
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
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		List<Reporte> reportes = this.reporteDao.mostrarTodos();
		
		Seguimiento seguimientoActual = this.seguimientoDao.buscar(id);
		
		request.setAttribute("reportes", reportes);
		request.setAttribute("seguimiento", seguimientoActual);
		RequestDispatcher dispatcher = request.getRequestDispatcher("seguimiento.jsp");
		dispatcher.forward(request, response);
	}

	private void listSeguimientos(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		List<Seguimiento> seguimientos = this.seguimientoDao.mostrarTodos();
		request.setAttribute("seguimientos", seguimientos);

		RequestDispatcher dispatcher = request.getRequestDispatcher("mostrarseguimienos.jsp");
		dispatcher.forward(request, response);
	}

	private void actualizarSeguimiento(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {

		Integer id = Integer.parseInt(request.getParameter("id"));
		Integer reporteId = Integer.parseInt(request.getParameter("reporte"));
		String dategenerateId = request.getParameter("dategenerate");
		Short state = Short.parseShort(request.getParameter("state"));
		String result = request.getParameter("result");
		String detailrequest = request.getParameter("detailrequest");
		String filegenerate = request.getParameter("filegenerate");
		String type = request.getParameter("type");
		Timestamp dategenerate = Timestamp.valueOf(dategenerateId);
		
		Reporte reporte = this.reporteDao.buscar(reporteId);
		Seguimiento seguimiento = new Seguimiento(id, dategenerate, detailrequest, filegenerate, result, state, type, reporte);
	
		this.seguimientoDao.actualizar(seguimiento);
		
		response.sendRedirect("list");
	}

	private void eliminarSeguimiento(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		Integer id = Integer.parseInt(request.getParameter("id"));

		this.seguimientoDao.eliminar(id);

		response.sendRedirect("list");
	}

	private void insertarSeguimiento(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		Integer reporteId = Integer.parseInt(request.getParameter("reporte"));
		String dategenerateId = request.getParameter("dategenerate");
		Short state = Short.parseShort(request.getParameter("state"));
		String result = request.getParameter("result");
		String detailrequest = request.getParameter("detailrequest");
		String filegenerate = request.getParameter("filegenerate");
		String type = request.getParameter("type");
		Timestamp dategenerate = Timestamp.valueOf(dategenerateId);		
		
		Reporte reporte = this.reporteDao.buscar(reporteId);
		Seguimiento seguimiento = new Seguimiento(dategenerate, detailrequest, filegenerate, result, state, type, reporte);
		this.seguimientoDao.insertar(seguimiento);

		response.sendRedirect("list");
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Reporte> reportes = this.reporteDao.mostrarTodos();
		request.setAttribute("reportes", reportes);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("reporte.jsp");
		dispatcher.forward(request, response);
	}

	
}
