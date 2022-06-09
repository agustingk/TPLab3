package cuenta;

import app.Boleto;

///CuentaPro podria tener un descuento sobre los pasajes que compra?
public class CuentaPro extends Cuenta {
	private double kilometrosGanados;//// porcentaje de los kilometros recorridos para luego ser canjeados por
										//// saldo?�?�

	public CuentaPro(String nombre, String apellido, int edad, String user, String pass, char genero, String dni) {
		super(nombre, apellido, edad, user, pass, genero, dni);
	}

	public Boleto sacarBoleto() {/// Resta el costo del Boleto al saldo pero recibe un descuento.
		return null;
	}
}
