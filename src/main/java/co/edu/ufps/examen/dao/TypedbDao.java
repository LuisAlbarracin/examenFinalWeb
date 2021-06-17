package co.edu.ufps.examen.dao;

import java.util.List;

import co.edu.ufps.examen.entities.Typedb;

public interface TypedbDao {
	public void insertar(Typedb typedb);
	public void actualizar(Typedb typedb);
	public void eliminar(Integer id);
	public Typedb buscar(Integer id);
	public List<Typedb> mostrarTodos();
}
