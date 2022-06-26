package exception;

public class TerminalException extends Exception {
	public TerminalException() {
		System.out.println("No hay datos cargados en el sistema como para poder exportar a archivo .json");
    }
}
