package co.edu.ufps.examen.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import co.edu.ufps.examen.entities.Seguimiento;
import co.edu.ufps.examen.util.ConexionMySQLJPA;

public class SeguimientoDaoJPA implements SeguimientoDao {

	@Override
	public void insertar(Seguimiento seguimiento) {
		ConexionMySQLJPA conexion = ConexionMySQLJPA.getConexion();
		EntityManager em = conexion.getEm();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(seguimiento);
		tx.commit();

	}

	@Override
	public void actualizar(Seguimiento seguimiento) {
		ConexionMySQLJPA conexion = ConexionMySQLJPA.getConexion();
		EntityManager em = conexion.getEm();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(seguimiento);
		tx.commit();

	}

	@Override
	public void eliminar(Integer id) {
		ConexionMySQLJPA conexion = ConexionMySQLJPA.getConexion();
		EntityManager em = conexion.getEm();
		EntityTransaction tx = em.getTransaction();
		Seguimiento seguimiento = em.find(Seguimiento.class, id);
		tx.begin();
		em.remove(seguimiento);
		tx.commit();
	}

	@Override
	public Seguimiento buscar(Integer id) {
		ConexionMySQLJPA conexion = ConexionMySQLJPA.getConexion();
		EntityManager em = conexion.getEm();
		EntityTransaction tx = em.getTransaction();
		Seguimiento seguimiento = em.find(Seguimiento.class, id);
		return seguimiento;
	}

	@Override
	public List<Seguimiento> mostrarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
