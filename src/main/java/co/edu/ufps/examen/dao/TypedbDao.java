package co.edu.ufps.examen.dao;

import java.util.List;

import co.edu.ufps.examen.entities.Typedb;

public interface TypedbDao {
	public void insertar(Typedb typedb);
	public void actualizar(Typedb typedb);
	public void eliminar(String id);
	public Typedb buscar(String id);
	public List<Typedb> mostrarTodos();
}
