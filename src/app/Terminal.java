package app;

import java.util.ArrayList;
import java.util.HashMap;

import cuenta.Cuenta;
import tren.Tren;

///Terminal:
///Se crea al ejecutar por primera vez el codigo (hace un chequeo de si el archivo "terminal.bin" existe, en caso de no encontrarlo se supone que es la primera vez ejecutando el programa)
///Contiene una lista de destinos, lista de trenes y un hashmap que contiene "user" como key y el objeto Cliente como value;
public class Terminal {
	private String nombre;
	private String direccion;
	private int recaudacion;
	ArrayList<Destino> listaDeDestinos;
	ArrayList<Tren> listaDeTrenes;
	HashMap<String, Cuenta> mapDeCuentas;
	
	public Terminal() {
		this.listaDeDestinos = new ArrayList<Destino>();
		this.listaDeTrenes = new ArrayList<Tren>();
		this.mapDeCuentas = new HashMap<String, Cuenta>();
	}
}
