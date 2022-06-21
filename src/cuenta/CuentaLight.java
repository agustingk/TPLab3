package cuenta;

import app.Boleto;

////Esta cuenta vendria a ser la "estandar"
public class CuentaLight extends Cuenta {

	public CuentaLight() {
		super();
	}

	public CuentaLight(String nombre, String apellido, int edad, String user, String pass, char genero, String dni) {
		super(nombre, apellido, edad, user, pass, genero, dni);
	}

	@Override
	public Boleto sacarBoleto() {/// Resta el costo del Boleto normalmente.
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void agregarSaldo() {
		// TODO Auto-generated method stub
		
	}

}
