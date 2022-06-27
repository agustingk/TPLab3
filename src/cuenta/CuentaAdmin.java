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
import app.ObjetoGenerico;
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
	
	public String mostrarListaPermanente(ObjetoGenerico<Tren> lista) {
		String elReturn = "";
		
		if(lista != null) {
			if(lista.getLista().size() > 0) {
				for(int i = 0; i < lista.getLista().size(); i++) {
					elReturn = elReturn + lista.getLista().get(i).toString() + "\n";
				}
				return elReturn;
			}
			else {
				return "La lista permanente se encuentra vacia.";
			}
		}
		else {
			return "La lista permanente se encuentra vacia.";
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
	
	public void agregarCosa(Tren trenNuevo, ObjetoGenerico<Tren> elemento) {
		if (elemento.getLista() != null) {
			if (elemento.getLista().contains(trenNuevo)) {
				//System.out.println("Este tren ya esta cargado en el sistema!");
			} else {
				elemento.getLista().add(trenNuevo);
				//System.out.println("Tren ingresado en la terminal!");
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
		Scanner scan = new Scanner(System.in);
		int indiceTren, indiceDestino, indiceTrenOriginal=0;
		Destino destinoElegido = new Destino();
		Tren trenElegido = new Tren();
		ArrayList<Tren> trenesDisp = new ArrayList<Tren>();
		
		if(destinos.size() > 0) {
			System.out.println("Seleccione el [INDICE] del destino: ");
			
			for(int i = 0; i < destinos.size(); i++) {
				System.out.println("["+i+"]" + "\n" + destinos.get(i));
			}
			
			try {
				indiceDestino = scan.nextInt();
				if(indiceDestino > destinos.size() - 1) {
					System.out.println("Error al elegir el destino. Asegurese de seleccionar el [INDICE] correcto.");
				}
				else {
					destinoElegido = destinos.get(indiceDestino);
					System.out.println("\n");
					System.out.println("Seleccione el [INDICE] de la lista de trenes disponibles para "+destinoElegido.getNombreDeDestino()+": ");
					for(int i = 0; i < trenes.size(); i++) {
						if(trenes.get(i).getDistanciaMaxima() >= destinoElegido.getDistanciaEnKilometros()) {
							if(!trenes.get(i).getEnViaje()) {
								trenesDisp.add(trenes.get(i));
							}
						}
					}
					if(trenesDisp.size() == 0) {
						System.out.println("No hay trenes disponibles por el momento.");
					}
					else {
						for(int i = 0; i < trenesDisp.size(); i++) {
							System.out.println("["+i+"]" + "\n" + trenesDisp.get(i));
						}
						
						indiceTren = scan.nextInt();
						if(indiceTren > trenesDisp.size() - 1) {
							System.out.println("Error al elegir el tren. Accion cancelada.");
						}
						else {
							trenElegido = trenesDisp.get(indiceTren);
							
							for(int f=0; f < trenes.size(); f++) {
								if(trenElegido.equals(trenes.get(f))) {
									indiceTrenOriginal = f;
								}
							}
									
							Boleto nuevoBoleto = new Boleto(destinoElegido, trenElegido, indiceTrenOriginal, this.getNombre(), this.getApellido(), 0);
							this.agregarBoleto(nuevoBoleto);
							System.out.println("Has sacado el boleto con destino a "+nuevoBoleto.getDestinoDelViaje().getNombreDeDestino()+".");

						}
				}
				}
			}
			catch(InputMismatchException e) {
				System.out.println("Error al elegir el tren. Accion cancelada.");
			}
		}
		else {
			System.out.println("No hay destinos disponibles por el momento.");
		}
	
		return 0;
	}

}
