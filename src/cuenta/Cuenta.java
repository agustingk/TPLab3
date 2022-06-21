package cuenta;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import app.Boleto;
import app.Destino;
import tren.Tren;

////Vendria a ser el "pasajero" que compra boletos online a los destinos disponibles.
///No se usa esta clase en si sino sus clases hijas "ClaseLight", "ClasePro" y UN "ClaseAdmin".
public abstract class Cuenta extends Persona implements Serializable{
	private String user;
	private String pass;
	private double saldo;/// saldo que es 0 al crear la cuenta peeeeero se puede ingresar dinero al mismo
						/// para luego ser gastado en Boletos.
	private ArrayList<Boleto> listaDeBoletos;

	public Cuenta() {
		////
	}

	public Cuenta(String nombre, String apellido, int edad, String user, String pass, char genero, String dni) {
		super(nombre, apellido, edad, genero, dni);
		this.user = user;
		this.pass = pass;
		this.saldo = 0;
		this.listaDeBoletos = new ArrayList<Boleto>();
	}
		
	public void agregarBoleto(Boleto boleto) {
		if(boleto!=null) {
			this.listaDeBoletos.add(boleto);
		}
	}
	
	public String mostrarSaldo() {
		return "El saldo de esta cuenta es de "+this.getSaldo()+"." ;
	}
	
	public void agregarSaldo() {
		int saldo=0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Ingrese saldo a depositar: ");
		try {
			saldo = scan.nextInt();	
			this.setSaldo(this.getEdad() + saldo);
			System.out.println("Saldo depositado correctamente.");
		}
		catch(InputMismatchException e) {
			System.out.println("Ingrese un dato correcto!");
		}
	}
	
	public abstract double sacarBoleto(ArrayList<Tren> trenes, ArrayList<Destino> destinos);//// este metodo abstracto va a depender de cada subclase.

	public void agregarSaldo(int dinero) {
		this.saldo += dinero;
	}

	@Override
	public String toString() {
		return getClass().getName() + " {\n\tuser: " + user + "\n\tpass: " + pass + "\n\tsaldo: " + saldo
				+ "\n\tlistaDeBoletos: " + this.mostrarListaDeBoletos() + "\n}";
	}

	public String getUser() {
		return user;
	}

	public String getPass() {
		return pass;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo += saldo;
	}

	public String mostrarListaDeTrenes(ArrayList<Tren> trenes) {
		return trenes.toString();
	}

	public String mostrarListaDeDestinos(ArrayList<Destino> destinos) {
		return destinos.toString();
	}
	
	public String mostrarListaDeBoletos() {
		return this.listaDeBoletos.toString();
	}
	
	public ArrayList<Boleto> getListaDeBoletos() {
		return this.listaDeBoletos;
	}


}
