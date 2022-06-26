package cuenta;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Inter.Jsoneable;
import app.Boleto;
import app.Destino;
import tren.Tren;

////Vendria a ser el "pasajero" que compra boletos online a los destinos disponibles.
///No se usa esta clase en si sino sus clases hijas "ClaseLight", "ClasePro" y UN "ClaseAdmin".
public abstract class Cuenta extends Persona implements Serializable, Jsoneable{
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
		scan.close();
	}
	
	public abstract double sacarBoleto(ArrayList<Tren> trenes, ArrayList<Destino> destinos);//// este metodo abstracto va a depender de cada subclase.

	public void agregarSaldo(int dinero) {
		this.saldo += dinero;
	}

	/*@Override
	public String toString() {
		return getClass().getName() + " {\n\tuser: " + user + "\n\tpass: " + pass + "\n\tsaldo: " + saldo
				+ "\n\tlistaDeBoletos: " + this.mostrarListaDeBoletos() + "\n}";
	}*/
	
	@Override
	public String toString() {
		String genero = "";
		if(this.getGenero() == 'm') {
			genero = "Masculino";
		}
		else {
			genero = "Femenino";
		}
		return "Cuenta: \n"+"Nombre: "+this.getNombre()+"\nApellido: "+this.getApellido()+"\nGenero: "+genero+"\nDNI: "+this.getDni()+"\nEdad: "+this.getEdad();
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
		this.saldo = saldo;
	}

	public String mostrarListaDeTrenes(ArrayList<Tren> trenes) {
		return trenes.toString();
	}

	public String mostrarListaDeDestinos(ArrayList<Destino> destinos) {
		return destinos.toString();
	}
	
	public String mostrarListaDeBoletos() {
		String boletos = "\n";
		
		if(this.getListaDeBoletos().size() > 0) {
			for(int i = 0; i < this.getListaDeBoletos().size(); i++) {
				boletos = boletos + this.getListaDeBoletos().get(i)+ "\n\n";
			}
		}
		else {
			boletos = "No tiene boletos actualmente.";
		}
		
		
		return boletos;
	}
	
	public ArrayList<Boleto> getListaDeBoletos() {
		return this.listaDeBoletos;
	}

	@Override
	public JSONObject toJson() {
		JSONObject nuevaCuenta = new JSONObject();
		try {
			nuevaCuenta.put("user", this.getUser());
			nuevaCuenta.put("pass", this.getPass());
			nuevaCuenta.put("saldo", this.getSaldo());
			
			JSONArray boletos = new JSONArray();
			ArrayList<Boleto> boletosArray = this.getListaDeBoletos();
			for(int i=0; i < boletosArray.size();i++) {
				JSONObject boleto = new JSONObject();
				boleto.put("destino", boletosArray.get(i).getDestinoDelViaje().getNombreDeDestino());
				boleto.put("tren", boletosArray.get(i).getTrenSeleccionado().getModelo());
				boleto.put("indice", boletosArray.get(i).getIndiceTren());
				boleto.put("dueño", boletosArray.get(i).getNombre() + " " + boletosArray.get(i).getApellido());
				boleto.put("precio", boletosArray.get(i).getPrecio());
				boleto.put("vencido", boletosArray.get(i).isVencido());
				boletos.put(i, boleto);
			}
			
			try{
				nuevaCuenta.put("boletos", boletos);
			}
			catch(JSONException e) {
				System.out.println("Se rompio todo");
			}
			
		} catch (JSONException e) {	
			e.printStackTrace();
		}
		return nuevaCuenta;
	}
	
	public void cambiarDatosDeUsuario() {
		Scanner scan = new Scanner(System.in);
		String nombre, apellido, dni;
		char genero;
		int edad;
		try{
			System.out.println("Ingrese nombre: ");
			nombre = (scan.nextLine());
			System.out.println("Ingrese apellido: ");
			apellido = scan.nextLine();
			System.out.println("Ingrese DNI: ");
			dni = scan.nextLine();
			System.out.println("Ingrese genero (m o f): ");
			genero = scan.next().charAt(0);
			System.out.println("Ingrese edad: ");
			edad = scan.nextInt();
			this.setApellido(apellido);
			this.setDni(dni);
			this.setEdad(edad);
			this.setGenero(genero);
			this.setNombre(nombre);
			System.out.println("\n\nDatos actualizados correctamente.");
		}
		catch(InputMismatchException e) {
			System.out.println("Error al ingresar datos. Accion cancelada.");
		}
	}
}
