package co.edu.ufps.examen.entities;

import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the rol database table.
 * 
 */
@Entity
@NamedQuery(name="Rol.findAll", query="SELECT r FROM Rol r")
public class Rol  {

	@Id
	private int id;

	private String description;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="rol")
	private List<Usuario> usuarios;

	public Rol() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setRol(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setRol(null);

		return usuario;
	}

	public Rol(int id, String description, List<Usuario> usuarios) {
		super();
		this.id = id;
		this.description = description;
		this.usuarios = usuarios;
	}

	public Rol(int id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	public Rol(int id) {
		super();
		this.id = id;
	}

	public Rol(String description) {
		super();
		this.description = description;
	}
	
	
	
	
	

}