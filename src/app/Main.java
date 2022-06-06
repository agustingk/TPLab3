package app;

import cuenta.Cuenta;
import cuenta.CuentaAdmin;

public class Main {

	public static void main(String[] args) {

		CuentaAdmin cuenta1 = new CuentaAdmin("Lucas", "Moreno", 43, "Lucas01", "1234", 'm');
		Terminal terminal1 = new Terminal("MDQ", "San Juan 1234", cuenta1);
		
		Cuenta cuenta2 = new Cuenta("Jose", "Perez", 17, "Jose05", "1234", 'm');
		
		cuenta2.agregarSaldo(5000);
		
		System.out.println(terminal1);
		
	}
}
