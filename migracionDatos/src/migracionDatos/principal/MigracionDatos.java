package migracionDatos.principal;

import java.util.ArrayList;
import java.util.List;

import migracionDatos.dtos.CarreraDto;
import migracionDatos.dtos.ConfiguracionCarreraDto;
import migracionDatos.dtos.EstudianteTitulacionJdbcDto;
import migracionDatos.excepciones.CarreraJdbcException;
import migracionDatos.excepciones.ConsutaGeneralJdbcException;
import migracionDatos.excepciones.PersonaFichaEstudianteJdbcException;
import migracionDatos.excepciones.ProcesosTramitesJdbcException;
import migracionDatos.excepciones.RolFlujoCarreraJdbcException;
import migracionDatos.excepciones.TramiteTituloJdbcException;
import migracionDatos.servicios.ServiciosGenerales;

public class MigracionDatos {
	
	public List<EstudianteTitulacionJdbcDto> estudiantesNoMigrados;
	public List<EstudianteTitulacionJdbcDto> estudiantesMigrados;
	ServiciosGenerales servicios = new ServiciosGenerales();
	
	public void migrarDatosTotales(List<EstudianteTitulacionJdbcDto> estudiantesTitulacion, List<CarreraDto> listCarreras){
		
		//INSTANCIO LOS OBJETOS DE LAS LISTAS DE QUIN HA SIDO MIGRADO Y QUIEN NO
		estudiantesNoMigrados= new ArrayList<EstudianteTitulacionJdbcDto>();
		estudiantesMigrados = new ArrayList<EstudianteTitulacionJdbcDto>();
		
		// CREACCION DEL OBJETO PARA LAS CARRERAS QUE VAN A SER MIGRADAS
		List<CarreraDto> listaCarrerasAmigrar = new ArrayList<CarreraDto>();
		CarreraDto carreraAmigrarAux = new CarreraDto();
		
		//BUSCO LAS CARRERAS QUE DEBEN SER MIGRADAS EN LOS ESTUDIANTES Y LAS GUARDO EN UN OBJETO
		for (CarreraDto itemCarrera : listCarreras) {
			for (EstudianteTitulacionJdbcDto itemEstudiantes : estudiantesTitulacion) {
				if(itemCarrera.getCrrId() == itemEstudiantes.getCrrId()){
					if(listaCarrerasAmigrar.size() == 0){
						listaCarrerasAmigrar.add(itemCarrera);
					}else{
						for (CarreraDto carrerasMigrarItem : listaCarrerasAmigrar) {
							if(carrerasMigrarItem.getCrrId() != itemCarrera.getCrrId()){
								carreraAmigrarAux = itemCarrera;
							}
						}
						listaCarrerasAmigrar.add(carreraAmigrarAux);
					}
					break;
				}
			}
		}
		
		Boolean banderaCreacionTramiteTitulo = false;
		try {
			for (CarreraDto itemCarrera : listaCarrerasAmigrar) {
				
				//BUSCO EL ID DE LA SECRETARIA PARA EL ROL FLUJO CARRERA
				Integer secretariaId = servicios.buscarRoFlCrXcarrera(itemCarrera.getCrrId(), 1, "emision titulo"); // 1.- secretaria
////				BUSCO EL ID DEL SEC ABOGADO PARA EL ROL FLUJO CARRERA
//				Integer secAbogadoId = servicios.buscarRoFlCrXcarrera(itemCarrera.getCrrId(), 2, "emision titulo"); // 2.- secretaria abogado
				//RECORRO LOS TRES GENEROS QUE EXISTEN PARA GENERAR TRAMITE TITULO
				for(int aux = 0; aux < 3; aux++){ //0.-Hombre   1.-Mujer  2.-Generico
					//RECORRO LOS ESTUDIANTES PARA HACER LA CONPARACION SI TIENE EL MISMO SEXO Y LA CARRERA BUSCADA
					for (EstudianteTitulacionJdbcDto itemEstudiante : estudiantesTitulacion) {
						//CONPARACION SI TIENE EL MISMO SEXO Y LA CARRERA BUSCADA
						if(itemEstudiante.getPrsSexo() == aux && itemEstudiante.getCrrId() == itemCarrera.getCrrId()){
							//busco el tramite titulo ultimo ingresado
							Integer tramiteTituloId = servicios.buscarMaximoIdXtabla("emision titulo", "tramite_titulo");
								if(!banderaCreacionTramiteTitulo){//CREO EL TRAMITE PARA ESA CARRERA CON ESE SEXO (SI AUN NO SE CREA EL TRAMITE TITULO)
//									Boolean guardoTramiteTitulo = servicios.insertarTramiteTitulo("emision titulo", itemEstudiante, 8); // 8 rector
									servicios.insertarTramiteTitulo("emision titulo", itemEstudiante, 8); // 8 rector
//									Boolean guardoProcesoTramite = servicios.insertarProcesosTramites("emision titulo", secretariaId, secAbogadoId, tramiteTituloId+1);
//									servicios.insertarProcesosTramites("emision titulo", secretariaId, secAbogadoId, tramiteTituloId+1);
									servicios.insertarProcesoTramite("emision titulo", secretariaId, tramiteTituloId+1);
									banderaCreacionTramiteTitulo = true;
									servicios.insertarPersonaYfichaEstudiante("emision titulo", itemEstudiante, tramiteTituloId+1);
									estudiantesMigrados.add(itemEstudiante);
									System.out.print(".");
//									estudiantesNoMigrados.add(itemEstudiante);
//									System.out.print("/");
									
								}else{
									servicios.insertarPersonaYfichaEstudiante("emision titulo", itemEstudiante, tramiteTituloId);
									estudiantesMigrados.add(itemEstudiante);
									System.out.print(".");
//										estudiantesNoMigrados.add(itemEstudiante);
//										System.out.print("/");
									
								}
						}
					}// fin recorrido estudientes
					banderaCreacionTramiteTitulo = false;
					System.out.println(" ");
				}
			}// fin recorrido carreras
		
		} catch (ConsutaGeneralJdbcException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RolFlujoCarreraJdbcException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TramiteTituloJdbcException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProcesosTramitesJdbcException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PersonaFichaEstudianteJdbcException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void migrarDatosXfacultad(List<EstudianteTitulacionJdbcDto> estudiantesTitulacion, int facultadId){
		
		//INSTANCIO LOS OBJETOS DE LAS LISTAS DE QUIN HA SIDO MIGRADO Y QUIEN NO
		estudiantesNoMigrados= new ArrayList<EstudianteTitulacionJdbcDto>();
		estudiantesMigrados = new ArrayList<EstudianteTitulacionJdbcDto>();
		
		Boolean banderaCreacionTramiteTitulo = false;
		try {
			// CREACCION DEL OBJETO PARA LAS CARRERAS QUE VAN A SER MIGRADAS
//			List<CarreraDto> listaCarrerasAmigrar = servicios.listarCarrerasXfacultad("emision titulo", facultadId);
			// CREACCION DEL OBJETO PARA LAS CONFIGURACIONES CARRERA QUE VAN A SER MIGRADAS
			List<ConfiguracionCarreraDto> listaConfCarreraAmigrar = servicios.listarConfCarreraXfacultad("emision titulo", facultadId);
			
			for (ConfiguracionCarreraDto itemConfCarrera : listaConfCarreraAmigrar) {
				System.out.println("");
				System.out.println(" RECORRIENDO CARRERA : "+ itemConfCarrera.getCrrId()+" Y CONF CARRERA: "+ itemConfCarrera.getCncrId());
				//BUSCO EL ID DE LA SECRETARIA PARA EL ROL FLUJO CARRERA
				Integer secretariaId = servicios.buscarRoFlCrXcarrera(itemConfCarrera.getCrrId(), 1, "emision titulo"); // 1.- secretaria

				//RECORRO LOS TRES GENEROS QUE EXISTEN PARA GENERAR TRAMITE TITULO
				for(int aux = 0; aux < 3; aux++){ //0.-Hombre   1.-Mujer  2.-Generico
					//RECORRO LOS ESTUDIANTES PARA HACER LA CONPARACION SI TIENE EL MISMO SEXO Y LA CARRERA BUSCADA
					for (EstudianteTitulacionJdbcDto itemEstudiante : estudiantesTitulacion) {
						System.out.print(".");
						//CONPARACION SI TIENE EL MISMO SEXO Y LA CARRERA BUSCADA
						if(itemEstudiante.getPrsSexo().intValue() == aux && itemEstudiante.getFcesConfCarreraId().intValue() == itemConfCarrera.getCncrId()){
							//busco el tramite titulo ultimo ingresado
							Integer tramiteTituloId = servicios.buscarMaximoIdXtabla("emision titulo", "tramite_titulo");
								if(!banderaCreacionTramiteTitulo){//CREO EL TRAMITE PARA ESA CARRERA CON ESE SEXO (SI AUN NO SE CREA EL TRAMITE TITULO)
//									Boolean guardoTramiteTitulo = servicios.insertarTramiteTitulo("emision titulo", itemEstudiante, 8); // 8 rector
									servicios.insertarTramiteTitulo("emision titulo", itemEstudiante, 8); // 8 rector
//									Boolean guardoProcesoTramite = servicios.insertarProcesosTramites("emision titulo", secretariaId, secAbogadoId, tramiteTituloId+1);
//									servicios.insertarProcesosTramites("emision titulo", secretariaId, secAbogadoId, tramiteTituloId+1);
									servicios.insertarProcesoTramite("emision titulo", secretariaId, tramiteTituloId+1);
									banderaCreacionTramiteTitulo = true;
									servicios.insertarPersonaYfichaEstudiante("emision titulo", itemEstudiante, tramiteTituloId+1);
									estudiantesMigrados.add(itemEstudiante);
//									estudiantesNoMigrados.add(itemEstudiante);
									
								}else{
									servicios.insertarPersonaYfichaEstudiante("emision titulo", itemEstudiante, tramiteTituloId);
									estudiantesMigrados.add(itemEstudiante);
//									estudiantesNoMigrados.add(itemEstudiante);
									
								}
						}
					}// fin recorrido estudientes
					banderaCreacionTramiteTitulo = false;
				}
			}// fin recorrido carreras
			System.out.println(" ");
			System.out.println("----------------------------------------------------");
			System.out.println("ACTUALIZANDO EN TITULACIÓN ESTUDIANTES MIGRADOS");
			System.out.println("----------------------------------------------------");
			
			int auxMigrados = servicios.actualizarTramiteTitulo("titulacion", estudiantesMigrados);

					System.out.println("----------------------------------------------------");
					System.out.println("ESTUDIANTES DE TITULACION ACTUALIZADOS EXITOSAMENTE");
					System.out.println("----------------------------------------------------");
			
			System.out.println(" ");
			System.out.println("----------------------------------------------------");
			System.out.println("EJECUTANDO SCRIPTS NECESARIOS");
			System.out.println("----------------------------------------------------");
			
			servicios.ejecutarScripts("Emision Titulo");
			
			System.out.println("----------------------------------------------------");
			System.out.println("SCRIPS EJECUTADOS EXITOSAMENTE");
			System.out.println("----------------------------------------------------");
			
			System.out.println(" ");
			System.out.println("----------------------------------------------------");
			System.out.println("EJECUTANDO SELECTS NECESARIOS");
			System.out.println("----------------------------------------------------");
			
			servicios.ejecutarSelects("Emision Titulo");
			
			System.out.println("----------------------------------------------------");
			System.out.println("SELECTS EJECUTADOS EXITOSAMENTE");
			System.out.println("----------------------------------------------------");
			
//			System.out.println("scripts: "+ auxScripts);
		
		} catch (ConsutaGeneralJdbcException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CarreraJdbcException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RolFlujoCarreraJdbcException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TramiteTituloJdbcException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProcesosTramitesJdbcException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PersonaFichaEstudianteJdbcException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
