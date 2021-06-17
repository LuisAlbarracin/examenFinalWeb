package co.edu.ufps.examen.dto;

import java.io.Serializable;
import java.util.Date;

public class SeguimientoDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer report;
	private Date dategenerate;
	private Integer state;
	private String result;
	private String detailrequest;
	private String type;
	private String filegenerate;

	public SeguimientoDto() {
		super();
	}

	public SeguimientoDto(Integer id, Integer report, Date dategenerate, Integer state, String result,
			String detailrequest, String type, String filegenerate) {
		super();
		this.id = id;
		this.report = report;
		this.dategenerate = dategenerate;
		this.state = state;
		this.result = result;
		this.detailrequest = detailrequest;
		this.type = type;
		this.filegenerate = filegenerate;
	}

	public SeguimientoDto(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getReport() {
		return report;
	}

	public void setReport(Integer report) {
		this.report = report;
	}

	public Date getDategenerate() {
		return dategenerate;
	}

	public void setDategenerate(Date dategenerate) {
		this.dategenerate = dategenerate;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getDetailrequest() {
		return detailrequest;
	}

	public void setDetailrequest(String detailrequest) {
		this.detailrequest = detailrequest;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFilegenerate() {
		return filegenerate;
	}

	public void setFilegenerate(String filegenerate) {
		this.filegenerate = filegenerate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
