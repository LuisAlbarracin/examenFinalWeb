package co.edu.ufps.examen.dto;

import java.io.Serializable;

public class TypedbDao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String description;
	private String driver;
	private String aditional;

	public TypedbDao(String id, String description, String driver, String aditional) {
		super();
		this.id = id;
		this.description = description;
		this.driver = driver;
		this.aditional = aditional;
	}

	public TypedbDao() {
		super();
	}

	public TypedbDao(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getAditional() {
		return aditional;
	}

	public void setAditional(String aditional) {
		this.aditional = aditional;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
