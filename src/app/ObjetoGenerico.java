package app;

import java.io.Serializable;
import java.util.ArrayList;

///Funciona como una clase generica contenedora de todos los trenes aunque sean dados de bajo.

public class ObjetoGenerico<T> implements Serializable {
	private ArrayList<T> lista;
	
	public ObjetoGenerico() {
		this.lista = new ArrayList<T>();
	}
	
	public void agregarElemento(T elemento) {
		this.lista.add(elemento);
	}
	
	public void quitarElemento(T elemento) {
		if(this.getLista() != null) {
			if(this.lista.contains(elemento)) {
				this.getLista().remove(elemento);
			}
			else {
				System.out.println("No se pudo encontrar el objeto en la lista.");
			}
		}
		else{
			
		}
	}

	public ArrayList<T> getLista() {
		return lista;
	}

}
