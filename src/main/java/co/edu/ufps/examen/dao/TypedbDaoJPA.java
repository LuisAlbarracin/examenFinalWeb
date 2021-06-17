package co.edu.ufps.examen.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import co.edu.ufps.examen.entities.Typedb;
import co.edu.ufps.examen.util.ConexionMySQLJPA;

public class TypedbDaoJPA implements TypedbDao {

	@Override
	public void insertar(Typedb typedb) {
		ConexionMySQLJPA conexion = ConexionMySQLJPA.getConexion();
		EntityManager em = conexion.getEm();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(typedb);
		tx.commit();

	}

	@Override
	public void actualizar(Typedb typedb) {
		ConexionMySQLJPA conexion = ConexionMySQLJPA.getConexion();
		EntityManager em = conexion.getEm();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(typedb);
		tx.commit();

	}

	@Override
	public void eliminar(String id) {
		ConexionMySQLJPA conexion = ConexionMySQLJPA.getConexion();
		EntityManager em = conexion.getEm();
		EntityTransaction tx = em.getTransaction();
		Typedb typedb =  em.find(Typedb.class, id);
		tx.begin();
		em.remove(typedb);
		tx.commit();

	}

	@Override
	public Typedb buscar(String id) {
		ConexionMySQLJPA conexion = ConexionMySQLJPA.getConexion();
		EntityManager em = conexion.getEm();
		EntityTransaction tx = em.getTransaction();
		Typedb typedb = em.find(Typedb.class, id);
		return typedb;
	}

	@Override
	public List<Typedb> mostrarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
