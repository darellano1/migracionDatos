package migracionDatos.excepciones;

public class TramiteTituloJdbcException extends Exception{
	private static final long serialVersionUID = -3995370847716513453L;

	/**
	 * Constructor por defecto de la excepci�n.
	 */
	public TramiteTituloJdbcException() {
		super();
	}

	/**
	 * Constructor de la excepci�n el cual acepta un mensaje de error como par�metro del
	 * constructor.
	 * @param message El mensaje de error.
	 */
	public TramiteTituloJdbcException(String message) {
		super(message);
	}

	/**
	 * Constructor de la excepci�n el cual acepta un mensaje de error y un objecto de tipo Throwable
	 * que representa la causa de �sta excepci�n.
	 * @param message El mensaje de error.
	 * @param cause La causa de la excepci�n.
	 * 
	 * @see java.lang.Throwable
	 */
	public TramiteTituloJdbcException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor de la excepci�n el cual acepta la causa de la excepci�n.
	 * @param cause La causa de la excepci�n.
	 * 
	 * @see java.lang.Throwable
	 */
	public TramiteTituloJdbcException(Throwable cause) {
		super(cause);
	}
}
