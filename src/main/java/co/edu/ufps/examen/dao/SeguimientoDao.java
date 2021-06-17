package co.edu.ufps.examen.dao;

import java.util.List;

import co.edu.ufps.examen.entities.Seguimiento;

public interface SeguimientoDao {

	public void insertar(Seguimiento seguimiento);
	public void actualizar(Seguimiento seguimiento);
	public void eliminar(Integer id);
	public Seguimiento buscar(Integer id);
	public List<Seguimiento> mostrarTodos();
}
