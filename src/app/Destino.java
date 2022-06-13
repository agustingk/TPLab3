package app;

import java.io.Serializable;

////Clase que cuenta con los atributos de nombre y distancia de los destinos en referencia a la ciudad de Mar del Plata.
public class Destino implements Serializable{
	private String nombreDeDestino;
	private double distanciaEnKilometros;

	public Destino() {

	}

	public Destino(String nombre, double distancia) {
		this.distanciaEnKilometros = distancia;
		this.nombreDeDestino = nombre;
	}

	@Override
	public String toString() {
		return getClass().getName() + " {\n\tnombreDeDestino: " + nombreDeDestino + "\n\tdistanciaEnKilometros: "
				+ distanciaEnKilometros + "\n}";
	}

	public String getNombreDeDestino() {
		return nombreDeDestino;
	}

	public void setNombreDeDestino(String nombreDeDestino) {
		this.nombreDeDestino = nombreDeDestino;
	}

	public double getDistanciaEnKilometros() {
		return distanciaEnKilometros;
	}

	public void setDistanciaEnKilometros(float distanciaEnKilometros) {
		this.distanciaEnKilometros = distanciaEnKilometros;
	}

}
