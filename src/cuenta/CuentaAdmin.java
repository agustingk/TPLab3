package cuenta;
import java.util.ArrayList;

import app.Boleto;
import app.Destino;
import tren.Tren;

////Cuenta con metodos extra.
////Los metodos son de tipo "void" temporalmente.
////Esta clase solo se crea UNA VEZ EN LA TERMINAL. ES UNICA.
public class CuentaAdmin extends Cuenta{
	
	
	public CuentaAdmin() {
		super();
	}
	
	public CuentaAdmin(String nombre, String apellido, int edad, String user, String pass, char genero, String dni) {
		super(nombre, apellido, edad, user, pass, genero, dni);
	}
	
	
	public void agregarDestino(Destino destinoNuevo, ArrayList<Destino> destinos) {
		if(destinoNuevo != null) {
			if(destinos.contains(destinos)) {
				System.out.println("Este destino ya esta cargado en el sistema!");
			}
			else{
				destinos.add(destinoNuevo);
				System.out.println("Destino cargado exitosamente!");
			}
		}
	}
	
	public void quitarDestino(int indiceDestino, ArrayList<Destino> destinos) {////indiceDeDestino seria la posicion que ocupa el destino que se desea eliminar en la listaDeDestinos de la terminal.
		if(destinos!=null) {
			if(destinos.get(indiceDestino) != null) {
				destinos.remove(indiceDestino);
				System.out.println("Destino eliminado exitosamente!");
			}
			else {
				System.out.println("No se encuentra ese destino en la base de datos! Revise bien los datos.");
			}
		}
	}
	
	public void agregarTren(Tren trenNuevo, ArrayList<Tren> trenes) {
		if(trenes!=null) {
			if(trenes.contains(trenNuevo)) {
				System.out.println("Este tren ya esta cargado en el sistema!");
			}
			else {
				trenes.add(trenNuevo);
				System.out.println("Tren ingresado en la terminal!");
			}
		}
	}
	
	public void quitarTren(int indiceDeTren, ArrayList<Tren> trenes) {////indiceDeTren seria la posicion que ocupa el tren que se desea eliminar en la listaDeTrenes de la terminal.
		if(trenes!=null) {
			if(trenes.get(indiceDeTren) != null) {
				trenes.remove(indiceDeTren);
				System.out.println("El tren se retiro de la terminal.");
			}
			else {
				System.out.println("No se pudo encontrar el tren en la terminal! Revise bien los datos.");
			}
		}
	}
	
	public void iniciarViaje(int indiceDeTren) {////indiceDeTren seria la posicion que ocupa el tren el cual inicia el viaje en la listaDeTrenes de la terminal. Cambia su estado de enViaje de false a true.
		///todo;
	}
	
	public void generarFileJsonDeCuentas() {///genera un archivo json con los datos de las cuentas.
		///todo;
	}
	
	public void generarFileJsonDeTrenes() {///genera un archivo json con los datos de los trenes.
		///todo;
	}

	@Override
	public Boleto sacarBoleto() {///sacar boleto para el admin no deberia restar saldo. Seria sacar un boleto gratis.
		// TODO Auto-generated method stub
		return null;
	}
	
}
