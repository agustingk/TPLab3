package app;

import cuenta.Cuenta;
import cuenta.CuentaAdmin;

public class Main {

	public static void main(String[] args) {

		Terminal terminal1 = new Terminal("MDQ", "San Juan 1234");
		
		Cuenta cuenta1 = new Cuenta("Jose", "Perez", 17, "Jose05", "1234", 'm');
		Cuenta cuenta2 = new CuentaAdmin("Lucas", "Moreno", 43, "Lucas01", "1234", 'm');
		
		cuenta1.agregarSaldo(5000);
		
		System.out.println(cuenta1);
		
		terminal1.agregarCuenta(cuenta2);
		
	
		System.out.println(terminal1);
	}
}
