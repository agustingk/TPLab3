package exception;



///Exception custom. Hay que ver donde ponerla.
public class CustomException extends Exception{
	public static final long serialVersionUID = 700L;
	
	public CustomException(String mensaje) {
		super(mensaje);
	}
	
	
}
