package cuenta;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import app.Boleto;
import app.Destino;
import tren.Tren;

////Esta cuenta vendria a ser la "estandar"
public class CuentaLight extends Cuenta {

	public CuentaLight() {
		super();
	}

	public CuentaLight(String nombre, String apellido, int edad, String user, String pass, char genero, String dni) {
		super(nombre, apellido, edad, user, pass, genero, dni);
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
							
							precio = destinoElegido.getDistanciaEnKilometros() * trenElegido.getPrecioPorKilometro();
							
							if(this.getSaldo() >= precio) {
								this.setSaldo(this.getSaldo() - precio);
								Boleto nuevoBoleto = new Boleto(destinoElegido, trenElegido, indiceTrenOriginal, this.getNombre(), this.getApellido(), precio);
								this.agregarBoleto(nuevoBoleto);
								System.out.println("Has sacado el boleto con destino a "+nuevoBoleto.getDestinoDelViaje().getNombreDeDestino()+".");
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
}
