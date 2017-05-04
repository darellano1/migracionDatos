package migracionDatos.servicios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import migracionDatos.conexion.base.Conexion;
import migracionDatos.dtos.CarreraDto;
import migracionDatos.dtos.ConfiguracionCarreraDto;
import migracionDatos.dtos.EstudianteTitulacionJdbcDto;
import migracionDatos.excepciones.CarreraJdbcException;
import migracionDatos.excepciones.ConsutaGeneralJdbcException;
import migracionDatos.excepciones.PersonaFichaEstudianteJdbcException;
import migracionDatos.excepciones.PersonaJdbcException;
import migracionDatos.excepciones.ProcesosTramitesJdbcException;
import migracionDatos.excepciones.RolFlujoCarreraJdbcException;
import migracionDatos.excepciones.TramiteTituloJdbcException;
import migracionDatos.utilitarios.Utilidades;

public class ServiciosGenerales {
	
	public List<EstudianteTitulacionJdbcDto> listarPersonas(String base) throws PersonaJdbcException{
		Conexion con = new Conexion(base);
		List<EstudianteTitulacionJdbcDto> retorno = new ArrayList<EstudianteTitulacionJdbcDto>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			StringBuffer ssql = new StringBuffer();
			ssql.append(" SELECT ");
			ssql.append(" fces.");ssql.append("fces_fecha_inicio as fces_fecha_inicio ");
			ssql.append(" ,fces.");ssql.append("fces_fecha_egresamiento as fces_fecha_egresamiento ");
			ssql.append(" ,fces.");ssql.append("fces_fecha_acta_grado as fces_fecha_acta_grado ");
			ssql.append(" ,fces.");ssql.append("fces_num_acta_grado as fces_num_acta_grado ");
			ssql.append(" ,fces.");ssql.append("fces_crr_estud_previos as fces_crr_estud_previos ");
			ssql.append(" ,fces.");ssql.append("fces_tiempo_estud_rec as fces_tiempo_estud_rec ");
			ssql.append(" ,fces.");ssql.append("fces_tipo_durac_rec as fces_tipo_durac_rec ");
			ssql.append(" ,fces.");ssql.append("fces_tipo_colegio as fces_tipo_colegio ");
			ssql.append(" ,fces.");ssql.append("fces_tipo_colegio_sniese as fces_tipo_colegio_sniese ");
			ssql.append(" ,fces.");ssql.append("fces_nota_prom_acumulado as fces_nota_prom_acumulado ");
			ssql.append(" ,fces.");ssql.append("fces_nota_trab_titulacion as fces_nota_trab_titulacion ");
			ssql.append(" ,fces.");ssql.append("fces_link_tesis as fces_link_tesis ");
			ssql.append(" ,fces.");ssql.append("fces_rec_estud_previos as fces_rec_estud_previos ");
			ssql.append(" ,fces.");ssql.append("fces_rec_estud_prev_sniese as fces_rec_estud_prev_sniese ");
			ssql.append(" ,fces.");ssql.append("fces_fecha_creacion as fces_fecha_creacion ");
			ssql.append(" ,fces.");ssql.append("ubc_canton_residencia as ubc_canton_residencia ");
			ssql.append(" ,fces.");ssql.append("mcttcr_id as mcttcr_id ");
			ssql.append(" ,fces.");ssql.append("inac_id_inst_est_previos as inac_id_inst_est_previos ");
			ssql.append(" ,fces.");ssql.append("cncr_id as cncr_id ");
			ssql.append(" ,ttl.");ssql.append("ttl_descripcion as ttl_descripcion ");
			ssql.append(" ,prs.");ssql.append("prs_tipo_identificacion as prs_tipo_identificacion ");
			ssql.append(" ,prs.");ssql.append("prs_tipo_identificacion_sniese as prs_tipo_identificacion_sniese ");
			ssql.append(" ,prs.");ssql.append("prs_identificacion as prs_identificacion ");
			ssql.append(" ,prs.");ssql.append("prs_primer_apellido as prs_primer_apellido ");
			ssql.append(" ,prs.");ssql.append("prs_segundo_apellido as prs_segundo_apellido ");
			ssql.append(" ,prs.");ssql.append("prs_nombres as prs_nombres ");
			ssql.append(" ,prs.");ssql.append("prs_sexo as prs_sexo ");
			ssql.append(" ,prs.");ssql.append("prs_sexo_sniese as prs_sexo_sniese ");
			ssql.append(" ,prs.");ssql.append("prs_mail_personal as prs_mail_personal ");
			ssql.append(" ,prs.");ssql.append("prs_mail_institucional as prs_mail_institucional ");
			ssql.append(" ,prs.");ssql.append("prs_telefono as prs_telefono ");
			ssql.append(" ,prs.");ssql.append("prs_fecha_nacimiento as prs_fecha_nacimiento ");
			ssql.append(" ,prs.");ssql.append("etn_id as etn_id ");
			ssql.append(" ,prs.");ssql.append("ubc_id as ubc_id ");
			ssql.append(" ,mcttcr.");ssql.append("mctt_id as mctt_id ");
			ssql.append(" ,crr.");ssql.append("crr_id as crr_id ");
			ssql.append(" ,trtt.");ssql.append("trtt_id as trtt_id ");
			ssql.append(" ,trtt.");ssql.append("trtt_estado_proceso as trtt_estado_proceso ");
			ssql.append(" FROM ficha_estudiante fces, tramite_titulo trtt, persona prs, mecanismo_titulacion_carrera mcttcr, configuracion_carrera cncr, carrera crr, titulo ttl ");
			ssql.append(" WHERE fces.trtt_id = trtt.trtt_id ");
			ssql.append(" AND fces.prs_id = prs.prs_id ");
			ssql.append(" AND fces.mcttcr_id = mcttcr.mcttcr_id ");
			ssql.append(" AND fces.cncr_id = cncr.cncr_id ");
			ssql.append(" AND cncr.crr_id= crr.crr_id ");
			ssql.append(" AND trtt.trtt_estado_proceso IN(108,109) ");
			ssql.append(" AND fces.ttl_titulo_bachiller = ttl.ttl_id ");
			ssql.append(" ORDER BY crr.crr_id DESC");
			
			pstmt = con.getConexion().prepareStatement(ssql.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				retorno.add(resultSetAdtoEstudianteTitulacion(rs));
			}
			
		} catch (SQLException e) {
			throw new PersonaJdbcException(e);
		} catch (Exception e) {
			throw new PersonaJdbcException(e);
		} finally {
			try {
				if(rs != null){
					rs.close();
				}
				if(pstmt != null){
					pstmt.close();
				}
				if (con != null) {
					con.cerrarConexion();
				}
				
			} catch (SQLException e) {
			}
		}
		if(retorno==null || retorno.size()<=0){
			throw new PersonaJdbcException("No existen estudiantes para migrar");
		}
		return retorno;
		
	}
	
	public List<EstudianteTitulacionJdbcDto> listarPersonasXfacultad(String base,int facultadId) throws PersonaJdbcException{
		Conexion con = new Conexion(base);
		List<EstudianteTitulacionJdbcDto> retorno = new ArrayList<EstudianteTitulacionJdbcDto>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			StringBuffer ssql = new StringBuffer();
			ssql.append(" SELECT ");
			ssql.append(" fces.");ssql.append("fces_fecha_inicio as fces_fecha_inicio ");
			ssql.append(" ,fces.");ssql.append("fces_fecha_egresamiento as fces_fecha_egresamiento ");
			ssql.append(" ,fces.");ssql.append("fces_fecha_acta_grado as fces_fecha_acta_grado ");
			ssql.append(" ,fces.");ssql.append("fces_num_acta_grado as fces_num_acta_grado ");
			ssql.append(" ,fces.");ssql.append("fces_crr_estud_previos as fces_crr_estud_previos ");
			ssql.append(" ,fces.");ssql.append("fces_tiempo_estud_rec as fces_tiempo_estud_rec ");
			ssql.append(" ,fces.");ssql.append("fces_tipo_durac_rec as fces_tipo_durac_rec ");
			ssql.append(" ,fces.");ssql.append("fces_tipo_colegio as fces_tipo_colegio ");
			ssql.append(" ,fces.");ssql.append("fces_tipo_colegio_sniese as fces_tipo_colegio_sniese ");
			ssql.append(" ,fces.");ssql.append("fces_nota_prom_acumulado as fces_nota_prom_acumulado ");
			ssql.append(" ,fces.");ssql.append("fces_nota_trab_titulacion as fces_nota_trab_titulacion ");
				ssql.append(" ,CASE ");ssql.append(" fces.");ssql.append("fces_link_tesis ");
				ssql.append(" WHEN NULL THEN ");ssql.append("' '");
				ssql.append(" ELSE ");ssql.append(" fces.");ssql.append("fces_link_tesis ");ssql.append(" END AS fces_link_tesis ");
			ssql.append(" ,fces.");ssql.append("fces_rec_estud_previos as fces_rec_estud_previos ");
			ssql.append(" ,fces.");ssql.append("fces_rec_estud_prev_sniese as fces_rec_estud_prev_sniese ");
			ssql.append(" ,fces.");ssql.append("fces_fecha_creacion as fces_fecha_creacion ");
			ssql.append(" ,fces.");ssql.append("ubc_canton_residencia as ubc_canton_residencia ");
			ssql.append(" ,fces.");ssql.append("mcttcr_id as mcttcr_id ");
			ssql.append(" ,fces.");ssql.append("inac_id_inst_est_previos as inac_id_inst_est_previos ");
			ssql.append(" ,fces.");ssql.append("cncr_id as cncr_id ");
			ssql.append(" ,ttl.");ssql.append("ttl_descripcion as ttl_descripcion ");
			ssql.append(" ,prs.");ssql.append("prs_tipo_identificacion as prs_tipo_identificacion ");
			ssql.append(" ,prs.");ssql.append("prs_tipo_identificacion_sniese as prs_tipo_identificacion_sniese ");
			ssql.append(" ,prs.");ssql.append("prs_identificacion as prs_identificacion ");
			ssql.append(" ,prs.");ssql.append("prs_primer_apellido as prs_primer_apellido ");
			ssql.append(" ,prs.");ssql.append("prs_segundo_apellido as prs_segundo_apellido ");
			ssql.append(" ,prs.");ssql.append("prs_nombres as prs_nombres ");
			ssql.append(" ,prs.");ssql.append("prs_sexo as prs_sexo ");
			ssql.append(" ,prs.");ssql.append("prs_sexo_sniese as prs_sexo_sniese ");
			ssql.append(" ,prs.");ssql.append("prs_mail_personal as prs_mail_personal ");
			ssql.append(" ,prs.");ssql.append("prs_mail_institucional as prs_mail_institucional ");
			ssql.append(" ,prs.");ssql.append("prs_telefono as prs_telefono ");
			ssql.append(" ,prs.");ssql.append("prs_fecha_nacimiento as prs_fecha_nacimiento ");
			ssql.append(" ,prs.");ssql.append("etn_id as etn_id ");
			ssql.append(" ,prs.");ssql.append("ubc_id as ubc_id ");
			ssql.append(" ,mcttcr.");ssql.append("mctt_id as mctt_id ");
			ssql.append(" ,crr.");ssql.append("crr_id as crr_id ");
			ssql.append(" ,trtt.");ssql.append("trtt_id as trtt_id ");
			ssql.append(" ,trtt.");ssql.append("trtt_estado_proceso as trtt_estado_proceso ");
			ssql.append(" FROM ficha_estudiante fces, tramite_titulo trtt, persona prs, mecanismo_titulacion_carrera mcttcr, configuracion_carrera cncr, carrera crr, titulo ttl ");
			ssql.append(" WHERE fces.trtt_id = trtt.trtt_id ");
			ssql.append(" AND fces.prs_id = prs.prs_id ");
			ssql.append(" AND fces.mcttcr_id = mcttcr.mcttcr_id ");
			ssql.append(" AND fces.cncr_id = cncr.cncr_id ");
			ssql.append(" AND cncr.crr_id= crr.crr_id ");
			ssql.append(" AND trtt.trtt_estado_proceso IN(108,109) ");
			ssql.append(" AND fces.ttl_titulo_bachiller = ttl.ttl_id ");
			ssql.append(" AND crr.fcl_id = ? ");
			ssql.append(" ORDER BY crr.crr_id DESC ");
			System.out.println(ssql);
			pstmt = con.getConexion().prepareStatement(ssql.toString());
			pstmt.setInt(1, facultadId);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				retorno.add(resultSetAdtoEstudianteTitulacion(rs));
			}
			
		} catch (SQLException e) {
			throw new PersonaJdbcException(e);
		} catch (Exception e) {
			throw new PersonaJdbcException(e);
		} finally {
			try {
				if(rs != null){
					rs.close();
				}
				if(pstmt != null){
					pstmt.close();
				}
				if (con != null) {
					con.cerrarConexion();
				}
				
			} catch (SQLException e) {
			}
		}
		if(retorno==null || retorno.size()<=0){
			throw new PersonaJdbcException("No existen estudiantes para migrar");
		}
		return retorno;
		
	}
	
	public List<CarreraDto> listarCarreras(String base) throws CarreraJdbcException{
		Conexion con = new Conexion(base);
		List<CarreraDto> retorno = new ArrayList<CarreraDto>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			StringBuffer ssql = new StringBuffer();
			ssql.append(" SELECT ");
			ssql.append(" crr.");ssql.append("crr_id as crr_id ");
			ssql.append(" ,crr.");ssql.append("crr_descripcion as crr_descripcion ");
			ssql.append(" ,crr.");ssql.append("crr_cod_sniese as crr_cod_sniese ");
			ssql.append(" ,crr.");ssql.append("crr_detalle as crr_detalle ");
			ssql.append(" ,crr.");ssql.append("fcl_id as fcl_id ");
			ssql.append(" FROM carrera crr ");
			ssql.append(" ORDER BY crr.crr_id");
			
			pstmt = con.getConexion().prepareStatement(ssql.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				retorno.add(resultSetAdtoCarrera(rs));
			}
			
		} catch (SQLException e) {
			throw new CarreraJdbcException(e);
		} catch (Exception e) {
			throw new CarreraJdbcException(e);
		} finally {
			try {
				if(rs != null){
					rs.close();
				}
				if(pstmt != null){
					pstmt.close();
				}
				if (con != null) {
					con.cerrarConexion();
				}
				
			} catch (SQLException e) {
			}
		}
		if(retorno==null || retorno.size()<=0){
			throw new CarreraJdbcException("No existen carreras ");
		}
		return retorno;
		
	}
	
	public List<CarreraDto> listarCarrerasXfacultad(String base, int facultadId) throws CarreraJdbcException{
		Conexion con = new Conexion(base);
		List<CarreraDto> retorno = new ArrayList<CarreraDto>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			StringBuffer ssql = new StringBuffer();
			ssql.append(" SELECT ");
			ssql.append(" crr.");ssql.append("crr_id as crr_id ");
			ssql.append(" ,crr.");ssql.append("crr_descripcion as crr_descripcion ");
			ssql.append(" ,crr.");ssql.append("crr_cod_sniese as crr_cod_sniese ");
			ssql.append(" ,crr.");ssql.append("crr_detalle as crr_detalle ");
			ssql.append(" ,crr.");ssql.append("fcl_id as fcl_id ");
			ssql.append(" FROM carrera crr ");
			ssql.append(" WHERE crr.fcl_id = ? ");
			ssql.append(" ORDER BY crr.crr_id");
			
			pstmt = con.getConexion().prepareStatement(ssql.toString());
			pstmt.setInt(1, facultadId);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				retorno.add(resultSetAdtoCarrera(rs));
			}
			
		} catch (SQLException e) {
			throw new CarreraJdbcException(e);
		} catch (Exception e) {
			throw new CarreraJdbcException(e);
		} finally {
			try {
				if(rs != null){
					rs.close();
				}
				if(pstmt != null){
					pstmt.close();
				}
				if (con != null) {
					con.cerrarConexion();
				}
				
			} catch (SQLException e) {
			}
		}
		if(retorno==null || retorno.size()<=0){
			throw new CarreraJdbcException("No existen carreras para la facultad : "+facultadId);
		}
		return retorno;
		
	}
	
	public List<ConfiguracionCarreraDto> listarConfCarreraXfacultad(String base, int facultadId) throws CarreraJdbcException{
		Conexion con = new Conexion(base);
		List<ConfiguracionCarreraDto> retorno = new ArrayList<ConfiguracionCarreraDto>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			StringBuffer ssql = new StringBuffer();
//			ssql.append(" SELECT ");
//			ssql.append(" crr.");ssql.append("crr_id as crr_id ");
//			ssql.append(" ,crr.");ssql.append("crr_descripcion as crr_descripcion ");
//			ssql.append(" ,crr.");ssql.append("crr_cod_sniese as crr_cod_sniese ");
//			ssql.append(" ,crr.");ssql.append("crr_detalle as crr_detalle ");
//			ssql.append(" ,crr.");ssql.append("fcl_id as fcl_id ");
//			ssql.append(" FROM carrera crr ");
//			ssql.append(" WHERE crr.fcl_id = ? ");
//			ssql.append(" ORDER BY crr.crr_id");
			
			ssql.append(" SELECT cncr.cncr_id as cncr_id ,crr.crr_id as crr_id FROM configuracion_carrera cncr, carrera crr ");
			ssql.append(" WHERE cncr.crr_id = crr.crr_id ");
			ssql.append(" AND crr.fcl_id = ? ");
			ssql.append(" ORDER BY crr.crr_id");
			
			pstmt = con.getConexion().prepareStatement(ssql.toString());
			pstmt.setInt(1, facultadId);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				retorno.add(resultSetAdtoConfiguracionCarreraDto(rs));
			}
			
		} catch (SQLException e) {
			throw new CarreraJdbcException(e);
		} catch (Exception e) {
			throw new CarreraJdbcException(e);
		} finally {
			try {
				if(rs != null){
					rs.close();
				}
				if(pstmt != null){
					pstmt.close();
				}
				if (con != null) {
					con.cerrarConexion();
				}
				
			} catch (SQLException e) {
			}
		}
		if(retorno==null || retorno.size()<=0){
			throw new CarreraJdbcException("No existen carreras para la facultad : "+facultadId);
		}
		return retorno;
		
	}
	
	
	public Boolean insertarPersona(String base, EstudianteTitulacionJdbcDto estudiante, int maxPersona) throws PersonaJdbcException{
		Conexion con = new Conexion(base);
		int respuesta;
		Boolean retorno;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			StringBuffer ssql = new StringBuffer();
			ssql.append(" INSERT INTO persona VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt = con.getConexion().prepareStatement(ssql.toString());
			pstmt.setInt(1, maxPersona);
			pstmt.setInt(2, estudiante.getPrsTipoIdentificacion());
			pstmt.setInt(3, estudiante.getPrsTipoIdentificacionSniese());
			pstmt.setString(4, estudiante.getPrsIdentificacion());
			pstmt.setString(5, estudiante.getPrsPrimerApellido());
			pstmt.setString(6, estudiante.getPrsSegundoApellido());
			pstmt.setString(7, estudiante.getPrsNombres());
			pstmt.setInt(8, estudiante.getPrsSexo());
			pstmt.setInt(9, estudiante.getPrsSexoSniese());
			pstmt.setString(10, estudiante.getPrsMailPersonal());
			pstmt.setString(11, estudiante.getPrsMailInstitucional());
			pstmt.setString(12, estudiante.getPrsTelefono());
			pstmt.setDate(13, estudiante.getPrsFechaNacimiento());
			respuesta = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new PersonaJdbcException(e);
		} catch (Exception e) {
			throw new PersonaJdbcException(e);
		} finally {
			try {
				if(rs != null){
					rs.close();
				}
				if(pstmt != null){
					pstmt.close();
				}
				if (con != null) {
					con.cerrarConexion();
				}
				
			} catch (SQLException e) {
			}
		}
		
		if(respuesta != 0){
			retorno = true;
		}else{
			retorno = false;
			throw new PersonaJdbcException("No se guardo ninguna persona");
		}
		
		return retorno;
		
	}
	
	public Boolean insertarTramiteTitulo(String base, EstudianteTitulacionJdbcDto estudiante, int usuarioRolId) throws TramiteTituloJdbcException{
		Conexion con = new Conexion(base);
		int respuesta;
		Boolean retorno;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			StringBuffer ssql = new StringBuffer();
			int maximoTabla = (buscarMaximoIdXtabla(base, "tramite_titulo")+1);
			ssql.append(" INSERT INTO tramite_titulo (trtt_id, trtt_num_tramite, trtt_estado_tramite, trtt_estado_proceso, cncr_id,usro_id) VALUES(?,?,?,?,?,?)");
			pstmt = con.getConexion().prepareStatement(ssql.toString());
			pstmt.setInt(1, maximoTabla);
			pstmt.setString(2, Utilidades.generarNumeroTramite(maximoTabla, new Timestamp(new Date().getTime())));
			pstmt.setInt(3, 0); // 2.- PENDIENTE REGISTRO OUDE
			pstmt.setInt(4, 0); // 0.- ACTIVO 1.- INACTIVO
			pstmt.setInt(5, estudiante.getFcesConfCarreraId());
			pstmt.setInt(6,usuarioRolId );
			
			respuesta = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new TramiteTituloJdbcException(e);
		} catch (Exception e) {
			throw new TramiteTituloJdbcException(e);
		} finally {
			try {
				if(rs != null){
					rs.close();
				}
				if(pstmt != null){
					pstmt.close();
				}
				if (con != null) {
					con.cerrarConexion();
				}
				
			} catch (SQLException e) {
			}
		}
		
		if(respuesta != 0){
			retorno = true;
		}else{
			retorno = false;
			throw new TramiteTituloJdbcException("No se guardo ningun trámite título");
		}
		
		return retorno;
		
	}
	
	public Integer buscarMaximoIdXtabla(String base, String tabla) throws ConsutaGeneralJdbcException{
		Conexion con = new Conexion(base);
		Integer retorno;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			StringBuffer ssql = new StringBuffer();
			ssql.append(" SELECT MAX( ");
			ssql.append(Utilidades.extraerAbreviatura(tabla));
			ssql.append("_id");
			ssql.append(" ) as max FROM ");
			ssql.append(tabla);
			pstmt = con.getConexion().prepareStatement(ssql.toString());
			rs =  pstmt.executeQuery();
			if(rs.next()){
				retorno = rs.getInt("max");
			}else{
				retorno = null;
			}
			
		} catch (SQLException e) {
			throw new ConsutaGeneralJdbcException(e);
		} catch (Exception e) {
			throw new ConsutaGeneralJdbcException(e);
		} finally {
			try {
				if(rs != null){
					rs.close();
				}
				if(pstmt != null){
					pstmt.close();
				}
				if (con != null) {
					con.cerrarConexion();
				}
				
			} catch (SQLException e) {
			}
		}
		
		if(retorno == null){
			throw new ConsutaGeneralJdbcException("error al buscar el maximo de la tabla(no se encontro respuesta)");
		}
		return retorno;
	}
	
	
	public Integer buscarRoFlCrXcarrera(int carreraId, int rolId, String base) throws RolFlujoCarreraJdbcException{
		Conexion con = new Conexion(base);
		Integer retorno;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			StringBuffer ssql = new StringBuffer();
			ssql.append(" SELECT roflcr.roflcr_id as roflcrId");
			ssql.append(" FROM rol_flujo_carrera roflcr, usuario_rol usro, rol rol, carrera crr");
			ssql.append(" WHERE roflcr.usro_id = usro.usro_id");
			ssql.append(" AND usro.rol_id = rol.rol_id");
			ssql.append(" AND roflcr.crr_id = crr.crr_id");
			ssql.append(" AND crr.crr_id = ?");
			ssql.append(" AND usro.rol_id = ?");
			ssql.append(" LIMIT 1");
			pstmt = con.getConexion().prepareStatement(ssql.toString());
			pstmt.setInt(1, carreraId);
			pstmt.setInt(2, rolId); 
			rs =  pstmt.executeQuery();
			if(rs.next()){
				retorno = rs.getInt("roflcrId");
			}else{
				retorno = null;
			}
			
		} catch (SQLException e) {
			throw new RolFlujoCarreraJdbcException(e);
		} catch (Exception e) {
			throw new RolFlujoCarreraJdbcException(e);
		} finally {
			try {
				if(rs != null){
					rs.close();
				}
				if(pstmt != null){
					pstmt.close();
				}
				if (con != null) {
					con.cerrarConexion();
				}
				
			} catch (SQLException e) {
			}
		}
		
		if(retorno == null){
			throw new RolFlujoCarreraJdbcException("no se encontró ningun rol flujo carrera para la carrera buscada");
		}
		return retorno;
	}
	
	public Boolean buscarPersonaXid(String base, String idPersonaIdentificacion) throws PersonaJdbcException{
		Conexion con = new Conexion(base);
		Boolean retorno;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			StringBuffer ssql = new StringBuffer();
			ssql.append(" SELECT prs.prs_identificacion as id FROM persona prs WHERE prs.prs_identificacion = ?");
			pstmt = con.getConexion().prepareStatement(ssql.toString());
			pstmt.setString(1, idPersonaIdentificacion);
			rs =  pstmt.executeQuery();
			
			if(rs.next()){
				if(rs.getString("id").equals(idPersonaIdentificacion)){
					retorno =  true;
				}else{
					retorno = false;
				}
			}else{
				retorno = null;
			}
			
			
			
			
		} catch (SQLException e) {
			throw new PersonaJdbcException(e);
		} catch (Exception e) {
//			retorno = false;
			throw new PersonaJdbcException(e);
		} finally {
			try {
				if(rs != null){
					rs.close();
				}
				if(pstmt != null){
					pstmt.close();
				}
				if (con != null) {
					con.cerrarConexion();
				}
				
			} catch (SQLException e) {
			}
		}
		
		if(retorno != null){
//			retorno =  true;
		}else{
			retorno = false;
//			throw new ConsutaGeneralJdbcException("no se encontró ningun rol flujo carrera para la carrera buscada");
		}
		return retorno;
	}
	
	
	public Boolean insertarProcesosTramites(String base, int roflcrSecretaria, int roflcrAbogado, int trttId) throws ProcesosTramitesJdbcException, ConsutaGeneralJdbcException{
		Conexion con = new Conexion(base);
		Boolean retorno;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int maxTabla = buscarMaximoIdXtabla(base, "proceso_tramite");
		int tipoProceso = 0;
		int respuesta = 0;
		try {
			StringBuffer ssql = new StringBuffer();
			int aux = 0;
			for(int i = 0; i < 3; i++){
				ssql.append(" INSERT INTO proceso_tramite (prtr_id, prtr_tipo_proceso, prtr_fecha_ejecucion, roflcr_id,trtt_id) VALUES(?,?,?,?,?);");
			}
			pstmt = con.getConexion().prepareStatement(ssql.toString());
			for(int i = 0; i < 3; i++){
				pstmt.setInt(++aux, ++maxTabla);
				pstmt.setInt(++aux, tipoProceso++); 
				pstmt.setTimestamp(++aux, new Timestamp(new Date().getTime()));
				if(i==2){
					pstmt.setInt(++aux, roflcrAbogado);
				}else{
					pstmt.setInt(++aux, roflcrSecretaria);
				}
				pstmt.setInt(++aux,trttId);
				
//				numRegistrosInsertados++;
			}
			
			respuesta = pstmt.executeUpdate();
	
			
		} catch (SQLException e) {
			throw new ProcesosTramitesJdbcException(e);
		} catch (Exception e) {
			throw new ProcesosTramitesJdbcException(e);
		} finally {
			try {
				if(rs != null){
					rs.close();
				}
				if(pstmt != null){
					pstmt.close();
				}
				if (con != null) {
					con.cerrarConexion();
				}
				
			} catch (SQLException e) {
			}
		}
		
		if(respuesta != 0){
			retorno = true;
		}else{
			retorno = false;
			throw new ProcesosTramitesJdbcException("Error al guardar");
		}
		
		return retorno;
		
	}
	
	public Boolean insertarProcesoTramite(String base, int roflcrSecretaria, int trttId) throws ProcesosTramitesJdbcException, ConsutaGeneralJdbcException{
		Conexion con = new Conexion(base);
		Boolean retorno;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int maxTabla = buscarMaximoIdXtabla(base, "proceso_tramite");
		int tipoProceso = 0;
		int respuesta = 0;
		try {
			StringBuffer ssql = new StringBuffer();
			ssql.append(" INSERT INTO proceso_tramite (prtr_id, prtr_tipo_proceso, prtr_fecha_ejecucion, roflcr_id,trtt_id) VALUES(?,?,?,?,?);");
			pstmt = con.getConexion().prepareStatement(ssql.toString());
			pstmt.setInt(1, ++maxTabla);
			pstmt.setInt(2, tipoProceso++); 
			pstmt.setTimestamp(3, new Timestamp(new Date().getTime()));
			pstmt.setInt(4, roflcrSecretaria);
			pstmt.setInt(5,trttId);
			respuesta = pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new ProcesosTramitesJdbcException(e);
		} catch (Exception e) {
			throw new ProcesosTramitesJdbcException(e);
		} finally {
			try {
				if(rs != null){
					rs.close();
				}
				if(pstmt != null){
					pstmt.close();
				}
				if (con != null) {
					con.cerrarConexion();
				}
				
			} catch (SQLException e) {
			}
		}
		
		if(respuesta != 0){
			retorno = true;
		}else{
			retorno = false;
			throw new ProcesosTramitesJdbcException("Error al guardar");
		}
		
		return retorno;
		
	}
	
	public Boolean insertarPersonaYfichaEstudiante(String base, EstudianteTitulacionJdbcDto estudiante, int trttId) throws PersonaFichaEstudianteJdbcException, ConsutaGeneralJdbcException{
		Conexion con = new Conexion(base);
		Boolean retorno;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int maxTablaPersona = buscarMaximoIdXtabla(base, "persona");
		int maxTablaFichaEstudiante = buscarMaximoIdXtabla(base, "ficha_estudiante");
		int respuesta;
		try {
			StringBuffer ssql = new StringBuffer();
			if(estudiante.getFcesRecEstuPrevios() == 1){
				if(estudiante.getFcesLinkTesis().isEmpty()){
					ssql.append(" INSERT INTO persona VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?);");
					ssql.append(" INSERT INTO ficha_estudiante ");
					ssql.append(" (fces_id, fces_fecha_inicio, fces_fecha_egresamiento, fces_fecha_acta_grado,fces_num_acta_grado "); //////
					ssql.append(" ,fces_tipo_colegio, fces_tipo_colegio_sniese, fces_titulo_bachiller, fces_nota_prom_acumulado,fces_nota_trab_titulacion "); //
					ssql.append(" , fces_rec_estud_previos, fces_rec_estud_prev_sniese, fces_fecha_creacion "); //
					ssql.append(" ,ubc_pais_nacimiento, ubc_canton_residencia, etn_id,mctt_id "); //
					ssql.append(" , prs_id, trtt_id, cncr_id ) ");
					ssql.append(" VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
					
						pstmt = con.getConexion().prepareStatement(ssql.toString());
						pstmt.setInt(1, ++maxTablaPersona);
						pstmt.setInt(2, estudiante.getPrsTipoIdentificacion()); 
						pstmt.setInt(3, estudiante.getPrsTipoIdentificacionSniese());
						pstmt.setString(4, estudiante.getPrsIdentificacion());
						pstmt.setString(5, estudiante.getPrsPrimerApellido());
						pstmt.setString(6, estudiante.getPrsSegundoApellido());
						pstmt.setString(7, estudiante.getPrsNombres());
						pstmt.setInt(8, estudiante.getPrsSexo());
						pstmt.setInt(9, estudiante.getPrsSexoSniese());
						pstmt.setString(10, estudiante.getPrsMailPersonal());
						pstmt.setString(11, estudiante.getPrsMailInstitucional());
						pstmt.setString(12, estudiante.getPrsTelefono());
						pstmt.setDate(13, estudiante.getPrsFechaNacimiento());

						pstmt.setInt(14, ++maxTablaFichaEstudiante);
						pstmt.setDate(15, estudiante.getFcesFechaInicio()); 
						pstmt.setDate(16, estudiante.getFcesFechaEgresamiento());
						pstmt.setDate(17, estudiante.getFcesFechaActaGrado());
						pstmt.setString(18, estudiante.getFcesNumActaGrado());
						
						pstmt.setInt(19, estudiante.getFcesTipoColegio());
						pstmt.setString(20, estudiante.getFcesTipoColegioSniese());
						pstmt.setString(21, estudiante.getFcesTituloBachiller());
						pstmt.setBigDecimal(22, estudiante.getFcesNotaPromAcumulado());
						pstmt.setBigDecimal(23, estudiante.getFcesNotaTrabTitulacion());
						
						pstmt.setInt(24, estudiante.getFcesRecEstuPrevios());
						pstmt.setString(25, estudiante.getFcesRecEstuPreviosSniese());
						pstmt.setTimestamp(26, estudiante.getFcesFechaCreacion());
						
						pstmt.setInt(27, estudiante.getPrsUbicacionId());
						pstmt.setInt(28, estudiante.getFcesCantonResidenciaId());
						pstmt.setInt(29, estudiante.getPrsEtniaId());
						pstmt.setInt(30, estudiante.getFcesMecanismoTitulacionId());
						
						pstmt.setInt(31, maxTablaPersona);
						pstmt.setInt(32, trttId);
						pstmt.setInt(33, estudiante.getFcesConfCarreraId());
						respuesta = pstmt.executeUpdate();
				}else{
					ssql.append(" INSERT INTO persona VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?);");
					ssql.append(" INSERT INTO ficha_estudiante ");
					ssql.append(" (fces_id, fces_fecha_inicio, fces_fecha_egresamiento, fces_fecha_acta_grado,fces_num_acta_grado "); //////
					ssql.append(" ,fces_tipo_colegio, fces_tipo_colegio_sniese, fces_titulo_bachiller, fces_nota_prom_acumulado,fces_nota_trab_titulacion "); //
					ssql.append(" ,fces_link_tesis, fces_rec_estud_previos, fces_rec_estud_prev_sniese, fces_fecha_creacion "); //
					ssql.append(" ,ubc_pais_nacimiento, ubc_canton_residencia, etn_id,mctt_id "); //
					ssql.append(" , prs_id, trtt_id, cncr_id ) ");
					ssql.append(" VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
					
						pstmt = con.getConexion().prepareStatement(ssql.toString());
						pstmt.setInt(1, ++maxTablaPersona);
						pstmt.setInt(2, estudiante.getPrsTipoIdentificacion()); 
						pstmt.setInt(3, estudiante.getPrsTipoIdentificacionSniese());
						pstmt.setString(4, estudiante.getPrsIdentificacion());
						pstmt.setString(5, estudiante.getPrsPrimerApellido());
						pstmt.setString(6, estudiante.getPrsSegundoApellido());
						pstmt.setString(7, estudiante.getPrsNombres());
						pstmt.setInt(8, estudiante.getPrsSexo());
						pstmt.setInt(9, estudiante.getPrsSexoSniese());
						pstmt.setString(10, estudiante.getPrsMailPersonal());
						pstmt.setString(11, estudiante.getPrsMailInstitucional());
						pstmt.setString(12, estudiante.getPrsTelefono());
						pstmt.setDate(13, estudiante.getPrsFechaNacimiento());

						pstmt.setInt(14, ++maxTablaFichaEstudiante);
						pstmt.setDate(15, estudiante.getFcesFechaInicio()); 
						pstmt.setDate(16, estudiante.getFcesFechaEgresamiento());
						pstmt.setDate(17, estudiante.getFcesFechaActaGrado());
						pstmt.setString(18, estudiante.getFcesNumActaGrado());
						
						pstmt.setInt(19, estudiante.getFcesTipoColegio());
						pstmt.setString(20, estudiante.getFcesTipoColegioSniese());
						pstmt.setString(21, estudiante.getFcesTituloBachiller());
						pstmt.setBigDecimal(22, estudiante.getFcesNotaPromAcumulado());
						pstmt.setBigDecimal(23, estudiante.getFcesNotaTrabTitulacion());
						
						pstmt.setString(24, estudiante.getFcesLinkTesis());
						pstmt.setInt(25, estudiante.getFcesRecEstuPrevios());
						pstmt.setString(26, estudiante.getFcesRecEstuPreviosSniese());
						pstmt.setTimestamp(27, estudiante.getFcesFechaCreacion());
						
						pstmt.setInt(28, estudiante.getPrsUbicacionId());
						pstmt.setInt(29, estudiante.getFcesCantonResidenciaId());
						pstmt.setInt(30, estudiante.getPrsEtniaId());
						pstmt.setInt(31, estudiante.getFcesMecanismoTitulacionId());
						
						pstmt.setInt(32, maxTablaPersona);
						pstmt.setInt(33, trttId);
						pstmt.setInt(34, estudiante.getFcesConfCarreraId());
						respuesta = pstmt.executeUpdate();
				}
				
			}else{
				if(estudiante.getFcesLinkTesis().isEmpty()){
					ssql.append(" INSERT INTO persona VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?);");
					ssql.append(" INSERT INTO ficha_estudiante ");
					ssql.append(" (fces_id, fces_fecha_inicio, fces_fecha_egresamiento, fces_fecha_acta_grado,fces_num_acta_grado "); //////
					ssql.append(" ,fces_crr_estud_previos, fces_tiempo_estud_rec,fces_tipo_durac_rec ");//
					ssql.append(" ,fces_tipo_colegio, fces_tipo_colegio_sniese, fces_titulo_bachiller, fces_nota_prom_acumulado,fces_nota_trab_titulacion "); //
					ssql.append(" , fces_rec_estud_previos, fces_rec_estud_prev_sniese, fces_fecha_creacion "); //
					ssql.append(" ,ubc_pais_nacimiento, ubc_canton_residencia, etn_id,mctt_id "); //
					ssql.append(" ,inac_id_inst_est_previos, prs_id, trtt_id, cncr_id ) ");
					ssql.append(" VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
					
						pstmt = con.getConexion().prepareStatement(ssql.toString());
						pstmt.setInt(1, ++maxTablaPersona);
						pstmt.setInt(2, estudiante.getPrsTipoIdentificacion()); 
						pstmt.setInt(3, estudiante.getPrsTipoIdentificacionSniese());
						pstmt.setString(4, estudiante.getPrsIdentificacion());
						pstmt.setString(5, estudiante.getPrsPrimerApellido());
						pstmt.setString(6, estudiante.getPrsSegundoApellido());
						pstmt.setString(7, estudiante.getPrsNombres());
						pstmt.setInt(8, estudiante.getPrsSexo());
						pstmt.setInt(9, estudiante.getPrsSexoSniese());
						pstmt.setString(10, estudiante.getPrsMailPersonal());
						pstmt.setString(11, estudiante.getPrsMailInstitucional());
						pstmt.setString(12, estudiante.getPrsTelefono());
						pstmt.setDate(13, estudiante.getPrsFechaNacimiento());

						pstmt.setInt(14, ++maxTablaFichaEstudiante);
						pstmt.setDate(15, estudiante.getFcesFechaInicio()); 
						pstmt.setDate(16, estudiante.getFcesFechaEgresamiento());
						pstmt.setDate(17, estudiante.getFcesFechaActaGrado());
						pstmt.setString(18, estudiante.getFcesNumActaGrado());
						
						pstmt.setString(19, estudiante.getFcesCrrEstudPrevios());
						pstmt.setInt(20, estudiante.getFcesTiempoEstudRec());
						pstmt.setInt(21, estudiante.getFcesTipoDuracionRec());
						
						pstmt.setInt(22, estudiante.getFcesTipoColegio());
						pstmt.setString(23, estudiante.getFcesTipoColegioSniese());
						pstmt.setString(24, estudiante.getFcesTituloBachiller());
						pstmt.setBigDecimal(25, estudiante.getFcesNotaPromAcumulado());
						pstmt.setBigDecimal(26, estudiante.getFcesNotaTrabTitulacion());
						
						pstmt.setInt(27, estudiante.getFcesRecEstuPrevios());
						pstmt.setString(28, estudiante.getFcesRecEstuPreviosSniese());
						pstmt.setTimestamp(29, estudiante.getFcesFechaCreacion());
						
						pstmt.setInt(30, estudiante.getPrsUbicacionId());
						pstmt.setInt(31, estudiante.getFcesCantonResidenciaId());
						pstmt.setInt(32, estudiante.getPrsEtniaId());
						pstmt.setInt(33, estudiante.getFcesMecanismoTitulacionId());
						
						pstmt.setInt(34, estudiante.getFcesInacInstEstPreviosId());
						pstmt.setInt(35, maxTablaPersona);
						pstmt.setInt(36, trttId);
						pstmt.setInt(37, estudiante.getFcesConfCarreraId());
						respuesta = pstmt.executeUpdate();
				}else{
					ssql.append(" INSERT INTO persona VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?);");
					ssql.append(" INSERT INTO ficha_estudiante ");
					ssql.append(" (fces_id, fces_fecha_inicio, fces_fecha_egresamiento, fces_fecha_acta_grado,fces_num_acta_grado "); //////
					ssql.append(" ,fces_crr_estud_previos, fces_tiempo_estud_rec,fces_tipo_durac_rec ");//
					ssql.append(" ,fces_tipo_colegio, fces_tipo_colegio_sniese, fces_titulo_bachiller, fces_nota_prom_acumulado,fces_nota_trab_titulacion "); //
					ssql.append(" ,fces_link_tesis, fces_rec_estud_previos, fces_rec_estud_prev_sniese, fces_fecha_creacion "); //
					ssql.append(" ,ubc_pais_nacimiento, ubc_canton_residencia, etn_id,mctt_id "); //
					ssql.append(" ,inac_id_inst_est_previos, prs_id, trtt_id, cncr_id ) ");
					ssql.append(" VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
					
						pstmt = con.getConexion().prepareStatement(ssql.toString());
						pstmt.setInt(1, ++maxTablaPersona);
						pstmt.setInt(2, estudiante.getPrsTipoIdentificacion()); 
						pstmt.setInt(3, estudiante.getPrsTipoIdentificacionSniese());
						pstmt.setString(4, estudiante.getPrsIdentificacion());
						pstmt.setString(5, estudiante.getPrsPrimerApellido());
						pstmt.setString(6, estudiante.getPrsSegundoApellido());
						pstmt.setString(7, estudiante.getPrsNombres());
						pstmt.setInt(8, estudiante.getPrsSexo());
						pstmt.setInt(9, estudiante.getPrsSexoSniese());
						pstmt.setString(10, estudiante.getPrsMailPersonal());
						pstmt.setString(11, estudiante.getPrsMailInstitucional());
						pstmt.setString(12, estudiante.getPrsTelefono());
						pstmt.setDate(13, estudiante.getPrsFechaNacimiento());

						pstmt.setInt(14, ++maxTablaFichaEstudiante);
						pstmt.setDate(15, estudiante.getFcesFechaInicio()); 
						pstmt.setDate(16, estudiante.getFcesFechaEgresamiento());
						pstmt.setDate(17, estudiante.getFcesFechaActaGrado());
						pstmt.setString(18, estudiante.getFcesNumActaGrado());
						
						pstmt.setString(19, estudiante.getFcesCrrEstudPrevios());
						pstmt.setInt(20, estudiante.getFcesTiempoEstudRec());
						pstmt.setInt(21, estudiante.getFcesTipoDuracionRec());
						
						pstmt.setInt(22, estudiante.getFcesTipoColegio());
						pstmt.setString(23, estudiante.getFcesTipoColegioSniese());
						pstmt.setString(24, estudiante.getFcesTituloBachiller());
						pstmt.setBigDecimal(25, estudiante.getFcesNotaPromAcumulado());
						pstmt.setBigDecimal(26, estudiante.getFcesNotaTrabTitulacion());
						
						pstmt.setString(27, estudiante.getFcesLinkTesis());
						pstmt.setInt(28, estudiante.getFcesRecEstuPrevios());
						pstmt.setString(29, estudiante.getFcesRecEstuPreviosSniese());
						pstmt.setTimestamp(30, estudiante.getFcesFechaCreacion());
						
						pstmt.setInt(31, estudiante.getPrsUbicacionId());
						pstmt.setInt(32, estudiante.getFcesCantonResidenciaId());
						pstmt.setInt(33, estudiante.getPrsEtniaId());
						pstmt.setInt(34, estudiante.getFcesMecanismoTitulacionId());
						
						pstmt.setInt(35, estudiante.getFcesInacInstEstPreviosId());
						pstmt.setInt(36, maxTablaPersona);
						pstmt.setInt(37, trttId);
						pstmt.setInt(38, estudiante.getFcesConfCarreraId());
						respuesta = pstmt.executeUpdate();
				}
				
			}
			
			
				
//			}
			
		} catch (SQLException e) {
			throw new PersonaFichaEstudianteJdbcException(e);
		} catch (Exception e) {
			throw new PersonaFichaEstudianteJdbcException(e);
		} finally {
			try {
				if(rs != null){
					rs.close();
				}
				if(pstmt != null){
					pstmt.close();
				}
				if (con != null) {
					con.cerrarConexion();
				}
				
			} catch (SQLException e) {
			}
		}
		
		if(respuesta != 0){
			retorno = true;
		}else{
			retorno = false;
			throw new PersonaFichaEstudianteJdbcException("Error al guardar los estudiantes");
		}
		
		return retorno;
		
	}
	
	public int actualizarTramiteTitulo(String base, List<EstudianteTitulacionJdbcDto> estudiantesMigrados) throws TramiteTituloJdbcException{
		Conexion con = new Conexion(base);
		int respuesta;
//		Boolean retorno;
		int retorno = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			StringBuffer ssql = new StringBuffer();
			
			for (EstudianteTitulacionJdbcDto itemEstud : estudiantesMigrados) {
				if(itemEstud.getTrttEstadoProceso().equals(108)){
					ssql.append(" UPDATE tramite_titulo SET trtt_estado_proceso = 110 WHERE trtt_estado_proceso = 108 AND trtt_id = ?; \n");
				}
				if(itemEstud.getTrttEstadoProceso().equals(109)){
					ssql.append(" UPDATE tramite_titulo SET trtt_estado_proceso = 111 WHERE trtt_estado_proceso = 109 AND trtt_id = ?; \n");
				}
				
			}
			pstmt = con.getConexion().prepareStatement(ssql.toString());
			int contador = 0;
			for (EstudianteTitulacionJdbcDto itemEstud : estudiantesMigrados) {
				pstmt.setInt(++contador, itemEstud.getTrttId());	
			}
			respuesta = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new TramiteTituloJdbcException(e);
		} catch (Exception e) {
			throw new TramiteTituloJdbcException(e);
		} finally {
			try {
				if(rs != null){
					rs.close();
				}
				if(pstmt != null){
					pstmt.close();
				}
				if (con != null) {
					con.cerrarConexion();
				}
				
			} catch (SQLException e) {
			}
		}
		
		if(respuesta != 0){
//			retorno = true;
			retorno = respuesta;
		}else{
//			retorno = false;
			throw new TramiteTituloJdbcException("No se actualizó nada");
		}
		
//		return respuesta;
		return retorno;
		
	}
	
	
	
	public void ejecutarSelects(String base) throws TramiteTituloJdbcException{
		List<String> querys = new ArrayList<String>();
		querys.add(" SELECT setval('persona_prs_id_seq', max(prs_id)) FROM persona;");
		querys.add(" SELECT setval('ficha_estudiante_fces_id_seq', max(fces_id)) FROM ficha_estudiante;");
		querys.add(" SELECT setval('tramite_titulo_trtt_id_seq', max(trtt_id)) FROM tramite_titulo;");
		querys.add(" SELECT setval('proceso_tramite_prtr_id_seq', max(prtr_id)) FROM proceso_tramite;");
		
		Conexion con = new Conexion(base);
//		int respuesta;
//		int retorno;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			for (String item : querys) {
				pstmt = con.getConexion().prepareStatement(item);
				pstmt.executeQuery();
				System.out.print(".");
			}
			
		} catch (SQLException e) {
			throw new TramiteTituloJdbcException(e);
		} catch (Exception e) {
			throw new TramiteTituloJdbcException(e);
		} finally {
			try {
				if(rs != null){
					rs.close();
				}
				if(pstmt != null){
					pstmt.close();
				}
				if (con != null) {
					con.cerrarConexion();
				}
				
			} catch (SQLException e) {
			}
		}
		
//		if(respuesta == 0){
//			throw new TramiteTituloJdbcException("No se actualizó nada");
//		}else{
//			retorno = respuesta;
//		}
//		return retorno;
	}
	
	public void ejecutarScripts(String base) throws TramiteTituloJdbcException{
		Conexion con = new Conexion(base);
		List<String> querys = new ArrayList<String>();
		querys.add(" UPDATE ficha_estudiante SET fces_titulo_bachiller=upper(norm_text_latin(norm_text_latin(norm_text_latin(fces_titulo_bachiller))));");
		querys.add(" UPDATE ficha_estudiante SET fces_crr_estud_previos=upper(norm_text_latin(norm_text_latin(norm_text_latin(fces_crr_estud_previos))));");
		querys.add(" UPDATE ficha_estudiante SET fces_observacion=upper(norm_text_latin(norm_text_latin(norm_text_latin(fces_observacion))));");
		
		StringBuilder ssql = new StringBuilder();
		ssql.append(" UPDATE ficha_estudiante");
		ssql.append(" SET fces_titulo_bachiller = fces.fces_titulo_bachiller");
		ssql.append(" FROM (SELECT fces_id , translate(fces_titulo_bachiller,'áéíóúÁÉÍÓÚäëïöüÄËÏÖÜ','aeiouAEIOUaeiouAEIOU')");
		ssql.append(" as fces_titulo_bachiller from ficha_estudiante) as fces");
		ssql.append(" WHERE ficha_estudiante.fces_id = fces.fces_id;");
		querys.add(ssql.toString());
		
		ssql = new StringBuilder();
		ssql.append(" UPDATE ficha_estudiante");
		ssql.append(" SET fces_observacion = fces.fces_observacion");
		ssql.append(" FROM (SELECT fces_id , translate(fces_observacion,'áéíóúÁÉÍÓÚäëïöüÄËÏÖÜ','aeiouAEIOUaeiouAEIOU')");
		ssql.append(" as fces_observacion from ficha_estudiante) as fces");
		ssql.append(" WHERE ficha_estudiante.fces_id = fces.fces_id;");
		querys.add(ssql.toString());
		
		ssql = new StringBuilder();
		ssql.append(" UPDATE ficha_estudiante");
		ssql.append(" SET fces_link_tesis = fces.fces_link_tesis");
		ssql.append(" FROM (SELECT fces_id , translate(fces_link_tesis,'áéíóúÁÉÍÓÚäëïöüÄËÏÖÜ','aeiouAEIOUaeiouAEIOU')");
		ssql.append(" as fces_link_tesis from ficha_estudiante) as fces");
		ssql.append(" WHERE ficha_estudiante.fces_id = fces.fces_id;");
		querys.add(ssql.toString());
		
		ssql = new StringBuilder();
		ssql.append(" UPDATE ficha_estudiante");
		ssql.append(" SET fces_observacion = fces.fces_observacion");
		ssql.append(" FROM (SELECT fces_id , translate(fces_observacion,'áéíóúÁÉÍÓÚäëïöüÄËÏÖÜ','aeiouAEIOUaeiouAEIOU')");
		ssql.append(" as fces_observacion from ficha_estudiante) as fces");
		ssql.append(" WHERE ficha_estudiante.fces_id = fces.fces_id;");
		querys.add(ssql.toString());
		
//		int respuesta;
//		int retorno;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			for (String item : querys) {
				pstmt = con.getConexion().prepareStatement(item);
				pstmt.executeUpdate();
				System.out.print(".");
			}
			
		} catch (SQLException e) {
			throw new TramiteTituloJdbcException(e);
		} catch (Exception e) {
			throw new TramiteTituloJdbcException(e);
		} finally {
			try {
				if(rs != null){
					rs.close();
				}
				if(pstmt != null){
					pstmt.close();
				}
				if (con != null) {
					con.cerrarConexion();
				}
				
			} catch (SQLException e) {
			}
		}
		
