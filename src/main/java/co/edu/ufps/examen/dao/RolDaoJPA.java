package co.edu.ufps.examen.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import co.edu.ufps.examen.entities.Rol;
import co.edu.ufps.examen.util.ConexionMySQLJPA;

public class RolDaoJPA implements RolDao {

	@Override
	public void insertar(Rol rol) {
		ConexionMySQLJPA conexion = ConexionMySQLJPA.getConexion();
		EntityManager em = conexion.getEm();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(rol);
		tx.commit();

	}

	@Override
	public void actualizar(Rol rol) {
		ConexionMySQLJPA conexion = ConexionMySQLJPA.getConexion();
		EntityManager em = conexion.getEm();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(rol);
		tx.commit();

	}

	@Override
	public void eliminar(Integer id) {
		ConexionMySQLJPA conexion = ConexionMySQLJPA.getConexion();
		EntityManager em = conexion.getEm();
		EntityTransaction tx = em.getTransaction();
		Rol rol = em.find(Rol.class, id);
		tx.begin();
		em.remove(rol);
		tx.commit();

	}

	@Override
	public Rol buscar(Integer id) {
		ConexionMySQLJPA conexion = ConexionMySQLJPA.getConexion();
		EntityManager em = conexion.getEm();
		EntityTransaction tx = em.getTransaction();
		Rol rol = em.find(Rol.class, id);
		return rol;
	}

	@Override
	public List<Rol> mostrarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
