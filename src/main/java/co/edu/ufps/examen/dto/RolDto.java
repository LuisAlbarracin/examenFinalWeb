package co.edu.ufps.examen.dto;

import java.io.Serializable;

public class RolDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String description;

	public RolDto() {
		super();
	}

	public RolDto(Integer id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	public RolDto(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
