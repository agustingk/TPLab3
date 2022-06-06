package cuenta;

import app.Destino;
import tren.Tren;

////vendria a ser la primera Cuenta creada y por consecuencia la del indice "0" en la listaDeCuentas de la terminal.
////Cuenta con metodos extra.
////Los metodos son de tipo "void" temporalmente.
public class CuentaAdmin extends Cuenta{
	
	
	public CuentaAdmin() {
		super();
	}
	
	public void agregarDestino(Destino destinoNuevo) {
		///todo;
	}
	
	public void quitarDestino(int indiceDeDestino) {////indiceDeDestino seria la posicion que ocupa el destino que se desea eliminar en la listaDeDestinos de la terminal.
		///todo;
	}
	
	public void agregarTren(Tren trenNuevo) {
		///todo;
	}
	
	public void quitarTren(int indiceDeTren) {////indiceDeTren seria la posicion que ocupa el tren que se desea eliminar en la listaDeTrenes de la terminal.
		///todo;
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
	
}