//		if(respuesta == 0){
//			throw new TramiteTituloJdbcException("No se actualizó nada");
//		}else{
//			retorno = respuesta;
//		}
//		return retorno;
	}
	
	private EstudianteTitulacionJdbcDto resultSetAdtoEstudianteTitulacion(ResultSet rs) throws SQLException {
		EstudianteTitulacionJdbcDto retorno = new EstudianteTitulacionJdbcDto();
		retorno.setFcesFechaInicio((rs.getDate("fces_fecha_inicio")));
		retorno.setFcesFechaEgresamiento((rs.getDate("fces_fecha_egresamiento")));
		retorno.setFcesFechaActaGrado((rs.getDate("fces_fecha_acta_grado")));
		retorno.setFcesNumActaGrado((rs.getString("fces_num_acta_grado")));
		retorno.setFcesCrrEstudPrevios((rs.getString("fces_crr_estud_previos")));
		retorno.setFcesTiempoEstudRec((rs.getInt("fces_tiempo_estud_rec")));
		retorno.setFcesTipoDuracionRec((rs.getInt("fces_tipo_durac_rec")));
		retorno.setFcesTipoColegio((rs.getInt("fces_tipo_colegio")));
		retorno.setFcesTipoColegioSniese((rs.getString("fces_tipo_colegio_sniese")));
		retorno.setFcesNotaPromAcumulado((rs.getBigDecimal("fces_nota_prom_acumulado")));
		retorno.setFcesNotaTrabTitulacion((rs.getBigDecimal("fces_nota_trab_titulacion")));
		if(rs.getString("fces_link_tesis") == null){
			retorno.setFcesLinkTesis(new String());
		}else{
			retorno.setFcesLinkTesis((rs.getString("fces_link_tesis")));
		}
		retorno.setFcesRecEstuPrevios((rs.getInt("fces_rec_estud_previos")));
		retorno.setFcesRecEstuPreviosSniese((rs.getString("fces_rec_estud_previos")));
		retorno.setFcesFechaCreacion(new Timestamp(new Date().getTime()));
		retorno.setFcesCantonResidenciaId((rs.getInt("ubc_canton_residencia")));
		retorno.setFcesMecanismoTitulacionId((rs.getInt("mcttcr_id")));
		
		retorno.setFcesInacInstEstPreviosId((rs.getInt("inac_id_inst_est_previos")));

		retorno.setFcesConfCarreraId((rs.getInt("cncr_id")));
		retorno.setFcesTituloBachiller((rs.getString("ttl_descripcion")));
		retorno.setPrsTipoIdentificacion((rs.getInt("prs_tipo_identificacion")));
		retorno.setPrsTipoIdentificacionSniese((rs.getInt("prs_tipo_identificacion_sniese")));
		retorno.setPrsIdentificacion((rs.getString("prs_identificacion")));
		retorno.setPrsPrimerApellido((rs.getString("prs_primer_apellido")));
		retorno.setPrsSegundoApellido((rs.getString("prs_segundo_apellido")));
		retorno.setPrsNombres((rs.getString("prs_nombres")));
		retorno.setPrsSexo((rs.getInt("prs_sexo")));
		retorno.setPrsSexoSniese((rs.getInt("prs_sexo_sniese")));
		retorno.setPrsMailPersonal((rs.getString("prs_mail_personal")));
		retorno.setPrsMailInstitucional((rs.getString("prs_mail_institucional")));
		retorno.setPrsTelefono((rs.getString("prs_telefono")));
		retorno.setPrsFechaNacimiento((rs.getDate("prs_fecha_nacimiento")));
		retorno.setPrsEtniaId((rs.getInt("etn_id")));
		retorno.setPrsUbicacionId((rs.getInt("ubc_id")));
		retorno.setFcesMecanismoTitulacionId((rs.getInt("mctt_id")));
		retorno.setCrrId((rs.getInt("crr_id")));
		retorno.setTrttId((rs.getInt("trtt_id")));
		retorno.setTrttEstadoProceso((rs.getInt("trtt_estado_proceso")));
		return retorno;
	}
	
	private CarreraDto resultSetAdtoCarrera(ResultSet rs) throws SQLException {
		CarreraDto retorno = new CarreraDto();
		retorno.setCrrId((rs.getInt("crr_id")));
		retorno.setCrrDescripcion((rs.getString("crr_descripcion")));
		retorno.setCrrCodSniese((rs.getString("crr_cod_sniese")));
		retorno.setCrrDetalle((rs.getString("crr_detalle")));
		retorno.setCrrFclId((rs.getInt("fcl_id")));
		return retorno;
	}
	
	private ConfiguracionCarreraDto resultSetAdtoConfiguracionCarreraDto(ResultSet rs) throws SQLException {
		ConfiguracionCarreraDto retorno = new ConfiguracionCarreraDto();
		retorno.setCrrId((rs.getInt("crr_id")));
		retorno.setCncrId((rs.getInt("cncr_id")));
		return retorno;
	}
	
}
