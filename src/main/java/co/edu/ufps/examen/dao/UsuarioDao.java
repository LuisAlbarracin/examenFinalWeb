package co.edu.ufps.examen.dao;

import java.util.List;

import co.edu.ufps.examen.entities.Usuario;

public interface UsuarioDao {

	public void insertar(Usuario usuario);
	public void actualizar(Usuario usuario);
	public void eliminar(Integer id);
	public Usuario buscar(Integer id);
	public List<Usuario> mostrarTodos();
}
