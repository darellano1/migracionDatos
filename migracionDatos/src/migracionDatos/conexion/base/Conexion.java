package migracionDatos.conexion.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import migracionDatos.utilitarios.ConstantesGenerales;


public class Conexion {
	private Connection conexion ;
	private String driver;
	private String cadenaConexion;
	private String base;
	
	public Conexion(String base) {
		this.base = base;
		if(base.equals("titulacion")){
//			/*POSTGRES*/
			driver = "org.postgresql.Driver";
			cadenaConexion = "jdbc:postgresql://"+ConstantesGenerales.CON_HOST+":"+ConstantesGenerales.CON_PUERTO+"/"+ConstantesGenerales.CON_BASE;
		}else{
//			/*POSTGRES*/
			driver = "org.postgresql.Driver";
			cadenaConexion = "jdbc:postgresql://"+ConstantesGenerales.CON_HOST_EMI_TIT+":"+ConstantesGenerales.CON_PUERTO+"/"+ConstantesGenerales.CON_BASE_EMISION_TITULO;
		}

		/*ORACLE*/
//		driver = "oracle.jdbc.driver.OracleDriver";
//		cadenaConexion = "jdbc:oracle:thin:@"+ConstantesGenerales.CON_HOST+":"+ConstantesGenerales.CON_PUERTO+":"+ConstantesGenerales.CON_BASE;
	}


	public Connection getConexion() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		if(base.equals("titulacion")){
			conexion = DriverManager.getConnection(cadenaConexion, ConstantesGenerales.CON_USUARIO , ConstantesGenerales.CON_CLAVE);
		}else{
			conexion = DriverManager.getConnection(cadenaConexion, ConstantesGenerales.CON_USUARIO , ConstantesGenerales.CON_CLAVE_EMI_TIT);
		}
		
		return conexion;
	}

	public void cerrarConexion(){
		try {
			if(conexion !=null){
				conexion.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
}
