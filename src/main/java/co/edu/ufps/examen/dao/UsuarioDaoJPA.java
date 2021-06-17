package co.edu.ufps.examen.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import co.edu.ufps.examen.entities.Usuario;
import co.edu.ufps.examen.util.ConexionMySQLJPA;

public class UsuarioDaoJPA implements UsuarioDao {

	@Override
	public void insertar(Usuario usuario) {
		ConexionMySQLJPA conexion = ConexionMySQLJPA.getConexion();
		EntityManager em = conexion.getEm();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(usuario);
		tx.commit();
	}

	@Override
	public void actualizar(Usuario usuario) {
		ConexionMySQLJPA conexion = ConexionMySQLJPA.getConexion();
		EntityManager em = conexion.getEm();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(usuario);
		tx.commit();

	}

	@Override
	public void eliminar(Integer id) {
		ConexionMySQLJPA conexion = ConexionMySQLJPA.getConexion();
		EntityManager em = conexion.getEm();
		EntityTransaction tx = em.getTransaction();
		Usuario usuario = em.find(Usuario.class, id);
		tx.begin();
		em.remove(usuario);
		tx.commit();

	}

	@Override
	public Usuario buscar(Integer id) {
		ConexionMySQLJPA conexion = ConexionMySQLJPA.getConexion();
		EntityManager em = conexion.getEm();
		EntityTransaction tx = em.getTransaction();
		Usuario usuario = em.find(Usuario.class, id);
		return usuario;
	}

	@Override
	public List<Usuario> mostrarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
