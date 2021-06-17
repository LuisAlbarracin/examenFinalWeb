package co.edu.ufps.examen.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the reporte database table.
 * 
 */
@Entity
@NamedQuery(name="Reporte.findAll", query="SELECT r FROM Reporte r")
public class Reporte  {

	@Id
	private int id;

	private Timestamp datecreate;

	private String description;

	private String file;

	private String name;

	private String state;

	//bi-directional many-to-one association to Connectiontoken
	@ManyToOne
	@JoinColumn(name="conexion")
	private Connectiontoken connectiontoken;

	//bi-directional many-to-one association to Seguimiento
	@OneToMany(mappedBy="reporte")
	private List<Seguimiento> seguimientos;

	public Reporte() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getDatecreate() {
		return this.datecreate;
	}

	public void setDatecreate(Timestamp datecreate) {
		this.datecreate = datecreate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFile() {
		return this.file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Connectiontoken getConnectiontoken() {
		return this.connectiontoken;
	}

	public void setConnectiontoken(Connectiontoken connectiontoken) {
		this.connectiontoken = connectiontoken;
	}

	public List<Seguimiento> getSeguimientos() {
		return this.seguimientos;
	}

	public void setSeguimientos(List<Seguimiento> seguimientos) {
		this.seguimientos = seguimientos;
	}

	public Seguimiento addSeguimiento(Seguimiento seguimiento) {
		getSeguimientos().add(seguimiento);
		seguimiento.setReporte(this);

		return seguimiento;
	}

	public Seguimiento removeSeguimiento(Seguimiento seguimiento) {
		getSeguimientos().remove(seguimiento);
		seguimiento.setReporte(null);

		return seguimiento;
	}

	public Reporte(int id, Timestamp datecreate, String description, String file, String name, String state,
			Connectiontoken connectiontoken) {
		super();
		this.id = id;
		this.datecreate = datecreate;
		this.description = description;
		this.file = file;
		this.name = name;
		this.state = state;
		this.connectiontoken = connectiontoken;
	}

	public Reporte(Timestamp datecreate, String description, String file, String name, String state,
			Connectiontoken connectiontoken) {
		super();
		this.datecreate = datecreate;
		this.description = description;
		this.file = file;
		this.name = name;
		this.state = state;
		this.connectiontoken = connectiontoken;
	}
	
	
	
	
	

}