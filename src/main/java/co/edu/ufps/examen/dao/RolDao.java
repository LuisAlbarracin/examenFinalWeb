package co.edu.ufps.examen.dao;

import java.util.List;

import co.edu.ufps.examen.entities.Rol;

public interface RolDao {

	public void insertar(Rol typedb);
	public void actualizar(Rol typedb);
	public void eliminar(Integer id);
	public Rol buscar(Integer id);
	public List<Rol> mostrarTodos();
}
