package migracionDatos.utilitarios;

import java.util.ResourceBundle;

public class ConstantesGenerales {
		public static final String CON_HOST;//ip de la base de datos
		public static final String CON_HOST_EMI_TIT;//ip de la base de datos emision titulio
		public static final String CON_PUERTO;//puerto de la base de datos
		public static final String CON_BASE;//nombre de la base
		public static final String CON_BASE_EMISION_TITULO;//nombre de la base de emision título
		public static final String CON_USUARIO;//usuario para la BD
		public static final String CON_CLAVE;//clave del usuario
		public static final String CON_CLAVE_EMI_TIT;//clave del usuario
		public static final String GEN_ESQUEMA;//esquema de la base que se va a generar}
		
		
		static{
			ResourceBundle rb = ResourceBundle.getBundle("migracionDatos.configuracion.configuracion");
			CON_HOST = rb.getString("con.host");
			CON_HOST_EMI_TIT = rb.getString("con.host.emi.tit");
			CON_PUERTO = rb.getString("con.puerto");
			CON_BASE = rb.getString("con.base");
			CON_BASE_EMISION_TITULO = rb.getString("con.base.emision.titulo");
			CON_USUARIO = rb.getString("con.usuario");
			CON_CLAVE = rb.getString("con.clave");
			CON_CLAVE_EMI_TIT = rb.getString("con.clave.emi.tit");
			GEN_ESQUEMA = rb.getString("gen.esquema");
			
			
		}	
}
