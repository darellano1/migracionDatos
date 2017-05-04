package migracionDatos.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Date;


public class EstudianteTitulacionJdbcDto implements Serializable {
	
	private static final long serialVersionUID = -657122440738721554L;
	
	//****************** FICHA ESTUDIANTE *****************************
	private Date fcesFechaInicio;
	private Date fcesFechaEgresamiento;
	private Date fcesFechaActaGrado;
	private String fcesNumActaGrado;
	private String fcesCrrEstudPrevios;
	private Integer fcesTiempoEstudRec;
	private Integer fcesTipoDuracionRec;
	private Integer fcesTipoColegio;
	private String fcesTipoColegioSniese;
	private BigDecimal fcesNotaPromAcumulado;
	private BigDecimal fcesNotaTrabTitulacion;
	private String fcesLinkTesis;
	private Integer fcesRecEstuPrevios;
	private String fcesRecEstuPreviosSniese;
	private Timestamp fcesFechaCreacion;
	private Integer fcesCantonResidenciaId;
	private Integer fcesMecanismoTitulacionId;
	private Integer fcesInacInstEstPreviosId;
	private Integer fcesConfCarreraId;
	private String fcesTituloBachiller;
	
	//****************** PERSONA *****************************
	private Integer prsTipoIdentificacion;
	private String prsTipoIdentificacionSt;
	private Integer prsTipoIdentificacionSniese;
	private String prsIdentificacion;
	private String prsPrimerApellido;
	private String prsSegundoApellido;
	private String prsNombres;
	private String prsMailPersonal;
	private String prsMailInstitucional;
	private String prsTelefono;
	private Date prsFechaNacimiento;
	private Integer prsSexo;
	private String prsSexoSt;
	private Integer prsSexoSniese;	
	private Integer prsEtniaId;
	private Integer prsUbicacionId;
	
	//****************** CONFIGURACION CARRERA*****************************
	private Integer crrId;
	
	//****************** TRAMITE TITULO *****************************
	private Integer trttEstadoProceso;
	private Integer trttId;
	
	
	public EstudianteTitulacionJdbcDto(){
	
	}

	public EstudianteTitulacionJdbcDto(Date fcesFechaInicio, Date fcesFechaEgresamiento, Date fcesFechaActaGrado,
			String fcesNumActaGrado, String fcesCrrEstudPrevios, Integer fcesTiempoEstudRec,
			Integer fcesTipoDuracionRec, Integer fcesTipoColegio, String fcesTipoColegioSniese,
			BigDecimal fcesNotaPromAcumulado, BigDecimal fcesNotaTrabTitulacion, String fcesLinkTesis,
			Integer fcesRecEstuPrevios, String fcesRecEstuPreviosSniese, Timestamp fcesFechaCreacion,
			Integer fcesCantonResidenciaId, Integer fcesMecanismoTitulacionId, Integer fcesInacInstEstPreviosId,
			Integer fcesConfCarreraId, String fcesTituloBachiller, Integer prsTipoIdentificacion,
			String prsTipoIdentificacionSt, Integer prsTipoIdentificacionSniese, String prsIdentificacion,
			String prsPrimerApellido, String prsSegundoApellido, String prsNombres, String prsMailPersonal,
			String prsMailInstitucional, String prsTelefono, Date prsFechaNacimiento, Integer prsSexo, String prsSexoSt,
			Integer prsSexoSniese, Integer prsEtniaId, Integer prsUbicacionId, Integer trttEstadoProceso, Integer crrId,Integer trttId) {
		this.fcesFechaInicio = fcesFechaInicio;
		this.fcesFechaEgresamiento = fcesFechaEgresamiento;
		this.fcesFechaActaGrado = fcesFechaActaGrado;
		this.fcesNumActaGrado = fcesNumActaGrado;
		this.fcesCrrEstudPrevios = fcesCrrEstudPrevios;
		this.fcesTiempoEstudRec = fcesTiempoEstudRec;
		this.fcesTipoDuracionRec = fcesTipoDuracionRec;
		this.fcesTipoColegio = fcesTipoColegio;
		this.fcesTipoColegioSniese = fcesTipoColegioSniese;
		this.fcesNotaPromAcumulado = fcesNotaPromAcumulado;
		this.fcesNotaTrabTitulacion = fcesNotaTrabTitulacion;
		this.fcesLinkTesis = fcesLinkTesis;
		this.fcesRecEstuPrevios = fcesRecEstuPrevios;
		this.fcesRecEstuPreviosSniese = fcesRecEstuPreviosSniese;
		this.fcesFechaCreacion = fcesFechaCreacion;
		this.fcesCantonResidenciaId = fcesCantonResidenciaId;
		this.fcesMecanismoTitulacionId = fcesMecanismoTitulacionId;
		this.fcesInacInstEstPreviosId = fcesInacInstEstPreviosId;
		this.fcesConfCarreraId = fcesConfCarreraId;
		this.fcesTituloBachiller = fcesTituloBachiller;
		this.prsTipoIdentificacion = prsTipoIdentificacion;
		this.prsTipoIdentificacionSt = prsTipoIdentificacionSt;
		this.prsTipoIdentificacionSniese = prsTipoIdentificacionSniese;
		this.prsIdentificacion = prsIdentificacion;
		this.prsPrimerApellido = prsPrimerApellido;
		this.prsSegundoApellido = prsSegundoApellido;
		this.prsNombres = prsNombres;
		this.prsMailPersonal = prsMailPersonal;
		this.prsMailInstitucional = prsMailInstitucional;
		this.prsTelefono = prsTelefono;
		this.prsFechaNacimiento = prsFechaNacimiento;
		this.prsSexo = prsSexo;
		this.prsSexoSt = prsSexoSt;
		this.prsSexoSniese = prsSexoSniese;
		this.prsEtniaId = prsEtniaId;
		this.prsUbicacionId = prsUbicacionId;
		this.trttEstadoProceso = trttEstadoProceso;
		this.crrId = crrId;
		this.trttId = trttId;
	}
	
	

