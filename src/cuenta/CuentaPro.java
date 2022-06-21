package cuenta;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import app.Boleto;
import app.Destino;
import tren.Tren;


///CuentaPro podria tener un descuento sobre los pasajes que compra?
public class CuentaPro extends Cuenta {
	private double kilometrosGanados;//// porcentaje de los kilometros recorridos para luego ser canjeados por
										//// saldo?�?�

	public CuentaPro(String nombre, String apellido, int edad, String user, String pass, char genero, String dni) {
		super(nombre, apellido, edad, user, pass, genero, dni);
	}

	@Override
	public void agregarSaldo() {
		int saldo=0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Ingrese saldo a depositar: ");
		try {
			saldo = scan.nextInt();			
		}
		catch(InputMismatchException e) {
			System.out.println("Ingrese un dato correcto!");
		}
		
		this.setSaldo(this.getEdad() + saldo);
	}

	@Override
	public double sacarBoleto(ArrayList<Tren> trenes, ArrayList<Destino> destinos) {
		Scanner scan = new Scanner(System.in);
		int indiceTren, indiceDestino, indiceTrenOriginal=0;
		Destino destinoElegido = new Destino();
		Tren trenElegido = new Tren();
		double precio=0;
		ArrayList<Tren> trenesDisp = new ArrayList<Tren>();
		
		if(destinos.size() > 0) {
			System.out.println("Seleccione destino: ");
			System.out.println(destinos);
			
			try {
				indiceDestino = scan.nextInt();
				destinoElegido = destinos.get(indiceDestino);
				System.out.println("Trenes disponibles: ");
				for(int i = 0; i < trenes.size(); i++) {
					if(trenes.get(i).getDistanciaMaxima() >= destinoElegido.getDistanciaEnKilometros()) {
						if(!trenes.get(i).getEnViaje()) {
							trenesDisp.add(trenes.get(indiceDestino));
						}
					}
				}
				
				
				if(trenesDisp.size() == 0) {
					System.out.println("No hay trenes disponibles por el momento.");
				}
				else {
					System.out.println(trenesDisp);
					indiceTren = scan.nextInt();
					trenElegido = trenesDisp.get(indiceTren);
					
					for(int f=0; f < trenes.size(); f++) {
						if(trenElegido.equals(trenes.get(f))) {
							indiceTrenOriginal = f;
						}
					}
					
					precio = destinoElegido.getDistanciaEnKilometros() * 3;
					
					if(this.getSaldo() >= precio) {
						this.setSaldo(this.getSaldo() - precio);
						Boleto nuevoBoleto = new Boleto(destinoElegido, trenElegido, indiceTrenOriginal, this.getNombre(), this.getApellido(), precio);
						this.agregarBoleto(nuevoBoleto);
						System.out.println("Has sacado el boleto con destino "+nuevoBoleto.getDestinoDelViaje().getNombreDeDestino()+".");
					}
					else {
						System.out.println("Saldos insuficientes ! PAGA RATA !");
						precio=0;
					}
				}
				
				
			}
			catch(InputMismatchException e) {
				System.out.println("Ingresa un dato correcto!");
			}
		}
		else {
			System.out.println("No hay destinos ingresados!");
		}
	
		return precio;
	}
}
