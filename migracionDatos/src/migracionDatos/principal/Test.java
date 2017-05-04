package migracionDatos.principal;

import java.util.ArrayList;
import java.util.List;

import migracionDatos.dtos.EstudianteTitulacionJdbcDto;
import migracionDatos.excepciones.PersonaJdbcException;
import migracionDatos.servicios.ServiciosGenerales;

public class Test {
	
	public static void main(String[] args) {
		try {
			ServiciosGenerales srv = new ServiciosGenerales();

//			System.out.println("***********************************************************");
//			System.out.println("***********************************************************");
//			System.out.println("***********************************************************");
//			System.out.println("********************INICIO PROCESO*************************");
//			System.out.println("***********************************************************");
//			System.out.println("***********************************************************");
			
			/**
			 * Migrar datos de todas las facultades
			 */
			
//			// LISTA DE ESTUDIANTES QUE TIENEN QUE SER MIGRADOS
//			List<EstudianteTitulacionJdbcDto> listaTitulacion = new ArrayList<EstudianteTitulacionJdbcDto>();
//			listaTitulacion = srv.listarPersonas("titulacion");
			
//			// LISTA DE CARRERAS EXISTENTES
//			List<CarreraDto> listaCarreras = new ArrayList<CarreraDto>();
//			listaCarreras = srv.listarCarreras("titulacion");
			
//			TestMigracion migracion = new TestMigracion();
//			
//			migracion.migrarDatosTotales(listaTitulacion, listaCarreras);
//			
//			System.out.println("migrados: "+migracion.estudiantesMigrados.size());
//			System.out.println("no migrados: "+migracion.estudiantesNoMigrados.size());
			
			/**
			 * Migrar datos por facultad
			 */
			int facultad =12;
			
//			srv.listarPersonasXfacultad("titulacion", facultad);
			
			// LISTA DE ESTUDIANTES QUE TIENEN QUE SER MIGRADOS
			List<EstudianteTitulacionJdbcDto> listaTitulacion = new ArrayList<EstudianteTitulacionJdbcDto>();
			listaTitulacion = srv.listarPersonasXfacultad("titulacion", facultad);
			
			List<EstudianteTitulacionJdbcDto> estudiantesEncontrados = new ArrayList<EstudianteTitulacionJdbcDto>();
			System.out.println("**********************************");
			System.out.println("BUSCANDO ESTUDIANTES YA MIGRADOS...............");
//			List<Boolean> encontrdos = new ArrayList<Boolean>();
			for (EstudianteTitulacionJdbcDto itemEstudiante : listaTitulacion) {
				if(srv.buscarPersonaXid("emision titulo", itemEstudiante.getPrsIdentificacion())){
					estudiantesEncontrados.add(itemEstudiante);
					System.out.print(".");
				}
			}
			System.out.println("FIN BUSQUEDA DE ESTUDIANTES....................");
			if(estudiantesEncontrados.size() != 0){
				System.out.println("*************************************************");
				System.out.println("*************************************************");
				System.out.println("*******SE ENCONTRÓ ESTUDIANTES YA MIGRADOS*******");
				System.out.println("*************************************************");
				System.out.println("*************************************************");
				for (EstudianteTitulacionJdbcDto itemEstudEncontrados : estudiantesEncontrados) {
					System.out.println("estudiante : "+ itemEstudEncontrados.getPrsIdentificacion()); 
				}
				
				System.out.println("");
				System.out.println("VERIFICAR ESTUDIANTES EN LA LISTA DESPLEGADA.............");
				System.out.println(".........................................................");
				System.out.println("EL PROGRAMA NO EJECUTÓ NINGUNA MIGRACIÓN.................");
				
			}else{
				System.out.println("***********************************************************");
				System.out.println("***********************************************************");
				System.out.println("***********************************************************");
				System.out.println("********************INICIO PROCESO MIGRACIÓN **************");
				System.out.println("***********************************************************");
				System.out.println("***********************************************************");
				MigracionDatos migracion = new MigracionDatos();
				
				migracion.migrarDatosXfacultad(listaTitulacion, facultad);
				System.out.println("");
				System.out.println("migrados: "+migracion.estudiantesMigrados.size());
				System.out.println("no migrados: "+migracion.estudiantesNoMigrados.size());
				
				
				System.out.println("***********************************************************");
				System.out.println("***********************************************************");
				System.out.println("***********************************************************");
				System.out.println("********************FIN PROCESO****************************");
				System.out.println("***********************************************************");
				System.out.println("***********************************************************");
			}
			
		} catch (PersonaJdbcException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