	public Date getFcesFechaInicio() {
		return fcesFechaInicio;
	}

	public void setFcesFechaInicio(Date fcesFechaInicio) {
		this.fcesFechaInicio = fcesFechaInicio;
	}

	public Date getFcesFechaEgresamiento() {
		return fcesFechaEgresamiento;
	}

	public void setFcesFechaEgresamiento(Date fcesFechaEgresamiento) {
		this.fcesFechaEgresamiento = fcesFechaEgresamiento;
	}

	public Date getFcesFechaActaGrado() {
		return fcesFechaActaGrado;
	}

	public void setFcesFechaActaGrado(Date fcesFechaActaGrado) {
		this.fcesFechaActaGrado = fcesFechaActaGrado;
	}

	public String getFcesNumActaGrado() {
		return fcesNumActaGrado;
	}

	public void setFcesNumActaGrado(String fcesNumActaGrado) {
		this.fcesNumActaGrado = fcesNumActaGrado;
	}

	public String getFcesCrrEstudPrevios() {
		return fcesCrrEstudPrevios;
	}

	public void setFcesCrrEstudPrevios(String fcesCrrEstudPrevios) {
		this.fcesCrrEstudPrevios = fcesCrrEstudPrevios;
	}

	public Integer getFcesTiempoEstudRec() {
		return fcesTiempoEstudRec;
	}

	public void setFcesTiempoEstudRec(Integer fcesTiempoEstudRec) {
		this.fcesTiempoEstudRec = fcesTiempoEstudRec;
	}

	public Integer getFcesTipoDuracionRec() {
		return fcesTipoDuracionRec;
	}

	public void setFcesTipoDuracionRec(Integer fcesTipoDuracionRec) {
		this.fcesTipoDuracionRec = fcesTipoDuracionRec;
	}

	public Integer getFcesTipoColegio() {
		return fcesTipoColegio;
	}

	public void setFcesTipoColegio(Integer fcesTipoColegio) {
		this.fcesTipoColegio = fcesTipoColegio;
	}

	public String getFcesTipoColegioSniese() {
		return fcesTipoColegioSniese;
	}

	public void setFcesTipoColegioSniese(String fcesTipoColegioSniese) {
		this.fcesTipoColegioSniese = fcesTipoColegioSniese;
	}

	public BigDecimal getFcesNotaPromAcumulado() {
		return fcesNotaPromAcumulado;
	}

	public void setFcesNotaPromAcumulado(BigDecimal fcesNotaPromAcumulado) {
		this.fcesNotaPromAcumulado = fcesNotaPromAcumulado;
	}

	public BigDecimal getFcesNotaTrabTitulacion() {
		return fcesNotaTrabTitulacion;
	}

	public void setFcesNotaTrabTitulacion(BigDecimal fcesNotaTrabTitulacion) {
		this.fcesNotaTrabTitulacion = fcesNotaTrabTitulacion;
	}

	public String getFcesLinkTesis() {
		return fcesLinkTesis;
	}

	public void setFcesLinkTesis(String fcesLinkTesis) {
		this.fcesLinkTesis = fcesLinkTesis;
	}

	public Integer getFcesRecEstuPrevios() {
		return fcesRecEstuPrevios;
	}

	public void setFcesRecEstuPrevios(Integer fcesRecEstuPrevios) {
		this.fcesRecEstuPrevios = fcesRecEstuPrevios;
	}

	public String getFcesRecEstuPreviosSniese() {
		return fcesRecEstuPreviosSniese;
	}

	public void setFcesRecEstuPreviosSniese(String fcesRecEstuPreviosSniese) {
		this.fcesRecEstuPreviosSniese = fcesRecEstuPreviosSniese;
	}

	public Timestamp getFcesFechaCreacion() {
		return fcesFechaCreacion;
	}

	public void setFcesFechaCreacion(Timestamp fcesFechaCreacion) {
		this.fcesFechaCreacion = fcesFechaCreacion;
	}

	public Integer getFcesCantonResidenciaId() {
		return fcesCantonResidenciaId;
	}

	public void setFcesCantonResidenciaId(Integer fcesCantonResidenciaId) {
		this.fcesCantonResidenciaId = fcesCantonResidenciaId;
	}

