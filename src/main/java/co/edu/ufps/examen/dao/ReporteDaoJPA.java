package co.edu.ufps.examen.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import co.edu.ufps.examen.entities.Reporte;
import co.edu.ufps.examen.util.ConexionMySQLJPA;

public class ReporteDaoJPA implements ReporteDao {

	@Override
	public void insertar(Reporte reporte) {
		ConexionMySQLJPA conexion = ConexionMySQLJPA.getConexion();
		EntityManager em = conexion.getEm();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.persist(reporte);
		tx.commit();

	}

	@Override
	public void actualizar(Reporte reporte) {
		ConexionMySQLJPA conexion = ConexionMySQLJPA.getConexion();
		EntityManager em = conexion.getEm();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(reporte);
		tx.commit();

	}

	@Override
	public void eliminar(Integer id) {
		ConexionMySQLJPA conexion = ConexionMySQLJPA.getConexion();
		EntityManager em = conexion.getEm();
		EntityTransaction tx = em.getTransaction();
		Reporte reporte = em.find(Reporte.class, id);
		tx.begin();
		em.remove(reporte);
		tx.commit();
	}

	@Override
	public Reporte buscar(Integer id) {
		ConexionMySQLJPA conexion = ConexionMySQLJPA.getConexion();
		EntityManager em = conexion.getEm();
		EntityTransaction tx = em.getTransaction();
		Reporte reporte = em.find(Reporte.class, id);
		return reporte;
	}

	@Override
	public List<Reporte> mostrarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
