package co.edu.ufps.examen.dao;

import java.util.List;

import co.edu.ufps.examen.entities.Connectiontoken;

public interface ConnectiontokenDao {
	public void insertar(Connectiontoken connectiontoken);
	public void actualizar(Connectiontoken connectiontoken);
	public void eliminar(Integer id);
	public Connectiontoken buscar(Integer id);
	public List<Connectiontoken> mostrarTodos();
}
