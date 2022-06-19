package app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import cuenta.Cuenta;
import cuenta.CuentaAdmin;
import cuenta.CuentaLight;
import cuenta.CuentaPro;
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
		this.admin = new CuentaAdmin("nombre", "apellido", 0, "admin", "admin", 'm', "00000000");
		this.direccion = "Av. Pedro Luro 4524";
		this.nombre = "Terminal Mar del Plata";
	}

	public Terminal(String nombre, String direc, CuentaAdmin cuentaAdmin) {
		this.admin = cuentaAdmin;
		this.nombre = nombre;
		this.direccion = direc;
		this.listaDeDestinos = new ArrayList<Destino>();
		this.listaDeTrenes = new ArrayList<Tren>();
		this.mapDeCuentas = new HashMap<String, Cuenta>();
	}
	
	public void login() {
		Scanner scan = new Scanner(System.in);
		String user="";
		String pass="";
		char opcion=0;
		
		System.out.println("Ingrese nombre de usuario: ");
		user = scan.next();
		System.out.println("\nIngrese contraseña: ");
		pass = scan.next();
		Cuenta cuentaLogeada = this.buscarCuentaEnTerminal(user, pass);
		if(cuentaLogeada != null) {
			System.out.println("LOGEASTE LINCE");
		}
	}

	public void registrarCuenta() {
		String user="";
		String pass = "";
		Scanner scan = new Scanner(System.in);
		int opcion=1, opcion2=3;
		Cuenta cuentaARegistrar;
		
		while(opcion!=0) {
			System.out.println("-----REGISTRO DE CUENTA----");
			System.out.println("\n\nIngrese un nombre de usuario a registrar: ");
			user = scan.next();
			if(this.buscarCuentaDisponibleEnTerminal(user) == true) {
				System.out.println("Este nombre de usuario ya se encuentra registrado en la base de datos. Intente con otro usuario.");
			}
			else {
				System.out.println("\nIngrese una contraseña: ");
				pass = scan.next();
				while(opcion2 != 1 && opcion2 != 2 ) {
					System.out.println("\nPor favor, elija el tipo de cuenta que desea registrar: ");
					System.out.println("1.Cuenta Light");
					System.out.println("2.Cuenta Pro");
					System.out.println("3.Salir");
					opcion2 = scan.nextInt();
					switch(opcion2) {
					case 1:
						cuentaARegistrar = new CuentaLight("Sin datos", "Sin datos", 0, user, pass, 'm', "Sin datos");
						this.mapDeCuentas.put(user, cuentaARegistrar);
						System.out.println("\nRegistro completado satisfactoriamente.");
						break;
					case 2:
						cuentaARegistrar = new CuentaPro("Sin datos", "Sin datos", 0, user, pass, 'm', "Sin datos");
						this.mapDeCuentas.put(user, cuentaARegistrar);
						System.out.println("\nRegistro completado satisfactoriamente.");
						break;
					case 3:
						break;
					default:
						System.out.println("\nIngrese una opcion correcta!");
					}
				}
			}
			System.out.println("Desea continuar con el registro? Ingrese cualquier tecla para continuar o '0' para salir...");
			try {
				opcion = scan.nextInt();
			}
			catch(InputMismatchException e) {
				scan.next();
			}
		}
		FileUtiles.grabarTerminal(this);
	}
	
	public boolean buscarCuentaDisponibleEnTerminal(String user) {/// retorna false si no se encuentra el usario en la cuenta admin y en el hashmap de cuentas.
		if(this.admin != null) {
			if(this.admin.getUser().equals(user)) {
				return true;
			}
			else {
				if(this.mapDeCuentas.containsKey(user)) {
					return true;
				}
				else{
					return false;
				}
			}
		}
		else {
			return false;
		}
	}
	
	public Cuenta buscarCuentaEnTerminal(String user, String pass) {
		if(this.admin != null) {	
			if(this.admin.getUser().equals(user)) {
				if(this.admin.getPass().equals(pass)) {
					return this.admin;
				}
				else {
					System.out.println("Clave incorrecta !");
					return null;
				}
			}
			else { 
				if(this.mapDeCuentas.containsKey(user)) {
					if(this.mapDeCuentas.get(user).getPass().equals(pass)) {
						return this.mapDeCuentas.get(user);
					}
					else {
						System.out.println("Clave incorrecta !");
						return null;
					}
				}
				else {
					System.out.println("No se encuentra ese usuario en la base de datos !");
					return null;
				}
			}
		}
		else {
			return null;
		}
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

	public void actualizarFile() {
		FileUtiles.grabarTerminal(this);
	}
	
}
