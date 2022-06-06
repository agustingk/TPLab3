package app;

import tren.Tren;

///Esta clase funciona como conexion entre el Destino y el Tren que se elije para el viaje por medio del metodo sacarPasaje() de la clase Cuenta.
///Dependiendo de a donde se quiera ir, ciertos Trenes no podran ser seleccionados. Todo depende del Destino seleccionado por la Cuenta.
public class Boleto {
	public Destino destinoDelViaje;
	public Tren trenSeleccionado;
	public String nombre;///nombre de la Cuenta que compro el boleto.
	public String apellido;///apellido de la Cuenta que compro el boleto.
	public int precio;///hay que encontrar la forma de que el precio dependa de la distancia del Destino y el Tren que se elija. De modo que a medida que sea mas lejos o mejor sea el tren, mas caro sea el boleto.
	
}
