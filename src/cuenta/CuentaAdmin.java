package cuenta;

import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import json.JsonUtiles;

import app.Boleto;
import app.Destino;
import app.FileUtiles;
import exception.TerminalException;
import tren.Tren;

////Cuenta con metodos extra.
////Los metodos son de tipo "void" temporalmente.
////Esta clase solo se crea UNA VEZ EN LA TERMINAL. ES UNICA.
public class CuentaAdmin extends Cuenta {

	public CuentaAdmin() {
		super();
	}

	public CuentaAdmin(String nombre, String apellido, int edad, String user, String pass, char genero, String dni) {
		super(nombre, apellido, edad, user, pass, genero, dni);
	}

	public void eliminarCuenta(HashMap<String, Cuenta> cuentas, String buscado) {
		if(cuentas.containsKey(buscado))
		{
			cuentas.remove(buscado);
			System.out.println("°°La cuenta fue eliminada con exito°°");
		}
		else
		{
			System.out.println("El usuario es incorrecto o no existe");
		}
		
	}
	
	public void agregarDestino(Destino destinoNuevo, ArrayList<Destino> destinos) {
		if (destinoNuevo != null) {
			if (destinos.contains(destinos)) {
				System.out.println("Este destino ya esta cargado en el sistema!");
			} else {
				destinos.add(destinoNuevo);
				System.out.println("Destino cargado exitosamente!");
			}
		}
	}
	
	public void quitarDestino(int indiceDestino, ArrayList<Destino> destinos) {//// indiceDeDestino seria la posicion
																				//// que ocupa el destino que se desea
																				//// eliminar en la listaDeDestinos de
																				//// la terminal.
		if (destinos != null) {
			if (destinos.get(indiceDestino) != null) {
				destinos.remove(indiceDestino);
				System.out.println("Destino eliminado exitosamente!");
			} else {
				System.out.println("No se encuentra ese destino en la base de datos! Revise bien los datos.");
			}
		}
	}

	public void agregarTren(Tren trenNuevo, ArrayList<Tren> trenes) {
		if (trenes != null) {
			if (trenes.contains(trenNuevo)) {
				System.out.println("Este tren ya esta cargado en el sistema!");
			} else {
				trenes.add(trenNuevo);
				System.out.println("Tren ingresado en la terminal!");
			}
		}
	}

	public void quitarTren(int indiceDeTren, ArrayList<Tren> trenes) {//// indiceDeTren seria la posicion que ocupa el
																		//// tren que se desea eliminar en la
																		//// listaDeTrenes de la terminal.
		if (trenes != null) {
			if (trenes.get(indiceDeTren) != null) {
				trenes.remove(indiceDeTren);
				System.out.println("El tren se retiro de la terminal.");
			} else {
				System.out.println("No se pudo encontrar el tren en la terminal! Revise bien los datos.");
			}
		}
	}

	public void iniciarViaje(int indiceDeTren, ArrayList<Tren> trenes) {//// indiceDeTren seria la posicion que ocupa el
																		//// tren el cual inicia el viaje en la
																		//// listaDeTrenes de la terminal. Cambia su
																		//// estado de enViaje de false a true.
		if (trenes != null) {
			if (trenes.get(indiceDeTren) != null) {
				if (trenes.get(indiceDeTren).getEnViaje() == true) {
					System.out.println("Este tren ya se encuentra en viaje!");
				} else {
					trenes.get(indiceDeTren).setEnViaje(true);
				}
			} else {
				System.out.println("No se encuentra ese tren en la terminal! Revise bien los datos.");
			}
		}
	}

	public void terminarViaje(int indiceDeTren, ArrayList<Tren> trenes) {
		if (trenes != null) {
			if (trenes.get(indiceDeTren) != null) {
				if (trenes.get(indiceDeTren).getEnViaje() == false) {
					System.out.println("Este tren no puede terminar viaje ya que no se encuentra en uno!");
				} else {
					trenes.get(indiceDeTren).setEnViaje(false);
				}
			} else {
				System.out.println("No se encuentra ese tren en la terminal! Revise bien los datos.");
			}
		}
	}

	public void exportarFileJsonDeCuentas(HashMap<String, Cuenta> cuentas) throws TerminalException {/// genera un archivo json con los datos de las cuentas.
		if(cuentas!=null && cuentas.size() > 0) {
			int cont=0;
			JSONArray jsonArray = new JSONArray();
			for(HashMap.Entry<String, Cuenta> entry : cuentas.entrySet()) {
				try {
					JSONObject cuenta = entry.getValue().toJson();
					jsonArray.put(cont, cuenta);
					cont++;
				} catch (JSONException e) {
					e.printStackTrace();
				}	
				JsonUtiles.grabar(jsonArray, "jsonCuentas");			
			}
		}
		else {
			throw new TerminalException();
		}
	}

	public void exportarFileJsonDeTrenes(ArrayList<Tren> trenes) throws TerminalException {/// genera un archivo json con los datos de los trenes.
		if(trenes!=null && trenes.size() > 0) {
			JSONArray jsonArray = new JSONArray();
			for(int i=0; i < trenes.size();i++) {
				try {
					JSONObject tren = trenes.get(i).toJson();
					jsonArray.put(i, tren);
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
			JsonUtiles.grabar(jsonArray, "jsonTrenes");
		}
		else {
			throw new TerminalException();
		}
	}

	@Override
	public double sacarBoleto(ArrayList<Tren> trenes, ArrayList<Destino> destinos) {/// sacar boleto para el admin no deberia restar saldo. Seria sacar un boleto
									/// gratis.
		// TODO Auto-generated method stub
		return 0;
	}

}
