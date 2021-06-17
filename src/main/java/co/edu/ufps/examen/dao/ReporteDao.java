package co.edu.ufps.examen.dao;

import java.util.List;

import co.edu.ufps.examen.entities.Reporte;

public interface ReporteDao {

	public void insertar(Reporte reporte);
	public void actualizar(Reporte reporte);
	public void eliminar(Integer id);
	public Reporte buscar(Integer id);
	public List<Reporte> mostrarTodos();
}
