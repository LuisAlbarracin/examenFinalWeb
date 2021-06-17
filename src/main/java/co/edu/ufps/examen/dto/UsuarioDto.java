package co.edu.ufps.examen.dto;

import java.io.Serializable;

public class UsuarioDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String usuario;
	private String email;
	private String pass;
	private String role;
	private Integer state;

	public UsuarioDto(Integer id, String usuario, String email, String pass, String role, Integer state) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.email = email;
		this.pass = pass;
		this.role = role;
		this.state = state;
	}

	public UsuarioDto() {
		super();
	}

	public UsuarioDto(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
