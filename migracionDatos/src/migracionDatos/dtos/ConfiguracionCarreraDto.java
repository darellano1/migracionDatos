package migracionDatos.dtos;

import java.io.Serializable;

public class ConfiguracionCarreraDto implements Serializable {
	
	private static final long serialVersionUID = -7819704526393256290L;

	/*******************************************************/
	/********* Declaración de variables para el DTO ********/
	/*******************************************************/
	private int cncrId;
	private int crrId;
	private String crrDescripcion;
	private String crrDetalle;
	private int vgnId;
	private String vgnDescripcion;
	private int mdlId;
	private String mdlDescripcion;
	private int ttlId;
	private String ttlDescripcion;
	private int ttlSexo;
	private String ttlSexoSt;
	private int ubcId;
	private String ubcDescripcion;
	private int tiseId;
	private String tiseDescripcion;
	private int tifrId;
	private String tifrDescripcion;
	private int rgacId;
	private String rgacDescripcion;
	private int nvfrId;
	private String nvfrDescripcion;
	private int drcId;
	private int drcTipo;
	private String drcTipoSt;
	private int drcTiempo;
	
	/*******************************************************/
	/***************** Métodos Geters y Seters**************/
	/*******************************************************/
	public int getCncrId() {
		return cncrId;
	}
	public void setCncrId(int cncrId) {
		this.cncrId = cncrId;
	}
	public int getCrrId() {
		return crrId;
	}
	public void setCrrId(int crrId) {
		this.crrId = crrId;
	}
	public String getCrrDescripcion() {
		return crrDescripcion;
	}
	public void setCrrDescripcion(String crrDescripcion) {
		this.crrDescripcion = crrDescripcion;
	}
	public String getCrrDetalle() {
		return crrDetalle;
	}
	public void setCrrDetalle(String crrDetalle) {
		this.crrDetalle = crrDetalle;
	}
	public int getVgnId() {
		return vgnId;
	}
	public void setVgnId(int vgnId) {
		this.vgnId = vgnId;
	}
	public String getVgnDescripcion() {
		return vgnDescripcion;
	}
	public void setVgnDescripcion(String vgnDescripcion) {
		this.vgnDescripcion = vgnDescripcion;
	}
	public int getMdlId() {
		return mdlId;
	}
	public void setMdlId(int mdlId) {
		this.mdlId = mdlId;
	}
	public String getMdlDescripcion() {
		return mdlDescripcion;
	}
	public void setMdlDescripcion(String mdlDescripcion) {
		this.mdlDescripcion = mdlDescripcion;
	}
	public int getTtlId() {
		return ttlId;
	}
	public void setTtlId(int ttlId) {
		this.ttlId = ttlId;
	}
	public String getTtlDescripcion() {
		return ttlDescripcion;
	}
	public void setTtlDescripcion(String ttlDescripcion) {
		this.ttlDescripcion = ttlDescripcion;
	}
	public int getTtlSexo() {
		return ttlSexo;
	}
	public void setTtlSexo(int ttlSexo) {
		this.ttlSexo = ttlSexo;
	}
	public String getTtlSexoSt() {
		return ttlSexoSt;
	}
	public void setTtlSexoSt(String ttlSexoSt) {
		this.ttlSexoSt = ttlSexoSt;
	}
	public int getUbcId() {
		return ubcId;
	}
	public void setUbcId(int ubcId) {
		this.ubcId = ubcId;
	}
	public String getUbcDescripcion() {
		return ubcDescripcion;
	}
	public void setUbcDescripcion(String ubcDescripcion) {
		this.ubcDescripcion = ubcDescripcion;
	}
	public int getTiseId() {
		return tiseId;
	}
	public void setTiseId(int tiseId) {
		this.tiseId = tiseId;
	}
	public String getTiseDescripcion() {
		return tiseDescripcion;
	}
	public void setTiseDescripcion(String tiseDescripcion) {
		this.tiseDescripcion = tiseDescripcion;
	}
	public int getTifrId() {
		return tifrId;
	}
	public void setTifrId(int tifrId) {
		this.tifrId = tifrId;
	}
	public String getTifrDescripcion() {
		return tifrDescripcion;
	}
	public void setTifrDescripcion(String tifrDescripcion) {
		this.tifrDescripcion = tifrDescripcion;
	}
	public int getRgacId() {
		return rgacId;
	}
	public void setRgacId(int rgacId) {
		this.rgacId = rgacId;
	}
	public String getRgacDescripcion() {
		return rgacDescripcion;
	}
	public void setRgacDescripcion(String rgacDescripcion) {
		this.rgacDescripcion = rgacDescripcion;
	}
	public int getNvfrId() {
		return nvfrId;
	}
	public void setNvfrId(int nvfrId) {
		this.nvfrId = nvfrId;
	}
	public String getNvfrDescripcion() {
		return nvfrDescripcion;
	}
	public void setNvfrDescripcion(String nvfrDescripcion) {
		this.nvfrDescripcion = nvfrDescripcion;
	}
	public int getDrcId() {
		return drcId;
	}
	public void setDrcId(int drcId) {
		this.drcId = drcId;
	}
	public int getDrcTipo() {
		return drcTipo;
	}
	public void setDrcTipo(int drcTipo) {
		this.drcTipo = drcTipo;
	}
	public String getDrcTipoSt() {
		return drcTipoSt;
	}
	public void setDrcTipoSt(String drcTipoSt) {
		this.drcTipoSt = drcTipoSt;
	}
	public int getDrcTiempo() {
		return drcTiempo;
	}
	public void setDrcTiempo(int drcTiempo) {
		this.drcTiempo = drcTiempo;
	}
	/*******************************************************/
	/***************** Método toString *********************/
	/*******************************************************/
	public String toString() {
	    	String tabulador = "\t";
			StringBuilder sb = new StringBuilder();
			sb.append("cncrId : " + cncrId);
			sb.append(tabulador + "crrId : " + crrId);
			sb.append(tabulador + "crrDescripcion : " + crrDescripcion);
			sb.append(tabulador + "crrDetalle : " + crrDetalle);
			sb.append(tabulador + "vgnId : " + vgnId);
			sb.append(tabulador + "vgnDescripcion : " + vgnDescripcion);
			sb.append(tabulador + "mdlId : " + mdlId);
			sb.append(tabulador + "mdlDescripcion : " + mdlDescripcion);
			sb.append(tabulador + "ttlId : " + ttlId);
			sb.append(tabulador + "ttlDescripcion : " + ttlDescripcion);
			sb.append(tabulador + "ttlSexo : " + ttlSexo);
			sb.append(tabulador + "ttlSexoSt : " + ttlSexoSt);
			sb.append(tabulador + "ubcId : " + ubcId);
			sb.append(tabulador + "ubcDescripcion : " + ubcDescripcion);
			sb.append(tabulador + "tiseId : " + tiseId);
			sb.append(tabulador + "tiseDescripcion : " + tiseDescripcion);
			sb.append(tabulador + "tifrId : " + tifrId);
			sb.append(tabulador + "tifrDescripcion : " + tifrDescripcion);
			sb.append(tabulador + "rgacId : " + rgacId);
			sb.append(tabulador + "rgacDescripcion : " + rgacDescripcion);
			sb.append(tabulador + "nvfrId : " + nvfrId);
			sb.append(tabulador + "nvfrDescripcion : " + nvfrDescripcion);
			sb.append(tabulador + "drcId : " + drcId);
			sb.append(tabulador + "drcTipo : " + drcTipo);
			sb.append(tabulador + "drcTipoSt : " + drcTipoSt);
			sb.append(tabulador + "drcTiempo : " + drcTiempo);
			return sb.toString();
	}

	
	
}
