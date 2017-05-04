package migracionDatos.utilitarios;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Utilidades {
	/**
	 * Genera el numero de tramite
	 * @param trmId - id del registro de tramite
	 * @param fecha - fecha de creacion del tramite
	 * @return
	 */
	public static String generarNumeroTramite(int trmId, Timestamp fecha){
		StringBuilder sb = new StringBuilder();
		sb.append("TRM_");
		sb.append(trmId);
		sb.append("_");
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy");
		sb.append(sdf.format(fecha.getTime()));
		return sb.toString();
	}
	
	public static String extraerAbreviatura(String nombreTabla){
		String abreviatura = null;
		String[] partes = nombreTabla.toLowerCase().split("_");
		
		if(partes.length == 1){// si tiene una sola palabra
			abreviatura = extraerAbrebiaturaUnaPalabra(partes[0]);
		}else{// si tiene dos o mas palabra
			StringBuilder sb = new StringBuilder();
			for (String item : partes) {
				sb.append(extraerAbrebiaturaUnaPalabra(item).substring(0, 2));
			}
			abreviatura = sb.toString();
		}
		return abreviatura.toLowerCase();
	}
	
	
	public static String extraerAbrebiaturaUnaPalabra(String palabra){
		String abreviatura = null;
		int[] contTipo = cuentaVocalYConsonante(palabra);
		if(! esVocal(palabra.charAt(0))){//si el nombre inicia con una consonante
			if(contTipo[1]>=3){//tiene minimo 3 consonantes
				abreviatura = extraerTresConsonantes(palabra);
			}else{//tiene menos de 3 consonantes
				abreviatura = extraerConsonanteVocalConsonante(palabra);
			}
		}else{//si el nombre inicia con una vocal
			if(contTipo[1]>=2){//tiene minimo 2 consonantes
				abreviatura = extraerVocalConsonanteConsonante(palabra);
			}else{//tiene menos de 2 consonantes
				abreviatura = extraerVocalConsonanteVocal(palabra);
			}
		}
		
		return abreviatura;
	}
	public static boolean esVocal(char letra){
		int asciiVal = (int)letra;
		boolean retorno = false;
		if(asciiVal == 97 || asciiVal == 101 || asciiVal == 105 || asciiVal == 111 || asciiVal == 117
				|| asciiVal == 65 || asciiVal == 69 || asciiVal == 73 || asciiVal == 79 || asciiVal == 85 ){
			retorno = true;
		}
		return retorno;
	}
	
	/**
	 * Retorna el numero de vocales y de consonantes de una palabra, vocales en la posicion 0 y consonantes en la posicion 1
	 * @param cadena
	 * @return
	 */
	public static int[] cuentaVocalYConsonante(String cadena){
		int[] contador = new int[2];
		
		int contVocal = 0;
		int contConsonante = 0;
		
		for (int i = 0; i < cadena.length(); i++) {
			if(esVocal(cadena.charAt(i))){
				contVocal++;
			}else{
				contConsonante++;
			}
		}
		contador[0] = contVocal;
		contador[1] = contConsonante;
		return contador;
	}
	
	/**
	 * extrae las tres primeras  consonantes de la palabra
	 * @param cadena
	 * @return
	 */
	public static String extraerTresConsonantes(String cadena){
		StringBuilder abreviatura = new StringBuilder();
		int contador = 0;
		for (int i = 0; i < cadena.length(); i++) {
			if(!esVocal(cadena.charAt(i))){//no es vocal
				abreviatura.append(cadena.charAt(i));
				contador++;
			}
			if(contador>=3){
				break;
			}
		}
		return abreviatura.toString();
	}
	
	
	/**
	 * extrae la primera vocal y las dos primeras  consonantes de la palabra
	 * @param cadena
	 * @return
	 */
	public static String extraerVocalConsonanteConsonante(String cadena){
		StringBuilder abreviatura = new StringBuilder();
		int contador = 0;
		for (int i = 0; i < cadena.length(); i++) {
			if(contador == 0){ //primera posicion
				if(esVocal(cadena.charAt(i))){// es vocal
					abreviatura.append(cadena.charAt(i));
					contador++;
				}
			}else if(contador == 1){ //posicion dos
				if(!esVocal(cadena.charAt(i))){// no es vocal
					abreviatura.append(cadena.charAt(i));
					contador++;
				}
			}else if(contador == 2){ //posicion tres
				if(!esVocal(cadena.charAt(i))){//no es vocal
					abreviatura.append(cadena.charAt(i));
					contador++;
				}
			}
			
			if(contador>3){
				break;
			}
		}
		return abreviatura.toString();
	}
	
	/**
	 * extrae la primera consonante, la primera vocal y la segunda consonante de la palabra
	 * @param cadena
	 * @return
	 */
	public static String extraerConsonanteVocalConsonante(String cadena){
		StringBuilder abreviatura = new StringBuilder();
		int contador = 0;
		for (int i = 0; i < cadena.length(); i++) {
			if(contador == 0){ //primera posicion
				if(!esVocal(cadena.charAt(i))){//no es vocal
					abreviatura.append(cadena.charAt(i));
					contador++;
				}
			}
			
			if(contador == 1){ //posicion dos
				if(esVocal(cadena.charAt(i))){// es vocal
					abreviatura.append(cadena.charAt(i));
					contador++;
				}
			}
			
			if(contador == 2){ //posicion tres
				if(!esVocal(cadena.charAt(i))){//no es vocal
					abreviatura.append(cadena.charAt(i));
					contador++;
				}
			}
			
			if(contador>3){
				break;
			}
		}
		return abreviatura.toString();
	}
	
	/**
	 * extrae la primera vocal, la consonante y la siguiente vocal que está a continuación de la consonantes de la palabra
	 * @param cadena
	 * @return
	 */
	public static String extraerVocalConsonanteVocal(String cadena){
		StringBuilder abreviatura = new StringBuilder();
		int contador = 0;
		for (int i = 0; i < cadena.length(); i++) {
			if(contador == 0){ //primera posicion
				if(esVocal(cadena.charAt(i))){// es vocal
					abreviatura.append(cadena.charAt(i));
					contador++;
				}
			}else if(contador == 1){ //posicion dos
				if(!esVocal(cadena.charAt(i))){// no es vocal
					abreviatura.append(cadena.charAt(i));
					contador++;
				}
			}else if(contador == 2){ //posicion tres
				if(esVocal(cadena.charAt(i))){//es vocal
					abreviatura.append(cadena.charAt(i));
					contador++;
				}
			}
			
			if(contador>3){
				break;
			}
		}
		return abreviatura.toString();
	}
	
}
