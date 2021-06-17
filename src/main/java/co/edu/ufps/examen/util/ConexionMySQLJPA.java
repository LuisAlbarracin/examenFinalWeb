package co.edu.ufps.examen.util;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexionMySQLJPA {
	private EntityManager em;
	
	private static ConexionMySQLJPA conexion;
	
	private ConexionMySQLJPA() {
		if(this.em == null) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("examenFinal");
			this.em =  emf.createEntityManager()
;		}
	}
	
	public static ConexionMySQLJPA getConexion() {
		if (conexion == null)
			conexion = new ConexionMySQLJPA();
		return conexion;
	}
	
	public EntityManager getEm() {
		return this.em;
	}
	
}
