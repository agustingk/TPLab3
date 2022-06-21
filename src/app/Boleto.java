package app;

import java.io.Serializable;

import cuenta.Persona;
import tren.Tren;

///Esta clase funciona como conexion entre el Destino y el Tren que se elije para el viaje por medio del metodo sacarPasaje() de la clase Cuenta.
///Dependiendo de a donde se quiera ir, ciertos Trenes no podran ser seleccionados. Todo depende del Destino seleccionado por la Cuenta.
public class Boleto implements Serializable{
	private Destino destinoDelViaje;
	private Tren trenSeleccionado;
	private int indiceTren;//// Es el indice que tiene el tren en la listaDeTrenes de la Terminal. Es para
							//// diferenciar trenes entre si (ej., un mismo modelo de tren con el mismo
							//// destino).
	private String nombre;
	private String apellido;
	private double precio;/// hay que encontrar la forma de que el precio dependa de la distancia del
						/// Destino y el Tren que se elija. De modo que a medida que sea mas lejos o
						/// mejor sea el tren, mas caro sea el boleto.
	private boolean vencido;/// siempre sera false hasta que mismo tren con el mismo destino inicie el
							/// viaje.

	public Boleto() {
		///
	}

	public Boleto(Destino destino, Tren tren, int indice, String nombre, String apellido, double precio) {
		this.destinoDelViaje = destino;
		this.trenSeleccionado = tren;
		this.indiceTren = indice;
		this.nombre = nombre;
		this.apellido = apellido;
		this.precio = precio;
		this.vencido = false;
	}

	public Destino getDestinoDelViaje() {
		return destinoDelViaje;
	}

	public void setDestinoDelViaje(Destino destinoDelViaje) {
		this.destinoDelViaje = destinoDelViaje;
	}

	public Tren getTrenSeleccionado() {
		return trenSeleccionado;
	}

	public void setTrenSeleccionado(Tren trenSeleccionado) {
		this.trenSeleccionado = trenSeleccionado;
	}

	public int getIndiceTren() {
		return indiceTren;
	}

	public void setIndiceTren(int indiceTren) {
		this.indiceTren = indiceTren;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public boolean isVencido() {
		return vencido;
	}

	public void setVencido(boolean vencido) {
		this.vencido = vencido;
	}

	@Override
	public String toString() {
		return getClass().getName() + " {\n\tdestinoDelViaje: " + destinoDelViaje + "\n\ttrenSeleccionado: "
				+ trenSeleccionado + "\n\tindiceTren: " + indiceTren + "\n\tnombre: " + nombre + "\n\tapellido: "
				+ apellido + "\n\tprecio: " + precio + "\n\tvencido: " + vencido + "\n}";
	}

}