	public Integer getFcesMecanismoTitulacionId() {
		return fcesMecanismoTitulacionId;
	}

	public void setFcesMecanismoTitulacionId(Integer fcesMecanismoTitulacionId) {
		this.fcesMecanismoTitulacionId = fcesMecanismoTitulacionId;
	}

	public Integer getFcesInacInstEstPreviosId() {
		return fcesInacInstEstPreviosId;
	}

	public void setFcesInacInstEstPreviosId(Integer fcesInacInstEstPreviosId) {
		this.fcesInacInstEstPreviosId = fcesInacInstEstPreviosId;
	}

	public Integer getFcesConfCarreraId() {
		return fcesConfCarreraId;
	}

	public void setFcesConfCarreraId(Integer fcesConfCarreraId) {
		this.fcesConfCarreraId = fcesConfCarreraId;
	}

	public String getFcesTituloBachiller() {
		return fcesTituloBachiller;
	}

	public void setFcesTituloBachiller(String fcesTituloBachiller) {
		this.fcesTituloBachiller = fcesTituloBachiller;
	}

	public Integer getPrsTipoIdentificacion() {
		return prsTipoIdentificacion;
	}

	public void setPrsTipoIdentificacion(Integer prsTipoIdentificacion) {
		this.prsTipoIdentificacion = prsTipoIdentificacion;
	}

	public String getPrsTipoIdentificacionSt() {
		return prsTipoIdentificacionSt;
	}

	public void setPrsTipoIdentificacionSt(String prsTipoIdentificacionSt) {
		this.prsTipoIdentificacionSt = prsTipoIdentificacionSt;
	}

	public Integer getPrsTipoIdentificacionSniese() {
		return prsTipoIdentificacionSniese;
	}

	public void setPrsTipoIdentificacionSniese(Integer prsTipoIdentificacionSniese) {
		this.prsTipoIdentificacionSniese = prsTipoIdentificacionSniese;
	}

	public String getPrsIdentificacion() {
		return prsIdentificacion;
	}

	public void setPrsIdentificacion(String prsIdentificacion) {
		this.prsIdentificacion = prsIdentificacion;
	}

	public String getPrsPrimerApellido() {
		return prsPrimerApellido;
	}

	public void setPrsPrimerApellido(String prsPrimerApellido) {
		this.prsPrimerApellido = prsPrimerApellido;
	}

	public String getPrsSegundoApellido() {
		return prsSegundoApellido;
	}

	public void setPrsSegundoApellido(String prsSegundoApellido) {
		this.prsSegundoApellido = prsSegundoApellido;
	}

	public String getPrsNombres() {
		return prsNombres;
	}

	public void setPrsNombres(String prsNombres) {
		this.prsNombres = prsNombres;
	}

	public String getPrsMailPersonal() {
		return prsMailPersonal;
	}

	public void setPrsMailPersonal(String prsMailPersonal) {
		this.prsMailPersonal = prsMailPersonal;
	}

	public String getPrsMailInstitucional() {
		return prsMailInstitucional;
	}

	public void setPrsMailInstitucional(String prsMailInstitucional) {
		this.prsMailInstitucional = prsMailInstitucional;
	}

	public String getPrsTelefono() {
		return prsTelefono;
	}

	public void setPrsTelefono(String prsTelefono) {
		this.prsTelefono = prsTelefono;
	}

	public Date getPrsFechaNacimiento() {
		return prsFechaNacimiento;
	}

	public void setPrsFechaNacimiento(Date prsFechaNacimiento) {
		this.prsFechaNacimiento = prsFechaNacimiento;
	}

	public Integer getPrsSexo() {
		return prsSexo;
	}

	public void setPrsSexo(Integer prsSexo) {
		this.prsSexo = prsSexo;
	}

	public String getPrsSexoSt() {
		return prsSexoSt;
	}

	public void setPrsSexoSt(String prsSexoSt) {
		this.prsSexoSt = prsSexoSt;
	}

	public Integer getPrsSexoSniese() {
		return prsSexoSniese;
	}

	public void setPrsSexoSniese(Integer prsSexoSniese) {
		this.prsSexoSniese = prsSexoSniese;
	}

	public Integer getPrsEtniaId() {
		return prsEtniaId;
	}

	public void setPrsEtniaId(Integer prsEtniaId) {
		this.prsEtniaId = prsEtniaId;
	}

	public Integer getPrsUbicacionId() {
		return prsUbicacionId;
	}

	public void setPrsUbicacionId(Integer prsUbicacionId) {
		this.prsUbicacionId = prsUbicacionId;
	}

	public Integer getTrttEstadoProceso() {
		return trttEstadoProceso;
	}

	public void setTrttEstadoProceso(Integer trttEstadoProceso) {
		this.trttEstadoProceso = trttEstadoProceso;
	}

	public Integer getCrrId() {
		return crrId;
	}

	public void setCrrId(Integer crrId) {
		this.crrId = crrId;
	}

	public Integer getTrttId() {
		return trttId;
	}

	public void setTrttId(Integer trttId) {
		this.trttId = trttId;
	}
	
}
