package cuenta;

////Vendria a ser el "pasajero" que compra boletos online a los destinos disponibles.
public class Cuenta {
	private String nombre;
	private String apellido;
	private int edad;
	private String user;
	private String pass;
	private int saldo;///saldo que es 0 al crear la cuenta peeeeero se puede ingresar dinero al mismo para luego ser gastado en Boletos.
	
	public Cuenta() {
		
	}
	
	public Cuenta(String nombre, String apellido, int edad, String user, String pass) {
		this.apellido = apellido;
		this.nombre = nombre;
		this.edad = edad;
		this.user = user;
		this.pass = pass;
	}
	
	public void agregarSaldo(int dinero) {
		this.saldo += dinero;
	}
	
	
	
}
