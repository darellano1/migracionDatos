package migracionDatos.excepciones;

public class CarreraJdbcException extends Exception{
	private static final long serialVersionUID = -3995370847716513453L;

	/**
	 * Constructor por defecto de la excepci�n.
	 */
	public CarreraJdbcException() {
		super();
	}

	/**
	 * Constructor de la excepci�n el cual acepta un mensaje de error como par�metro del
	 * constructor.
	 * @param message El mensaje de error.
	 */
	public CarreraJdbcException(String message) {
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
	public CarreraJdbcException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor de la excepci�n el cual acepta la causa de la excepci�n.
	 * @param cause La causa de la excepci�n.
	 * 
	 * @see java.lang.Throwable
	 */
	public CarreraJdbcException(Throwable cause) {
		super(cause);
	}
}
