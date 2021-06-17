package co.edu.ufps.examen.dto;

import java.io.Serializable;
import java.util.Date;

public class ReporteDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String file;
	private Integer conexion;
	private Date datecreate;
	private String state;
	private String description;
	private String name;

	public ReporteDto(Integer id) {
		super();
		this.id = id;
	}

	public ReporteDto(Integer id, String file, Integer conexion, Date datecreate, String state, String description,
			String name) {
		super();
		this.id = id;
		this.file = file;
		this.conexion = conexion;
		this.datecreate = datecreate;
		this.state = state;
		this.description = description;
		this.name = name;
	}

	public ReporteDto() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public Integer getConexion() {
		return conexion;
	}

	public void setConexion(Integer conexion) {
		this.conexion = conexion;
	}

	public Date getDatecreate() {
		return datecreate;
	}

	public void setDatecreate(Date datecreate) {
		this.datecreate = datecreate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
