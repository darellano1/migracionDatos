package migracionDatos.dtos;

import java.io.Serializable;

public class CarreraDto implements Serializable {
	
	private static final long serialVersionUID = -7819704526393256290L;

	/*******************************************************/
	/********* Declaración de variables para el DTO ********/
	/*******************************************************/
	private int crrId;
	private String crrDescripcion;
	private String crrCodSniese;
	private String crrDetalle;
	private int crrFclId;
	
	public CarreraDto() {
	}
	
	public CarreraDto(int crrId) {
		this.crrId = crrId;
	}
	/*******************************************************/
	/***************** Métodos Geters y Seters**************/
	/*******************************************************/
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
	public String getCrrCodSniese() {
		return crrCodSniese;
	}
	public void setCrrCodSniese(String crrCodSniese) {
		this.crrCodSniese = crrCodSniese;
	}

	public String getCrrDetalle() {
		return crrDetalle;
	}

	public void setCrrDetalle(String crrDetalle) {
		this.crrDetalle = crrDetalle;
	}

	public int getCrrFclId() {
		return crrFclId;
	}

	public void setCrrFclId(int crrFclId) {
		this.crrFclId = crrFclId;
	}

	/*******************************************************/
	/***************** Método toString *********************/
	/*******************************************************/
    public String toString() {
    	String tabulador = "\t";
		StringBuilder sb = new StringBuilder();
		sb.append("crrId : " + crrId);
		sb.append(tabulador + "crrDescripcion : " + (crrDescripcion==null? "NULL":crrDescripcion));
		sb.append(tabulador + "crrCodSniese : " + (crrCodSniese==null? "NULL":crrCodSniese));
		sb.append(tabulador + "crrDetalle : " + (crrDetalle==null? "NULL":crrDetalle));
		return sb.toString();
    }
	
}
