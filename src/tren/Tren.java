package tren;

///Simple clase Tren que tiene un nombre de modelo, a�o de fabricacion, distancia maxima posible y un estado "enViaje" que se modifica por la CuentaAdmin cuando se inicia un viaje con el mismo.
public class Tren {
	private String modelo;
	private int anioFabricacion;
	private int distanciaMaxima;
	private boolean enViaje;

	public Tren() {
		///
	}

	public Tren(String modelo, int anioFabricacion, int distanciaMaxima) {
		this.anioFabricacion = anioFabricacion;
		this.modelo = modelo;
		this.distanciaMaxima = distanciaMaxima;
		this.enViaje = false;
	}

	@Override
	public String toString() {
		return " \n\tmodelo: " + modelo + "\n\tanioFabricacion: " + anioFabricacion + "\n\tenViaje: " + enViaje
				+ "\n\tdistanciaMaxima: " + distanciaMaxima + "\n";
	}

	public void setEnViaje(boolean enViaje) {
		this.enViaje = enViaje;
	}

	public boolean getEnViaje() {
		return this.enViaje;
	}
	
	public String getModelo() {
		return this.modelo;
	}

	public int getAnioFabricacion() {
		return anioFabricacion;
	}

	public void setAnioFabricacion(int anioFabricacion) {
		this.anioFabricacion = anioFabricacion;
	}

	public int getDistanciaMaxima() {
		return distanciaMaxima;
	}

	public void setDistanciaMaxima(int distanciaMaxima) {
		this.distanciaMaxima = distanciaMaxima;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
}
