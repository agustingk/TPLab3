package cuenta;

import java.util.ArrayList;

import app.Boleto;
import app.Destino;
import tren.Tren;

////Vendria a ser el "pasajero" que compra boletos online a los destinos disponibles.
///No se usa esta clase en si sino sus clases hijas "ClaseLight" y "ClasePro"
public abstract class Cuenta extends Persona{
	private String user;
	private String pass;
	private int saldo;///saldo que es 0 al crear la cuenta peeeeero se puede ingresar dinero al mismo para luego ser gastado en Boletos.
	private ArrayList<Boleto> listaDeBoletos;
	
	public Cuenta() {
	}
	
	public Cuenta(String nombre, String apellido, int edad, String user, String pass, char genero, String dni) {
		super(nombre, apellido, edad, genero, dni);
		this.user = user;
		this.pass = pass;
		this.saldo = 0;
		this.listaDeBoletos = new ArrayList<Boleto>();
	}
	
	public abstract Boleto sacarBoleto();////este metodo abstracto va a depender de cada subclase.
	
	public void agregarSaldo(int dinero) {
		this.saldo += dinero;
	}
	
	@Override
	public String toString() {
		return getClass().getName() + " {\n\tuser: " + user + "\n\tpass: " + pass + "\n\tsaldo: " + saldo + "\n}";
	}

	public String getUser() {
		return user;
	}

	public String getPass() {
		return pass;
	}

	public int getSaldo() {
		return saldo;
	}
	
	public String mostrarListaDeTrenes(ArrayList<Tren> trenes) {
		return trenes.toString();
	}
	
	public String mostrarListaDeDestinos(ArrayList<Destino> destinos) {
		return destinos.toString();
	}
	
}
