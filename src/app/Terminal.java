package app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import cuenta.Cuenta;
import cuenta.CuentaAdmin;
import tren.Tren;

///Terminal:
///Se crea al ejecutar por primera vez el codigo (hace un chequeo de si el archivo "terminal.bin" existe, en caso de no encontrarlo se supone que es la primera vez ejecutando el programa)
///Contiene una lista de Destinos, lista de Trenes y un hashmap que contiene "user" como key y el objeto Cliente como value;
public class Terminal implements Serializable {
	private String nombre;
	private String direccion;
	private double recaudacion;
	private CuentaAdmin admin;
	private ArrayList<Destino> listaDeDestinos;
	private ArrayList<Tren> listaDeTrenes;
	private HashMap<String, Cuenta> mapDeCuentas;

	public Terminal() {
		this.listaDeDestinos = new ArrayList<Destino>();
		this.listaDeTrenes = new ArrayList<Tren>();
		this.mapDeCuentas = new HashMap<String, Cuenta>();
	}

	public Terminal(String nombre, String direc, CuentaAdmin cuentaAdmin) {
		this.admin = cuentaAdmin;
		this.nombre = nombre;
		this.direccion = direc;
		this.listaDeDestinos = new ArrayList<Destino>();
		this.listaDeTrenes = new ArrayList<Tren>();
		this.mapDeCuentas = new HashMap<String, Cuenta>();
	}

	@Override
	public String toString() {
		return getClass().getName() + " {\n\tnombre: " + nombre + "\n\tdireccion: " + direccion + "\n\trecaudacion: "
				+ recaudacion + "\n\tadmin: " + admin + "\n\tlistaDeDestinos: " + listaDeDestinos
				+ "\n\tlistaDeTrenes: " + listaDeTrenes + "\n\tmapDeCuentas: " + mapDeCuentas + "\n}";
	}

	public void agregarCuenta(Cuenta nuevaCuenta) {
		if (nuevaCuenta != null) {
			if (this.mapDeCuentas.containsKey(nuevaCuenta.getUser())) {
				System.out.println("Este usuario ya ha sido tomado!");
			} else {
				this.mapDeCuentas.put(nuevaCuenta.getUser(), nuevaCuenta);
			}
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public double getRecaudacion() {
		return recaudacion;
	}

	public void setRecaudacion(int recaudacion) {
		this.recaudacion = recaudacion;
	}

	public CuentaAdmin getAdmin() {
		return admin;
	}

	public void setAdmin(CuentaAdmin admin) {
		this.admin = admin;
	}

	public ArrayList<Destino> getListaDeDestinos() {
		return listaDeDestinos;
	}

	public void setListaDeDestinos(ArrayList<Destino> listaDeDestinos) {
		this.listaDeDestinos = listaDeDestinos;
	}

	public ArrayList<Tren> getListaDeTrenes() {
		return listaDeTrenes;
	}

	public void setListaDeTrenes(ArrayList<Tren> listaDeTrenes) {
		this.listaDeTrenes = listaDeTrenes;
	}

	public HashMap<String, Cuenta> getMapDeCuentas() {
		return mapDeCuentas;
	}

	public void setMapDeCuentas(HashMap<String, Cuenta> mapDeCuentas) {
		this.mapDeCuentas = mapDeCuentas;
	}

}
