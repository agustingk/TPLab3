package cuenta;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import app.Boleto;
import app.Destino;
import tren.Tren;


///CuentaPro podria tener un descuento sobre los pasajes que compra?
public class CuentaPro extends Cuenta {
	private double kilometrosGanados;//// porcentaje de los kilometros recorridos para luego ser canjeados por
										//// saldo?ï¿½?ï¿½

	public CuentaPro(String nombre, String apellido, int edad, String user, String pass, char genero, String dni) {
		super(nombre, apellido, edad, user, pass, genero, dni);
	}

	public void canjearKilometrosGanados() {
		Formatter fmt = new Formatter();
		Scanner scan = new Scanner(System.in);
		int opcion=10;
		
		if(this.getKilometrosGanados() > 0) {
			while(opcion!=1 && opcion!=2) {
				fmt.format("%.2f", this.getKilometrosGanados());
				System.out.println("Usted posee "+ fmt + " kilometros ganados. Desea canjearlo por saldo?: ");
				System.out.println("1.Si, deseo canjear mis kilometros ganados.");
				System.out.println("2.No, deseo Salir y cancelar la operacion.");
				opcion = scan.nextInt();
				try {
					switch(opcion) {
					case 1:
						this.setSaldo(this.getSaldo() + this.getKilometrosGanados());
						this.setKilometrosGanados(0);
						System.out.println("Kilometros canjeados! Su saldo ha sido actualizado.");
						break;
					case 2:
						break;
					default:
						System.out.println("Ingrese una opcion valida por favor.");
						break;
					}
				}
				catch(InputMismatchException e) {
					System.out.println("Ingrese una opcion valida por favor.");
				}	
			}
		}
		else {
			System.out.println("No tiene kilometros ganados por el momento. Compre mas boletos !");
		}
	}
	
	public double getKilometrosGanados() {
		return kilometrosGanados;
	}

	public void setKilometrosGanados(double kilometrosGanados) {
		this.kilometrosGanados = kilometrosGanados;
	}

	@Override
	public double sacarBoleto(ArrayList<Tren> trenes, ArrayList<Destino> destinos) {
		Scanner scan = new Scanner(System.in);
		int indiceTren, indiceDestino, indiceTrenOriginal=0;
		Destino destinoElegido = new Destino();
		Tren trenElegido = new Tren();
		double precio=0, nuevoSaldo=0;
		ArrayList<Tren> trenesDisp = new ArrayList<Tren>();
		
		if(destinos.size() > 0) {
			System.out.println("Seleccione destino: ");
			System.out.println(destinos);
			
			try {
				indiceDestino = scan.nextInt();
				if(indiceDestino > destinos.size() - 1) {
					System.out.println("Error al elegir el destino. Accion cancelada.");
				}
				else {
					destinoElegido = destinos.get(indiceDestino);
					System.out.println("Trenes disponibles: ");
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
						System.out.println(trenesDisp);
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
							
							precio = destinoElegido.getDistanciaEnKilometros() * trenElegido.getPrecioPorKilometro() * 0.95;//5 porciento de descuento.
							
							if(this.getSaldo() >= precio) {
								this.setSaldo(this.getSaldo() - precio);
								Boleto nuevoBoleto = new Boleto(destinoElegido, trenElegido, indiceTrenOriginal, this.getNombre(), this.getApellido(), precio);
								this.agregarBoleto(nuevoBoleto);
								this.setKilometrosGanados(this.getKilometrosGanados() + precio * 0.05);///gana un 5 porciento a kilometros ganados.
								System.out.println("Has sacado el boleto con destino "+nuevoBoleto.getDestinoDelViaje().getNombreDeDestino()+".");
							}
							else {
								System.out.println("Saldos insuficientes. Recuerde ingresar saldo antes de sacar un pasaje.");
								precio=0;
							}
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
	
		return precio;
	}
	
	@Override
	public JSONObject toJson() {
		JSONObject nuevaCuenta = new JSONObject();
		try {
			nuevaCuenta.put("user", this.getUser());
			nuevaCuenta.put("pass", this.getPass());
			nuevaCuenta.put("saldo", this.getSaldo());
			nuevaCuenta.put("kilometrosGanados", this.getKilometrosGanados());
			
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
	
}
