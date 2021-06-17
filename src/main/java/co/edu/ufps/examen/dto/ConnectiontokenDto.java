package co.edu.ufps.examen.dto;

import java.io.Serializable;

public class ConnectiontokenDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String host;
	private String userdb;
	private String pass;
	private String db;
	private String token;
	private Integer port;
	private String user;
	private Integer state;
	private String type;

	public ConnectiontokenDto(Integer id, String host, String userdb, String pass, String db, String token,
			Integer port, String user, Integer state, String type) {
		super();
		this.id = id;
		this.host = host;
		this.userdb = userdb;
		this.pass = pass;
		this.db = db;
		this.token = token;
		this.port = port;
		this.user = user;
		this.state = state;
		this.type = type;
	}

	public ConnectiontokenDto(Integer id) {
		super();
		this.id = id;
	}

	public ConnectiontokenDto() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUserdb() {
		return userdb;
	}

	public void setUserdb(String userdb) {
		this.userdb = userdb;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getDb() {
		return db;
	}

	public void setDb(String db) {
		this.db = db;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
