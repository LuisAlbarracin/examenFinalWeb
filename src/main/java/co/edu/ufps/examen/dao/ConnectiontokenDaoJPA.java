package co.edu.ufps.examen.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import co.edu.ufps.examen.entities.Connectiontoken;
import co.edu.ufps.examen.util.ConexionMySQLJPA;

public class ConnectiontokenDaoJPA implements ConnectiontokenDao {

	@Override
	public void insertar(Connectiontoken connectiontoken) {
		ConexionMySQLJPA conexion = ConexionMySQLJPA.getConexion();
		EntityManager em = conexion.getEm();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(connectiontoken);
		tx.commit();
	}

	@Override
	public void actualizar(Connectiontoken connectiontoken) {
		ConexionMySQLJPA conexion = ConexionMySQLJPA.getConexion();
		EntityManager em = conexion.getEm();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(connectiontoken);
		tx.commit();

	}

	@Override
	public void eliminar(Integer id) {
		ConexionMySQLJPA conexion = ConexionMySQLJPA.getConexion();
		EntityManager em = conexion.getEm();
		EntityTransaction tx = em.getTransaction();
		Connectiontoken ct = em.find(Connectiontoken.class, id);
		tx.begin();
		em.remove(ct);
		tx.commit();
		
	}

	@Override
	public Connectiontoken buscar(Integer id) {
		ConexionMySQLJPA conexion = ConexionMySQLJPA.getConexion();
		EntityManager em = conexion.getEm();
		EntityTransaction tx = em.getTransaction();
		Connectiontoken ct = em.find(Connectiontoken.class, id);
		return ct;
	}

	@Override
	public List<Connectiontoken> mostrarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
