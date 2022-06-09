package app;

import cuenta.Persona;
import tren.Tren;

///Esta clase funciona como conexion entre el Destino y el Tren que se elije para el viaje por medio del metodo sacarPasaje() de la clase Cuenta.
///Dependiendo de a donde se quiera ir, ciertos Trenes no podran ser seleccionados. Todo depende del Destino seleccionado por la Cuenta.
public class Boleto {
	public Destino destinoDelViaje;
	public Tren trenSeleccionado;
	public int indiceTren;//// Es el indice que tiene el tren en la listaDeTrenes de la Terminal. Es para
							//// diferenciar trenes entre si (ej., un mismo modelo de tren con el mismo
							//// destino).
	public Persona persona;/// contiene los datos de BASICOS de un Cliente que compro el boleto.
	public int precio;/// hay que encontrar la forma de que el precio dependa de la distancia del
						/// Destino y el Tren que se elija. De modo que a medida que sea mas lejos o
						/// mejor sea el tren, mas caro sea el boleto.
	public boolean vencido;/// siempre sera false hasta que mismo tren con el mismo destino inicie el
							/// viaje.

	public Boleto() {
		///
	}

	public Boleto(Destino destino, Tren tren, int indice, Persona persona, int precio) {
		this.destinoDelViaje = destino;
		this.trenSeleccionado = tren;
		this.indiceTren = indice;
		this.persona = persona;
		this.precio = precio;
		this.vencido = false;
	}

	@Override
	public String toString() {
		return getClass().getName() + " {\n\tdestinoDelViaje: " + destinoDelViaje + "\n\ttrenSeleccionado: "
				+ trenSeleccionado + "\n\tindiceTren: " + indiceTren + "\n\tpersona: " + persona + "\n\tprecio: "
				+ precio + "\n\tvencido: " + vencido + "\n}";
	}

}
