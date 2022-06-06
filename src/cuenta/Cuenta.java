package cuenta;

////Vendria a ser el "pasajero" que compra boletos online a los destinos disponibles.
public class Cuenta extends Persona{
	private String user;
	private String pass;
	private int saldo;///saldo que es 0 al crear la cuenta peeeeero se puede ingresar dinero al mismo para luego ser gastado en Boletos.
	
	public Cuenta() {
		
	}
	
	public Cuenta(String nombre, String apellido, int edad, String user, String pass, char genero) {
		super(nombre, apellido, edad, genero);
		this.user = user;
		this.pass = pass;
		this.saldo = 0;
	}
	
	public void agregarSaldo(int dinero) {
		this.saldo += dinero;
	}
	
	
	
}
